package course2.yandexMarket;

//https://habr.com/ru/post/502292/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class LoginPage extends Base {

    public WebDriver driver;

    //private WebElement loginField = driver.findElement(By.xpath("//*[contains(@id, 'passp-field-login')]"));

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля ввода логина
     */
    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;

    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginBtn;
    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwdField;

    /**
     * метод для ввода логина
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    /**
     * метод для ввода пароля
     */
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public void clickLoginBtn() {
        loginBtn.click();
    }

    /**
     * методы для проверки открытых таб
     */
    // периодически страница авторизации открывается в новой вкладке а иногда в той же
    public void tabCheck() {
        ArrayList tabs = new ArrayList(driver.getWindowHandles());//Получение списка табов
        if (tabs.size() > 1) {
            driver.switchTo().window((String) tabs.get(1));//Переключение на второй таб в браузере
        } else {
            System.out.println("One tab only");
        }
    }

    //танец с бубном нужен т.к. после ввода логина меняется url у страницы и драйвер это не понимает, поэтому тут костыль
    public void tabCheckPswd() {
        ArrayList tabs = new ArrayList(driver.getWindowHandles()); // Получение списка табов
        if (tabs.size() > 1) {
            driver.switchTo().window((String) tabs.get(0)); //Переключение на первый таб в браузере
            driver.switchTo().window((String) tabs.get(1)); //Переключение на второй таб в браузере
        } else {
            System.out.println("One tab only");
        }
    }

    // драйвер не понимаент, что осталась только одна страница и ищет дальнейший элемент не там -_-
    public void tabCheckAfterLogin() {
        ArrayList tabs = new ArrayList(driver.getWindowHandles()); // Получение списка табов
        driver.switchTo().window((String) tabs.get(0));
        // ОСТАЁТСЯ ПУСТАЯ СТРАНИЦА 0_o
    }

}