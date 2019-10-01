package com.javarush.task.task26.task2603;

public class TestClass {
    public String f1;
    public String f2;
    public String f3;

    public TestClass(String f1, String f2, String f3) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }

    @Override
    public String toString() {
        return this.f1+" "+ this.f2+ " "+this.f3;
    }
}
