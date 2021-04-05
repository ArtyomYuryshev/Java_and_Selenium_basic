package course1.collections.progressions;

public class Geometric extends Progression {

    private  double firstElement;
    private double delta; //знаменатель геометрической прогрессии
    private double lastElemnt;
    private final String name = "Геометрическая прогрессия";

    public Geometric(double firstElement, double delta) {
        this.firstElement = firstElement;
        this.delta = delta;
    }

    @Override
    public double getSummNElements(double n) {
        System.out.println("Сумма элементов прогрессии равна: " + (firstElement * ((Math.pow(delta, n) - 1) / (delta - 1))));
        return (firstElement * ((Math.pow(delta, n) - 1) / (delta - 1)));
    }

    @Override
    public double getNElement(double n) {

        this.lastElemnt = (firstElement * Math.pow(delta, (n - 1)));
        System.out.println("Последний элемент прогрессии равен: " + lastElemnt);
        return this.lastElemnt;
    }

    @Override
    public String toString() {
        return "\n" + name + "; Первый элемент: " + firstElement
                + "; Разность прогрессии (дельта): " + delta;
    }

}
