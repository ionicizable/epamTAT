package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.PartPage;

public class SearchPartTest extends CommonConditions{

    @Test
    public void searchPartTest() {
        new HomePage(driver)
                .openPage()
                .chooseCarBrand()
                .chooseCarModel()
                .chooseCarPart()
                .submitSearch();
        String actual = new PartPage(driver).getPartInfo();
        Assert.assertEquals("Амортизатор подвескиAcura\n" +
                "MDX 2001-2006", actual);
    }
}
