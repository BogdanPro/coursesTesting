package com.andre.mvc.database.forum.entity;

import javax.persistence.*;

/**
 * Created by Андрей on 17.05.2015.
 */

@Entity
@Table(name = "andretest_members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_member")
    private Long id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "id_group")
    private Integer group;

    @Column(name = "passwd")
    private String password;

    @Column(name = "email_address")
    private String email;

    @Column(name = "password_salt")
    private String salt;

    // This and other fields, initialized with ampty string
    // are colled to prevent hibernate exception - in db this columns
    // can't be null
    @Column(name = "buddy_list")
    private String buddyList = "";

    @Column(name = "message_labels")
    private String messageLabels = "";

    @Column(name = "openid_uri")
    private String openIdUri = "";

    @Column(name = "signature")
    private String signature = "";

    @Column(name = "ignore_boards")
    private String ignoreBoards = "";

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuddyList() {
        return buddyList;
    }

    public void setBuddyList(String buddyList) {
        this.buddyList = buddyList;
    }

    public String getMessageLabels() {
        return messageLabels;
    }

    public void setMessageLabels(String messageLabels) {
        this.messageLabels = messageLabels;
    }

    public String getOpenIdUri() {
        return openIdUri;
    }

    public void setOpenIdUri(String openIdUri) {
        this.openIdUri = openIdUri;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getIgnoreBoards() {
        return ignoreBoards;
    }

    public void setIgnoreBoards(String ignoreBoards) {
        this.ignoreBoards = ignoreBoards;
    }
}
