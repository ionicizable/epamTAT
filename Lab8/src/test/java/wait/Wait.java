package wait;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private static final int WAIT_TIMEOUT_SECONDS = 10;

    public static void waitForPageLoaded(WebDriver driver){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(d -> ((JavascriptExecutor)d).executeScript("return document.readyState").equals("complete"));
    }
}
