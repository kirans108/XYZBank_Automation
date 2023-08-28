package com.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
//String browser
    public void setup(String browser) {
        /*if(browser.equalsIgnoreCase("Chrome")){
            driver =new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");*/

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
}
