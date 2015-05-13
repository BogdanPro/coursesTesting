package com.andre.mvc.database.entity;

import java.util.Date;

/**
 * Created by Bios on 20.11.14.
 */
public class DayTime {
    private int day;
    private Date start;
    private Date end;

    public DayTime(int day, Date start, Date end) {
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public int getDay() {
        return day;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
