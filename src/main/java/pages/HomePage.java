package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@class='header-search__field evinent-search-input']")
    private WebElement searchInput;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void fillSearchInput(String name) {
        searchInput.clear();
        searchInput.sendKeys(name, Keys.ENTER);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }
}