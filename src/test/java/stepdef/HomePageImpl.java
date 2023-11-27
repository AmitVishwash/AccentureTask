package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddToCartPage;
import pageObjects.FlipkartHomePage;
import pageObjects.LaptopCategoryPage;

public class HomePageImpl {

    FlipkartHomePage homePage = new FlipkartHomePage(Hooks.driver);
    LaptopCategoryPage laptopCategoryPage = new LaptopCategoryPage(Hooks.driver);
    AddToCartPage addToCartPage = new AddToCartPage(Hooks.driver);

    @Given("User  is on home page of application")
    public void userIsOnHomePageOfApplication() {
        homePage.launchApplication();
        homePage.isHomePageDisplayed();
        homePage.clickOn_X();
    }
    @And("User clicks on the {string} product category")
    public void user_clicks_on_the_product_category(String productCategory) throws InterruptedException {
        homePage.hoverOnCategory(productCategory);


    }
    @And("User selects {string} for product category")
    public void user_selects_for_product_category(String subProductCategory) throws InterruptedException {Thread.sleep(10);
        homePage.clickOnSubProductCategory(subProductCategory);
    }

    @Then("{string} page should be displayed")
    public void pageShouldBeDisplayed(String subcategory) {
        laptopCategoryPage.isSubCategoryPageDisplayed();
    }

    @And("user adds the top two products")
    public void userAddsTheTopTwoProducts() throws InterruptedException {

            laptopCategoryPage.addTwoProducts();

    }

    @When("user filters the category by {string}")
    public void userFiltersTheCategoryBy(String filterCategory) {
        laptopCategoryPage.clickOnFilterCategory(filterCategory);
    }

    @Then("the total product count should be {string}")
    public void theTotalProductCountShouldBe(String count) {
        laptopCategoryPage.clickOnCartIcon();
        addToCartPage.checkProductCount(count);
        try {
            Thread.sleep(6);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
