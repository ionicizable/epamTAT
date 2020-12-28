package test;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.PartPage;
import service.UserCreator;

public class ChangeCityTest extends CommonConditions {

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
}