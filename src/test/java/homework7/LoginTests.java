package homework7;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.CartPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.PayPage;
import pageObjects.saucedemo.ProductPage;

import static driver.DriverCreation.getDriver;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private PayPage payPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage(getDriver());
        productPage = new ProductPage();
        cartPage = new CartPage();
        payPage = new PayPage();
        loginPage.open("https://www.saucedemo.com");
    }

    @Test(priority = 1)
    public void successfulLoginTest1() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open("https://www.saucedemo.com");
        loginPage.enterUsername(loginPage.getUsernames().get(0));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLogin();
        loginPage.clickMenuButton();
        loginPage.clickLogout();
    }

    @Test(priority = 2)
    public void successfulLoginTest2() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open("https://www.saucedemo.com");
        loginPage.enterUsername(loginPage.getUsernames().get(2));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLogin();
        loginPage.clickMenuButton();
        loginPage.clickLogout();
    }

    @Test
    public void successfulLoginTest3() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open("https://www.saucedemo.com");
        loginPage.enterUsername(loginPage.getUsernames().get(4));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLogin();
    }

    @Test(priority = 4)
    public void addProductToCartTest() {
        loginPage.enterUsername(loginPage.getUsernames().get(4));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLogin();
        productPage.verifyPage();
        productPage.clickAddToCart(1);
    }

    @Test(priority = 5)
    public void removeProductFromCartTest() {
        cartPage.checkCart();
        cartPage.removeItem();
        loginPage.clickMenuButton();
        loginPage.clickLogout();
    }

    @Test(priority = 6)
    public void payProductTest() {
        loginPage.enterUsername(loginPage.getUsernames().get(4));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLogin();
        productPage.verifyPage();
        productPage.clickAddToCart(1);
        cartPage.checkCart();
        payPage.clickCheckoutMenu();
        payPage.enterFirstname("Vasya");
        payPage.enterLastname("Vasechkin");
        payPage.enterZipCode("123456");
        payPage.clickContinueMenu();
        payPage.clickFinish();
    }


}
