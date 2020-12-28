package page;

import model.User;
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

    public AccountPage login(User user) {
        CustomWaits.waitForPageLoaded(driver);
        phoneNumber.sendKeys(user.getPhoneNumber() + "");
        password.sendKeys(user.getPassword());
        loginButton.click();
        return this;
    }

    public String checkLoginStatus() {
        CustomWaits.waitForPageLoaded(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.textToBe(By.xpath("//a[@class='personal-account']/p"), "Мой кабинет"));
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//a[@class='personal-account']/p"))).getText();
    }

    @Override
    public AccountPage openPage(String url) {
        driver.get(url);
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
