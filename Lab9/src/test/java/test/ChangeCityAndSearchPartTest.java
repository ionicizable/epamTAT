package test;



import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.PartPage;

public class ChangeCityAndSearchPartTest extends CommonConditions {

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
    public void loginTest() {
        final String HOME_PAGE_URL = "https://motorland.by/";
        User user = new User(256223828, "Motorland201");
        String actual = new HomePage(driver)
            .openPage(HOME_PAGE_URL)
            .openLoginPage()
            .login(user).checkLoginStatus();
        Assert.assertEquals(actual, "Мой кабинет");
    }

    @Test
    public void searchPartTest() {
        final String HOME_PAGE_URL = "https://motorland.by/";

        new HomePage(driver)
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

    @Test
    public void addToFavoritesTest() {
        final String HOME_PAGE_URL = "https://motorland.by/";
        User user = new User(256223828, "Motorland201");
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
