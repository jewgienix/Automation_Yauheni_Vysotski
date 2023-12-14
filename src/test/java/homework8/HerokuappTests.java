package homework8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DynamicControlsPage;
import pageObjects.herokuapp.FramesPage;
import pageObjects.herokuapp.HomePage;

import static pageObjects.herokuapp.HomePageItems.DYNAMIC_CONTROLS;
import static pageObjects.herokuapp.HomePageItems.FRAMES;

public class HerokuappTests extends BaseTest {
    HomePage homePage;
    @BeforeMethod
    public void precondition(){
        homePage = new HomePage();
        homePage.open("https://the-internet.herokuapp.com/");
    }
    @Test(priority = 1)
    public void iframeTest() {
        FramesPage framespage = new FramesPage();
        homePage.clickOnItem(FRAMES);
        framespage.clickOnItem("iFrame");
        framespage.switchToFrame();
        framespage.verifyTextIsDisplayed();
        framespage.unSwitchToFrame();
    }
    @Test(priority = 2)
    public void dynamicControlsTest(){
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        homePage.clickOnItem(DYNAMIC_CONTROLS);
        dynamicControlsPage.verifyTitleText();
        dynamicControlsPage.verifyCheckbox();
        dynamicControlsPage.clickOnRemoveButton();
        dynamicControlsPage.verifyFirstMessage();
        dynamicControlsPage.verifyNotCheckbox();
        dynamicControlsPage.verifyTextFieldIsDisabled();
        dynamicControlsPage.clickOnEnableButton();
        dynamicControlsPage.verifySecondMessage();
        dynamicControlsPage.enterText("Hey everybody!");
    }

}
