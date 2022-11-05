package com.n11.pages;

import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DashboardPage {
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
    static Actions actions = new Actions(Driver.getDriver());

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "searchData")
    public static WebElement searchBox;

    @FindBy(xpath = "//div[@class='resultText ']/h1")
    public static WebElement searchedItem;

    @FindBy(xpath = "//div[@class='iLoading']")
    public static WebElement loadingSign;

    public static void searchForItem() {
        searchBox.sendKeys(ConfigurationReader.getProperty("item") + Keys.ENTER);
    }

    public static void itemVerification() {
        String expectedTitle = ConfigurationReader.getProperty("item");
        String actualTitle = searchedItem.getText();

        if (expectedTitle.equalsIgnoreCase(actualTitle)) {
            System.out.println("Searched item " + expectedTitle + " is verified");
        } else {
            System.out.println("Searched item " + expectedTitle + " is NOT verified");
        }
    }

    public static void secondPageVerification() {
        List<WebElement> PageItems = Driver.getDriver().findElements(By.xpath("//div[@data-position]"));
        int FirstPageSize = PageItems.size();
        System.out.println("First Page Has : " + FirstPageSize + " items.");

        int secondPageThirdItem = FirstPageSize + 3;
        System.out.println(secondPageThirdItem + ". item will be our third item of the second page.");

        for (int i = 0; i < secondPageThirdItem; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            if (loadingSign.isDisplayed()) {
                String secondPageUrl = Driver.getDriver().getCurrentUrl();
                System.out.println("Second Page Starts Here :" + secondPageUrl);
                break;
            }
        }

        WebElement thirdItem = Driver.getDriver().findElements(By.xpath("//span[@class='followBtn']")).get(secondPageThirdItem - 1);
        wait.until(ExpectedConditions.visibilityOf(thirdItem));
        thirdItem.click();
    }
}