package com.doss.framework.bean;

import java.util.Date;

/**
 * 支出类型Bean
 */
public class ExpenditureType {
    private Integer id;

    private String typeName;

    private String comm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }
}
