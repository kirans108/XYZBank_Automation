package com.selenium.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {
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

    public TakeScreenshot(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public  void screenshot() throws IOException, InterruptedException {
        Depositbutton.click();
        Thread.sleep(2000);
        Amount.sendKeys("100");
        submit.click();
        String dp=DepositSuccess.getText();
        Assert.assertEquals(dp,"Deposit Successful");
        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File ss=screenshot.getScreenshotAs(OutputType.FILE);
        File destination= new File("C:\\Users\\kiran\\IdeaProjects\\XYZBank_Automation\\src\\main\\resources\\srcshot1.jpg");
        FileHandler.copy(ss,destination);
    }
}
