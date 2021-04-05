package course1.exceptions;

public class Random {

    public void randomInt() throws AllWentWrong {
        int intA = (int) (1 + Math.random() * 100);
        if (intA > 50) {
            throw new AllWentWrong();
        } else {
            System.out.println(intA);
        }
    }

}
