package lesson3.model;

public class Manager extends Employee{
    public Manager(String name, String midName, String surName, String phone, int salary, String birthday) {
        super(name, midName, surName, "Manager", phone, salary, birthday);
    }
    public static void increaseSalary(Employee person, int sizeIncrease){
        if (!(person instanceof Manager) && sizeIncrease > 0) {
            int newSalary = person.getSalary() + sizeIncrease;
            person.setSalary(newSalary);
        }
    }
}
