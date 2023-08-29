package com.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class Customer_Login {
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
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Transactions']")
    WebElement transaction;
    @CacheLookup
    @FindBy(xpath = "//td[normalize-space()='Credit']")
    WebElement credit;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Back']")
    WebElement Back;
    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withdrawlbutton;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit1;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement transactionsuccess;
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn logout']")
    WebElement logoutbutn;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn home']")
    WebElement home;

    public  Customer_Login( WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    public String currentTitle() {
        String currenttitle = driver.getTitle();
        return currenttitle;
    }
    public void customerlogin() throws InterruptedException {
        coustomerlogin.click();
        Thread.sleep(2000);
        username.click();
        Select select = new Select(username);
        select.selectByVisibleText("Neville Longbottom");
        submitbtn.click();
    }

    public String depositAmount() throws InterruptedException, IOException {
        Depositbutton.click();
        Thread.sleep(2000);
        Amount.sendKeys("100");
        submit.click();

        String dp = driver.findElement(By.xpath("//span[@class='error ng-binding']")).getText();

        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File ss=screenshot.getScreenshotAs(OutputType.FILE);
        File destination= new File("C:\\Users\\kiran\\IdeaProjects\\XYZBank_Automation\\src\\main\\resources\\srcshot1.jpg");
        FileHandler.copy(ss,destination);
        return dp;
    }

    public String transactions() throws InterruptedException {
        Thread.sleep(2000);
        transaction.click();
        Thread.sleep(2000);
        String cr = credit.getText();

        Back.click();
        return cr;
    }

    public String withdrawl() throws InterruptedException {
        Thread.sleep(2000);
        withdrawlbutton.click();
        amount.sendKeys("50");
        submit1.click();
        //Transaction successful
        String tr = transactionsuccess.getText();

        return tr;
    }
    public  void LogOut(){
        logoutbutn.click();
        home.click();
    }

}