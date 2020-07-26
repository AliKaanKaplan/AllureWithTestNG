package com.n11.optim.webpages;

import com.n11.optim.model.ExcelUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static com.n11.optim.webpages.FacebookAutPage.*;

public class LoginPage {
    private WebDriver driver;
    //////////////// ---- LOGIN PAGE

    @FindBy(xpath = "//*[@class=\"facebook_large medium facebookBtn  btnLogin\"]")
    private WebElement facebookLogin;

    @FindBy(xpath = "//*[@class=\"logo  home \"]")
    private WebElement logo;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailIdBtn;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement emailPasswordBtn;

    @FindBy(xpath = "//*[@id=\"loginButton\"]")
    private WebElement mainLoginBtn;

    @FindBy(xpath = "//*[@class=\"logoutBtn\"]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[@id=\"email\"]")
    public static WebElement facebookIdBtn;

    @FindBy(xpath = "//*[@id=\"pass\"]")
    public static WebElement facebookPasswordBtn;

    @FindBy(xpath = "//*[@name=\"login\"]")
    public static WebElement facebookLoginBtn2;

    @FindBy(xpath = "//a[.='Hesabım']")
    public static WebElement girisHover;

    @FindBy(xpath = "//*[@class=\"btnSignIn\"]")
    private WebElement loginBtn;




    //Constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;

        PageFactory.initElements(driver, this);
    }

    public  void facebookIleGirisYap() throws InterruptedException, IOException {
        HomePage homePage = new HomePage(driver);
        System.out.println("Anasayfa pop-up'ı kapatılıyor.");
        homePage.closeHomePagePopUp();

        System.out.println("Giriş sayfasına gidiliyor.");
        homePage.enterLoginPage();
        Thread.sleep(3000);

        System.out.println("Facebook ile giriş yap butonuna tıklanıyor.");
        facebookLogin.click();
        Thread.sleep(3000);

        System.out.println("Açılan yeni ekranda facebook sayfası handle ediliyor. >> "+driver.getTitle());
        for(String handle:driver.getWindowHandles())
        {
            driver.switchTo().window(handle);
        }
        Thread.sleep(3000);

        System.out.println("Excel Dataları Okunuyor.");
        List<ExcelUser> excelUsers = ExcelPage.excelDataRead();
        Thread.sleep(3000);

        System.out.println("ID Textbox'ına id giriliyor.");
        String username =ExcelPage.username.toString();
        Thread.sleep(3000);
        facebookIdBtn.sendKeys(username);

        System.out.println("Password Textbox'ına password giriliyor.");
        String password = ExcelPage.password.toString();
        Thread.sleep(3000);
        facebookPasswordBtn.sendKeys(password);
        Thread.sleep(3000);

        System.out.println("Giriş yap butonuna tıklanıyor.");
        facebookLoginBtn2.click();

        System.out.println("Login sayfasına tekrardan geri handlelanıyor.");
        for(String handle:driver.getWindowHandles())
        {
            System.out.println("Login sayfasına tekrar geri dönüş yapıldı.");
            driver.switchTo().window(handle);
            break;
        }
        Thread.sleep(3000);

        /*
        // Bu kısım normal yolla login olmayı denerseniz facebookla girdiğimiz oturumdan çıkış yapabilmesi için hazırlanmıştır.
        // Email ile login olma n11 tarafından engellendiği için bu kısmı unable bırakıyorum.
        Actions builder = new Actions(driver);
        Thread.sleep(3000);
        builder.moveToElement(girisHover).perform();
        Thread.sleep(3000);
        builder.moveToElement(logoutBtn).click().perform();
        */

        System.out.println("Sol üstteki logo'ya tıklanarak Anasayfa'ya gidiliyor.");
       logo.click();
        Thread.sleep(3000);
    }

    public  void login(String mainEmail, String mainPassword) throws InterruptedException {

        loginBtn.click();
        Thread.sleep(3000);
        emailIdBtn.sendKeys(mainEmail);
        Thread.sleep(3000);
        emailPasswordBtn.sendKeys(mainPassword);
        mainLoginBtn.click();
        Thread.sleep(3000);

    }
}
