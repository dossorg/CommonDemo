package com.doss.framework.bean;

import java.util.Date;

public class Records {

    private Integer id;
    private String recNum;
    private String rtype;
    private String subject;
    private Double rNumber;
    private String detail;
    private String comm;
    private Integer payUserId;
    private User payUser;
    private Date createTime;
    private String createUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecNum() {
        return recNum;
    }

    public void setRecNum(String recNum) {
        this.recNum = recNum;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getrNumber() {
        return rNumber;
    }

    public void setrNumber(Double rNumber) {
        this.rNumber = rNumber;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
}
