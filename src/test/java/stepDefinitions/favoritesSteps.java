package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.FavoritesPage;
import pages.General;
import pages.HomePage;
import pages.LoginPage;

public class favoritesSteps {

    FavoritesPage favoritesPage = new FavoritesPage();

    @Then("correct product add to favorites on the Favorites Page")
    public void correctProductAddToFavoritesOnTheFavoritesPage() {favoritesPage.checkCorrectProduct();}
}
