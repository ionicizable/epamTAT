import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StorageChangeTest {
    @Test
    public void storageChangeTest() {
        System.setProperty("webdriver.gecko.driver","E:\\programms\\webdrivers\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        webDriver.get("https://motorland.by/");
        WebElement oldCity = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("custom-select__gap")));
        executor.executeScript("arguments[0].click();", oldCity);
        WebElement newCity = webDriver.findElement(By.className("custom-select__list")).findElement(By.xpath("li[5]/span"));
        String expected = newCity.getText();
        executor.executeScript("arguments[0].click();", newCity);
        String actual = oldCity.getText();
        webDriver.quit();
        Assert.assertEquals(expected,actual);
    }


}
