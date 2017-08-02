package com.yet.spring.core.beans;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger {
    private String fileName;
    private File file;

    public FileEventLogger() {
        super();
    }

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(File file, String str) throws IOException {
        FileUtils.writeStringToFile(file, str, true);

    }

    private void init() throws IOException{
        this.file = new File(fileName);
        file.canWrite();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileEventLogger that = (FileEventLogger) o;

        return fileName != null ? fileName.equals(that.fileName) : that.fileName == null;
    }

    @Override
    public int hashCode() {
        return fileName != null ? fileName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FileEventLogger{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
