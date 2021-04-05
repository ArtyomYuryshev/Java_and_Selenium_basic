package course2.yandexMarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CatalogsPage extends Base {

    public WebDriver driver;

    public CatalogsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля списка категорий
     */
//    Первый Вариант
//    @FindBy(css = "div[role = tablist] button span")
//    private List<WebElement> allCategories;

    @FindBy(xpath = "//a[@class=\"_3Lwc_UVFq4\"]/img")
    private List<WebElement> allCategories;


    /**
     * получить список всех категорий
     */
    public List<WebElement> allCategoriesList() {
        List<WebElement> allCategoriesList = allCategories;
        return allCategoriesList;
    }

    /**
     * получить название категорйи и сохранить в лист
     */
    public ArrayList<String> arrayList() {
        ArrayList<String> list = new ArrayList<>();
        for (WebElement webElement : allCategoriesList()) {
            String text = webElement.getAttribute("alt");
            list.add(text);
        }
        return list;
    }

//    Первый Вариант
//    public ArrayList<String> arrayList2() {
//        ArrayList<String> list = new ArrayList<>();
//        for (WebElement webElement : allCategoriesList()) {
//            String text = webElement.getText();
//            list.add(text);
//        }
//        return list;
//    }

}