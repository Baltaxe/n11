package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavItemPage {
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
    static Actions actions = new Actions(Driver.getDriver());

    public FavItemPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='//www.n11.com/hesabim/istek-listelerim']")
    public static WebElement myFavoritiesIcon;

    @FindBy(xpath = "//a[@href='https://www.n11.com/hesabim/favorilerim']")
    public static WebElement myFavoritiesPage;

    @FindBy(xpath = "//h2[.='Favorilerim']")
    public static WebElement favTitle;


    @FindBy(xpath = "//span[@class='deleteProFromFavorites']")
    public static WebElement deleteMyFav;

    @FindBy(xpath = "//span[@class='message']")
    public static WebElement message;

    @FindBy(xpath = "//span[.='Tamam']")
    public static WebElement oKAY;

    @FindBy(xpath = "//a[@href='//www.n11.com/cikis-yap']")
    public static WebElement logOut;

    public static void FavPage() {
        myFavoritiesIcon.click();
        myFavoritiesPage.click();
    }

    public static void FavPageVerification() {
        String expectedTitle = "Favorilerim";
        String actualTitle = favTitle.getText();

        if (expectedTitle.equalsIgnoreCase(actualTitle)) {
            System.out.println("The page of " + expectedTitle + " is verified");
        } else {
            System.out.println("The page of " + expectedTitle + " is NOT verified");
        }
    }

    public static void DeleteMyFav() {
        wait.until(ExpectedConditions.visibilityOf(deleteMyFav));
        deleteMyFav.click();

        String expectedTitle = "Ürününüz listeden silindi.";
        String actualTitle = message.getText();

        if (expectedTitle.equalsIgnoreCase(actualTitle)) {
            System.out.println(expectedTitle);
        } else {
            System.out.println("The deletion of " + expectedTitle + " is NOT verified");
        }

        wait.until(ExpectedConditions.visibilityOf(oKAY));
        oKAY.click();
    }

    public static void LogOut() {
        actions.moveToElement(LoginPage.userAccount).perform();
        wait.until(ExpectedConditions.elementToBeClickable(logOut));
        logOut.click();
        LoginPage.email.clear();

        Driver.closeDriver();
    }
}