package ru.appline.junitAllure.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class ServiceMenuPage extends BasePage {

    @FindBy(xpath = "//div[@class = 'service__title']//a[@href][1]")
    private List<WebElement> serviceMenuItems;

    @Step("Выбран сервис {itemText}")
    public ContributionPage selectService(String itemText) {
        switch (itemText) {
            case "Карты":
                clickElement(serviceMenuItems.get(0));
                break;
            case "Кредиты":
                clickElement(serviceMenuItems.get(1));
                break;
            case "Вклады":
                clickElement(serviceMenuItems.get(2));
                break;
            default:
                fail("No service with name " + itemText + " on the main page");
        }
        return app.getContributionPage();
    }


}
