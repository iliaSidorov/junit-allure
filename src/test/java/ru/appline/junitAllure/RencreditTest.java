package ru.appline.junitAllure;


import org.junit.jupiter.api.Test;

public class RencreditTest extends BaseTest{

    @Test
    void testContributionCalculator_01() {
        app.getServiceMenuPage()
                .selectService("Вклады")
                .selectCurrency("Рубли")
                .fillField("Сумма вклада", "300000")
                .selectPeriod("6 месяцев")
                .fillField("Ежемесячное пополнение", "50000")
                .activateMonthlyCapitalization()
                .checkCalculation("Начислено %", "7 422,56")
                .checkCalculation("Пополнение за 6 месяцев", "250 000")
                .checkCalculation("К снятию через 6 месяцев", "557 422,56");
    }

    @Test
    void testContributionCalculator_02() {
        app.getServiceMenuPage()
                .selectService("Вклады")
                .selectCurrency("Доллары США")
                .fillField("Сумма вклада", "500000")
                .selectPeriod("9 месяцев")
                .fillField("Ежемесячное пополнение", "30000")
                .activateMonthlyCapitalization()
                .checkCalculation("Начислено %", "1 382,24")
                .checkCalculation("Пополнение за 6 месяцев", "240 000")
                .checkCalculation("К снятию через 6 месяцев", "741 382,24");
    }
}
