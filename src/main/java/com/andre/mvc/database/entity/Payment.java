package com.andre.mvc.database.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bios on 28.11.2014.
 */

@Entity
@Table(name="Payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="creation_time")
    private Date creationTime;

    @Column(name="modification_time")
    private Date modificationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id")
    private Client client;

    @Column(name="price")
    private int price;

    @Column(name="comment")
    private String comment;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
