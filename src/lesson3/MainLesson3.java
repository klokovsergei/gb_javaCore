package lesson3;

import lesson3.model.Employee;
import lesson3.model.Manager;

import java.util.ArrayList;
import java.util.List;

public class MainLesson3 {
    public static void main(String[] args) {

        Employee person1 = new Employee("Ivan", "Ivanovich", "Ivanov",
                "Worker", "89050001234", 10_000, "2000-10-05");
        Employee person2 = new Employee("Petr", "Petrovich", "Petrov",
                "Worker", "89050001235", 11_000, "1999-06-05");
        Employee person3 = new Manager("Sidor", "Sidorovich", "Sidorov",
                "89050001235", 15_000, "1956-01-31");
        List<Employee> listEmployees = new ArrayList<>();
        listEmployees.add(person1);
        listEmployees.add(person2);
        listEmployees.add(person3);
        listEmployees.sort(Employee::compareTo);
        listEmployees.stream().map(x -> x.getSalary()).forEach(System.out::println);
        listEmployees.stream().forEach(x -> Manager.increaseSalary(x, 1_000));
        System.out.println("После повышения всем кроме менеджеров зарплаты на 1 000 руб.");
        listEmployees.stream().map(x -> x.getSalary()).forEach(System.out::println);

        System.out.println(listEmployees);
    }
}
