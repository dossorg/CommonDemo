package com.doss.framework.bean;

import java.util.Date;

/**
 * 支出信息Bean
 */
public class Expenditure {
    private Integer id;
    private String subject;
    private Integer typeId;
    private ExpenditureType expenditureType;
    private float number;
    private String comm;
    private Integer payUserId;
    private User payUser;
    private Date payTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public ExpenditureType getExpenditureType() {
        return expenditureType;
    }

    public void setExpenditureType(ExpenditureType expenditureType) {
        this.expenditureType = expenditureType;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public Integer getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(Integer payUserId) {
        this.payUserId = payUserId;
    }

    public User getPayUser() {
        return payUser;
    }

    public void setPayUser(User payUser) {
        this.payUser = payUser;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
