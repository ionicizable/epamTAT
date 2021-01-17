package test;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.PartPage;
import service.TestDataReader;
import service.UserCreator;

public class ChangeCityTest extends CommonConditions {

    @Test
    public void changeCityTest() {
        HomePage homePage = new HomePage(driver)
                .openPage();
        final String NEW_CITY = TestDataReader.getTestData("testdata.city");
        homePage.openCitiesList();
        homePage.clickNewCity(NEW_CITY);
        Assert.assertEquals(NEW_CITY, homePage.getOldCity());
    }
}