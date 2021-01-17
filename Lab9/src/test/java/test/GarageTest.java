package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GaragePage;
import page.HomePage;
import service.UserCreator;

public class GarageTest extends CommonConditions {

    @Test
    public void GarageTest() {
        User user = UserCreator.createUserFromProperties();
        String actual = new HomePage(driver)
            .openPage()
            .openLoginPage()
            .login(user)
                .openGaragePage()
                .addCar()
                .checkCar();
        new GaragePage(driver).removeCar();
        Assert.assertEquals(actual, "Audi 100 (44) 1983-1991");
    }
}
