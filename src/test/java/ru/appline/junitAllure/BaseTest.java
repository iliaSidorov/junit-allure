package ru.appline.junitAllure;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.appline.junitAllure.managers.InitManager;
import ru.appline.junitAllure.managers.PageManager;

public class BaseTest {
    protected PageManager app = PageManager.getPageManager();

    @BeforeAll
    public static void setUp() {
        InitManager.initFramework();
    }

    @AfterAll
    public static void tearDown() {
        InitManager.quitFramework();
    }
}