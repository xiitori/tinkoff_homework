package edu.hw10.task2.proxy;

import edu.hw10.task2.annotation.Cache;
import edu.hw10.task2.cacher.Cacher;
import edu.hw10.task2.proxy.parser.StringToObjectParser;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CacheProxyHandler implements InvocationHandler {

    private static final Logger LOGGER = LogManager.getLogger();
    private final Object object;

    public CacheProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
        throws InvocationTargetException, IllegalAccessException {
        boolean hasAnnotation = method.isAnnotationPresent(Cache.class);
        if (!hasAnnotation) { //проверка, есть ли Cache аннотация
            return method.invoke(object, args);         //если нет, то обычное выполнение метода
        }
        boolean persists = method.getAnnotation(Cache.class).persists();

        var value = getFromCache(object, method, persists); //пытаемся получить значение из кэша
        if (value == null) {
            var returnValue = method.invoke(object, args); //если его нет, то выполняем метод и записываем полученное
            LOGGER.info("value " + returnValue + " now in cache"); //значение в кэш
            return putToCache(object, method, returnValue, persists);
        } else {
            return value; //иначе просто достаем значение из кэша, без новых вычислений
        }
    }

    private static Object getFromCache(Object object, Method method, boolean persists) {
        Cacher cacher = Cacher.getCacherByPersists(persists);
        String value = cacher.get(object, method);
        Class<?> returnType = method.getReturnType();
        if (value == null) {
            LOGGER.info("Trying to get value from cache, but there is no such record");
            return null;
        } else {
            LOGGER.info(value + " is received from cache");
            return StringToObjectParser.parseByType(value, returnType); //так как кэшировать мы можем совершенно любой
        } //тип, то необходимо уметь парсить каждый отдельный класс
    }

    private static Object putToCache(Object object, Method method, Object returnValue, boolean persists) {
        Cacher cacher = Cacher.getCacherByPersists(persists);
        cacher.put(object, method, returnValue);
        return returnValue;
    }
}
