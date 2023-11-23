package edu.hw6;

import edu.hw6.task6.PortScanner;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    void test() {
        PortScanner portScanner = new PortScanner();
        portScanner.printPortsInfo(0, 49152);
    }
}
