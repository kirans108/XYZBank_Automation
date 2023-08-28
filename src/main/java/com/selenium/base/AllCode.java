package com.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AllCode {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        //currenttitle
        String currenttitle = driver.getTitle();
        System.out.println(currenttitle);
        Assert.assertEquals(currenttitle, "XYZ Bank");
        Thread.sleep(2000);
        //Customer Login
        driver.findElement(By.xpath("//button[text()='Customer Login']")).click();
        Thread.sleep(2000);
        WebElement YourName = driver.findElement(By.name("userSelect"));
        YourName.click();
        Select select = new Select(YourName);
        select.selectByVisibleText("Neville Longbottom");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        // String AccNum = driver.findElement(By.xpath("//strong[normalize-space()='1013']")).getText();
        //System.out.println("Account number = " + AccNum);
        //Assert.assertEquals(username,"Welcome");

        //Deposit
        driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@ng-model='amount']")).sendKeys("100");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Deposit Successful
        String deposite=driver.findElement(By.xpath("//span[@class='error ng-binding']")).getText();
        Assert.assertEquals(deposite,"Deposit Successful");

        //Transactions
        driver.findElement(By.xpath("//button[normalize-space()='Transactions']")).click();
        Thread.sleep(2000);
        String transactiontype=driver.findElement(By.xpath("//td[normalize-space()='Credit']")).getText();
        Assert.assertEquals(transactiontype,"Credit");

        driver.findElement(By.xpath("//button[normalize-space()='Back']")).click();
        //withdrawal
        Thread.sleep(2000);
        driver.findElement(By.xpath(" //button[@class='btn btn-lg tab btn-primary'] ")).click();
        driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("50");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Transaction successful
        String Transactionsuccess=driver.findElement(By.xpath("//span[@class='error ng-binding']")).getText();
        Assert.assertEquals(Transactionsuccess,"Transaction successful");
        //logout
        driver.findElement(By.xpath("//button[@class='btn logout']")).click();
        driver.findElement(By.xpath("//button[@class='btn home']")).click();


        //Manager login
        driver.findElement(By.xpath("//button[text()='Bank Manager Login']")).click();
        //Add Customer
        driver.findElement(By.xpath("//button[normalize-space()='Add Customer']")).click();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Rohit");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Sharma");
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("582219");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.switchTo().alert().accept();
        //Customers
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();
        String coustomername=driver.findElement(By.xpath("//td[normalize-space()='Rohit']")).getText();
        Assert.assertEquals(coustomername,"Rohit");
        driver.findElement(By.xpath("//tbody/tr[6]/td[5]/button[1]")).click();
        //Open Account
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

        //search customer
        driver.findElement(By.xpath("//button[@class='btn btn-lg tab btn-primary']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Hermoine");
        String accountnumber=driver.findElement(By.xpath("//span[normalize-space()='1003']")).getText();
        Assert.assertEquals(accountnumber,"1003");
    }

}
