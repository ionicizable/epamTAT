package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.PartPage;

public class SearchPartTest extends CommonConditions{

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
        Assert.assertEquals("Амортизатор подвескиAcura\n" +
                "MDX 2001-2006", actual);
    }
}
