package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public static final int WAITING_WEB_ELEMENTS_IN_SECONDS = 10;
    public BasePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
