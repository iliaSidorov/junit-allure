package ru.appline.junitAllure.utils;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static ru.appline.junitAllure.managers.DriverManager.getDriver;

public class AfterEachExtention implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        if (context.getExecutionException().isPresent()) {
            addScreenshot();
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    private static byte[] addScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
