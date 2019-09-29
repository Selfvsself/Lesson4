package com.aplana.homework;

import com.aplana.homework.page.RGSPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.aplana.homework.page.*;

import java.util.List;

public class RGSTest extends WebDriverSetting {
    @Test
    public void RGSTest() {
        //Загружаем страницу
        driver.get(RGSPage.MainPage.url);
        //Кликаем на кнопке меню
        driver.findElementByXPath(RGSPage.MainPage.LeftMenu).click();

        //Кликаем по пункту ДМС
        driver.findElementByXPath(RGSPage.MainPage.DMSOnMenu).click();

        //Ждем загрузки кнопки отправить завяку и нажимаем ее
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath(RGSPage.DMSPage.needHead)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath(RGSPage.DMSPage.buttonSendDMSMessage)));

        //Проверяем наличие заголовка о страховании
        Assert.assertTrue(driver
                .findElementsByXPath(RGSPage.DMSPage.needHead).size() != 0);
        driver.findElementByXPath(RGSPage.DMSPage.buttonSendDMSMessage).click();

        //Ждем загрузки первого поля в форме заявки
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath(RGSPage.DMSPage.inputLastName)));

        //Проверяем наличие заголовка о страховании
        Assert.assertTrue(driver
                .findElementsByXPath(RGSPage.DMSPage.needTitleForm).size() != 0);

        //Заполняем таблицу
        inputData();

        //Проверяем данные
        checkData();

        //Кликаем по кнопке отправить
        driver.findElementByXPath(RGSPage.DMSPage.buttonSendForm).click();

        //Проверяем наличие текста о ошибке ввода email
        Assert.assertTrue(driver
                .findElementsByXPath(RGSPage.DMSPage.textErrorIncorrectEmail).size() != 0);

    }

    private void inputData() {
        //Заполняем фамилию
        driver.findElementByXPath(RGSPage.DMSPage.inputLastName)
                .sendKeys(RGSPage.DMSPage.valueLastName);

        //заполняем имя
        driver.findElementByXPath(RGSPage.DMSPage.inputFirstName)
                .sendKeys(RGSPage.DMSPage.valueFirstName);

        //Заполняем отчество
        driver.findElementByXPath(RGSPage.DMSPage.inputMiddleName)
                .sendKeys(RGSPage.DMSPage.valueMiddleName);

        //Выбираем из списка регион
        //Select select = new Select(driver.findElementByXPath(RGSPage.DMSPage.selectRegion));
        //select.selectByValue(RGSPage.DMSPage.valueRegion);
        driver.findElementByXPath(RGSPage.DMSPage.selectRegionM).click();

        //Нажимаем и заполняем номер телефона
        WebElement elementPhone = driver.findElementByXPath(RGSPage.DMSPage.inputPhone);
        elementPhone.click();
        elementPhone.sendKeys(RGSPage.DMSPage.valueNumberPhone);

        //Заполняем email
        driver.findElementByXPath(RGSPage.DMSPage.inputEmail)
                .sendKeys(RGSPage.DMSPage.valueEmail);

        //Заполняем дату
        WebElement elementDate = driver.findElementByXPath(RGSPage.DMSPage.inputContactDate);
        elementDate.click();
        elementDate.sendKeys(RGSPage.DMSPage.getDate());

        //Заполняем комментарий
        driver.findElementByXPath(RGSPage.DMSPage.inputComment)
                .sendKeys(RGSPage.DMSPage.valueCommend);

        //ставим галочку на обработку данных
        driver.findElementByXPath(RGSPage.DMSPage.checkedIsProcessingPersonalData).click();
    }

    private void checkData() {
        Assert.assertEquals(driver.findElementByXPath(RGSPage.DMSPage.inputLastName).getAttribute("value")
                , RGSPage.DMSPage.valueLastName);
        Assert.assertEquals(driver.findElementByXPath(RGSPage.DMSPage.inputFirstName).getAttribute("value")
                , RGSPage.DMSPage.valueFirstName);
        Assert.assertEquals(driver.findElementByXPath(RGSPage.DMSPage.inputMiddleName).getAttribute("value")
                , RGSPage.DMSPage.valueMiddleName);

        //Проверяем регион из select
        WebElement elementSelectRegion = driver.findElementByXPath(RGSPage.DMSPage.selectRegion);
        Select select = new Select(elementSelectRegion);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), RGSPage.DMSPage.valueRegion);

        Assert.assertEquals(driver.findElementByXPath(RGSPage.DMSPage.inputPhone).getAttribute("value")
                , RGSPage.DMSPage.getPatternNumberPhone());
        Assert.assertEquals(driver.findElementByXPath(RGSPage.DMSPage.inputEmail).getAttribute("value")
                , RGSPage.DMSPage.valueEmail);
        Assert.assertEquals(driver.findElementByXPath(RGSPage.DMSPage.inputContactDate).getAttribute("value")
                , RGSPage.DMSPage.getPatternDate());
        Assert.assertEquals(driver.findElementByXPath(RGSPage.DMSPage.inputComment).getAttribute("value")
                , RGSPage.DMSPage.valueCommend);
    }
}
