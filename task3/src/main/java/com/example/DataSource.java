package com.example;

import java.util.UUID;

public class DataSource implements IDataSource {
    public String getRecord(RecordLocator recordLocator) {
        return UUID.randomUUID().toString();
    }
}
