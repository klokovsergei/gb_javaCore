package lesson3;

import lesson3.model.Employee;
import lesson3.model.Gender;
import lesson3.model.Manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainLesson3 {
    public static void main(String[] args) {

        Employee person1 = new Employee(Gender.MALE,"Иван", "Ivanovich", "Ivanov",
                "Worker", "89050001234", 10_000, "2000-10-05");
        Employee person2 = new Employee(Gender.FEMALE,"Ольга", "Petrovna", "Petrova",
                "Worker", "89050001235", 11_000, "1999-06-05");
        Employee person3 = new Manager(Gender.MALE, "Максим", "Sidorovich", "Sidorov",
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

        // Задание из 4 урока - добавить праздники и поздравлять согласно полу и дню

        System.out.println(System.lineSeparator() + "*****************" + System.lineSeparator());

        //здесь менять дату, чтобы проверить разные поздравления
        LocalDate date = LocalDate.of(2024, 3, 8);

        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");
        String dateToString = date.format(formatter);
        Holiday today = null;
        for (var day : Holiday.values()) {
            if (dateToString.equals(day.getDateToString())) {
                today = day;
                break;
            } else
                today = Holiday.ORDINARY;
        }

        String text;
        switch (today){
            case FEBRUARY_23 -> text = "Уважаемый %s, с 23 Февраля! Желаю вам крепкого здоровья, мужества и успехов в работе. " +
                    "Пусть каждый день приносит новые победы и достижения. Будьте опорой для коллектива и вдохновением для близких. С праздником!";
            case MARCH_8 -> text = "Дорогая %s, с 8 Марта! Желаю вам весеннего настроения, ярких улыбок и исполнения всех мечтаний. " +
                    "Пусть каждый день приносит радость и вдохновение. Будьте всегда красивы, нежны и любимы. С праздником!";
            case NEW_YEAR -> text = "С наступающим Новым годом! Пусть год принесет новые возможности, успехи и радость. " +
                    "Желаю крепкого здоровья, счастья и исполнения всех желаний. Пусть работа будет в радость, а коллектив — дружным и поддерживающим. С праздником!";
            default -> text = "%s, желаю удачного рабочего дня! Пусть все задачи решаются легко и быстро, а настроение будет на высоте. " +
                    "Пусть каждый момент приносит радость и удовлетворение от работы. Удачи и вдохновения!";
        }
        for (Employee stuff : listEmployees){
            if (!(today == Holiday.FEBRUARY_23 && stuff.getGender() == Gender.FEMALE) &&
                    !(today == Holiday.MARCH_8 && stuff.getGender() == Gender.MALE)) {
                System.out.printf(text + System.lineSeparator(), stuff.getName());
            }
        }



    }

    private enum Holiday{
        ORDINARY("ordinary"), NEW_YEAR("31-12"), MARCH_8("08-03"), FEBRUARY_23("23-02");
        private final String dateToString;
        Holiday(String dateToString){
            this.dateToString = dateToString;
        }

        public String getDateToString(){
            return dateToString;
        }
    }
}
