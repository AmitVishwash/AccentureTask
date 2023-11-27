package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdef.Hooks;
import utilities.ActionLibrary;

import java.util.Iterator;
import java.util.Set;

public class LaptopCategoryPage {
    WebDriver driver;
    ActionLibrary actionLibrary = new ActionLibrary();

    private static String parentWindow;

    public LaptopCategoryPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//img[@title='Flipkart']")
    public static WebElement laptopsPageLabel;

    @FindBy(xpath = "//span[contains(text(),'Filters')]")
    public static WebElement filterLabel;

    @FindBy(xpath = "//span[contains(text(),'CATEGORIES')]")
    public static WebElement categoriesLabel;

    @FindBy(xpath = "//span[contains(text(),'Price')]")
    public static WebElement priceLabel;

    @FindBy(xpath = "//div[text()='Brand']")
    public static WebElement brandLabel;

    @FindBy(xpath = "//div[text()='Popularity']")
    public static WebElement sortByPopularityButton;

    @FindBy(xpath = "//div[text()='Price -- Low to High']")
    public static WebElement sortByLowToHighButton;

    @FindBy(xpath = "//div[text()='Price -- High to Low']")
    public static WebElement sortByHighToLowButton;

    @FindBy(xpath = "//div[text()='Newest First']")
    public static WebElement sortByNewestFirstButton;

    @FindBy(xpath = "//div[text()='₹4,29,990']")
    public static WebElement highestCostProduct_1;

    @FindBy(xpath = "//div[text()='₹4,20,000']")
    public static WebElement highestCostProduct_2;

    @FindBy(xpath = "//li[@class='col col-6-12'][1]")
    public static WebElement addToCartButton;


    @FindBy(xpath = "//span[contains(text(),'Cart')]")
    public static WebElement cartIcon;


    public void isSubCategoryPageDisplayed() {
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(laptopsPageLabel));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(filterLabel));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(categoriesLabel));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(priceLabel));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(brandLabel));
        Assert.assertTrue(actionLibrary.getElementIsEnabledStatus(sortByPopularityButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(sortByLowToHighButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(sortByHighToLowButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(sortByNewestFirstButton));

    }


    public void clickOnFilterCategory(String filterCategory) {
        WebElement element = Hooks.driver.findElement(By.xpath("//div[text()=" + "'" + filterCategory + "'" + "]"));
        actionLibrary.clickElement(element);
    }

    public void addTwoProducts() throws InterruptedException {

            addFirstProduct();
            addSecondProduct();
    }

    private void addSecondProduct() throws InterruptedException {
        actionLibrary.clickElement(highestCostProduct_2);
        Set<String> windows = Hooks.driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!parentWindow.equals(childWindow)) {
                Hooks.driver.switchTo().window(childWindow);
                actionLibrary.clickElement(addToCartButton);
                Thread.sleep(5000);
                Hooks.driver.close();
            }
        }
        Hooks.driver.switchTo().window(parentWindow);

    }

    private void addFirstProduct() throws InterruptedException {
        parentWindow = Hooks.driver.getWindowHandle();
        actionLibrary.clickElement(highestCostProduct_1);
        Set<String> windows = Hooks.driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!parentWindow.equals(childWindow)) {
                Hooks.driver.switchTo().window(childWindow);
                actionLibrary.clickElement(addToCartButton);
                Thread.sleep(5000);
                Hooks.driver.close();
            }
        }

        Hooks.driver.switchTo().window(parentWindow);
    }

    public void clickOnCartIcon() {
        actionLibrary.clickElement(cartIcon);
    }
}
