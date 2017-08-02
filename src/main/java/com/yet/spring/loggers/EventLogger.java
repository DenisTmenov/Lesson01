package com.yet.spring.loggers;

import com.yet.spring.beans.Event;

public interface EventLogger {
  void logEvent(Event event);
}
