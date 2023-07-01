package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.CartPage;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartSteps {
    private WebDriver webDriver;

    public CartSteps() {
        super();
        this.webDriver = Hooks.webDriver;
    }

    @And("User already on cart page")
    public void verifyCartPage(){
        CartPage cartPage = new CartPage(webDriver);
        Assert.assertTrue(cartPage.isVerifyCartPageDisplayed());
        cartPage.clickCart();

    }

    @When("User Remove item from the cart page \"(.*)\"")
    public void ProductClick(String removeProduct) throws InterruptedException {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.ClickProduct(removeProduct);
    }

    @Then("User verify that the quantity of the item is the same as click on the sales page")
    public void userVerifyQuantityItemSameFromTheSalesPage() {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.VerifyQty();
    }

    @And("User verify that the price of the item is the same as listed on the sales page")
    public void userVerifyThatThePriceOfTheItemIsTheSameAsListedOnTheSalesPage() {
        CartPage cartPage = new CartPage(webDriver);
        cartPage.VerifyPrice();
    }

    @Then("User click checkout button")
    public void clickCheckout(){
        CartPage cartPage = new CartPage(webDriver);
        cartPage.clickCheckout();
    }

}