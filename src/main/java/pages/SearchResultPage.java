package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {


    @FindBy(xpath = "//div[@class='listing__body-wrap image-switch']//div")
    private List<WebElement> listOfProducts;
    @FindBy(xpath = "//ul[@class='listing__body-sort']//li[@data-sort-order='PriceDesc']//a")
    private WebElement sortFromExpensiveToLowLink;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstElementFromListOfProducts() {
        listOfProducts.get(0).click();
    }

    public void clickOnSortFromExpensiveToLowLink() {
        sortFromExpensiveToLowLink.click();
    }

}