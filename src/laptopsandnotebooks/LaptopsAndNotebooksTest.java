package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl="http://tutorialsninja.com/demo/index.php?";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
@Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
    //1.1 Mouse hover on Laptops & Notebooks Tab.and click
    mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
    //1.2 Click on “Show All Laptops & Notebooks”
    clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
    //1.3 Select Sort By "Price (High > Low)"
    selectByVisibleText(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"),"Price (High > Low)");
    //1.4 Verify the Product price will arrange in High to Low order.
    verifyText(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");

    }
    @Test
    public void   verifyThatUserPlaceOrderSuccessfully() {
       // 2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleText(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"),"Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));
        //2.5 Verify the text “MacBook”
        verifyText(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"),"MacBook");
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyText(By.xpath("//body/div[@id='product-product']/div[1]"),"Success: You have added MacBook to your shopping cart!");
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        //2.9 Verify the text "Shopping Cart"
        verifyText(By.xpath("//h1[contains(text(),' (0.00kg)')]"),"Shopping Cart");
        //2.10 Verify the Product name "MacBook"
        verifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"MacBook");
        //2.11 Change Quantity "2"
        sendText(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyText(By.xpath("//body/div[@id='checkout-cart']/div[1]"),"Success: You have modified your shopping cart!");
        //2.14 Verify the Total £737.45
        verifyText(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")," £737.45");
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        verifyText(By.xpath("//h1[contains(text(),'Checkout')]"),"Checkout");
        //2.17 Verify the Text “New Customer”
        verifyText(By.xpath("//h2[contains(text(),'New Customer')]"),"New Customer");
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("First Name"),"John");
        sendTextToElement(By.id("Last Name"),"Smith");
        sendTextToElement(By.id("E-Mail"),"SmithJohn@hotmail.com");
        sendTextToElement(By.id("Password"),"Smith12345@");
        sendTextToElement(By.id("Password Confirm"),"Smith12345@");
        sendTextToElement(By.id("Telephone"),"07378539512");
        sendTextToElement(By.id("Address 1"),"langley road");
        sendTextToElement(By.id("City"),"london");
        sendTextToElement(By.id("Post Code"),"sl25en");
        selectByValueFromDropDown(By.id("Country"),"United Kingdom");
        selectByValueFromDropDown(By.id("Region / State"),"Berkshire");

        //2.21 Click on “Continue”Button
        clickOnElement(By.xpath("//input[@id='button-register']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//div[1]/p[2]/textarea[1]"),"Not available");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.name("agree"));
        //2.24 Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));
       // 2.25 Verify the message “Warning: Payment method required!”




    }
    @After
    public void teardown(){
        closeBrowser();
    }



}
