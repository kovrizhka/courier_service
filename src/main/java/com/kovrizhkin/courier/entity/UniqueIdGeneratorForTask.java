package com.kovrizhkin.courier.entity;

public class UniqueIdGeneratorForTask {
    private static int nextId = 1;

    public static int getNextId() {
        return nextId++;
    }
}
