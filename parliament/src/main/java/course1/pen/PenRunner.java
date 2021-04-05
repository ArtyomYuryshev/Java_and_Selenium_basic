package course1.pen;

public class PenRunner {

    public static void main(String[] args) {
        Pen pen = new Pen(1);
        System.out.println(pen.write("Test"));


        pen.isWork();
        System.out.println(pen.isWork());

        pen.doSomethingElse();


    }
}