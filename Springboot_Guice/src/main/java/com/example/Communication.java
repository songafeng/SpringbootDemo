package com.example;

import com.google.inject.Inject;

/**
 * Hello world!
 *
 */

public class Communication {
    @Inject
    private Communicator communicator;

    public Communication(Boolean keepRecords) {
        if (keepRecords) {
            System.out.println("Message logging enabled");
        }
    }

    public boolean sendMessage(String message) {
        communicator.sendMessage(message);
        return true;
    }


}