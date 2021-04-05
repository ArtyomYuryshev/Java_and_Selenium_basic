package course1;

import java.math.BigDecimal;

public class President {
    public static void main(String[] args) {
        System.out.println("I Like to rule \nnew law: IT professionals do not pay taxes ");

        //start of the 3rd homeWork
        // Массивы
        System.out.println(" "); //вывод пустой строки, для удобства чтения массива из консоли
        //Объявить и инициализировать массив типа int размером 3 элемента:
        int[] intArray1 = {1, 2, 3};

        //Вывести в консоль все элементы массива:
        for (int i = 0; i < intArray1.length; i++) {
            System.out.println(intArray1[i]);
        }

        System.out.println(" "); //вывод пустой строки, для удобства чтения массива из консоли

        //Поменять местами первый и последний элементы
        int lastItem = intArray1[0];
        intArray1[0] = intArray1[intArray1.length - 1];
        intArray1[intArray1.length - 1] = lastItem;

        //Вывести в консоль все элементы массива :
        for (int i = 0; i < intArray1.length; i++) {
            System.out.println(intArray1[i]);
        }
        //Переменные
        System.out.println(" "); //вывод пустой строки, для удобства чтения массива из консоли
        //Объявить переменную String stringValue и присвоить ей значение 2
        String stringValue = "2";

        //Объявить переменную double result и присвоить ей результат операции stringValue/3.0
        double result = Double.parseDouble(stringValue);
        result = result / 3.0;
        System.out.println(result);

        //Объявить переменную rounding и в нее записать результат округления переменной result до 4 значащих цифр
        BigDecimal bigDecimal1 = new BigDecimal(result);
        String  rounding = bigDecimal1.setScale(4, BigDecimal.ROUND_HALF_EVEN).toString();
        //или можно проще
        //result = result * 10000;
        //double rounding = Math.round(result);
        //rounding = rounding / 10000;

        //Вывести в консоль текст "Результат операции: rounding", где rounding - значение, полученное выше
        System.out.println("Результат операции: " + rounding);

        //Для сложения строк использовать 2 способа из лекции и самостоятельно изучить метод String.format()
        double dblStringValue = Double.parseDouble(stringValue);
        double dblRounding = Double.parseDouble(rounding);
        double newCount1 =  dblStringValue + dblRounding;
        System.out.println("Результат сложения: " + newCount1);

        String str1 = "я не совсем понял ";
        String str2 = "какие строки нужно сложить";
        //через +
        System.out.println(str1 + str2);

        //concat
        System.out.println(str1.concat(str2));

        //String.format()
        System.out.println(
                String.format("возможно сложил не то, т.к. %1$s%2$s ", str1, str2)
        );

        // Вывести в консоль булиновский результат сравнения значений rounding и result
        //вариант 1
        boolean compareRoundingResult = dblRounding > result;
        System.out.println(compareRoundingResult);

        //вариант 2
        boolean blnTrue = true;
        boolean blnFalse = false;
        if (result > dblRounding) {
            System.out.println(blnTrue);
        } else {
            System.out.println(blnFalse);
        }
    }
}