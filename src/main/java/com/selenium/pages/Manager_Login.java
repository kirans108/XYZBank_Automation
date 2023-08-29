package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;

public class Manager_Login {
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
    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement Customers;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement coustomerName;
    @CacheLookup
    @FindBy(xpath = "//td[text()='Hermoine']")
    WebElement searchresult;

    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement openacount;
    @CacheLookup
    @FindBy(xpath ="//select[@id='userSelect'] ")
    WebElement coustomername;
    @CacheLookup
    @FindBy(xpath =" //select[@id='currency']")
    WebElement currency;
    @CacheLookup
    @FindBy(xpath =" //button[@type='submit']")
    WebElement submit1;
    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement searchtab;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement SearchCustomer;
    @CacheLookup
    @FindBy(xpath = "//td[text()='Hermoine']")
    WebElement search;
    public  Manager_Login( WebDriver driver) {
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
    public  void customers() throws AWTException {
        Customers.click();
        coustomerName.sendKeys("Hermoine");
        String search=searchresult.getText();
        Assert.assertEquals(search,"Hermoine");

    }
    public void openacc(){
        openacount.click();
        coustomername.click();
        Select select1 = new Select(coustomername);
        select1.selectByVisibleText("Harry Potter");

        currency.click();
        Select select2=new Select(currency);
        select2.selectByVisibleText("Rupee");

        submit1.click();
        driver.switchTo().alert().accept();
    }
    public void search(){
        searchtab.click();
        SearchCustomer.sendKeys("Hermoine");
        String search2=search.getText();
        Assert.assertEquals(search2,"Hermoine");
    }
}
