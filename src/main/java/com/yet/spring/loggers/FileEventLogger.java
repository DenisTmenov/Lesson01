package com.yet.spring.loggers;

import com.yet.spring.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\r\n", true);
        } catch (IOException e) {
            throw new RuntimeException("Problem in logEvent!!!");
        }
    }

    private void init() throws RuntimeException {
        this.file = new File(fileName);
        if (file.exists() && !file.canWrite()) {
            throw new RuntimeException("Problem in write file!!!");
        } else if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Problem with create file!!!");
            }
        }
    }
}
