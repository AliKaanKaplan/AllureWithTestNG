package com.n11.optim.webpages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    //////////////// ---- HOME PAGE

    @FindBy(xpath = "//*[@class=\"content\"]//*[@class=\"closeBtn\"]")
    private WebElement PopupCloseBtn;

    @FindBy(xpath = "//*[@class=\"btnSignIn\"]")
    private WebElement loginBtn;

    @FindBy(xpath = "//i[@class='noAfter']")
    private WebElement smileBtn;

    @FindBy(xpath = "//*[@id=\"searchData\"]")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@class=\"searchBtn\"]")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@class=\"pagination\"]//*[.='2']")
    private WebElement secontPage;

    @FindBy(xpath = "//*[@class=\"pagination\"]//*[@class=\"active \"]")
    private WebElement secontPageCheck;

    @FindBy(xpath = "(//*[@id=\"view\"]//*[@class=\"clearfix\"]//*[@class=\"column \"])[3]//*[@class=\"pro\"]//*[@class=\"productName \" or @class=\"productName bold\"]")
    private WebElement productName;

    @FindBy(xpath = "(//*[@id=\"view\"]//*[@class=\"clearfix\"]//*[@class=\"column \"])[3]//*[@class=\"pro\"]//*[@class=\"plink\"]")
    private WebElement thirdElement;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void closeHomePagePopUp() throws InterruptedException {

        Thread.sleep(10000);
        PopupCloseBtn.click();
    }
    public void enterLoginPage(){

        loginBtn.click();
    }
    public void search(String text) throws InterruptedException {
        System.out.println("Search bar'a samsung yazılıyor.");
        searchBar.sendKeys(text);
        searchBtn.click();
        Thread.sleep(3000);

    }
    public void HomePageControl(){

        if(!smileBtn.isDisplayed()){
            Assert.fail("Anasayfa açılamadı.");
        }
        else{
            System.out.println("Anasayfa'ya açıldı");
        }
    }

    public void secontPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)");
        secontPage.click();
        Thread.sleep(2000);
        if(!secontPageCheck.getText().contains("2")){
            System.out.println(productName.getText());
            Assert.fail("2. Sayfa açılamadı");
        }

    }
    public void selectThirdProduct(){
        if(!productName.getText().contains("Samsung")){
            System.out.println(productName.getText());
            Assert.fail("sayfada Samsung ürünü bulunamadı");
        }
        thirdElement.click();

    }





}