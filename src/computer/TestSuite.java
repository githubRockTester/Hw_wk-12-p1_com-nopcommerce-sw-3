package computer;

import junit.framework.TestResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;
import zmq.socket.pubsub.Pub;

public class TestSuite extends Utility {
    @Before
    public void setUp() {
        //Method to open the url in the browser
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {                 //Method to verify the product order
        //Hovering mouse to the computer and then on desktop and click on it
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        // Click on Desktop
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //Select Sort By position and click on "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //Verify the Product will arrange in Descending order.
        verifyActualAndExpectedText(By.xpath("//option[contains(text(),'Name: Z to A')]"), "Name: Z to A");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Click on Computer
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        // Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        //Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //Click on Add To Cart
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //Verify the text "Build your own computer"
        verifyActualAndExpectedText(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer");
        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //Select RAM 8GB [+$60.00]
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        //Select Radio HDD 400 GB [+$100.00]
        clickOnElement(By.id("product_attribute_3_7"));
        //Select Radio OS Vista Premium[+$60.00]
        clickOnElement(By.id("product_attribute_4_9"));
        //Check two check boxes Microsoft office [+$50.00] and Total commander [+$5.00]
        clickOnElement(By.id("product_attribute_5_12"));
        //Verifing the price
        Thread.sleep(2000);
        verifyActualAndExpectedText(By.id("price-value-1"), "$1,475.00");
        //Click on ADD TO CART
        clickOnElement(By.id("add-to-cart-button-1"));
        Thread.sleep(2000);
        //Verifing the text 'The product has been added to your shopping cart'
        verifyActualAndExpectedText(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");
        //Click on the cross button
        clickOnElement(By.xpath("//span[@title='Close']"));
        //MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(2000);
        //CLick on the cart
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        mouseHoverToElementAndClick(By.xpath("//button[normalize-space()='Go to cart']"));
        //verify the text
        verifyActualAndExpectedText(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        Thread.sleep(2000);
        //Clear the data and input new data in the quantity box
        clearDataAddData(By.cssSelector("input[value='1']"), "2");
        //Click on Update cart
        mouseHoverToElementAndClick(By.id("updatecart"));
        //Verify the actual and expected text 'Total $2950.00'
        verifyActualAndExpectedText(By.xpath("//span[@class='product-subtotal']"), "$2,950.00");
        //Click to check the box of Termofservices
        mouseHoverToElementAndClick(By.name("termsofservice"));
        //Click on the check out
        clickOnElement(By.id("checkout"));
        //Verify the text 'Welcome, Please Sign In!'
        verifyActualAndExpectedText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
        //Click on 'Check out as guest'
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Alex");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Bosky");
        sendTextToElement(By.id("BillingNewAddress_Email"), "bosky.alex@gmail.com");
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "India");
        Thread.sleep(3000);
        sendTextToElement(By.id("BillingNewAddress_StateProvinceId"), "Other");
        sendTextToElement(By.id("BillingNewAddress_City"), "Anand");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "Mota Bazar");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "388 580");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "98858 01058");
        mouseHoverToElementAndClick(By.xpath("//button[@onclick='Billing.save()']"));
        mouseHoverToElementAndClick(By.xpath("//input[@id='shippingoption_1']"));
        mouseHoverToElementAndClick(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        mouseHoverToElementAndClick(By.id("paymentmethod_1"));
        mouseHoverToElementAndClick(By.xpath("//button[@type='button' and @onclick='PaymentMethod.save()']"));
        sendTextToElement(By.id("CardholderName"), "Mr Bosky");
        sendTextToElement(By.id("CardNumber"), "0750 5804 6876 126");
        sendTextToElement(By.id("ExpireMonth"), "03");
        sendTextToElement(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "259");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@type='button' and @onclick='PaymentInfo.save()']"));
        verifyActualAndExpectedText(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"), "$2,950.00");
        verifyActualAndExpectedText(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"), "Your order has been successfully processed!");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
