package com.codurance.ocp;

public abstract class Employee {

    private int salary;
    private int bonus;

    Employee(int salary, int bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public int getSalary() {
        return salary;
    }

    public int getBonus() {
        return bonus;
    }

    public int payAmount() {
        return 0;
    }

}