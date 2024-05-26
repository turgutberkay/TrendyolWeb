package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.General;
import pages.HomePage;

public class homeSteps {

    HomePage homePage = new HomePage();
    General general = new General();

    @Given("Go to Url {string}")
    public void tapsToUseWatchAdsButtonOnTheExpressScreen(String url) {general.goToUrl(url);}

    @Then("should see Home Page")
    public void shouldSeeHomePage() {homePage.checkHomePage();}

    @Then("should see Logged In MemberShip on the Home Page")
    public void shouldSeeLoggedInMemberShipOnTheHomePage() throws InterruptedException {homePage.checkLoggedInMemberShip();}

    @When("taps to Login button on the Home Page")
    public void tapsToLoginButtonOnTheHomePage() {homePage.clickLoginButton();}

}
