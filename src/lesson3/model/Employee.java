package lesson3.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee implements Comparable {

    protected String name;
    protected String midName;
    protected String surName;
    protected String position;
    protected String phone;
    protected int salary;
    protected String birthday;

    public Employee(String name, String midName, String surName, String position,
                    String phone, int salary, String birthday) {
        this.name = name;
        this.midName = midName;
        this.surName = surName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", midName='" + midName + '\'' +
                ", surName='" + surName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        String birthdayObj2;
        if (o instanceof Employee)
            birthdayObj2 = ((Employee) o).getBirthday();
        else
            throw new RuntimeException("Не подходящий класс для сравнения");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate bdObj1 = LocalDate.parse(this.birthday, formatter);
        LocalDate bdObj2 = LocalDate.parse(birthdayObj2, formatter);

        return (int)(bdObj1.toEpochDay() - bdObj2.toEpochDay());
    }

}
