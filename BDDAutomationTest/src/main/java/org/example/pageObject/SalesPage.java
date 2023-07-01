package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SalesPage {

    private WebDriver driver;

    public SalesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement verifySalesPage;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortProduct;


    public boolean verifySalesPage() {
        return verifySalesPage.isDisplayed();
    }

    public void setSortProduct(String sort) {
        Select a = new Select(sortProduct);
        a.selectByVisibleText(sort);
    }

    public void productClick(String namaProduk) {
        String productElement = "//div[contains(text(), '" + namaProduk + "')]/ancestor::div[@class='inventory_item_description']//*[contains(@id,'add-to-cart')]";
        driver.findElement(By.xpath(productElement)).isDisplayed();
        driver.findElement(By.xpath(productElement)).click();
    }
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void verifyDetailProduct(String detail){
        String DetailProduct = "//div[.='" + detail + "']";
        driver.findElement(By.xpath(DetailProduct)).isDisplayed();
    }

    public void shoppingCartLink(){
        driver.findElement(By.xpath("//a[.='2']")).click();
    }
}
