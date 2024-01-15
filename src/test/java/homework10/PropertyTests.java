package homework10;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.CartPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.NavigationPage;
import pageObjects.saucedemo.ProductPage;

import static driver.DriverCreation.getDriver;

public class PropertyTests extends BaseTest {
    LoginPage loginPage;
    NavigationPage navigationPage;
    ProductPage productPage;
    CartPage cartPage;
    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage(getDriver());
        navigationPage = new NavigationPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        loginPage.open();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }
    @Test
    public void PropertyTest(){
        loginPage.open();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }


}

