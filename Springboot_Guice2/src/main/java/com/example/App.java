package com.example;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by jdd on 2019/12/4.
 */
public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BasicModule());

        Communication comms = injector.getInstance(Communication.class);

        comms.sendMessage("hello world");

    }
}
