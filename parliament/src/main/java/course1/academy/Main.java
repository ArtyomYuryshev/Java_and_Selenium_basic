package course1.academy;

public class Main {
    public static void main(String[] args) {
        Academy bru = new Academy();
        boolean state = true;
        while (state) {
            switch (bru.start()) {
                case "add": //добавление студента
                    String firstName = bru.createName();
                    String secondName = bru.createLastName();
                    int[] mass = bru.createScore();
                    Student newStudent = new Student(firstName, secondName, mass);
                    bru.addStudent(newStudent);
                    System.out.println("\nНовый студент добавлен");
                    break;
                case "show": //вывод списка студентов
                    System.out.println("\nСписок студентов");
                    bru.showStudents();
                    break;
                case "remove": //удаление стдентов
                    bru.removeStudents();
                    System.out.println("\nСтуденты удалены");
                    break;
                case "end": //завершение программы
                    System.out.println("\ngoodbye");
                    state = false;
                    break;
                default: //сообщение при неверной команде
                    System.out.println("\nНеверная комманда. Попробуйте ещё раз.");
            }
        }
    }
}