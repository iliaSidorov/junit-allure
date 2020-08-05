package ru.appline.junitAllure;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;
import ru.appline.junitAllure.managers.InitManager;
import ru.appline.junitAllure.managers.PageManager;
import ru.appline.junitAllure.utils.AfterEachExtention;

public class BaseTest {

    protected PageManager app = PageManager.getPageManager();

    @RegisterExtension
    AfterEachExtention afterEachExtention = new AfterEachExtention();

    @BeforeAll
    public static void setUp() {
        InitManager.initFramework();
    }

    @AfterAll
    public static void tearDown() {
        InitManager.quitFramework();
    }
}