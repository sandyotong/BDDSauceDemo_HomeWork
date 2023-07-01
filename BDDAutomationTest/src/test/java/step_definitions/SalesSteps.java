package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.SalesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class SalesSteps {

    private WebDriver webDriver;

    public SalesSteps(){
        super();
        this.webDriver = Hooks.webDriver;
    }

    @Then("User already on sales page")
    public void verifySalesPage(){
        SalesPage salesPage = new SalesPage(webDriver);
        Assert.assertTrue(salesPage.verifySalesPage());
    }

    @When("User sort product list by \"(.*)\"")
    public void selectAutoSorting(String sort) throws InterruptedException {
        SalesPage salesPage = new SalesPage(webDriver);
        salesPage.setSortProduct(sort);

    }

    @Then("User pick up items from the checkout list \"(.*)\" and \"(.*)\" and to cart list")
    public void clickProduct(String product1, String product2) throws InterruptedException {
        SalesPage salesPage = new SalesPage(webDriver);
        salesPage.productClick(product1);
        salesPage.productClick(product2);
    }

    @When("User click \"(.*)\" to show detailed product information")
    public void verifyDetail(String product1) throws InterruptedException {
        SalesPage salesPage = new SalesPage(webDriver);
        salesPage.verifyDetailProduct(product1);

    }

    @Then("User click shopping_cart_link")
    public void userClickShopping_cart_link() throws InterruptedException {
        SalesPage salesPage = new SalesPage(webDriver);
        salesPage.shoppingCartLink();
    }

}
