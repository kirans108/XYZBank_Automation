package com.test;

import com.selenium.base.BaseClass;
import com.selenium.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;


public class CustomerLoginTest extends BaseClass {


    public Customer_Login customerlogin;

    @BeforeTest()
    //@Parameters("browserName")//||@Optional("Chrome")
    public void initialise(@Optional("Chrome") String browserName) {
        setup(browserName);
        customerlogin = new Customer_Login(driver);

    }

    @Test(priority = 0, alwaysRun = true)
    public void GetCurrentTitle() {
        String currenttitle=  customerlogin.currentTitle();
        Assert.assertEquals(currenttitle, "XYZ Bank");

    }

    @Test(priority = 1)
    public void CoustomerLogin() throws InterruptedException {
        customerlogin.customerlogin();
    }

    @Test(priority = 2)
    public void setDepositAmount() throws InterruptedException, IOException {
        String dp=customerlogin.depositAmount();
        Assert.assertEquals(dp, "Deposit Successful");

    }

    @Test(priority = 3)
    public void setTransactions() throws InterruptedException {
        String cr=customerlogin.transactions();
        Assert.assertEquals(cr, "Credit");
    }

    @Test(priority = 4)
    public void setWithdrawl() throws InterruptedException {
        String tr= customerlogin.withdrawl();
        Assert.assertEquals(tr, "Withdraw");
    }

    @Test(priority = 5)
    public void logout() {
        customerlogin.LogOut();
    }

}
