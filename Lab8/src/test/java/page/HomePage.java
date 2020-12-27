package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.Wait;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "custom-select__gap")
    private WebElement oldCity;

    private final By locator = By.className("custom-select__gap");

    private WebElement newCity;

    @FindBy(xpath = "//span[text()='Марка автомобиля']")
    private WebElement carBrand;

    public HomePage chooseCarBrand(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(carBrand));
        carBrand.click();
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.ARROW_DOWN);
        currentElement.sendKeys(Keys.ARROW_DOWN);
        currentElement.sendKeys(Keys.RETURN);
        return this;
    }

    public HomePage chooseCarModel(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-Filter_Model_VikiAutoModelId-container']")));
        WebElement model = driver.findElement(By.xpath("//span[@id='select2-Filter_Model_VikiAutoModelId-container']"));
        model.click();
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.ARROW_DOWN);
        currentElement.sendKeys(Keys.ARROW_DOWN);
        currentElement.sendKeys(Keys.RETURN);
        return this;
    }

    public HomePage chooseCarPart(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-Filter_VikiPartId-container']")));
        WebElement part = driver.findElement(By.xpath("//span[@id='select2-Filter_VikiPartId-container']"));
        part.click();
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.ARROW_DOWN);
        currentElement.sendKeys(Keys.RETURN);
        return this;
    }

    public HomePage submitSearch(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("button-searh")));
        WebElement searchButton = driver.findElement(By.id("button-searh"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return this;
    }

    public HomePage openCitiesList(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(oldCity));
        oldCity.click();
        return this;
    }

    public HomePage clickNewCity(String cityName){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath())).click();
        return this;
    }

    public String getOldCity(){
        WebElement newBlueCity = driver.findElement(By.className("custom-select__gap"));
        return newBlueCity.getText();
    }

    @Override
    public HomePage openPage(String url) {
        driver.get(url);
        Wait.waitForPageLoaded(driver);
        return this;
    }

}
