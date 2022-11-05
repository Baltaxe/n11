package com.n11.stepDefs;

import com.n11.pages.DashboardPage;
import com.n11.pages.FavItemPage;
import com.n11.pages.HomePage;
import com.n11.pages.LoginPage;
import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StepDefs {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    FavItemPage favItemPage = new FavItemPage();


    @When("user enters the page url")
    public void user_Enters_The_Page_String() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    }

    @And("user verifies the main page")
    public void user_Verifies_The_Main_Page() {

        HomePage.mainPageVerification();

    }

    @And("user login the credentials")
    public void user_login_the_credentials() {
        LoginPage.login();
    }

    @And("user should see the dashboard")
    public void userShouldSeeTheDashboard() {
        LoginPage.userAccount();
    }

    @And("user search for the item")
    public void userSearchForTheItem() {
        DashboardPage.searchForItem();
    }

    @And("user verifies the results title for Iphone")
    public void userVerifiesTheResultsTitleForIphone() {
        DashboardPage.itemVerification();
    }

    @And("user adds the third product on the second page to the favourites")
    public void userAddsTheThirdProductOnThePageToTheFavourites() {
        DashboardPage.secondPageVerification();
    }

    @And("user launches Hesabım>Favorilerim>Listelerim page")
    public void userLaunchesHesabimFavorilerimListelerimPage() {
        FavItemPage.FavPage();
    }

    @And("user verifies the Favorilerim page is launched")
    public void userVerifiesTheFavorilerimPageIsLaunched() {
        FavItemPage.FavPageVerification();
    }

    @And("user deletes the last added product")
    public void userDeletesTheLastAddedProduct() {
        FavItemPage.DeleteMyFav();
    }

    @Then("user logs out")
    public void user_logs_out() {
        FavItemPage.LogOut();
    }
}