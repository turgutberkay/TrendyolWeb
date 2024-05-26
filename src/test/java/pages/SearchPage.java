package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.ElementUtil;

import java.util.List;

public class SearchPage {

    public static String productName ;
    ElementUtil elementUtil = new ElementUtil();

    private final By description = By.cssSelector(".dscrptn.dscrptn-V2");
    private final By filterCardName = By.cssSelector(".fltr-cntnr-ttl");
    private final By filterName = By.cssSelector(".fltr-item-text");
    private final By minimumPriceBox = By.cssSelector(".fltr-srch-prc-rng-input.min");
    private final By maximumPriceBox = By.cssSelector(".fltr-srch-prc-rng-input.max");
    private final By searchButtonPriceFilter = By.cssSelector(".fltr-srch-prc-rng-srch");
    private final By productCard = By.cssSelector(".p-card-wrppr.with-campaign-view");
    private final By productPrice = By.cssSelector(".prc-box-dscntd");
    private final By favoritesButtonRandom = By.cssSelector(".fvrt-btn");
    private final By popUp = By.cssSelector(".popup");


    public void checkDescriptionContains(String text) {elementUtil.checkElementContainsText(description, text);}

    public void clickFilter(String text) {elementUtil.click(elementUtil.elementWithTextFromTheElements(filterName, text));}

    public void ensureFilterSelectionExpanded(String text) {
       WebElement arrowElement = elementUtil.elementWithTextFromTheElements(filterCardName, text).findElement(By.xpath("..")).findElement(By.cssSelector(".i-dropdown-arrow"));
        if (!arrowElement.getAttribute("class").contains("transform")) {
            elementUtil.click(arrowElement);
        }
    }

    public void sendKeyMinimumPrice(String text) {elementUtil.sendKey(minimumPriceBox, text);}

    public void sendKeyMaximumPrice(String text) {elementUtil.sendKey(maximumPriceBox, text);}

    public void checkProductPriceWithinTwice(String price1, String price2) {
        for(var i=0; i<elementUtil.getElementSizeFromElements(productPrice)-1; i++ ){
            if (elementUtil.getElementIntegerIndexFromElements(productPrice, i) < Integer.parseInt(price1) || elementUtil.getElementIntegerIndexFromElements(productPrice, i) > Integer.parseInt(price2)) {
                throw new AssertionError("Product price " + elementUtil.getElementIntegerIndexFromElements(productPrice, i) + " is not within the range " + Integer.parseInt(price1) + " to " + Integer.parseInt(price2));
            }
        }
    }

    public void clickSearchButtonPriceFilter() {elementUtil.click(searchButtonPriceFilter);}

    public void clickRandomProduct(){elementUtil.click(elementUtil.getRandomElementFromElements(productCard));}

    public void ifDisplayedPopupClose(){if(elementUtil.checkElementVisibleNotError(popUp)){elementUtil.randomClick();}}

    public void randomProductFavoritesButton(){
        WebElement element = elementUtil.getRandomElementFromElements(favoritesButtonRandom);
        productName = element.findElement(By.xpath("../..")).findElement(By.cssSelector(".prdct-desc-cntnr-name")).getText();
        elementUtil.click(element);
    }










}
