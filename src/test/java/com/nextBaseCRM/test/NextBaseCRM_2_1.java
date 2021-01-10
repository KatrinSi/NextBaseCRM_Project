package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextBaseCRM_2_1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //1. User logs in to the NextBase CRM app with valid User Name and Password
        driver.get("https://login.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk21@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.manage().window().maximize();
        //2. Click on "MESSAGE" tab
        driver.findElement(By.xpath("//span[@class='feed-add-post-form-link feed-add-post-form-link-active']//span[.='Message']")).click();
        //Sleep.toSleep(100);
        //3. Type random text inside of the Message panel
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(By.xpath("//iframe")).sendKeys("heloooooo");

        //4. Click on the "SEND" button



        //toSleep(10);
        //driver.close();

    }
}
