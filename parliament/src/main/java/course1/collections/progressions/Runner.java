//1 Написать программу, которая будет высчитывать геометрическую и арифметические прогрессии:

package course1.collections.progressions;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<Progression> progression = new ArrayList<>();

        Menu menu = new Menu();
        Linear liner = null;
        Geometric geometric = null;
        boolean state = true;
        while (state) {
            switch (menu.start()) {
                case "lin":
                    for (int i = 0; i < 3; i++) {
                        liner = new Linear(menu.firstElementSet(), menu.deltaSet());
                        progression.add(liner);
                    }
                    break;
                case "geom":
                    for (int i = 0; i < 3; i++) {
                        geometric = new Geometric(menu.firstElementSet(), menu.deltaSet());
                        progression.add(geometric);
                    }
                    break;
                case "show":
                    System.out.println(progression);
                    break;
                case "calc":
                    System.out.println("\nНачинаем подсчёт суммы и N-ого элемента для прогрессий");
                    for (int i = 0; i < progression.size(); i++) {
                        System.out.println("\nЗапись № " + (i + 1));
                        if (progression.get(i) instanceof Linear) {
                            double elementN = menu.nSet();
                            System.out.println(progression.get(i));
                            liner.getNElement(elementN);
                            liner.getSummNElements(elementN);
                        } else {
                            double elementN = menu.nSet();
                            System.out.println(progression.get(i));
                            geometric.getNElement(elementN);
                            geometric.getSummNElements(elementN);
                        }
                    }
                    break;
                case "end":
                    System.out.println("\ngoodbye");
                    state = false;
                    break;
                default:
                    System.out.println("\nНеверная команда. Попробуйте ещё раз.");
            }
        }

    }

//    // Вариант без меню
//    public static void main(String[] args) {
//
//        List<Progression> progression = new ArrayList<>();
//        Menu menu = new Menu();
//        Linear liner = null;
//        Geometric geometric = null;
//
//        System.out.println("\nзапишем 3 арифметические прогрессии");
//        for (int i = 0; i < 3; i++) {
//            liner = new Linear(menu.firstElementSet(), menu.deltaSet());
//            progression.add(liner);
//        }
//
//        System.out.println("\nзапишем 3 геометрические прогрессии");
//        for (int i = 0; i < 3; i++) {
//            geometric = new Geometric(menu.firstElementSet(), menu.deltaSet());
//            progression.add(geometric);
//        }
//
//        System.out.println("\nНачинаем подсчёт суммы и N-ого элемента для прогрессий");
//        for(int i = 0; i < progression.size(); i++) {
//            System.out.println("Запись № " + (i + 1));
//            if (progression.get(i) instanceof Linear) {
//                double elementN = menu.nSet();
//                System.out.println(progression.get(i));
//                liner.getNElement(elementN);
//                liner.getSummNElements(elementN);
//            } else {
//                double elementN = menu.nSet();
//                System.out.println(progression.get(i));
//                geometric.getNElement(elementN);
//                geometric.getSummNElements(elementN);
//            }
//        }
//    }

}

