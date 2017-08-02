package com.yet.spring.core.beans;

public class ConsoleEventLogger {
    public ConsoleEventLogger() {
        super();
    }

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
