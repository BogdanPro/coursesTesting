package com.andre.mvc.database.forum.entity;

import javax.persistence.*;

/**
 * Created by Khemrayev A.K. on 18.05.2015.
 */

@Entity
@Table(name = "andretest_membergroup")
public class MemberGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_group")
    private Long id;

    @Column(name = "group_name")
    private String name;

    @Column(name = "description")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
