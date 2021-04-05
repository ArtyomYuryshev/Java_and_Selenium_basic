package course2.yandexMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Runner extends Base {

    /**
     * ПОМЕНЯТЬ ПУТЬ
     */
    private static final String path = System.getenv("csvFilePath");

    @Test
    public void test1() throws IOException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        //браузер на весь экран
        driver.manage().window().maximize();

        // неявное ожидание
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /**
         * 1) Зайти на страницу https://market.yandex.by
         */
        driver.get(getProperty("url"));

        /**
         * 2) Выполнить процесс авторизации
         */
        LoginPage loginPage = new LoginPage(driver);

        //клик кнопки вход
        loginPage.clickLoginBtn();

        driverWait();

        //проверка таб
        loginPage.tabCheck();

        //ждать 10 сек поле логин
        driverWaitByLocator(By.xpath(getProperty("loginFld")));

        //вводим логин
        loginPage.inputLogin(getProperty("login"));

        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        driverWait();

        //проверка таб после ввода логина
        loginPage.tabCheckPswd();

        //ждать 10 сек поле пароль
        driverWaitByLocator(By.xpath(getProperty("passwdFld")));

        //вводим пароль
        loginPage.inputPasswd(getProperty("passwd"));

        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        driverWait();

        //проверка таб после ввода пароля
        loginPage.tabCheckAfterLogin();

        /**
         * 3) Получить список популярных категорий товаров
         */
        driverWait();

        HomePage mainTab = new HomePage(driver);

        //получим лист для будущего сравнения
        ArrayList list1 = mainTab.arrayList();
        System.out.println(list1);

        /**
         * 4) Перейти на случайную категорию из списка
         */
        driverWait();

        //клик рандомной категории
        mainTab.clickRndCategory();

        /**
         * 5) Перейти на главную страницу сайта
         */
        driverWait();

        //вернуться на главную
        mainTab.clickLogo();

        /**
         * 6)  Кликнуть на «Все категории», получить список всех категорий.
         * Все найденные категории записать в csv файл, который должен создаваться тестом автоматически
         * */
        //ждать 10 секунд кнопка каталог
        driverWaitByLocator(By.xpath(getProperty("catalogBtn")));

        //открыть весь каталог
        mainTab.clickCatalogBtn();

        //ждать 10 секунд tablist каталог
        driverWaitByLocator(By.xpath(getProperty("tabList")));

        CatalogsPage catalogTab = new CatalogsPage(driver);
        ArrayList list2 = catalogTab.arrayList();

        // запись в csv
        writeCSV(list2, path);

        /**
         * 7) Проверить, что в списке «Всех категорий», полученном на шаге 6, содержатся
         * все категории популярных товаров, полученные в шаге 3
         */

        // сравнить ArrayList
        // выдаёт false, т.к. на топбаре и в разделе каталог элементы называются по разному
        // например "Компьютеры" и "Компьютерная техника"
        compareArray(list2, list1);

        /**
         * 8) Выполнить log out
         */
        mainTab.avatarClick();
        mainTab.logOut();
    }

}