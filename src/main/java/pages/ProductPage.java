package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class='button product-box__main-buy__button buy-button product-buy-button']")
    private WebElement buyButton;

    @FindBy(xpath = "//div[@class='header-tooltip__cards-item__price']")
    private WebElement priceInCartSumSpan;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBuyButton() {
        buyButton.click();
    }

    public String getSumOFPriceInCartSumSpan() {
        return priceInCartSumSpan.getText().replaceAll("\\s+", "");
    }

}