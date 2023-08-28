package com.test;

import com.selenium.base.BaseClass;
import com.selenium.pages.*;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;


public class XYZBankTest extends BaseClass {

    public LoginPage login;
    public Deposit depositamount;
    public Transactions transactions;
    public Withdrawl withdrawl;
    public Logout logout;
    public  ManagerLogin mnlogin;
    public  Customers customers;
    public  OpenAccount opacc;
    public Searchcustomer search;
    public TakeScreenshot takeScreenshot;


    @BeforeTest
    //@Parameters("browserName")//||@Optional("Chrome")
    public void initialise(@Optional("Chrome") String browserName) {
        setup(browserName);
        login=new LoginPage(driver);
        depositamount=new Deposit(driver);
        transactions=new Transactions(driver);
        withdrawl = new Withdrawl(driver);
        logout = new Logout(driver);
        mnlogin =new ManagerLogin(driver);
        customers=new Customers(driver);
        opacc = new OpenAccount(driver);
        search=new Searchcustomer(driver);
        takeScreenshot =new TakeScreenshot(driver);
    }

    @Test (priority = 0  ,alwaysRun = true)
    public void GetCurrentTitle() {
        login.currentTitle();

    }

    @Test (priority = 1)
    public void CoustomerLogin() throws InterruptedException {
        login.customerlogin();
    }

    @Test(priority = 2)
    public void setDepositAmount() throws InterruptedException {
        depositamount.depositAmount();
    }

    @Test(priority = 3)
    public  void setTransactions() throws InterruptedException {
        transactions.transactions();
    }

    @Test(priority = 5)
    public void setWithdrawl() throws InterruptedException {
        withdrawl.withdrawl();
    }

    @Test(priority = 6)
    public  void logout(){
        logout.LogOut();
    }

    @Test(priority = 7  /*dataProvider = "DataProvider", dataProviderClass = DataPro.class*/)
    public void managerlogin(){
        mnlogin.managerlogin();
    }

    @Test(priority = 8)

    public void customers() throws AWTException {

        customers.customers();
    }

    @Test(priority = 9)
    public void openacc(){
        opacc.openacc();
    }

    @Test(priority = 10)
    public void setSearch(){
        search.search();
    }

    @Test(priority = 4)
    public void setTakeScreenshot() throws IOException, InterruptedException {
        takeScreenshot.screenshot();
    }

    @AfterTest
    public void TearDown(){
        driver.close();
    }
}
