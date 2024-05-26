package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;
import pages.SearchPage;
import util.ElementUtil;

public class productSteps {

    ProductPage productPage = new ProductPage();
    ElementUtil elementUtil = new ElementUtil();

    @Then("should see Product Page")
    public void shouldSeeProductPage() {
        elementUtil.switchToNewWindow();
        productPage.checkProductPageContainer();
    }

    @When("taps to Add To Basket Product on the Product Page")
    public void tapsToAddToBasketProductOnTheProductPage() {productPage.clickAddToBasket();}


}
