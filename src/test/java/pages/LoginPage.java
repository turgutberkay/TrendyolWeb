package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import util.ElementUtil;

public class LoginPage {

    ElementUtil elementUtil = new ElementUtil();

    private final By loginForm = By.cssSelector(".q-layout.login");
    private final By ePostaInput = By.id("login-email");
    private final By passwordInput = By.name("login-password");
    private final By loginButton = By.cssSelector(".q-primary.q-fluid.q-button-medium.q-button.submit");
    private final By errorMessage = By.id("error-box-wrapper");


    public void checkLoginForm() {elementUtil.checkElementVisible(loginForm);}

    public void checkErrorMessage(String text) {
        elementUtil.checkElementText(errorMessage, text);
    }

    public void writeToEPosta(String mail) {
        elementUtil.click(ePostaInput);
        elementUtil.sendKey(ePostaInput,mail);
    }

    public void writeToPassword(String password) {
        elementUtil.click(passwordInput);
        elementUtil.sendKey(passwordInput,password);
    }

    public void clickLoginButton() {
        elementUtil.click(loginButton);
    }






}
