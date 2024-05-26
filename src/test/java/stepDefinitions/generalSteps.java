package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.General;
import pages.HomePage;
import pages.LoginPage;

public class generalSteps {

    General general = new General();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("User Logged In {string} {string}")
    public void tapsToUseWatchAdsButtonOnTheExpressScreen(String arg0, String arg1) throws InterruptedException {
        general.acceptCookies();
        homePage.checkHomePage();
        homePage.clickLoginButton();
        loginPage.checkLoginForm();
        loginPage.writeToEPosta(arg0);
        loginPage.writeToPassword(arg1);
        loginPage.clickLoginButton();
        homePage.checkHomePage();
        homePage.checkLoggedInMemberShip();
    }
    @When("write to {string} SearchBox")
    public void writeToSearchBoxOnTheHomePage(String arg0) {general.sendKeySearchBox(arg0);}

    @When("taps to Search Button on the SearchBox")
    public void tapsToSearchButtonOnTheSearchBox() {general.clickSearchButton();}

    @When("taps to Cookies Accept")
    public void tapsToCookiesAccept() {general.acceptCookies();}

    @Then("should see Product Preview Status Text {string}")
    public void shouldSeeProductPreviewStatusText(String arg0) { general.checkStatusText(arg0);}

    @When("taps to Favorites Navigation")
    public void tapsToFavoritesNavigation() {general.clickFavoritesNav();}

    @When("user clicks each tab one by one, clicks the first component, and logs whether the images of the first 4 products are received")
    public void userClicksEachTabOneByOneClicksTheFirstComponentAndLogsWhetherTheImagesOfTheFirstProductsAreReceived() {
        general.acceptCookies();
        general.clickEachTabAndLogFirstFourProductImages();
    }
}
