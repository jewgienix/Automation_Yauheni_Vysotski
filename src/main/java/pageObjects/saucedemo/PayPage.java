package pageObjects.saucedemo;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class PayPage extends BasePage {
    private final By checkoutButton = By.id("checkout");
    private final By header = By.className("header_secondary_container");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By paymentInformation = By.className("summary_info_label");
    private final By finishButton = By.id("finish");

    public void clickCheckoutMenu() {
        click(checkoutButton);
    }

    public void clickContinueMenu() {
        click(continueButton);
    }

    public void clickFinish() {
        click(finishButton);
    }

    public void enterFirstname(String firstname) {
        sendKeys(this.firstName, "Vasya");
    }

    public void enterLastname(String lastname) {
        sendKeys(this.lastName, "Vasechkin");
    }

    public void enterZipCode(String zipcode) {
        sendKeys(this.zipCode, "123456");
    }
}