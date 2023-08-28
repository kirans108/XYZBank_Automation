package com.selenium.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement coustomerlogin;
    @CacheLookup
    @FindBy(name = "userSelect")
    WebElement username;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitbtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void currentTitle() {
        String currenttitle = driver.getTitle();
        System.out.println(currenttitle);
        Assert.assertEquals(currenttitle, "XYZ Bank");
    }

    public void customerlogin() throws InterruptedException {
        coustomerlogin.click();
        Thread.sleep(2000);
        username.click();
        Select select = new Select(username);
        select.selectByVisibleText("Neville Longbottom");
        submitbtn.click();
    }


}
