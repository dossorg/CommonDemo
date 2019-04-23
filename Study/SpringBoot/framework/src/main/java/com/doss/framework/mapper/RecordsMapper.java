package com.doss.framework.mapper;

import com.doss.framework.bean.Records;

public interface RecordsMapper {
    public Records getRecordById(Integer id);

    public void insertRecords(Records records);
}
