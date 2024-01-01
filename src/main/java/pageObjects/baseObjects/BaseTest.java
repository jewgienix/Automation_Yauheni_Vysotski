package pageObjects.baseObjects;

import org.testng.IInvokedMethodListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testngUtils.InvokedListener;
import testngUtils.Listener;

import static driver.DriverCreation.createDriver;
import static driver.DriverCreation.quitDriver;
import static driver.DriverTypes.CHROME;
import static driver.DriverTypes.valueOf;
import static propertyUtils.PropertyReader.getProperties;
@Listeners({Listener.class, InvokedListener.class})
public abstract class BaseTest {
    @BeforeTest
    protected void setUp() {

        createDriver(System.getProperties().containsKey("config")
                ? valueOf(getProperties().getProperty("browser").toUpperCase())
                : CHROME
        );
    }

    @AfterTest(alwaysRun = true)
    protected void tearDown() {

        quitDriver();
    }
}
