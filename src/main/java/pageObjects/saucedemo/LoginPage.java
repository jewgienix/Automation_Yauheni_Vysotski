package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;
import static propertyUtils.PropertyReader.getProperties;

public class LoginPage extends BasePage {
    private final WebDriver driver;
    private final By header = By.className("login-logo");
    private final By username = By.id("user-name");
    private final By password = By.name("password");
    private final By login = By.cssSelector("input[value='Login']");
    private final By loginCredentials = By.id("login_credentials");
    private final By passwordCredentials = By.className("login_password");

    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logout = By.id("logout_sidebar_link");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void open(String url){
        driver.get(url);

    }
    public void verifyLoginPage(){
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name.");
        Arrays.asList(username, password, login).forEach(el -> Assert.assertTrue(getDriver().findElement(el).isDisplayed(), "Element not displayed :: " + el));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/", "Wrong header url.");
    }

    public void enterUsername(String username){
        sendKeys(this.username, username);
    }
    public void enterPassword(String password){
        sendKeys(this.password, password);
    }
    public void clickLogin(){
        click(login);
    }
    public void clickMenuButton(){
        click(menuButton);
    }
    public void clickLogout(){
        click(logout);
    }

    public List<String> getUsernames(){
        return Arrays.stream(driver.findElement(loginCredentials).getText().split("\n"))
                .filter(value -> !value.contains("Accepted usernames are"))
                .collect(Collectors.toList());
    }
    public String getPassword(){
        return Arrays.stream(driver.findElement(passwordCredentials).getText().split("\n"))
                .filter(value -> !value.contains("Password for all users"))
                .findFirst().orElse("");
    }
    public void open() {
        getDriver().get(getProperties().getProperty("url"));
    }
    public void enterUsername() {
        sendKeys(this.username, getProperties().getProperty("username"));
    }
    public void enterPassword() {
        sendKeys(this.password, getProperties().getProperty("password"));
    }
}
