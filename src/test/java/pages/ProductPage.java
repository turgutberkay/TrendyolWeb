package pages;

import org.openqa.selenium.By;
import util.ElementUtil;

public class ProductPage {

    ElementUtil elementUtil = new ElementUtil();

    private final By addToBasket = By.cssSelector(".add-to-basket");
    private final By addToBasketPopup = By.cssSelector(".basket-preview-popup");
    private final By goToBasket = By.cssSelector(".link.account-basket");
    private final By productPageContainer = By.id("product-detail-app");


    public void clickAddToBasket() {elementUtil.click(addToBasket);}

    public void checkProductPageContainer() {elementUtil.checkElementVisible(productPageContainer);}























}
