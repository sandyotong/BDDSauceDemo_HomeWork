package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.CheckOutOverviewPage;
import org.example.pageObject.SalesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckOutOverviewStep {
    private WebDriver webDriver;

    public CheckOutOverviewStep() {
        super();
        this.webDriver = Hooks.webDriver;
    }

    @And("User already on checkout overview page")
    public void checkoutOverviewPage() {
        CheckOutOverviewPage checkoutView = new CheckOutOverviewPage(webDriver);
        Assert.assertTrue(checkoutView.VerifyCheckOutOverviewPage());
    }

    @When("User verify the total price of item is \"([^\"]*)\"")
    public void userVerifiesTheTotalPriceOfItemIs(String expectedPrice) throws Throwable {
        CheckOutOverviewPage checkoutViewPage = new CheckOutOverviewPage(webDriver);
        String actualPrice = checkoutViewPage.getTotalPrice();
        Assert.assertEquals(Double.parseDouble(expectedPrice), Double.parseDouble(actualPrice), 0.01);
    }

    @Then("User click finish button")
    public void clickFinishButton() throws InterruptedException {
        CheckOutOverviewPage chekoutViewPage = new CheckOutOverviewPage(webDriver);
        chekoutViewPage.clickFinishBtn();
    }

    @And("User already on checkout: complete! page")
    public void completePage() throws InterruptedException {
        CheckOutOverviewPage checkoutView = new CheckOutOverviewPage(webDriver);
        Assert.assertTrue(checkoutView.verifyCompletePage());
    }

    @When("User click Back home button")
    public void clickBackToHome() throws InterruptedException {
        CheckOutOverviewPage checkoutView = new CheckOutOverviewPage(webDriver);
        checkoutView.clickBactoHomeBtn();

    }

    @Then("User back to sales page")
    public void backToSalesPage() throws InterruptedException {
        CheckOutOverviewPage checkoutView = new CheckOutOverviewPage(webDriver);
        Assert.assertTrue(checkoutView.verifySalesPage());
    }

    @When("User click burger button")
    public void userClickBurgerButton() {
        CheckOutOverviewPage checkout = new CheckOutOverviewPage(webDriver);
        checkout.burgerButton();
    }


    @Then("User click logout button")
    public void userClickLogoutButton() {
        CheckOutOverviewPage logout = new CheckOutOverviewPage(webDriver);
        logout.logoutButton();
    }
}

