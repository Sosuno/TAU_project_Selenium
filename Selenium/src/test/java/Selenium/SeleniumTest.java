package Selenium;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SeleniumTest {
    private SeleniumExample seleniumExample;
    private String expectedTitle = "My TAU";

    @BeforeSuite
    public void setUp() {
        seleniumExample = new SeleniumExample();
    }

    @AfterSuite
    public void tearDown() {
        seleniumExample.closeWindow();
    }

    @Test
    public void whenLoadedCheckTitle() {
        String actualTitle = seleniumExample.getTitle();
        assertNotNull(actualTitle);
        assertEquals(expectedTitle, actualTitle);
    }

    private void assertEquals(String expectedTitle, String actualTitle) {
    }

    @Test
    public void checkLogin(){
        seleniumExample.clickLogin();
        seleniumExample.writeToElement("username", "ewik");
        seleniumExample.writeToElement("password", "pass");
        assertTrue(seleniumExample.approveForm());
        seleniumExample.reset();
        seleniumExample.clickLogin();
        seleniumExample.writeToElement("username", "qwe");
        seleniumExample.writeToElement("password", "zxc");
        assertFalse(seleniumExample.approveForm());
        seleniumExample.reset();


    }
    @Test void checkRegister() {
        seleniumExample.clickRegister();
        seleniumExample.writeToElement("username", "ewik");
        seleniumExample.writeToElement("password", "pass");
        seleniumExample.writeToElement("repassword", "pass");
        seleniumExample.writeToElement("email", "pass@");
        assertTrue(seleniumExample.approveForm());
        seleniumExample.reset();
        seleniumExample.clickRegister();
        seleniumExample.writeToElement("username", "qwe");
        seleniumExample.writeToElement("password", "zxc");
        seleniumExample.writeToElement("repassword", "zsc");
        seleniumExample.writeToElement("email", "pass@");
        assertFalse(seleniumExample.approveForm());
        seleniumExample.reset();
        seleniumExample.clickRegister();
        seleniumExample.writeToElement("username", "qwe");
        seleniumExample.writeToElement("password", "zxc");
        seleniumExample.writeToElement("repassword", "zxc");
        seleniumExample.writeToElement("email", "pass");
        assertFalse(seleniumExample.approveForm());
        seleniumExample.reset();
    }

}

