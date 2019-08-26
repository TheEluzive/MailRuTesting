package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private static final int WAITING_WEB_ELEMENTS_IN_SECONDS = 10;
    public BasePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public static WebElement waitWebElement(WebDriver driver, WebElement webElement){
        webElement = (new WebDriverWait(driver, WAITING_WEB_ELEMENTS_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    public static void select(WebElement selector, String value){
        Select select = new Select(selector);
        selector.click();
        select.selectByVisibleText(value);
    }

    public static String getLocatorFromWebElement(WebElement element) {
        return element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "").substring(8);
    }

    public static void sendKeysByJS(WebDriver driver, WebElement webElement, String text) {
        String javaScript = " const elem = document.evaluate('"+ getLocatorFromWebElement(webElement) +
                "', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue; " +
                "elem.innerText = '" + text + "' ";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(javaScript, webElement);
    }

    public static void pressButton(WebElement webElement){
        webElement.click();
    }
}
