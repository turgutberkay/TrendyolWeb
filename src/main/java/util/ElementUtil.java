package util;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ElementUtil {

    WebDriver driver;
    WebDriverWait wait ;
    WebDriverWait wait2 ;
    Actions action;

    public ElementUtil() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        this.wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.action = new Actions(driver);
    }

    public void goToUrl(String url) {driver.get(url);}

    public void refreshPage() {driver.navigate().refresh();}

    public WebElement presenceElement(By key) {return wait.until(ExpectedConditions.presenceOfElementLocated(key));}

    public List<WebElement> presenceElements(By key) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
        return elements;
    }

    public WebElement visibilityElement(WebElement element) {return wait.until(ExpectedConditions.visibilityOf(element));}

    public WebElement visibilityElement(By key) {return wait.until(ExpectedConditions.visibilityOfElementLocated(key));}

    public WebElement findElementClickableShort(By key) {
        try {
            WebElement element = wait2.until(ExpectedConditions.elementToBeClickable(key));
            return element;
        }catch (Exception ignored) {
            return null;
        }
    }
    public WebElement findElementClickableShort(WebElement element) {
        try {
            WebElement returnElement = wait2.until(ExpectedConditions.elementToBeClickable(element));
            return returnElement;
        }catch (Exception ignored) {
            return null;
        }
    }

    public void click(By key) {
        try {
            findElementClickableShort(key).click();
        }catch (Exception e){
            scrollToElement(presenceElement(key));
            wait.until(ExpectedConditions.elementToBeClickable(key)).click();
        }
    }
    public void randomClick() {
        Actions actions = new Actions(driver);
        actions.moveByOffset(200, 200).click().perform();
    }

    public void click(WebElement element) {
        try {
            findElementClickableShort(element).click();
        }catch (Exception e){
            scrollToElement(element);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }
    public void scrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'})", element);
        }catch (Exception ignored){
            Assert.fail("Scroll couldn't be performed");
        }
    }

    public void checkElementVisible(By key) {
        presenceElement(key);
        try {
            visibilityElement(key);
        }catch (Exception ignored){
            scrollToElement(presenceElement(key));
            visibilityElement(key);
        }
    }

    public void sendKey(By key, String string) {
        try {
            WebElement element = visibilityElement(key);
            element.sendKeys(string);
        } catch (Exception ignored) {
            Assert.fail("Element not writing");
        }
    }

    public String elementGetText(By by) {
        String text = null;
        try {
            presenceElement(by);
            text = driver.findElement(by).getText();
            return text;
        } catch (Exception ignored) {
            Assert.fail();
            return null;
        }
    }

    public boolean checkElementVisibleNotError(By key) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(key));
            return true;
        }catch (Exception ignored){
            return false;
        }

    }

    public void checkElementText(By key,String text) {
        presenceElement(key);
        Assert.assertEquals(text, elementGetText(key));
    }

    public void checkElementContainsText(By key, String text) {
        presenceElement(key);
        String elementText = elementGetText(key);
        Assert.assertTrue("Expected text not found! Locator: " + key.toString(), elementText.contains(text));
    }
    public String elementGetText(WebElement element) {
        try {
            WebElement returnElement = wait.until(ExpectedConditions.visibilityOf(element));
            return returnElement.getText();
        } catch (Exception ignored) {
            Assert.fail("Element bulunamadı veya texti cekilemedi");
            return null;
        }
    }

    public WebElement elementWithTextFromTheElements(By key, String text) {
        List<WebElement> elements = presenceElements(key);
        boolean check = false;
        WebElement returnElement = null;
        for (WebElement element : elements) {
            if(elementGetText(element).equals(text)){
                check = true;
                returnElement = element;
                break;
            }
        }
        if(!check || returnElement == null){
            Assert.fail("Elementin texti bulunamadi");
        }
        return returnElement;
    }

    public WebElement getRandomElementFromElements(By by) {
        Random random = new Random();
        int randomNumber = random.nextInt(presenceElements(by).size()-1);
        return presenceElements(by).get(randomNumber);
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 750);");
    }

    public WebElement getElementIndexFromElements(By by, Integer number) {
        return presenceElements(by).get(number);
    }

    public int getElementIntegerIndexFromElements(By by, Integer number) {
        return Integer.parseInt(presenceElements(by).get(number).getText().replaceAll("[^0-9]", ""));
    }
    public int getElementSizeFromElements(By by) {
        return presenceElements(by).size();
    }

    public void switchToNewWindow() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
