package com.n11.pages;

import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Tümünü Kabul Et']")
    public static WebElement acceptCookieBtn;


    public static void mainPageVerification() {
        wait.until(ExpectedConditions.visibilityOf(acceptCookieBtn));
        acceptCookieBtn.click();

        String expectedTitle = "n11 - Hayat Sana Gelir";
        String actualTitle = Driver.getDriver().getTitle();

        if (expectedTitle.equalsIgnoreCase(actualTitle)) {
            System.out.println("The main page of " + expectedTitle + " is verified");
        } else {
            System.out.println("The main page of " + expectedTitle + " is NOT verified");
        }
    }
}