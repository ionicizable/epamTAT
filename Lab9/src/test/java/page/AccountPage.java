package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.CustomWaits;

import javax.swing.*;

public class AccountPage extends AbstractPage {

    private final static String ACCOUNT_PAGE_URL = "https://motorland.by/account/";

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "EmailOrPhone")
    private WebElement phoneNumber;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='cabinet-bloks__cars']//a[@class='cabinet-bloks__btn']")
    private WebElement garage;

    public AccountPage login(User user) {
        CustomWaits.waitForPageLoaded(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(phoneNumber)).click();
        phoneNumber.sendKeys(user.getPhoneNumber() + "");
        password.sendKeys(user.getPassword());
        loginButton.click();
        logger.info("Logged in");
        return this;
    }



    public String getAccountNumber() {
        CustomWaits.waitForPageLoaded(driver);
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='account__cabinet']/p/b"))).getText();
    }

    public HomePage openHomePage() {
        CustomWaits.waitForPageLoaded(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='home']")));
        return new HomePage(driver);
    }

    public GaragePage openGaragePage() {
        CustomWaits.waitForPageLoaded(driver);
        driver.get("https://motorland.by/account/garage/");
        return new GaragePage(driver);
    }

    @Override
    public AccountPage openPage() {
        driver.get(this.ACCOUNT_PAGE_URL);
        CustomWaits.waitForPageLoaded(driver);
        logger.info("Opened AccountPage");
        return this;
    }
}
