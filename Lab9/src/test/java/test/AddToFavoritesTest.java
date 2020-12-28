package test;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.PartPage;
import service.UserCreator;

public class AddToFavoritesTest extends CommonConditions {

    @Test
    public void addToFavoritesTest() {
        final String HOME_PAGE_URL = "https://motorland.by/";
        User user = UserCreator.createUserFromProperties();
        Boolean addedToFavorites = new HomePage(driver)
                .openPage(HOME_PAGE_URL)
                .openLoginPage()
                .login(user)
                .openHomePage()
                .openPage(HOME_PAGE_URL)
                .chooseCarBrand()
                .chooseCarModel()
                .chooseCarPart()
                .submitSearch()
                .addToFavorites();
        new PartPage(driver).removefromFavorites();
        Assert.assertTrue(addedToFavorites);
    }
}
