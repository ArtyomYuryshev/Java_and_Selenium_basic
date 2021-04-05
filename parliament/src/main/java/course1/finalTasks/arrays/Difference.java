package course1.finalTasks.arrays;

import java.util.*;

public class Difference {

    //вариант с коллекциями
    public static String[] arrayCollection(String[] array1, String[] array2) {
        List<String> list1 = new ArrayList<String>(Arrays.asList(array1));
        List<String> list2 = new ArrayList<String>(Arrays.asList(array2));
        list1.removeAll(list2);
        return list1.toArray(new String[list1.size()]);
    }

    //вариант без коллекций
    public static String[] arrayWithoutCollection(String[] array1, String[] array2) {
        int j;
        int arraySize = array1.length;
        String[] arrayDifference;
        for (String s : array2) {
            for (j = 0; j < arraySize; j++) {
                if (array1[j].equals(s)) {
                    break;
                }
            }
            for (int k = j; k < arraySize - 1; k++) {
                array1[k] = array1[k + 1];
            }
            arraySize--;
        }
        arrayDifference = new String[arraySize];
        for (j = 0; j < arraySize; j++) {
            arrayDifference[j] = array1[j];
        }
        return arrayDifference;
    }

}