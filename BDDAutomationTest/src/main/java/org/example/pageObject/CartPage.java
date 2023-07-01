package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement verifyCartPage;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[1]")
    private  WebElement cartKeranjang;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='cart_quantity']")
    private WebElement quantity;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private WebElement price;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isVerifyCartPageDisplayed() {
        return verifyCartPage.isDisplayed();
    }

    public void clickCart(){
        cartKeranjang.click();
    }

    public void ClickProduct(String productNama){
        String productItem = "//div[contains(text(), '" + productNama + "')]/ancestor::div[@class='cart_item_label']//*[contains(@id,'remove')]";
        driver.findElement(By.xpath(productItem)).isDisplayed();
        driver.findElement(By.xpath(productItem)).click();
    }

    public void VerifyQty(){
        quantity.isDisplayed();
    }

    public void VerifyPrice(){
        price.isDisplayed();
    }

    public void clickCheckout(){
        checkoutButton.click();
    }
}