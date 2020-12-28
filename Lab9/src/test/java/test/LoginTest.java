package test;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.PartPage;
import service.UserCreator;

public class LoginTest extends CommonConditions {

    @Test
    public void loginTest() {
        final String HOME_PAGE_URL = "https://motorland.by/";
        User user = UserCreator.createUserFromProperties();
        String actual = new HomePage(driver)
                .openPage(HOME_PAGE_URL)
                .openLoginPage()
                .login(user).checkLoginStatus();
        Assert.assertEquals(actual, "Мой кабинет");
    }
}