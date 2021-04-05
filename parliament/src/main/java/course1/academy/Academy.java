//класс для меню, обработки данных студентов и операций над ними

package course1.academy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Academy {
    private String firstName;
    private String secondName;
    private int[] mass;
    private ArrayList<Student> students;


    public String start() { //меню Академии
        System.out.println("\nМеню Академии \nкоманды: \n show - показать список студентов"
                + "\n add -  добавить нового студена \n remove - удалить двоечников \n end - выйти из Академии");
        Scanner scMenu = new Scanner(System.in);
        String params = scMenu.next();
        return params;
    }

    public Academy() {
        this.students = new ArrayList<Student>();
    }

    public void addStudent(Student st) {
        students.add(st);
    }

    public String createName() { //ввод имени
        System.out.println("\nДобавление студента \nВведите имя:");
        Scanner scName = new Scanner(System.in);
        firstName = scName.next();

        return firstName;
    }

    public String createLastName() { //ввод фамилии
        System.out.println("Введите фамилию:");
        Scanner scSecondName = new Scanner(System.in);
        secondName = scSecondName.next();
        return secondName;
    }

    public int[] createScore() { //ввод оценки
        Scanner scSize = new Scanner(System.in);
        Scanner scRate = new Scanner(System.in);
        System.out.println("Введите количество оценок");
        int scoreArray = scSize.nextInt();
        System.out.println("Введите оценки. Минимальная оценка - 1. Максимальная оценка - 10:");
        mass = new int[scoreArray];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = scRate.nextInt();
            if (mass[i] < 1 ||  mass[i] > 10) { //валидация
                System.out.format("%1$d - неверное значение. Попробуйте добавить оценку заново.\n",mass[i]);
                i--;
            }
        }
        return mass;
    }

    public void removeStudents() { //удаление студента с вводом среднего балла
        Scanner avgRate = new Scanner(System.in);
        System.out.println("\nВведите средний балл, ниже которого студнеты будут удалены");
        int avg = avgRate.nextInt();
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            if (studentIterator.next().getAverageScore() < avg) {
                studentIterator.remove();
            }
        }
    }

    public void showStudents() { //вывод студентов
        for (Student show: students) {
            System.out.println(show);
        }
    }

}