package ru.appline.junitAllure.managers;

import java.util.concurrent.TimeUnit;

import static ru.appline.junitAllure.managers.DriverManager.getDriver;
import static ru.appline.junitAllure.managers.DriverManager.quitDriver;
import static ru.appline.junitAllure.utils.PropConst.*;

public class InitManager {

    public static TestPropManager props = TestPropManager.getTestProperties();

    public static void initFramework() {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
        getDriver().get(props.getProperty(APP_URL));
    }

    public static void quitFramework() {
        quitDriver();
    }
}

