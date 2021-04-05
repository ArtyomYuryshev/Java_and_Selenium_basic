//2 Вывести в консоль все уникальные элементы, созданные рандомизатором:

package course1.collections.randomSort;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Runner {

    public static void main(String[] args) {

        Set<Element> elements = new TreeSet<Element>();

        for (int i = 1; i < 100; i++) {
            Element element = new Element(new Random().nextInt(i));
            elements.add(element);
        }
        System.out.println(elements);
    }

}
