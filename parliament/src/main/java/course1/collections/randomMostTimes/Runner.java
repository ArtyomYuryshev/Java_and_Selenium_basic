//3 Найти число, которое наибольшее количество раз создается методом new Random().nextInt(i)

package course1.collections.randomMostTimes;

import java.util.*;

public class Runner {
    public static void main(String[] args) {

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 1; i < 100; i++) {
            int value = new Random().nextInt(i);
            if (hashMap.containsKey(value) == true) {
                int a = hashMap.get(value);
                hashMap.remove(value);
                hashMap.put(value, a + 1);
            } else {
                hashMap.put(value, 1);
            }
        }
        System.out.println(hashMap);
        int maxValue = Collections.max(hashMap.values());
        System.out.println("Максимальное кол-во повторов: " + maxValue);

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                System.out.println("Максимальное кол-во повторений у числа: " + entry.getKey());
            }
        }


    }
}

