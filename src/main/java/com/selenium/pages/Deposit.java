package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Deposit {
    WebDriver driver;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement Depositbutton;
    @CacheLookup
    @FindBy(xpath = "//input[@ng-model='amount']")
    WebElement Amount;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement DepositSuccess;

    public Deposit(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void depositAmount() throws InterruptedException {
        Depositbutton.click();
        Thread.sleep(2000);
        Amount.sendKeys("100");
        submit.click();
        String dp=DepositSuccess.getText();
        Assert.assertEquals(dp,"Deposit Successful");
    }
}
