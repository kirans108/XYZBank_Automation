package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Transactions {
    WebDriver driver;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Transactions']")
    WebElement transaction;
    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Credit']")
    WebElement credit;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Back']")
    WebElement Back;

    public Transactions(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void transactions() throws InterruptedException {
        Thread.sleep(2000);
        transaction.click();
        Thread.sleep(2000);
        String  cr=credit.getText();
        Assert.assertEquals(cr, "Credit");
        Back.click();


    }
}