package com.example;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        CachedDataSource cachedDataSource = new CachedDataSource(new DataSource());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Enter last name: ");
            String lastName = scanner.nextLine();
            RecordLocator recordLocator = new RecordLocator(firstName, lastName);
            System.out.println("Data from data source: " + cachedDataSource.getRecord(recordLocator));
        }
    }
}
