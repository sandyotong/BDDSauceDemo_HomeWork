package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver webDriver;

    public LoginSteps(){
        super();
        this.webDriver = Hooks.webDriver;
    }

    @When("User input\"(.*)\" as userName and input\"(.*)\" as password")
    public void inputCredential(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();

    }
    @Given("User already on website sauce demo")
    public void  verifyLandingPage(){
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.verifyLandingPage());
    }

    @Then("User see error \"(.*)\" on login page")
    public void verifyErrorPage(String errorText){
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertEquals(errorText,loginPage.verifyErrorText());
    }

}
