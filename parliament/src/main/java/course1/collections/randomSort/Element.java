package course1.collections.randomSort;

public class Element implements Comparable {

    private int number;

    public Element(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Object o) {
        return ((Element) o).number - number;
    }

    @Override
    public String toString() {
        return "\n" + number;
    }
}
