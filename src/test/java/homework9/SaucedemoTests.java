package homework9;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.CartPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.NavigationPage;
import pageObjects.saucedemo.ProductPage;

import static driver.DriverCreation.getDriver;

public class SaucedemoTests extends BaseTest {
    LoginPage loginPage;
    NavigationPage navigationPage;
    ProductPage productPage;
    CartPage cartPage;
    Integer indexCount = 0;

    @Parameters({"url"})
    @BeforeTest
    public void precondition(@Optional("https://www.saucedemo.com") String url) {
        loginPage = new LoginPage(getDriver());
        navigationPage = new NavigationPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        loginPage.open(url);
    }

    @Test(priority = 1, dataProvider = "get login")
    public void LoginPageTests(String userName, String userPassword, Boolean loginStatus) {
        loginPage.enterUsername(userName);
        loginPage.enterPassword(userPassword);
        loginPage.clickLogin();
        if (loginStatus) {
            navigationPage.openMenu();
            navigationPage.clickMenuItem("Logout");
        }
    }

    @DataProvider(name = "get login")
    public Object[][] getData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", true},
                {" ", "secret_sauce", false},
                {"standard_user", "123456", false},
                {"error_user", " ", false}
        };
    }

    @Test(priority = 2, dataProvider = "add product to cart")
    public void addProductsTests(String product) {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        productPage.verifyPage();
        productPage.clickItem(product);
        productPage.clickAddToCartButton();
        productPage.headerElement.openCart();
        cartPage.removeItem();
        cartPage.headerElement.openMenu();
        navigationPage.clickMenuItem("Logout");
    }

    @DataProvider(name = "add product to cart")
    public Object[][] getProduct() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"}
        };
    }

    @Test(priority = 3, invocationCount = 6)
    public void addProductsTest2() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        productPage.verifyPage();
        productPage.clickAddToCart(indexCount++);
        productPage.headerElement.openCart();
        cartPage.removeItem();
        cartPage.headerElement.openMenu();
        navigationPage.clickMenuItem("Logout");
    }
}
