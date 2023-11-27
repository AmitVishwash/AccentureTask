package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ActionLibrary;

public class AddToCartPage {

    WebDriver driver;
    ActionLibrary actionLibrary = new ActionLibrary();

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Flipkart (')][1]")
    public static WebElement productCount;

    public void checkProductCount(String expectedCount) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualCount = productCount.getText().substring(10, 11);
        Assert.assertEquals(expectedCount, actualCount);
    }

}
