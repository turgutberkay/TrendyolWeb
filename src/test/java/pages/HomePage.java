package pages;

import org.apache.http.impl.client.SystemDefaultCredentialsProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import util.ElementUtil;

public class HomePage {

    ElementUtil elementUtil = new ElementUtil();

    private final By homePage = By.id("browsing-gw-homepage");
    private final By loginContainer = By.cssSelector(".link.account-user");


    public void checkHomePage() {elementUtil.checkElementVisible(homePage);}

    public void clickLoginButton() {
        elementUtil.click(loginContainer);
    }

    public void checkLoggedInMemberShip() throws InterruptedException {
        Thread.sleep(1000);
        elementUtil.checkElementText(loginContainer, "Hesabım");
        Thread.sleep(1000);
    }


}
