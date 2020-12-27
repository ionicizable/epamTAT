package test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.HomePage;
import page.PartPage;

public class ChangeCityAndSearchPartTests {
    private static WebDriver driver;

    @BeforeClass
    public static void browserSetup() {
        driver = new FirefoxDriver();
    }

    @Test
    public void changeCityTest() {
        final String HOME_PAGE_URL = "https://motorland.by/";

        HomePage homePage = new HomePage(driver)
                .openPage(HOME_PAGE_URL);

        String newCity = "Барановичи";
        homePage.openCitiesList();
        homePage.clickNewCity(newCity);
        Assert.assertEquals(newCity, homePage.getOldCity());
    }

    @Test
    public void searchPartTest() {
        final String HOME_PAGE_URL = "https://motorland.by/";

        HomePage homePage = new HomePage(driver)
                .openPage(HOME_PAGE_URL);
        PartPage partPage = new PartPage(driver);

        homePage.chooseCarBrand();
        homePage.chooseCarModel();
        homePage.chooseCarPart();
        homePage.submitSearch();
        String actual = partPage.getPartInfo();
        System.out.println(actual);
        Assert.assertEquals("Амортизатор подвескиAcura\n" +
                "MDX 2001-2006", actual);
        //driver.quit();
    }

    @AfterClass
    public static void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
