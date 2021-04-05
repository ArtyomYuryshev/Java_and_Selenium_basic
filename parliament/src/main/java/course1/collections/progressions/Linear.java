package course1.collections.progressions;

public class Linear extends Progression {

    double firstElement;
    double delta; //Разность прогрессии
    double lastElemnt;
    double summElement;
    private final String name = "Арифметическая прогрессия";

    public Linear(double firstElement, double delta) {
        this.firstElement = firstElement;
        this.delta = delta;
    }

    @Override
    public double getSummNElements(double n) {
        this.summElement = ((firstElement + lastElemnt) * n) / 2;
        System.out.println("Сумма элементов прогрессии равна: " + this.summElement);
        return this.summElement;
    }

    @Override
    public double getNElement(double n) {
        this.lastElemnt = (firstElement + (n - 1) * delta);
        System.out.println("Последний элемент прогрессии равен: " + this.lastElemnt);
        return this.lastElemnt;
    }

    @Override
    public String toString() {
        return "\n" + name + "; Первый элемент: " + firstElement
                + "; Разность прогрессии (дельта): " + delta;
    }

}
