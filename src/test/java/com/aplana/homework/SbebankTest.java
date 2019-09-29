package com.aplana.homework;

import org.junit.Assert;
import org.junit.Test;
import com.aplana.homework.page.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SbebankTest extends WebDriverSetting {

    @Test
    public void SberbankTest() {

        driver.get(SberbankPage.url);

        WebElement regionText = driver.findElementByXPath(SberbankPage.regionChoice);
        regionText.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath(SberbankPage.dialogSearchRegion)));

        driver.findElementByXPath(SberbankPage.dialogSearchRegion).sendKeys(SberbankPage.myRegion + "\n");

        wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath(SberbankPage.regionChoice)));
        Assert.assertEquals((driver.findElementByXPath(SberbankPage.regionChoice).getText()), SberbankPage.myRegion);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , driver.findElementByXPath(SberbankPage.footer));

        SberbankPage.getLogos().forEach(logo -> Assert.assertTrue(driver.findElementsByXPath(logo).size() != 0));
    }

}
