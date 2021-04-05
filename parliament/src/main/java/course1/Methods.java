package course1;

import java.util.Arrays;
import java.util.Scanner;

public class Methods {

    public static void main(String[] args) {

        System.out.println("Первая задача"); //для удобства чтения результата задания
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int firstInt = sc.nextInt();
        System.out.println("Введите второе число:");
        int secndInt = sc.nextInt();

        boolean methodResult = delenie(firstInt, secndInt);
        System.out.println("\nРезульатат: " + methodResult);


        System.out.println("\nВторая задача"); //для удобства чтения результата задания
        //Возведём стринг в квадрат
        String strX = "6";
        System.out.println(square(strX));
        //Возведём инт в квадрат
        int intX = 5;
        System.out.println(square(intX));

        System.out.println("\nТретья задача"); //для удобства чтения результата задания

        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int arraySize = input.nextInt();
        System.out.println("Заполните массив");
        int[] mas = new int[arraySize];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = input.nextInt();
        }
        System.out.println("Отсортировать в обратном порядке? (true/false)");
        boolean reverse = input.nextBoolean();

        sort(reverse, mas);
        System.out.println(Arrays.toString(mas));

    }


    //    1. Напишите метод, который бы проверял, делится ли число xxx(int) на n (int) без остатка и, если не делится,
    //    выводила бы остаток на экран. Метод должен принимать два параметра, выводить надпись на экран
    //    "Число xxx делится на n без остатка"."Число xxx не делится на n без остатка. Остаток: y" и,
    //    в зависимости от результата, true\false. Вызывающий метод должен выводить на консоль результат true\false
    public static boolean delenie(int firstInt, int secndInt) {
        boolean flag;
        if (secndInt == 0) {
            throw new ArithmeticException("Деление на 0 невозможно");
        } else if (firstInt % secndInt == 0) {
            flag = true;
            System.out.format("Число %1$d делится на %2$d без остатка", firstInt, secndInt);
        } else {
            flag = false;
            System.out.format("Число %1$d не делится на %2$d без остатка. Остаток: %3$d", firstInt, secndInt, firstInt % secndInt);
        }
        return flag;
    }

    //    2. Написать методы, которые будет возводить число в квадрат и продемонстрировать результат их работы.
    //    Методы должны принимать как параметр(число) типа String, так и параметр типа int и иметь одинаковое имя.
    //    (см. перегрузка методов)

    //метод для возведеиния интовых переменных в квадрат
    private static int square(int intX) {
        return intX * intX;
    }

    // метод для возведеиния стоковых переменных в квадрат
    private static int square(String strX) {
        int intX = Integer.parseInt(strX);
        return  intX * intX;
    }


    //    3. Объявить метод, который будет принимать boolean параметр и неопределенное количество параметров типа int.
    //    Значения должны быть отсортированы по убыванию\возрастанию (в зависимости от значения параметра типа boolean,
    //    который определяет тип сортировки). Написать свою реализацию сортировки, не прибегая к Collections.sort\Arrays.sort и т.п.
    //    Метод должен выводить в консоль минимальное и максимальное значение передаваемых параметров с соответствующим сообщением.
    //
    //    Предусмотреть следующие случаи поведения программы:
    //            a. Количество неопределенных аргументов равно 0
    //            b. Количество неопределенных аргументов равно 1

    public static void sort(boolean reverse, int...params) {
        if (params.length < 2) {  //проверка размера передаваемого массива
            System.out.println("Нечего сортировать. Слишком мало значений.");
        } else if (!reverse) {
            boolean sorted = false;
            int temp;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < params.length - 1; i++) { //сортировка от меньшего к большему
                    if (params[i] > params[i + 1]) {
                        temp = params[i];
                        params[i] = params[i + 1];
                        params[i + 1] = temp;
                        sorted = false;
                    }
                }
            }
        } else { //от большего к меньшему
            boolean sorted = false;
            int temp;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < params.length - 1; i++) {
                    if (params[i] < params[i + 1]) {
                        temp = params[i];
                        params[i] = params[i + 1];
                        params[i + 1] = temp;
                        sorted = false;
                    }
                }
            }
        }
    }

} /* class */