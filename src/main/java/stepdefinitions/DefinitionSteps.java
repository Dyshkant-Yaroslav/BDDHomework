package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.PageFactoryManager;
import pages.ProductPage;
import pages.SearchResultPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {
    private static final int DEFAULT_WAIT_TIME = 20000;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User open {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User enter in search input word {string}")
    public void userEnterInSearchInputWordProductType(final String type) {
        homePage.fillSearchInput(type);
        homePage.defaultWaiters(DEFAULT_WAIT_TIME);
    }

    @And("User sort products from expensive to low price")
    public void userSortProductsFromExpensiveToLowPrice() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.clickOnSortFromExpensiveToLowLink();
        searchResultPage.defaultWaiters(DEFAULT_WAIT_TIME);
    }

    @And("User click on first product")
    public void userClickOnFirstProduct() {
        searchResultPage.clickOnFirstElementFromListOfProducts();
        searchResultPage.defaultWaiters(DEFAULT_WAIT_TIME);
    }

    @And("User click on buy button")
    public void userClickOnBuyButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnBuyButton();
        productPage.defaultWaiters(DEFAULT_WAIT_TIME);
    }

    @Then("User check that sum of products in cart equals {string}")
    public void userCheckThatSumOfProductsInCartEqualsExpectedAmount(final String expectedAmount) {
        Assert.assertTrue(productPage.getSumOFPriceInCartSumSpan().contains(expectedAmount));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
