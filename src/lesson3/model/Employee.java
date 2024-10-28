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
    protected LocalDate birthday;
    protected Gender gender;

    public Employee(Gender gender, String name, String midName, String surName, String position,
                    String phone, int salary, String birthday) {
        this.gender = gender;
        this.name = name;
        this.midName = midName;
        this.surName = surName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.birthday = LocalDate.parse(birthday, formatter);
    }

    public String getName(){
        return name;
    }
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
        LocalDate birthdayObj2;
        if (o instanceof Employee)
            birthdayObj2 = ((Employee) o).getBirthday();
        else
            throw new RuntimeException("Не подходящий класс для сравнения");

        return (int)(this.birthday.toEpochDay() - birthdayObj2.toEpochDay());
    }

}
