package edu.hw6.task6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.HashMap;

public class PortScanner {

    private static final HashMap<Integer, String> PORTS_INFO = new HashMap<>();

    private static final Logger LOGGER = LogManager.getLogger();

    public void printPortsInfo(int from, int to) {
        LOGGER.info("Протокол  Порт");
        for (int i = from; i < to; i++) {
            try (ServerSocket socket = new ServerSocket(i)) {

            } catch (IOException e) {
                LOGGER.info("TCP" + "       " + i);
            }

            try (DatagramSocket socket = new DatagramSocket(i)) {

            } catch (SocketException e) {
                LOGGER.info("UDP" + "       " + i);
            }
        }
    }
}
