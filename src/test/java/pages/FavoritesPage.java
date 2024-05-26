package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.ElementUtil;

public class FavoritesPage {

    ElementUtil elementUtil = new ElementUtil();
    private String productNameFavPage = SearchPage.productName;

    private final By productNameFavorites = By.cssSelector(".prdct-desc-cntnr-name.no-white-space");

    public void checkCorrectProduct(){Assert.assertTrue(elementUtil.elementGetText(productNameFavorites).contains(productNameFavPage));}











}
