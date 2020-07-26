package com.n11.optim.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.n11.optim.webpages.*;


public class FacebookAutPage {
    private WebDriver driver;
    //////////////// ---- FACEBOOK AUT PAGE


    //Constructor
    public FacebookAutPage(WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }
}
