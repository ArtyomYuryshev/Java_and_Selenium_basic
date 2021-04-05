package course1;

public class Cycles {

    public static void main(String[] args) {
        //задание 4 "Циклы и Условия"
        int i;
        int j;
        for (i = 2; i < 100001; i++) {
            for (j = 2; (i % j) > 0; j++) {
            }
            if (j == i) {
                System.out.println(i + "\t");
            }
        }
        System.out.println("все числа подсчитаны");
    }
}