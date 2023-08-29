package com.test;

import com.selenium.base.BaseClass;
import com.selenium.pages.Manager_Login;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.awt.*;

public class ManagerLoginTest extends BaseClass {
    public Manager_Login managerLogin;
    @BeforeTest
    public void initialise(@Optional("Chrome") String browserName){
        setup(browserName);
        managerLogin = new Manager_Login(driver);
    }
    @Test(priority = 0  /*dataProvider = "DataProvider", dataProviderClass = DataPro.class*/)
    public void managerlogin(){
        managerLogin.managerlogin();
    }

    @Test(priority = 1)
    public void customers() throws AWTException {
        String search=managerLogin.customers();
        Assert.assertEquals(search,"Hermoine");
    }
    @Test(priority = 2)
    public void openacc(){
        managerLogin.openacc();
    }

    @Test(priority = 3)
    public void setSearch(){
        String search2=managerLogin.search();
        Assert.assertEquals(search2,"Hermoine");
    }

    @AfterTest
    public void TearDown(){
        driver.close();
    }
}


