package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;

public class Customers {
    WebDriver driver;
    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement Customers;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement coustomerName;
    @CacheLookup
    @FindBy(xpath = "//td[text()='Hermoine']")
    WebElement searchresult;

    public Customers(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public  void customers() throws AWTException {
        Customers.click();
        coustomerName.sendKeys("Hermoine");
        String search=searchresult.getText();
        Assert.assertEquals(search,"Hermoine");

    }
}
