package lecture_8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.*;

import static pageObjects.herokuapp.HomePageItems.*;



public class Lecture8Tests extends BaseTest {
    HomePage homePage;
    @BeforeMethod
    public void precondition(){
        homePage = new HomePage();
        homePage.open("https://the-internet.herokuapp.com/");
    }
    @Test(priority = 1)
    public void abTestingTest(){
        ABTestControlPage controlPage = new ABTestControlPage();
        homePage.clickOnItem(AB_TESTING);
        controlPage.verifyTitleText();
    }
    @Test(priority = 2)
    public void checkboxTest(){
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        homePage.clickOnItem(CHECKBOX);
        checkboxesPage.verifyElementsCount();
        checkboxesPage.clickCheckbox(1);
        checkboxesPage.verifyCheckboxStatus(1,true);
    }
    @Test(priority = 3)
    public void scrollTest() {
        InfiniteScrollPage scrollPage = new InfiniteScrollPage();
        homePage.clickOnItem(INFINITE_SCROLL);
        scrollPage.verifyTitleText();
        scrollPage.scroll(4);
    }
    @Test(priority = 4)
    public void iframeTest() {
        FramesPage framespage = new FramesPage();
        homePage.clickOnItem(FRAMES);
        framespage.clickOnItem("iFrame");
        framespage.switchToFrame();
        framespage.enterText("Hello world!");
        framespage.unSwitchToFrame();
        }
    }

