package com.aplana.homework.page;

import java.util.ArrayList;
import java.util.HashSet;

public class SberbankPage {
    public static String url = "http://www.sberbank.ru/ru/person";

    public static String regionChoice = "//header[@class='header']//span";
    public static String dialogSearchRegion = "//div[@aria-label='Выбор региона']//input[@type='search']";
    public static String footer = "//footer";

    public static String myRegion = "Нижегородская область";

    public static String logoFacebook = footer + "//a[contains(@href,'facebook.com')]";
    public static String logoTwitter = footer + "//a[contains(@href,'twitter.com')]";
    public static String logoYoutube = footer + "//a[contains(@href,'youtube.com')]";
    public static String logoInstagram = footer + "//a[contains(@href,'youtube.com')]";
    public static String logoVk = footer + "//a[contains(@href,'vk.com')]";
    public static String logoOk = footer + "//a[contains(@href,'ok.ru')]";

    public static HashSet<String> getLogos() {
        HashSet<String> arrayLogo = new HashSet<>();
        arrayLogo.add(logoFacebook);
        arrayLogo.add(logoTwitter);
        arrayLogo.add(logoYoutube);
        arrayLogo.add(logoInstagram);
        arrayLogo.add(logoVk);
        arrayLogo.add(logoOk);
        return arrayLogo;
    }
}
