package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumExample {


    private SeleniumConfig config;
    private String url = "http://localhost:8081/";

    public SeleniumExample() {
        config = new SeleniumConfig();
        config.getDriver().get(url);
    }


    public void closeWindow() {
        this.config.getDriver().close();
    }

    public String getTitle() {
        return this.config.getDriver().getTitle();
    }

    public void reset() {
        config.getDriver().get(url);
    }

    private void closeOverlay() {
        List<WebElement> webElementList = this.config.getDriver().findElements(By.tagName("a"));
        if (webElementList != null) {
            webElementList.stream()
                    .filter(webElement -> "Close".equalsIgnoreCase(webElement.getAttribute("title")))
                    .filter(WebElement::isDisplayed)
                    .findAny()
                    .ifPresent(WebElement::click);
        }
    }



    public void clickLogin() {

        config.getDriver().findElement(By.id("loginBtn")).click();

    }

    public boolean approveForm() {
        config.getDriver().findElement(By.id("subBtn")).click();
        Boolean result = config.getDriver().findElement(By.id("outcome")).isDisplayed();
        return result;
    }


    public void writeToElement(String e, String content) {
        WebElement ele = config.getDriver().findElement(By.id(e));
        ele.sendKeys(content);

    }

    public void clickRegister() {
        config.getDriver().findElement(By.id("registerBtn")).click();
    }

}

