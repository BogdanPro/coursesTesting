package com.andre.mvc.database.sms.entity;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Bogdan on 25.06.2015.
 */
@Entity
@Table(name = "gazlow")
public class Sms {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "msg_id")
    private String msgId;

    @Column
    private String number;

    @Column
    private String sign;

    @Column
    private String message;

    @Column
    private String wappush;

    @Column(name = "is_flash")
    private boolean isFlash;

    @Column
    private double cost;

    @Column
    private double balance;

    @Column
    private Timestamp added;

    @Column(name = "send_time")
    private Timestamp sendTime;

    @Column
    private Timestamp sended;

    @Column
    private Timestamp received;

    @Column(name = "error_code")
    private String errorCode;

    @Column
    private String status;

    public Sms(String number, String message, String sign) {
        this.number = number;
        this.message = message;
        this.sign = sign;
    }

    public Sms() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setWappush(String wappush) {
        this.wappush = wappush;
    }

    public void setIsFlash(boolean isFlash) {
        this.isFlash = isFlash;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAdded(Timestamp added) {
        this.added = added;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public void setSended(Timestamp sended) {
        this.sended = sended;
    }

    public void setReceived(Timestamp received) {
        this.received = received;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getMsgId() {
        return msgId;
    }

    public String getNumber() {
        return number;
    }

    public String getSign() {
        return sign;
    }

    public String getMessage() {
        return message;
    }

    public String getWappush() {
        return wappush;
    }

    public boolean isFlash() {
        return isFlash;
    }

    public double getCost() {
        return cost;
    }

    public double getBalance() {
        return balance;
    }

    public Timestamp getAdded() {
        return added;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public Timestamp getSended() {
        return sended;
    }

    public Timestamp getReceived() {
        return received;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getStatus() {
        return status;
    }
}

