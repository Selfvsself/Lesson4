package com.aplana.homework;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class WebDriverSetting {

    public ChromeDriver driver;
    public Wait<WebDriver> wait;


    @Before
    public void setUp() {
        File file = new File("chromeDriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.toString());
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5, 1000);
        driver.manage().window().maximize();
    }

    @After
    public void close() {
        //driver.close();
    }
}
