package com.yet.spring.loggers;

import com.yet.spring.beans.Event;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromeCache();
            cache.clear();
        }
    }

    private void writeEventsFromeCache() {
        cache.stream().forEach(super::logEvent);
    }

    private void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromeCache();
        }
    }
}
