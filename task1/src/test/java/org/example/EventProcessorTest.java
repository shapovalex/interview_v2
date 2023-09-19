package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EventProcessorTest {
    @Mock
    MovedEventProcessor movedEventProcessor;

    @Mock
    StoppedEventProcessor stoppedEventProcessor;

    EventProcessor eventProcessor;

    @BeforeEach
    void setUp() {
        eventProcessor = new EventProcessor(movedEventProcessor, stoppedEventProcessor);
    }

    @Test
    void test1() {
        eventProcessor.processEvent(new Event("MOVED", "payloadMoved"));
        Mockito.verify(movedEventProcessor).process("payloadMoved");
        Mockito.verify(stoppedEventProcessor, Mockito.never()).process(Mockito.anyString());
    }

    @Test
    void test2() {
        eventProcessor.processEvent(new Event("STOPPED", "payloadStopped"));
        Mockito.verify(stoppedEventProcessor).process("payloadStopped");
        Mockito.verify(movedEventProcessor, Mockito.never()).process(Mockito.anyString());
    }
}