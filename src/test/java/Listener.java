import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {


    public void onTestStart(ITestResult iTestResult) {
        BaseTest.LOGGER.info("Tests started!");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        BaseTest.LOGGER.info("Tests successful finish!");
    }

    public void onTestFailure(ITestResult iTestResult) {
        BaseTest.LOGGER.info("Tests Failure!");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        BaseTest.LOGGER.info("Tests Skipped!");

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        BaseTest.LOGGER.info("Tests Failure!");

    }

    public void onStart(ITestContext iTestContext) {
    }

    public void onFinish(ITestContext iTestContext) {

    }
}