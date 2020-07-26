package com.n11.optim.webpages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.n11.optim.webpages.*;

public class ProductPage {
    private WebDriver driver;
    //////////////// ---- PRODUCT PAGE
    @FindBy(xpath = "//*[@id=\"getWishList\"]")
    private WebElement addFavoriteBtn;

    @FindBy(xpath = "//*[@id=\"addToFavouriteWishListBtn\"]")
    private WebElement addFavoriteBtnStar;

    @FindBy(xpath = "//*[@id=\"myAccount\"]/div[1]/div[1]/div[2]/ul/li[5]/a")
    private WebElement favorite;

    @FindBy(xpath = "//*[@id=\"myAccount\"]/div[3]/ul/li[1]/div/a/h4")
    private WebElement favoriteList;

    @FindBy(xpath = "//*[@class=\"menuLink user\"]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@class=\"closeBtn\"]")
    private WebElement popUpClose;

    @FindBy(xpath = "//*[@class=\"deleteProFromFavorites\"]")
    private WebElement deleteBtn;

    @FindBy(xpath = "/html/body/div[4]/div/div/span")
    private WebElement deleteBtnPopup;

    @FindBy(xpath = "//*[@class=\"prodDetail\"]")
    private WebElement basketCheck;


    //Constructor
    public ProductPage(WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);

    }


    public void addFavorite() throws InterruptedException {
        Thread.sleep(2000);
        addFavoriteBtn.click();
        Thread.sleep(2000);
        addFavoriteBtnStar.click();
        Thread.sleep(2000);
    }
    public void goFavorite() throws InterruptedException {
        Actions builder = new Actions(driver);
        Thread.sleep(3000);
        builder.moveToElement(userMenu).click().perform();
        favorite.click();
        Thread.sleep(3000);
        favoriteList.click();
        Thread.sleep(3000);
        if (!deleteBtn.isDisplayed())
        {
            Assert.fail("Sepette ürün bulunmamaktadır.");
        }
        else
        {
            Assert.assertTrue("Sepette Urun bulunmaktadır",deleteBtn.isDisplayed());
        }
    }
    public void deleteProduct() throws InterruptedException {
        Thread.sleep(3000);
        deleteBtn.click();
        Thread.sleep(1000);
        deleteBtnPopup.click();

        if (!deleteBtn.isDisplayed())
        {
            Assert.fail("Urun silinemedi");
        }
        else
        {
            System.out.println("Ürün başarı ile silindi.");
        }

    }
}
