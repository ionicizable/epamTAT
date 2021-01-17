package test;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.UserCreator;

public class LoginTest extends CommonConditions {

    @Test
    public void loginTest() {
        User user = UserCreator.createUserFromProperties();
        String actual = new HomePage(driver)
                .openPage()
                .openLoginPage()
                .login(user).getAccountNumber();
        Assert.assertEquals(actual, "+375"+user.getPhoneNumber().toString());
    }
}