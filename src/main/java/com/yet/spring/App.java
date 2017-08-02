package com.yet.spring;

import com.yet.spring.beans.Client;
import com.yet.spring.beans.Event;
import com.yet.spring.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  private Client client;
  private EventLogger eventLogger;

  public App(Client client, EventLogger eventLogger) {
    this.client = client;
    this.eventLogger = eventLogger;
  }

  public static void main(String[] args) {

    ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
    App app =  ctx.getBean(App.class);

    Event event= ctx.getBean(Event.class);
    app.logEvent(event, "Some event for user 1");

    event= ctx.getBean(Event.class);
    app.logEvent(event, "Some event for user 2");

    ctx.close();
  }

  private void logEvent(Event event, String msg) {
    String message = msg.replaceAll(client.getId(), client.getFullName());
    event.setMsg(message);
    eventLogger.logEvent(event);
  }
}
