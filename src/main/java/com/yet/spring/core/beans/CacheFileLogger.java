package com.yet.spring.core.beans;

import java.io.IOException;
import java.util.List;

public class CacheFileLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileLogger(){
        super();
    }

    public CacheFileLogger(int cacheSize){
        this.cacheSize = cacheSize;
    }
    public void logEvent(Event event) throws IOException {
        cache.add(event);

        if (cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() throws IOException {
        logEvent(super.getFile(), cache.get(0).toString());
    }

    public void destroy() throws IOException {
        if (!cache.isEmpty()){
            writeEventsFromCache();
        }
    }
}
