package com.example;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class CachedDataSource implements IDataSource {
    private final IDataSource dataSource;
    private final Map<RecordLocator, String> cache = new HashMap<>();

    public String getRecord(RecordLocator recordLocator) {
        if (!cache.containsKey(recordLocator)) {
            cache.put(recordLocator, dataSource.getRecord(recordLocator));
        }
        return cache.get(recordLocator);
    }
}
