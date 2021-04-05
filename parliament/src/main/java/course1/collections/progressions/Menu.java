package course1.collections.progressions;

import java.util.Scanner;

public class Menu {

    public String start() { //меню Академии
        System.out.println("\nМеню \nкоманды: \nlin - добавить 3 арифметических прогрессии в лист "
                + "\ngeom  - добавить 3 геометрическая прогрессии в лист"
                + "\nshow - показать лист "
                + "\ncalc - посчитать сумму и N элемент"
                + "\nend - завершить программу");
        Scanner scMenu = new Scanner(System.in);
        return scMenu.next();
    }

    public double firstElementSet() {
        Scanner scFirst = new Scanner(System.in);
        System.out.println("Введите первый элемент");
        double a1 = scFirst.nextInt();
        System.out.println("Первый элемент установлен, значение: " + a1);
        return a1;
    }

    public double deltaSet() {
        Scanner scDelta = new Scanner(System.in);
        System.out.println("Введите дельту");
        double d = scDelta.nextInt();
        System.out.println("Дельта установлена, значение: " + d);
        return d;
    }

    public double nSet() {
        Scanner scN = new Scanner(System.in);
        System.out.println("Введите кол-во элементов прогрессии");
        double n = scN.nextInt();
        System.out.println("n установлено, значение: " + n);
        return n;
    }


}
