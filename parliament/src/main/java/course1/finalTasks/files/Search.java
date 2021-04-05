package course1.finalTasks.files;

import java.text.SimpleDateFormat;
import java.util.*;
import java.nio.file.*;
import java.io.*;
import java.util.stream.Collectors;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;

public class Search {

    // переменная равная 10 сек. для разницы в дате создания файлов
    private final int timeDifference = 10000;

    // настройка формата вывода даты
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    // создаём список файлов с расширениями и выводим самый "свежий" файл
    // + список файлов дата создания которых отличается от этого файла не более чем на 10 секунд
    public void getFilesByCreationDate(String path, String extension) throws IOException {
        List<File> files = getFilesAndSort(path, extension);
        for (File file : files) {
            BasicFileAttributes attributes = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);
            if (attributes.creationTime().toMillis() > Files.readAttributes(Paths.get(files.get(0).getPath()),
                    BasicFileAttributes.class).creationTime().toMillis() - timeDifference) {
                System.out.println(String.format("%1s --> creation time : %2s", file.getName(),
                        dateFormat.format(attributes.creationTime().toMillis())));

            }
        }
    }

    // получаем расширение файлов
    public String getExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    // получаем список файлов и сортируем файлы по времени модификации
    public ArrayList<File> getFilesAndSort(String filePath, String extension) {
        try {
            ArrayList<File> files = (ArrayList<File>) Files.walk(Paths.get(filePath))
                    .filter((f) -> getExtension(new File(String.valueOf(f))).equals(extension))
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            files.sort(new Comparator<File>() {
                public int compare(File file1, File file2) {
                    return Long.compare(file1.lastModified(), file2.lastModified());
                }
            });
            Collections.reverse(files);
            return files;
        } catch (IOException exception) {
            System.out.println(String.format("%1s \nпуть не существует!", exception));
            return null;
        }
    }

}