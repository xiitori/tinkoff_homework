package edu.hw6.task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MagicNumber")
public class PortScanner {
    private static final HashMap<Integer, String> PORTS_INFO = new HashMap<>();

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String FORMAT = "|%-10s|  %-10s|  %-20s|";

    private static final String NA = "N/A";

    static {
        PORTS_INFO.put(135, "EPMAP");
        PORTS_INFO.put(137, "NETBIOS-NS");
        PORTS_INFO.put(138, "NETBIOS-DGM");
        PORTS_INFO.put(139, "NETBIOS-SSN");
        PORTS_INFO.put(445, "MICROSOFT-DS");
        PORTS_INFO.put(1900, "MICROSOFT SSDP");
        PORTS_INFO.put(3702, "WS-Discovery");
        PORTS_INFO.put(5050, "Yahoo! Messenger");
        PORTS_INFO.put(5353, "Milticast DNS");
        PORTS_INFO.put(5432, "PostgreSQL");
        PORTS_INFO.put(5355, "LLMNR");

    }

    public void printPortsInfo(int from, int to) {
        LOGGER.info(String.format(FORMAT, "Протокол", "Порт", "Сервис"));
        for (int i = from; i < to; i++) {
            String portInfo = PORTS_INFO.getOrDefault(i, NA);
            if (isTCPPortClosed(i)) {
                LOGGER.info(String.format(FORMAT, "TCP", i, portInfo));
            }
            if (isUDPPortClosed(i)) {
                LOGGER.info(String.format(FORMAT, "UDP", i, portInfo));
            }
        }
    }

    private boolean isTCPPortClosed(int port) {
        try (ServerSocket ignored = new ServerSocket(port)) {
            return false;
        } catch (IOException e) {
            return true;
        }
    }

    private boolean isUDPPortClosed(int port) {
        try (DatagramSocket ignored = new DatagramSocket(port)) {
            return false;
        } catch (SocketException e) {
            return true;
        }
    }
}
