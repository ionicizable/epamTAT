package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import wait.CustomWaits;

public class PartPage extends AbstractPage {

    private final static String PART_PAGE_URL = "https://motorland.by/account/";

    public PartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='grid-new-item-name']/a")
    private WebElement partName;

    @FindBy(xpath = "//i[@class='favorites-new-icon']")
    private WebElement favButton;

    @FindBy(xpath = "//div[@class='grid-new-item-model']")
    private WebElement partInfo;

    public String getPartInfo(){
        return partName.getText()+partInfo.getText();
    }

    public Boolean addToFavorites(){
        CustomWaits.waitForPageLoaded(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(favButton)).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='popup-favorites popup-favorites-submited']")));
        logger.info("Added to favorites");
        return Boolean.TRUE;
    }

    public PartPage removefromFavorites(){
        CustomWaits.waitForPageLoaded(driver);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='favorites-new-icon-submited']"))).click();
        logger.info("Removed from favorites");
        return this;
    }



    @Override
    public PartPage openPage() {
        driver.get(this.PART_PAGE_URL);
        CustomWaits.waitForPageLoaded(driver);
        return this;
    }
}
