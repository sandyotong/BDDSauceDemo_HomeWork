package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.CheckOutPageInformation;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckOutStepsInformation {
    private WebDriver webDriver;

    public CheckOutStepsInformation(){
        super();
        this.webDriver = Hooks.webDriver;
    }

    @And("User already on checkout page")
    public void verifyCheckoutInfoPage() throws InterruptedException {
        CheckOutPageInformation checkoutInfo = new CheckOutPageInformation(webDriver);
        Assert.assertTrue(checkoutInfo.verifyCheckoutInformationPage());
    }
    @When("User inputs \"(.*)\" as firstName, inputs \"(.*)\" as lastName, inputs \"(.*)\" as postalCode")
    public void inputInformation(String firstName, String lastName, String postalCode) throws InterruptedException {
        CheckOutPageInformation checkoutInfo = new CheckOutPageInformation(webDriver);
        checkoutInfo.setFirstName(firstName);
        checkoutInfo.setLastName(lastName);
        checkoutInfo.setPostalCode(postalCode);
    }

    @Then("User click continue button")
    public void clickContiune() throws InterruptedException {
        CheckOutPageInformation checkOutPageInformation = new CheckOutPageInformation(webDriver);
        checkOutPageInformation.clickContinue();
    }
}
