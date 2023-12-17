package edu.hw10.task2.proxy;

import java.lang.reflect.Proxy;

public class CacheProxy {
    private CacheProxy() {

    }

    public static  <T> T create(Object object, Class<T> interfaceClass) {
        CacheProxyHandler handler = new CacheProxyHandler(object);
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(), new Class[]{interfaceClass}, handler);
    }
}
