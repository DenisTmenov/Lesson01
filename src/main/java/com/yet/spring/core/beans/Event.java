package com.yet.spring.core.beans;

import java.text.DateFormat;
import java.util.Date;

public class Event {
    private Integer id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event() {
        super();
    }

    public Event(Date date, DateFormat df) {
        this.date = date;
        generateRandomId();
        this.df = df;

    }

    private void generateRandomId() {
        this.id = (int) (Math.random() * 50 + 1);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
