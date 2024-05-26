package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.ElementUtil;

import java.util.List;

public class General {
    ElementUtil elementUtil = new ElementUtil();

    private final By statusText = By.cssSelector(".product-preview-status-text");
    private final By searchBox = By.cssSelector("[data-testid='suggestion']");
    private final By searchBoxButton = By.cssSelector("[data-testid='search-icon']");
    private final By acceptCookies = By.id("onetrust-accept-btn-handler");
    private final By favoritesNav = By.cssSelector(".account-nav-item.account-favorites");
    private final By tab = By.cssSelector(".tab-link");
    private final By products = By.cssSelector(".widget-product");
    private final By flashProducts = By.cssSelector(".p-card-chldrn-cntnr.card-border");
    private final By bestSellerProducts = By.cssSelector(".product-card");
    private final By componentItem = By.cssSelector(".component-item");



    public void goToUrl(String url) {elementUtil.goToUrl(url);}

    public void refreshPage() {elementUtil.refreshPage();}

    public void sendKeySearchBox(String text) {elementUtil.sendKey(searchBox,text);}

    public void clickSearchButton() {elementUtil.click(searchBoxButton);}

    public void acceptCookies() {
        elementUtil.click(acceptCookies);
    }

    public void checkStatusText(String text) {elementUtil.checkElementText(statusText, text);}

    public void clickFavoritesNav() {elementUtil.click(favoritesNav);}

    public void clickEachTabAndLogFirstFourProductImages() {
        for(var i=0; i< elementUtil.presenceElements(tab).size() ; i++){
            elementUtil.getElementIndexFromElements(tab,i).click();
            if(elementUtil.getElementIndexFromElements(tab,i).getText().contains("Çok Satanlar")){
                for(var j=0; j<3 ; j++){
                    elementUtil.getElementIndexFromElements(bestSellerProducts, j).findElement(By.tagName("img")).isDisplayed();
                }
            } else if (elementUtil.getElementIndexFromElements(tab,i).getText().contains("Flaş Ürünler")) {
                System.out.println("aaaaaaa");
                for(var j=0; j<3 ; j++){
                    elementUtil.getElementIndexFromElements(flashProducts, j).findElement(By.tagName("img")).isDisplayed();
                }
            } else if (elementUtil.getElementIndexFromElements(tab,i).getText().equals("Elektronik")) {
                elementUtil.click(componentItem);
                for(var j=0; j<3 ; j++){
                    elementUtil.getElementIndexFromElements(flashProducts, j).findElement(By.tagName("img")).isDisplayed();
                }
            } else {
                for(var j=0; j<3 ; j++){
                    elementUtil.getElementIndexFromElements(products, j).findElement(By.tagName("img")).isDisplayed();
                }
            }
        }
    }




}
