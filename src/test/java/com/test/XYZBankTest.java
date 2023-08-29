package com.test;

import com.selenium.base.BaseClass;
import com.selenium.pages.*;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;


public class XYZBankTest extends BaseClass {


    public Customer_Login customerlogin;
    public Manager_Login managerLogin;


    @BeforeTest
    //@Parameters("browserName")//||@Optional("Chrome")
    public void initialise(@Optional("Chrome") String browserName) {
        setup(browserName);
        customerlogin= new Customer_Login(driver);
        managerLogin=  new Manager_Login(driver);
    }

    @Test (priority = 0  ,alwaysRun = true)
    public void GetCurrentTitle() {
        customerlogin.currentTitle();

    }

    @Test (priority = 1)
    public void CoustomerLogin() throws InterruptedException {
        customerlogin.customerlogin();
    }

    @Test(priority = 2)
    public void setDepositAmount() throws InterruptedException, IOException {
        customerlogin.depositAmount();
    }

    @Test(priority = 3)
    public  void setTransactions() throws InterruptedException {
        customerlogin.transactions();
    }

    @Test(priority = 4)
    public void setWithdrawl() throws InterruptedException {
        customerlogin.withdrawl();
    }

    @Test(priority = 5)
    public  void logout(){
        customerlogin.LogOut();
    }

    @Test(priority = 6  /*dataProvider = "DataProvider", dataProviderClass = DataPro.class*/)
    public void managerlogin(){
        managerLogin.managerlogin();
    }

    @Test(priority = 7)
    public void customers() throws AWTException {
        managerLogin.customers();
    }
    @Test(priority = 8)
    public void openacc(){
        managerLogin.openacc();
    }

    @Test(priority = 9)
    public void setSearch(){
        managerLogin.search();
    }

    @AfterTest
    public void TearDown(){
        driver.close();
    }
}
