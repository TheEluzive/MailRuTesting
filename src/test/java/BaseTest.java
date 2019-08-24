import Model.DataPool;
import lombok.Data;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Listeners(Listener.class)
@Getter
public class BaseTest {

    public static final String EMAIL_FOR_LOGIN = "emailForQAQA";
    public static final String PASSWORD = "QAQAQAQA123qa";
    public static final String EMAIL_POSTFIX = "@inbox.ru";
    public static final String LETTER_ADDRESSEE = "emailForQAQA@inbox.ru";
    public static final String LETTER_TEXT = "The letter text!";
    public static Logger LOGGER;

    private static String mainURL="";
    private Properties property;
    DataPool dataPool;





    protected WebDriver driver;

    @BeforeTest
    public void onStart(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(mainURL);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void onFinish(){
        driver.close();
        LOGGER.info("Test finished!");
    }




    @BeforeSuite
    public void beforeSuite() {
        String log4jConfPath = "src/test/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        LOGGER = Logger.getLogger(BaseTest.class);

        FileInputStream fis;
        property = new Properties();

        try {
            fis = new FileInputStream("src/test/resources/config.properties");
            property.load(fis);
            mainURL = property.getProperty("mainURL");
            LOGGER.info("MainURL = " + mainURL);

        } catch (IOException e) {
            LOGGER.error("Properties files wasn`t found");
        }
    }


}
