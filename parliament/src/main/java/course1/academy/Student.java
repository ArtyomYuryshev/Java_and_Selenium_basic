//класс для создания студентов и расчёта среднего значения оценок
package course1.academy;

import java.util.Arrays;

public class Student {
    private String name;
    private String lastName;
    private int[] marks;

    public double getAverageScore() { //среднее значние оценок
        double sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        double average = sum / marks.length;
        return average;
    }

    public Student(String name, String lastName,  int[] marks) { //для создания студента
        this.name = name;
        this.lastName = lastName;
        this.marks = marks;
    }

    @Override //учим прилагу правильно выводить
    public String toString() {
        return "Имя:" + name + "\tФамилия: " + lastName + "\tОценки: " + Arrays.toString(marks);
    }
}