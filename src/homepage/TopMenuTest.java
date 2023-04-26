package homepage;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    @Before
    public void setUp() {
        //Method to open the url in the browser
        openBrowser(baseUrl);
    }
    public void selectMenu(String menu) {
        //Method to click on one of the element in menu
        clickOnElement(By.linkText(menu));
    }

    @Test
    public void verifyPageNavigation() {
        // used selectMenu method to select menu
        selectMenu("Computers");
        verifyActualAndExpectedText(By.xpath("//h1[contains(text(),'Computers')]"), "Computers");
        //verify the navigation
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
