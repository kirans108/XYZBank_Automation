package com.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Test {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Manager login
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        //customers
        driver.findElement(By.xpath("//button[@ng-class='btnClass3']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Hermoine");
        String search=driver.findElement(By.xpath("//td[text()='Hermoine']")).getText();
        Assert.assertEquals(search,"Hermoine");

        driver.findElement(By.xpath("//button[normalize-space()='Open Account']")).click();
        WebElement coustomername1 = driver.findElement(By.name("userSelect"));
        coustomername1.click();
        Select select1 = new Select(coustomername1);
        select1.selectByVisibleText("Harry Potter");

        WebElement currency= driver.findElement(By.xpath("//select[@id='currency']"));
        currency.click();
        Select select2=new Select(currency);
        select2.selectByVisibleText("Rupee");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.switchTo().alert().accept();


        driver.findElement(By.xpath("//button[@ng-class='btnClass3']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Hermoine");
        String search2=driver.findElement(By.xpath("//td[text()='Hermoine']")).getText();
        Assert.assertEquals(search2,"Hermoine");

    }
}