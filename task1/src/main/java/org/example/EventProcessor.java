package org.example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventProcessor {
    private MovedEventProcessor movedEventProcessor;
    private StoppedEventProcessor stoppedEventProcessor;
    public void processEvent(Event event) {
        if (event.getType() == "MOVED") {
            movedEventProcessor.process(event.getPayload());
        }
        if (event.getType() == "STOPPED") {
            stoppedEventProcessor.process(event.getPayload());
        }
    }
}
