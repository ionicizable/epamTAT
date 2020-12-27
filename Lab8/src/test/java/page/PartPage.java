package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import wait.Wait;

public class PartPage extends AbstractPage {

    public PartPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='grid-new-item-name']/a")
    private WebElement partName;

    @FindBy(xpath = "//div[@class='grid-new-item-model']")
    private WebElement partInfo;

    public String getPartInfo(){
        return partName.getText()+partInfo.getText();
    }


    @Override
    public PartPage openPage(String url) {
        driver.get(url);
        Wait.waitForPageLoaded(driver);
        return this;
    }
}
