package com.example.govtech;

import java.util.Comparator;

class User {
    private String name;
    private float salary;

    // constructor
    public User(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    // getter
    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public float updateSalary(float salary) {
        this.salary = salary;
        return salary;
    }

    @Override
    public String toString() {
        return String.format("\"name\": \"%s\", \"salary\": %.2f", this.getName(), this.getSalary());
    }
}

class UserNameComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return CharSequence.compare(u1.getName(), u2.getName());
    }
}

class UserSalaryComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return Float.compare(u1.getSalary(), u2.getSalary());
    }
}