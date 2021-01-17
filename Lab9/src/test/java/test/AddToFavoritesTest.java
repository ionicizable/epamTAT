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
        User user = UserCreator.createUserFromProperties();
        Boolean addedToFavorites = new HomePage(driver)
                .openPage()
                .openLoginPage()
                .login(user)
                .openHomePage()
                .openPage()
                .chooseCarBrand()
                .chooseCarModel()
                .chooseCarPart()
                .submitSearch()
                .addToFavorites();
        new PartPage(driver).removefromFavorites();
        Assert.assertTrue(addedToFavorites);
    }
}
