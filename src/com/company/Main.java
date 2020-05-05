package com.company;
//import java net
import javax.swing.*;
import java.io.IOException;
import java.net.*;
import java.lang.*;
import java.util.ArrayList;

public class Main {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static ArrayList<String> reachables = new ArrayList<String>(); // Create an ArrayList objectp
    public static ArrayList<String> exceptions = new ArrayList<String>(); // Create an ArrayList object


    public static void sendPingRequest(String ipAddress) throws UnknownHostException, IOException {
        try {
            InetAddress geek = InetAddress.getByName(ipAddress);
            System.out.println("Sending Ping Request to " + ipAddress);
            if (geek.isReachable(100)) {
                System.out.println(ANSI_GREEN + "Host is reachable" + ANSI_RESET);
                reachables.add(ipAddress);
            } else {
                System.out.println(ANSI_YELLOW + "Host unreachable" + ANSI_RESET);

            }
        } catch (Exception e) {
            System.err.println("Exception");
            exceptions.add(ipAddress);
            return;
        }
    }

    public static void main(String[] args) throws IOException {


        StringBuilder ip = new StringBuilder();
        short first = 192;
        short second = 168;
        short third = 0;
        short forth = 0;

        for (int i = 0; i < 256; i++) {
            third++;
            for (int j = 0; j < 256; j++) {
                forth++;
                ip.setLength(0);
                ip.append(first);
                ip.append('.');
                ip.append(second);
                ip.append('.');
                ip.append(third);
                ip.append('.');
                ip.append(forth);
                sendPingRequest(ip.toString());
            }
            forth = 0;
        }

        System.out.println(ANSI_GREEN + "Process complete!" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Reachable hosts" + ANSI_RESET);
        for (int i = 0; i < reachables.size(); i++) {
            System.out.println(reachables.get(i));
        }
    }
}