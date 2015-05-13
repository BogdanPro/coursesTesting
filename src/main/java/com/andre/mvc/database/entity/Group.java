package com.andre.mvc.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Bios on 20.11.14.
 */

@Entity
@Table(name="Groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="creation_time")
    private Date creationTime;

    @Column(name="modification_time")
    private Date modificationTime;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="comment")
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="coach_id")
    private Coach coach;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="place_id")
    private Place place;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course_id")
    private Course course;


    @JsonIgnore
    @OneToMany(mappedBy="group")
    private List<Client> clients;


    @JsonIgnore
    @OneToMany(mappedBy="group")
    private List<CalendarRecord> calendarRecords;

    public Group() {}

    public void schedule(Date startDate, DayTime[] days, int lessonCount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);

        do {
            for (DayTime dt : days) {
                if (cal.get(Calendar.DAY_OF_WEEK) == dt.getDay()) {
                    CalendarRecord cr = new CalendarRecord();

                    cr.setDate(cal.getTime());
                    cr.setStart(dt.getStart());
                    cr.setEnd(dt.getEnd());

                    calendarRecords.add(cr);
                    lessonCount--;
                }
            }

            cal.add(Calendar.DAY_OF_MONTH, 1);
        } while (lessonCount > 0);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<CalendarRecord> getCalendarRecords() {
        return calendarRecords;
    }

    public void setCalendarRecords(List<CalendarRecord> calendarRecords) {
        this.calendarRecords = calendarRecords;
    }
}
