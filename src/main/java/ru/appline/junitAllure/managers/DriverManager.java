package ru.appline.junitAllure.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static ru.appline.junitAllure.utils.PropConst.*;

public class DriverManager {

    private static WebDriver driver;
    private static TestPropManager props = TestPropManager.getTestProperties();

    private DriverManager() {
    }

    private static void initDriver() {
        if (driver == null) {
            switch (props.getProperty(BROWSER_TYPE)) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", props.getProperty(PATH_CHROME_DRIVER));
                    driver = new ChromeDriver();
                    break;
                default:
                    System.setProperty("webdriver.gecko.driver", props.getProperty(PATH_GEKO_DRIVER));
                    driver = new FirefoxDriver();
            }
        }
    }

    //lazy init
    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}

