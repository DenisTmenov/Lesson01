package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.ConsoleEventLogger;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.beans.FileEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    public App() {
super();
    }

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");

        App app = (App) context.getBean("app");

        FileEventLogger fileEventLogger = (FileEventLogger) context.getBean("fileEventLogger");

        Event event = (Event)context.getBean("event");
        event.setMsg("Some event for 1");

        app.logEvent(event);

       // app.logEvent("Some event for 2");


    }

    private void logEvent(Event event) {
       String message = event.getMsg().replaceAll(String.valueOf(client.getId()), client.getFullName());
       event.setMsg(message);
       eventLogger.logEvent(event);
    }
}
