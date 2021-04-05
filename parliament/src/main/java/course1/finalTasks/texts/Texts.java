package course1.finalTasks.texts;

import java.nio.charset.StandardCharsets;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Texts {

    // переменная для хранения пути к файлу
    private static String filePath;

    // переменная для хранения префикса имени к результирующему файлу
    private static final String prefix = "_res";

    // константа для нуля
    private final static int indexOfTableHeader = 0;

    // переменная для хранения списка строк результирующего файла
    private static ArrayList<String> result;

    // для возврата строк финального файла
    public static ArrayList<String> getResult() {
        return result;
    }

    /** Метод берёт строки из исходного файла, перемешивает случайно строки.
     * Из указанного кол-ва строк создаёт новый список и удаляет эти строки из исходного файла.
     *
     * @param path путь к файлу
     * @param row  количестresво строк
     * @return возвращает List со случайными строками
     * @throws IOException вызывается если файла нет
     */
    public static List<String> selectLine(String path, int row) throws IOException {
        filePath = path;
        List<String> lines = (List<String>) Files.readAllLines(Paths.get(filePath), StandardCharsets.ISO_8859_1);
        String title = lines.get(indexOfTableHeader);
        lines.remove(indexOfTableHeader);
        List<String> dump = new ArrayList<String>(lines);
        Collections.shuffle(dump);
        result = new ArrayList<String>();
        try {
            while (--row > indexOfTableHeader) {
                result.add(dump.get(row));
            }
            lines.removeAll(result);
            result.add(indexOfTableHeader, title);
            lines.add(indexOfTableHeader, title);
            writeFile(lines);
            writeFile(result, prefix);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println(String.format("%1s \nпуть не существует!", exception));
        }
        return result;
    }

    /** Переопределение метода с параметром row = 10.
     *
     * @param path путь к файлу
     * @return возвращает List со случайными строками
     * @throws IOException будет вызыватся если файла нет
     * @see Texts#selectLine(String, int)
     */
    public static List<String> selectLine(String path) throws IOException {
        return selectLine(path, 10);
    }


    /** Метод для записи файла.
     *
     * @param line   лист со строками которые нужно записать в файл
     * @param prefix перфикс нового файла
     * @throws IOException будет вызыватся если файла нет
     */
    public static void writeFile(List<String> line, String prefix) throws IOException {
        if (!prefix.equals("")) {
            filePath = filePath.replace(".txt", prefix + ".txt");
            System.out.println("Результат: " + filePath);
        }
        File file = new File(filePath);
        file.createNewFile();
        Files.write(Paths.get(file.getPath()), line, StandardCharsets.ISO_8859_1);
    }

    // переопределение метода для записи файла без префикса
    public static void writeFile(List<String> line) throws IOException {
        writeFile(line, "");
    }

    // вводим путь к файлу
    public static void enterPath() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите путь: ");
        filePath = in.nextLine();
        for (int i = 1; i < 4; i++) {
            if (filePath.equals("")) {
                System.out.println(String.format("Попытка %1d из 3", i));
                System.out.println("Введите путь");
                filePath = in.nextLine();
            } else {
                break;
            }
        }
    }

    // вводим кол-во строк для обработки
    public static void enterLineCount() throws IOException {
        enterPath();
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        String row = in.nextLine();
        if (row.equals("")) {
            selectLine(filePath);
        } else {
            try {
                selectLine(filePath, Integer.parseInt(row));
            } catch (IOException exception) {
                System.out.println(String.format("%1s \nпуть не существует!", exception));
            }
        }
        for (String s : getResult()) {
            System.out.println(s);
        }
    }

}