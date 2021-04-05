package course2.yandexMarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage extends Base {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора списка категорий на топбаре
     */
    @FindBy(css = "div[data-zone-name^='category-link'] span")
    private List<WebElement> categoriesList;

    /**
     * определение кнопки-логотипа
     */
    @FindBy(xpath = "//a[@id='logoPartMarket']/span[@class='_1SD7TRqR9b']")
    private WebElement logoBtn;

    /**
     * определение кнопки Каталог
     */
    @FindBy(xpath = "//span[@class=\"_2ZRlRXSh_x\"]")
    private WebElement catalogBtn;


    /**
     * определение локатора аватарки
     */
    @FindBy(xpath = "//img[@alt=\"user-avatar\"]")
    private WebElement avatar;


    /**
     * определение локатора кнопки выход
     */
    @FindBy(xpath = "//a[@class=\"_1CD2dC53fk _2ytcXq-1F2 side-menu-item_exit\"]")
    private WebElement logoutBtn;

    /**
     * получить список элементов на топбаре
     */
    public List<WebElement> topbarElementsList() {
        List<WebElement> topbarElementsList = categoriesList.subList(1,12);
        return topbarElementsList;
    }

    /**
     * получить название категорйи и сохранить в лист
     */
    public ArrayList<String> arrayList() {
        ArrayList<String> list = new ArrayList<>();
        for (WebElement webElement : topbarElementsList()) {
            String text = webElement.getText();
            list.add(text);
        }
        return list;
    }

    /**
     * кликнуть рандомную категорию
     */
    public void clickRndCategory() {
        List<WebElement> list = topbarElementsList();
        Random random = new Random();
        WebElement randomTab = list.get(random.nextInt(list.size()));
        randomTab.click();
    }

    /**
     * кликнуть лого
     */
    public void clickLogo() {
        logoBtn.click();
    }

    /**
     * открыть весь каталог
     */
    public void clickCatalogBtn() {
        catalogBtn.click();
    }

    /**
     * кликнуть по аватарке
     */
    public void avatarClick() {
        avatar.click();
    }

    /**
     * вылогинится
     */
    public void logOut() {
        Actions action = new Actions(driver);
        action.click(logoutBtn).perform();
    }

}