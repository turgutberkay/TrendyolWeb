package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.General;
import pages.SearchPage;
import util.ElementUtil;

public class searchSteps {

    SearchPage searchPage = new SearchPage();
    General general = new General();
    ElementUtil elementUtil = new ElementUtil();

    @Then("should see Description Contains {string} on the Search Page")
    public void shouldSeeDescriptionContainsOnTheSearchPage(String arg0){searchPage.checkDescriptionContains(arg0);}


    @When("choose Filter {string} on the Search Page")
    public void chooseFilterOnTheSearchPage(String arg0) throws InterruptedException {
        searchPage.clickFilter(arg0);
        //Filtre sectıkten sonra yenılenmıyor description. Orada bir bug var bu yuzden refreshlıyorum bir sonraki kontrol icin
        Thread.sleep(1000);
        general.refreshPage();
    }

    @When("ensure the Filter {string} section is expanded on the Search Page")
    public void ensureTheFilterSectionIsExpandedOnTheSearchPage(String arg0) {searchPage.ensureFilterSelectionExpanded(arg0);}

    @When("write to Minimum Price {string} Price Filter section on the Search Page")
    public void writeToMinimumPricePriceFilterSectionOnTheSearchPage(String arg0) {searchPage.sendKeyMinimumPrice(arg0);}

    @When("write to Maximum Price {string} Price Filter section on the Search Page")
    public void writeToMaximumPricePriceFilterSectionOnTheSearchPage(String arg0){searchPage.sendKeyMaximumPrice(arg0);}

    @Then("should see Products Price within {string} to {string} on the Search Page")
    public void shouldSeeProductsPriceWithinToOnTheSearchPage(String arg0, String arg1) throws InterruptedException {
        Thread.sleep(1000);
        searchPage.checkProductPriceWithinTwice(arg0,arg1);}

    @When("taps to Search Button Price Filter on the Search Page")
    public void tapsToSearchButtonPriceFilterOnTheSearchPage() {searchPage.clickSearchButtonPriceFilter();
    }

    @When("taps to Random Product on the Search Page")
    public void tapsToRandomProductOnTheSearchPage() {searchPage.clickRandomProduct();}


    @When("taps to Favorites Button Random Product on the Search Page")
    public void tapsToFavoritesButtonRandomProductOnTheSearchPage() throws InterruptedException {
        //Asagı scroll yaptıgımda farklı renk secenekleri pop-up ı geldıgı ıcın ekstra if li method yazmam gerekti
        elementUtil.scrollDown();
        searchPage.ifDisplayedPopupClose();
        searchPage.randomProductFavoritesButton();
    }
}
