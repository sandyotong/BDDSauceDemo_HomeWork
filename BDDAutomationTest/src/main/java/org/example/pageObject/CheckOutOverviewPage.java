package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage {

    public static  WebDriver driver;

    public  CheckOutOverviewPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@class='title']")
        private WebElement VerifyCheckOutOverviewPage;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement verifyTotalPrice;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement verifyPrice;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement taxLabel;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishBtn;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement verifyCompletePage;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backToHome;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement verifySalesPage;

    @FindBy(xpath = "//div[@class='bm-burger-button']")
    private WebElement burgerButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutSidebarLink;

    public boolean VerifyCheckOutOverviewPage() {
        return VerifyCheckOutOverviewPage. isDisplayed();
    }

    public String getTotalPrice() {
        String totalPrice = verifyTotalPrice.getText().replace("Total: $", "");
        return String.format("%.2f", Double.parseDouble(totalPrice));
    }

    public void clickFinishBtn (){
        finishBtn.click();
    }

    public boolean verifyCompletePage() {
        return verifyCompletePage.isDisplayed();
    }

    public void clickBactoHomeBtn(){
        backToHome.click();
    }

    public boolean verifySalesPage() {
        return verifySalesPage.isDisplayed();
    }

    public void burgerButton(){
        burgerButton.click();
    }

    public void logoutButton(){
        logoutSidebarLink.click();
    }
}

