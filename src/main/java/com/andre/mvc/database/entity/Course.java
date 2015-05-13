package com.andre.mvc.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Bios on 28.11.2014.
 */

@Entity
@Table(name="Courses")
public class Course {
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

    @Column(name="lessons", nullable = false)
    private int lessons;

    @Column(name="price1")
    private int price1;

    @Column(name="price2")
    private int price2;

    @Column(name="price3")
    private int price3;

    @JsonIgnore
    @OneToMany(mappedBy="course", fetch = FetchType.EAGER)
    private List<Group> groups;

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

    public int getLessons() {
        return lessons;
    }

    public void setLessons(int lessons) {
        this.lessons = lessons;
    }

    public int getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public int getPrice2() {
        return price2;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public int getPrice3() {
        return price3;
    }

    public void setPrice3(int price3) {
        this.price3 = price3;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
