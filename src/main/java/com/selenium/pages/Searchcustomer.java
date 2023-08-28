package com.selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Searchcustomer {
    WebDriver driver;
    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement searchtab;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement SearchCustomer;
    @CacheLookup
    @FindBy(xpath = "//td[text()='Hermoine']")
    WebElement search;
    public  Searchcustomer(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void search(){
        searchtab.click();
        SearchCustomer.sendKeys("Hermoine");
        String search2=search.getText();
        Assert.assertEquals(search2,"Hermoine");
    }
}
