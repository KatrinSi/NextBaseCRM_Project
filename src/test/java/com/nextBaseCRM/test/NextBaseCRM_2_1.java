package com.nextBaseCRM.test;

import com.nextBaseCRM.test.Utilities.Sleep;
import com.nextBaseCRM.test.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NextBaseCRM_2_1 {
    WebDriver driver;
    //1. User logs in to the NextBase CRM app with valid User Name and Password
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://login.nextbasecrm.com/");
        Sleep.toSleep(1);
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk21@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.manage().window().maximize();
    }
    @Test
    public void sendMessageTest() {
        //2. Click on "MESSAGE" tab
        driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']//span[.='Message']")).click();
        //3. Type random text inside of the Message panel
        Sleep.toSleep(3);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("//body")).sendKeys("Hello Hello! How are you?");
        //4. Click on the "SEND" button
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']")).click();
        Sleep.toSleep(5);

        String actualResult = driver.findElement(By.xpath("//*[.='Hello Hello! How are you?'][1]")).getText();
        Sleep.toSleep(1);
        System.out.println(driver.findElement(By.xpath("//*[.='Hello Hello! How are you?'][1]")).getAttribute("id"));
        String expectedResult = "Hello Hello! How are you?";

        Assert.assertEquals(actualResult,expectedResult, "Test FAILED, actual result is not equal to expected.");

    }

    @Test
    public void cancelMessageTest(){

        //2. Click on "MESSAGE" tab
        driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']//span[.='Message']")).click();
        //3. Type random text inside of the Message panel
        Sleep.toSleep(3);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        driver.findElement(By.xpath("//body")).sendKeys("Hello Hello! How are you?");
        //4. Click on the "Cancel" button
        driver.switchTo().defaultContent();
        driver.findElement(By.id("blog-submit-button-cancel")).click();

    }

    @Test
    @AfterMethod
    public void teardownMethod() {
        Sleep.toSleep(5);
        driver.quit();
    }

}


//how can I make sure that my message is sent? I don't have any confirm massage
//what's the diff between Implicit wait and toSleep()
