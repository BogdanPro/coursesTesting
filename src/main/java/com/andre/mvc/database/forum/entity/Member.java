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

    @Column()
    private String salt;

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
}
