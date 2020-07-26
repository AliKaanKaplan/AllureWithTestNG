package com.n11.optim.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.n11.optim.webpages.*;

import com.n11.optim.webpages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.IOException;

import static io.qameta.allure.Allure.step;

public class AddingProductControl {
    public static WebDriver driver;

    //  Test başlamadan önce gerekli requiredların çalıştırıldığı class
    @BeforeClass
    public void setup(){

        step("Driver ayağa kaldırılır.");
        String baseUrl = "https://www.n11.com/ ";
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    // Test'de alınan aksiyon classı
    @Test
    public void login() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage =new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        step("Facebook ile N11 sayfasına giriş yapılıyor.");
        loginPage.facebookIleGirisYap();

        step("Anasayfa'da olduğumuz kontrol ediliyor.");
        homePage.HomePageControl();

        //Bu step'de n11.com bende engelli olduğu için unable halde bırakıyorum. Ancak case çalışmaktadır.
        //step("Login ekranına gidiliyor ve login olunuyor.");
        //loginPage.login("optimdeneme@gmail.com","a1b2c4d3");

        step("Arama bar'ına samsung yazılıyor.");
       homePage.search("samsung");

        step("Ürün listesinde 2.sayfaya geçiliyor Ve 2.Sayfada olduğunun kontrolü yapılıyor.");
        homePage.secontPage();

        step("Ürün listesinden üstten 3.ürün seçiliyor.");
        homePage.selectThirdProduct();

        step("Ürün favorilere ekleniyor.");
        productPage.addFavorite();

        step("Favorilere gidip ürünün orada olduğu kontrol ediliyor.");
        productPage.goFavorite();

        step("Ürün sepetten siliniyor."); // ürün favorilerden silinmeli ve sonrasında silindiğinin kontrolü yapılmalı.
        productPage.deleteProduct();
    }

    // Test bittikten sonra gerekli required classı
    @AfterClass
    public void close(){

        step("Driver Kapatılıyor.");
       driver.close();
    }

}

