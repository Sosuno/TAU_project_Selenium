package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SeleniumConfig {
    private WebDriver driver;

    public SeleniumConfig() {
        System.out.println("Welcome to Maven World");
        System.out.println(findFile("geckodriver.exe") + "aa");
        System.setProperty("webdriver.gecko.driver", findFile("geckodriver.exe"));
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    /*
    static {
        System.setProperty("webdriver.gecko.driver", findFile("geckodriver"));
    }
*/
    static private String findFile(String filename) {
        String paths[] = {"", "bin/", "target/classes", "lib"};
        for (String path : paths) {
            if (new File(path + filename).exists())
                return path + filename;
        }
        return "";
    }
    public void close() {
        driver.close();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

