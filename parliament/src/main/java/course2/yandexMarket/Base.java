package course2.yandexMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Base {

    protected WebDriver driver;

    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    static {
        try {
            //указание пути до файла с настройками
            fileInputStream = new FileInputStream("src/main/java/course2/yandexMarket/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //обработка возможного исключения (нет файла и т.п.)
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * метод для возврата строки со значением из файла с настройками
     */
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key); }

    /**
     * ожидание 10 сек пока не доступен элемент по локатору
     */
    public void driverWaitByLocator(By locator) {
        new WebDriverWait(driver, 10000).until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * FluentWait
     */
    public void driverWait() {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(3, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }

    /**
     * для сравнения каталогов из топбара и из списка всех каталогов
     * @param first - ArrayList в котором ищем элементы из второго листа
     * @param second - ArrayList элементы которого ищем
     */
    protected void compareArray(ArrayList first, ArrayList second) {
        System.out.println(first.contains(second));
    }

    /**
     * запись названий категорий в csv
     * @param list - список категорий
     * @param path - путь, куда писать
     * @throws IOException - эксепшен
     */
    public static void writeCSV(ArrayList list, String path) throws IOException {
        new File(path);
        FileWriter writer = new FileWriter(path);
        List<String> test = list;
        String collect = test.stream().collect(Collectors.joining(", "));
        System.out.println(collect);
        writer.write(collect);
        writer.close();
    }

}