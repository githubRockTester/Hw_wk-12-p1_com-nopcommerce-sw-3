package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method is to clear the text
     */

    public void clearText(By by) {
        driver.findElement(by).clear();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will verify the actual and expected text
     */
    public void verifyActualAndExpectedText(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        Assert.assertEquals(actualText, expectedText);
    }

    /**
     * This method is for hovering the mouse
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    /**
     * This method is for hovering the mouse and clinking
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    /**
     * This methos is to clear the data and send the new input
     */
    public void clearDataAddData(By by, String input) {
        clearText(by);
        sendTextToElement(by, input);
    }


//************************* Alert Methods *****************************************************
// Homework Create 5 methods

    //*************************** Select Class Methods ***************************************//
    public void selectByVisibleTextFromDropDown(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);


//        WebElement dropDown = driver.findElement(by);
//        Select select = new Select(dropDown);
//        // Select by visible text
//        select.selectByVisibleText(text);
    }
    // Homework 2 more method
}