package org.example;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        EventProcessor eventProcessor = new EventProcessor(new MovedEventProcessor(), new StoppedEventProcessor());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter event type: ");
        String type = scanner.next();
        System.out.println("Enter payload: ");
        String payload = scanner.next();
        eventProcessor.processEvent(new Event(type, payload));
    }
}
