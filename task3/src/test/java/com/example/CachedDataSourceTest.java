package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CachedDataSourceTest {
    @Mock
    IDataSource dataSource;

    @Test
    void test1() {
        CachedDataSource cachedDataSource = new CachedDataSource(dataSource);
        RecordLocator recordLocator = new RecordLocator("John", "Smith");
        cachedDataSource.getRecord(recordLocator);
        cachedDataSource.getRecord(recordLocator);
        cachedDataSource.getRecord(recordLocator);

        Mockito.verify(dataSource, Mockito.times(1)).getRecord(recordLocator);
    }
}