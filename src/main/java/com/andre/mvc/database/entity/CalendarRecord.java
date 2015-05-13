package com.andre.mvc.database.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bios on 20.11.14.
 */
@Entity
@Table(name="Calendars")
public class CalendarRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name="date", nullable = false)
    private Date date;

    @Temporal(TemporalType.TIME)
    @Column(name="start", nullable = false)
    private Date start;

    @Temporal(TemporalType.TIME)
    @Column(name="end", nullable = false)
    private Date end;

    @Column(name="comment")
    private String comment;

    @Column(name="skip", nullable = false)
    private boolean skip;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="group_id", nullable = false)
    private Group group;

    public CalendarRecord() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
