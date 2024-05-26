package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class loginSteps {

    LoginPage loginPage = new LoginPage();


    @Then("should see Login Form on the Login Page")
    public void shouldSeeLoginFormOnTheLoginPage() {loginPage.checkLoginForm();}

    @When("write to E-posta {string} on the Login Page")
    public void writeToEPostaOnTheLoginPage(String arg0){loginPage.writeToEPosta(arg0);}

    @When("write to Password {string} on the Login Page")
    public void writeToPasswordOnTheLoginPage(String arg0) {loginPage.writeToPassword(arg0);}

    @When("taps to Login Button on the Login Page")
    public void tapsToLoginButtonOnTheLoginPage(){loginPage.clickLoginButton();}

    @Then("should see an Error Message saying {string} on the Login Page")
    public void shouldSeeAnErrorMessageSayingOnTheLoginPage(String arg0) {loginPage.checkErrorMessage(arg0);}

}
