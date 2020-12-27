package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.HomePage;
import page.PartPage;

public class ChangeCityAndSearchPartTests extends CommonConditions {

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
                .openPage(HOME_PAGE_URL)
                .chooseCarBrand()
                .chooseCarModel()
                .chooseCarPart()
                .submitSearch();
        String actual = new PartPage(driver).getPartInfo();
        System.out.println(actual);
        Assert.assertEquals("Амортизатор подвескиAcura\n" +
                "MDX 2001-2006", actual);
    }

}
