package com.aplana.homework.page;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RGSPage {


    public static class MainPage {
        public static String url = "https://www.rgs.ru/";
        public static String title = "ПАО СК «Росгосстрах» — флагман отечественного рынка страхования";
        public static String LeftMenu = "//ol[contains(@class,'left')]//a[contains(text(),'Меню')]";
        public static String DMSOnMenu = "//form[@id='rgs-main-menu-insurance-dropdown']//a[contains(text(),'ДМС')]";
    }

    public static class DMSPage {
        public static String needHead = "//h1[contains(text(),'добровольное медицинское страхование')]";
        public static String needTitleForm = "//b[contains(text(),'Заявка на добровольное медицинское страхование')]";
        public static String buttonSendDMSMessage = "//a[contains(text(),'Отправить заявку')]";
        public static String inputLastName = "//input[contains(@data-bind,'LastName')]";
        public static String inputFirstName = "//input[contains(@data-bind,'FirstName')]";
        public static String inputMiddleName = "//input[contains(@data-bind,'MiddleName')]";
        public static String selectRegion = "//select[@name='Region']";
        public static String selectRegionM = "//select[@name='Region']/option[text()='Москва']";
        public static String inputPhone = "//input[contains(@data-bind,'Phone')]";
        public static String inputEmail = "//input[contains(@data-bind,'Email')]";
        public static String inputContactDate = "//input[contains(@data-bind,'ContactDate')]";
        public static String inputComment = "//textarea[contains(@data-bind,'Comment')]";
        public static String checkedIsProcessingPersonalData = "//input[contains(@data-bind,'IsProcessingPersonalData')]";
        public static String buttonSendForm = "//button[contains(text(),'Отправить')]";

        public static String textErrorIncorrectEmail = inputEmail + "/parent::div//span[text()='Введите адрес электронной почты']";

        public static String valueFirstName = "Иван";
        public static String valueLastName = "Иванов";
        public static String valueMiddleName = "Иванович";
        public static String valueRegion = "Москва";
        public static String valueNumberPhone = "9455552525";
        public static String valueEmail = "qwertyqwerty";
        public static String valueCommend = "После 15:00 не звонить";

        public static String checkIsProcessingPersonalData = "on";

        public static String getDate() {
            LocalDate dateNow = LocalDate.now().plus(2, ChronoUnit.DAYS);
            return dateNow.format(DateTimeFormatter.ofPattern("ddMMuuuu"));
        }

        public static String getPatternNumberPhone() {
            StringBuilder answer = new StringBuilder();
            answer.append("+7 (");
            answer.append(valueNumberPhone, 0, 3).append(") ");
            answer.append(valueNumberPhone, 3, 6).append("-");
            answer.append(valueNumberPhone, 6, 8).append("-");
            answer.append(valueNumberPhone.substring(8));
            return answer.toString();
        }

        public static String getPatternDate() {
            LocalDate dateNow = LocalDate.now().plus(2, ChronoUnit.DAYS);
            return dateNow.format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
        }
    }
}
