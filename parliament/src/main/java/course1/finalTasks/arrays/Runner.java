//Разработать консольное приложение "Разность массивов"
package course1.finalTasks.arrays;

import java.text.ParseException;
import java.util.Arrays;

public class Runner {

    public static void main(String[] args) throws ParseException {
        String[] array1 = {"Alex", "Dima", "Kate", "Galina", "Ivan"};
        String[] array2 = {"Dima", "Ivan", "Kate"};
        System.out.println(String.format("%1s - Вариант с коллекциями", Arrays.toString(Difference.arrayCollection(array1, array2))));
        System.out.println(String.format("%1s - Вариант без коллекций", Arrays.toString(Difference.arrayWithoutCollection(array1, array2))));

    }

}