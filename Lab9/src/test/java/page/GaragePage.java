package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.CustomWaits;

public class GaragePage extends AbstractPage {

    private final static String GARAGE_PAGE_URL = "https://motorland.by/account/";

    public GaragePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//a[@class='btn-1 btn-1_green']")
    private WebElement addCar;

    public GaragePage addCar() {
        CustomWaits.waitForPageLoaded(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addCar)).click();

        CustomWaits.waitForPageLoaded(driver);
        Select brandSelect = new Select(driver.findElement(By.xpath("//select[@id='VikiAutoId']")));
        brandSelect.selectByVisibleText("Audi");

        CustomWaits.waitForPageLoaded(driver);
        Select modelSelect = new Select(driver.findElement(By.xpath("//select[@id='BrandModel_VikiAutoModelId']")));
        modelSelect.selectByVisibleText("   100 (44) 1983-1991");

        CustomWaits.waitForPageLoaded(driver);
        Select bodySelect = new Select(driver.findElement(By.xpath("//select[@id='BodyType']")));
        bodySelect.selectByVisibleText("Седан");

        CustomWaits.waitForPageLoaded(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-1 btn-1_green']"))).click();
        return this;
    }

    public GaragePage removeCar() {
        CustomWaits.waitForPageLoaded(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn-close']"))).click();
        return this;
    }



    public String checkCar() {
        CustomWaits.waitForPageLoaded(driver);
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='car-list__title-name-car']"))).getText();
    }

    @Override
    public GaragePage openPage() {
        driver.get(this.GARAGE_PAGE_URL);
        CustomWaits.waitForPageLoaded(driver);
        logger.info("Opened AccountPage");
        return this;
    }
}
