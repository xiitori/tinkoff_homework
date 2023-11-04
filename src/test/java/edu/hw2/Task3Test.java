package edu.hw2;

import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.FaultyConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    @Test
    void faultyConnectionManagerTest() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 3);

        assertThrows(ConnectionException.class, executor::updatePackages);
    }

    @Test
    void defaultConnectionManagerTest() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(), 1);

        assertDoesNotThrow(executor::updatePackages);
        assertDoesNotThrow(executor::updatePackages);
        assertDoesNotThrow(executor::updatePackages);
        assertDoesNotThrow(executor::updatePackages);
        assertDoesNotThrow(executor::updatePackages);
        assertThrows(ConnectionException.class, executor::updatePackages);
    }
}
