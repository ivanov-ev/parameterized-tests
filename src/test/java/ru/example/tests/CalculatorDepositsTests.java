package ru.example.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import ru.example.data.Deposits;
import ru.example.pages.CalculatorDepositsPage;

public class CalculatorDepositsTests extends TestBase {

    CalculatorDepositsPage calculatorDepositsPage = new CalculatorDepositsPage();

    @CsvSource(value = {
            "100 | 1 | 1 | 100.08",
            "100000 | 12 | 25 | 124951.16"
    }, delimiter = '|')
    @Tags (
            {@Tag("Smoke"),
            @Tag("Deposits")}
    )
    @ParameterizedTest
    public void enterSumDurationRateViaCsvAndTestFinalSumTest(String depositSum, String depositDuration, String depositRate, String finalSum) {
        calculatorDepositsPage.openPage();
        calculatorDepositsPage.setDepositSum(depositSum);
        calculatorDepositsPage.setDepositDuration(depositDuration);
        calculatorDepositsPage.setDepositRate(depositRate);
        calculatorDepositsPage.checkFinalSum(finalSum);
    }

    @CsvFileSource(resources = "/test_data/Deposits.csv", numLinesToSkip = 1)
    @Tag("Deposits")
    @ParameterizedTest
    public void enterSumDurationRateViaCsvFileAndTestFinalSumTest(String depositSum, String depositDuration, String depositRate, String finalSum) {
        calculatorDepositsPage.openPage();
        calculatorDepositsPage.setDepositSum(depositSum);
        calculatorDepositsPage.setDepositDuration(depositDuration);
        calculatorDepositsPage.setDepositRate(depositRate);
        calculatorDepositsPage.checkFinalSum(finalSum);
    }

    @EnumSource(Deposits.class)
    @Tag("Deposits")
    @ParameterizedTest
    public void enterSumDurationRateViaEnumAndTestFinalSumTest(Deposits deposits) {
        calculatorDepositsPage.openPage();
        calculatorDepositsPage.setDepositSum(deposits.getDepositSum());
        calculatorDepositsPage.setDepositDuration(deposits.getDepositDuration());
        calculatorDepositsPage.setDepositRate(deposits.getDepositRate());
        calculatorDepositsPage.checkFinalSum(deposits.getFinalSum());
    }

    @Tag("Deposits")
    @Disabled("JIRA-1234")
    @Test
    @DisplayName("Changing ANY of the currency fields must change the currency in ALL of them")
    public void changeCurrencyTest() {
        //TO-DO in JIRA-1234
    }
}
