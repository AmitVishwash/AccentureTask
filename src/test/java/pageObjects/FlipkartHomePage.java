package pageObjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdef.Hooks;
import utilities.ActionLibrary;

public class FlipkartHomePage {

    WebDriver driver;
    ActionLibrary actionLibrary = new ActionLibrary();
    public FlipkartHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//img[@title='Flipkart']")
    public static WebElement flipkartIcon;

    @FindBy(xpath = "//input[@name='q']")
    public static WebElement searchBox;

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    public static WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    public static WebElement cartButton;

    @FindBy(xpath = "//a[contains(text(),'Become a Seller')]")
    public static WebElement becomeASellerButton;

    @FindBy(xpath = "//span[@role='button']")
    public static WebElement crossButton;


    public void launchApplication() {
        actionLibrary.launchUrl();
    }

    public void isHomePageDisplayed()
    {
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(flipkartIcon));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(searchBox));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(loginButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(cartButton));
        Assert.assertTrue(actionLibrary.getElementIsDisplayedStatus(becomeASellerButton));
    }

    public void clickOn_X(){
        actionLibrary.clickElement(crossButton);
    }

    public void hoverOnCategory(String productCategory) throws InterruptedException {
        WebElement element = Hooks.driver.findElement(By.xpath("//span[contains(text()," + "'"+ productCategory +"'" + ")]"));
        actionLibrary.hover(element);

    }

    public void clickOnSubProductCategory(String subProductCategory) {
        WebElement element = driver.findElement(By.xpath("//a[contains(text()," + "'" + subProductCategory + "'" + ")]"));
        actionLibrary.clickElement(element);
    }
}
