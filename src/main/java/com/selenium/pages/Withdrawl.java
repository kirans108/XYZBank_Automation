package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Withdrawl {
        WebDriver driver;

        @CacheLookup
        @FindBy(xpath = "//button[@class='btn btn-lg tab btn-primary']")
        WebElement withdrawlbutton;

        @CacheLookup
        @FindBy(xpath = "//input[@placeholder='amount']")
        WebElement amount;
        @CacheLookup
        @FindBy(xpath = "//button[@type='submit']")
        WebElement submit;
        @CacheLookup
        @FindBy(xpath = "//button[@type='submit']")
        WebElement transactionsuccess;

        public Withdrawl(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);

        }

    public  void withdrawl() throws InterruptedException {
        Thread.sleep(2000);
        withdrawlbutton.click();
        amount.sendKeys("50");
        submit.click();
        //Transaction successful
        String tr=transactionsuccess.getText();
        Assert.assertEquals(tr,"Deposit");
    }
}
