package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenAccount {
    WebDriver driver;
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
    WebElement submit;
    public OpenAccount(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void openacc(){
        openacount.click();
        coustomername.click();
        Select select1 = new Select(coustomername);
        select1.selectByVisibleText("Harry Potter");

        currency.click();
        Select select2=new Select(currency);
        select2.selectByVisibleText("Rupee");

        submit.click();
        driver.switchTo().alert().accept();
    }
}
