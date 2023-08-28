package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
    WebDriver driver;
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn logout']")
    WebElement logoutbutn;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn home']")
    WebElement home;

    public  Logout(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public  void LogOut(){
        logoutbutn.click();
        home.click();
    }
}
