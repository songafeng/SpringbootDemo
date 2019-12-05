package com.example;

/**
 * Created by jdd on 2019/12/4.
 */
public class DefaultCommunicatorImpl implements Communicator {
    public boolean sendMessage(String message) {
        System.out.println("Sending Message + " + message);
        return true;
    }
}