package ru.SpringControlWork.SpringControlWork.service;

public class Singleton {
    private static volatile  Singleton instance = new Singleton();
    public static Singleton Instance() {
        return instance;
    }
    private Singleton() {}
}

