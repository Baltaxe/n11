package com.n11.pages;

import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='btnSignIn']")
    public static WebElement signInBtn;

    @FindBy(id = "email")
    public static WebElement email;

    @FindBy(id = "password")
    public static WebElement password;

    @FindBy(id = "loginButton")
    public static WebElement loginButton;

    @FindBy(xpath = "//a[@class='user']")
    public static WebElement userAccount;

    public static void login() {
        wait.until(ExpectedConditions.visibilityOf(signInBtn));
        signInBtn.click();
        email.sendKeys(ConfigurationReader.getProperty("email"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public static void userAccount() {
        String expectedTitle = "mb";
        String actualTitle = userAccount.getText();

        if (expectedTitle.equalsIgnoreCase(actualTitle)) {
            System.out.println("Account Owner " + expectedTitle + " is verified");
        } else {
            System.out.println("Account Owner " + expectedTitle + " is NOT verified");
        }
    }
}