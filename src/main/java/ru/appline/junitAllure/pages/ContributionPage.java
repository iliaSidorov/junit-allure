package ru.appline.junitAllure.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.appline.junitAllure.managers.DriverManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ContributionPage extends BasePage {

    @FindBy(xpath = "//span[@class='calculator__currency-field-text']")
    private List<WebElement> currencyTabs;

    @FindBy(xpath = "//input[@name='amount']")
    private WebElement amountInput;

    @FindBy(xpath = "//input[@name='replenish']")
    private WebElement replenishInput;

    @FindBy(xpath = "//select[@id='period']")
    private WebElement periodSelect;

    @FindBy(xpath = "//span[text()='Ежемесячная капитализация']")
    private WebElement monthlyCapitalizationCheckbox;

    @FindBy(xpath = "//div[@class='calculator__content']")
    private WebElement calculatorContentBlock;

    @FindBy(xpath = "//div[@class='calculator__result-block']")
    private WebElement calculatorResultBlock;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    private WebElement earnedResult;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    private WebElement replenishResult;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    private WebElement calcResult;

    @Step("Выбрана валюта {currencyName}")
    public ContributionPage selectCurrency(String currencyName) {
        for (WebElement currency : currencyTabs) {
            if (currency.getText().equalsIgnoreCase(currencyName)) {
                clickElement(currency);
                return this;
            }
        }
        fail(String.format("The currency with the name %s is not found on the page 'Contributions'", currencyName));
        return this;
    }

    @Step("Выбран период {period}")
    public ContributionPage selectPeriod(String period) {
        new Select(periodSelect).selectByVisibleText(period);
        return this;
    }

    @Step("Поле {fieldName} заполняется значением {value}")
    public ContributionPage fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Сумма вклада":
                fillField(amountInput, value);
                break;
            case "Ежемесячное пополнение":
                fillField(replenishInput, value);
                break;
            default:
                fail("There is no field with name " + fieldName + "on the page 'Contributions'");
        }
        return this;
    }

    @Step("Активирован чекбокс Ежемесячная капитализация")
    public ContributionPage activateMonthlyCapitalization() {
        scrollToElementJs(calculatorContentBlock);
        clickElement(monthlyCapitalizationCheckbox);
        return this;
    }

    public String getCalculatedValue (String fieldName) {
        scrollToElementJs(calculatorResultBlock);

        switch (fieldName) {
            case "Начислено %":
                waitUntilElementToBeClickable(earnedResult);
                return earnedResult.getText();
            case "Пополнение за 6 месяцев":
                waitUntilElementToBeClickable(replenishResult);
                return replenishResult.getText();
            case "К снятию через 6 месяцев":
                waitUntilElementToBeClickable(replenishResult);
                return calcResult.getText();
            default:
                throw new AssertionError("No field with name " + fieldName + " on the page 'Contributions'");
        }
    }

    private void fillField(WebElement field, String value) {
        field.sendKeys(value);
    }

    @Step("поле {field} должно быть заполнено значением {value}")
    public ContributionPage checkCalculation(String field, String value) {
        String actual = getCalculatedValue(field);
        assertTrue(actual.equals(value),
                String.format("The value of the field %s equals %s. Expected - %s", field, actual, value));
        return this;
    }
}
