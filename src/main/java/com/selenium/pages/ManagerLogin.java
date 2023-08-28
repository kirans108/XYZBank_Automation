package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerLogin {
    WebDriver driver;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Bank Manager Login']")
    WebElement login;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement AddCustomer;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement FirstName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement LastName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement PostCode;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    public  ManagerLogin(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void managerlogin(/*String first,String last,String pincode*/){
        login.click();
        //Add Customer
        AddCustomer.click();
        FirstName.sendKeys("rohit");
        LastName.sendKeys("sharma");
       PostCode.sendKeys("582219");
        submit.click();
        driver.switchTo().alert().accept();
    }
}
