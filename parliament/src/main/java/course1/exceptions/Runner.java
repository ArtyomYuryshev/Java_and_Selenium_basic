package course1.exceptions;

public class Runner {

    public static void main(String[] args) {
        Random rnd = new Random();
        try {
            rnd.randomInt();
            System.out.println("всё ок");
        } catch (AllWentWrong e) {
            e.printStackTrace();
        } finally {
            System.out.println("трай кэтч блок закончен");
        }
    }
}
