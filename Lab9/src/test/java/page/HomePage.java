package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.CustomWaits;
import wait.CustomWaits;

public class HomePage extends AbstractPage {

    private final String HOME_PAGE_URL = "https://motorland.by/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='personal-account']")
    private WebElement loginButton;

    @FindBy(className = "custom-select__gap")
    private WebElement oldCity;

    private final By locator = By.className("custom-select__gap");

    private WebElement newCity;

    @FindBy(xpath = "//span[text()='Марка автомобиля']")
    private WebElement carBrand;

    public AccountPage openLoginPage(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(loginButton))
                .click();
        return new AccountPage(driver);
    }

    public HomePage chooseCarBrand(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(carBrand));
        carBrand.click();
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.ARROW_DOWN);
        currentElement.sendKeys(Keys.ARROW_DOWN);
        currentElement.sendKeys(Keys.RETURN);
        return this;
    }

    public HomePage chooseCarModel(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-Filter_Model_VikiAutoModelId-container']")));
        WebElement model = driver.findElement(By.xpath("//span[@id='select2-Filter_Model_VikiAutoModelId-container']"));
        model.click();
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.ARROW_DOWN);
        currentElement.sendKeys(Keys.ARROW_DOWN);
        currentElement.sendKeys(Keys.RETURN);
        return this;
    }

    public HomePage chooseCarPart(){
        CustomWaits.waitForPageLoaded(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='select2-Filter_VikiPartId-container']")));
        WebElement part = driver.findElement(By.xpath("//span[@id='select2-Filter_VikiPartId-container']"));
        part.click();
        WebElement currentElement = driver.switchTo().activeElement();
        currentElement.sendKeys(Keys.ARROW_DOWN);
        currentElement.sendKeys(Keys.RETURN);
        return this;
    }

    public PartPage submitSearch(){
        CustomWaits.waitForPageLoaded(driver);
        WebElement searchButton = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("button-searh")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        logger.info("Searching for part");
        return new PartPage(driver);
    }

    public HomePage openCitiesList(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(oldCity));
        oldCity.click();
        return this;
    }

    public HomePage clickNewCity(String cityName){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='"+cityName+"']"))).click();
        return this;
    }

    public String getOldCity(){
        WebElement newBlueCity = driver.findElement(By.className("custom-select__gap"));
        return newBlueCity.getText();
    }

    @Override
    public HomePage openPage() {
        driver.get(this.HOME_PAGE_URL);
        CustomWaits.waitForPageLoaded(driver);
        logger.info("Opened HomePage");
        return this;
    }

}
