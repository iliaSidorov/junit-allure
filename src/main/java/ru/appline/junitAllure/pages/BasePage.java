package ru.appline.junitAllure.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.junitAllure.managers.PageManager;

import static ru.appline.junitAllure.managers.DriverManager.getDriver;

public class BasePage {

    protected PageManager app = PageManager.getPageManager();
    protected WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);
    protected JavascriptExecutor js = (JavascriptExecutor) getDriver();
    protected Actions actions = new Actions(getDriver());


    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }


    protected WebElement waitUntilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clickElement(WebElement element) {
            actions.moveToElement(element).build().perform();
            waitUntilElementToBeClickable(element).click();
    }

    protected void scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
