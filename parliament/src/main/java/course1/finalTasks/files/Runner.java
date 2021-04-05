//Разработать консольное приложение "Поиск последнего созданного файла с заданным расширением"
// args[0] и args[1] задаются через настройки конфигурации
package course1.finalTasks.files;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        Search search = new Search();
        search.getFilesByCreationDate(args[0], args[1]);
    }

}