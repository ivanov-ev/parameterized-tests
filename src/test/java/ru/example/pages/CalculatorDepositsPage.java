package ru.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.text.NumberFormat;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// =================================================================
//PAGE OBJECT FOR https://www.banki.ru/services/calculators/deposits
// ================================================================

public class CalculatorDepositsPage {
    private final SelenideElement
            depositSumInput = $(byText("Сумма вклада")).preceding(0),
            depositDurationInput = $(byText("Срок вклада")).preceding(0),
            depositRateInput = $(byText("Процентная ставка, % годовых")).preceding(0),
            depositSumAtPeriodEndOutput = $(byText("Сумма в конце срока")).sibling(0);

    public CalculatorDepositsPage openPage() {
        open("/deposits");
        return this;
    }

    public CalculatorDepositsPage setDepositSum(String value) {
        for (int i = 0; i <= 5; i++) {
            depositSumInput.sendKeys(Keys.BACK_SPACE);
        }
        depositSumInput.setValue(value);
        return this;
    }

    public CalculatorDepositsPage setDepositDuration(String value) {
        for (int i = 0; i <= 2; i++) {
            depositDurationInput.sendKeys(Keys.BACK_SPACE);
        }
        depositDurationInput.setValue(value);
        return this;
    }

    public CalculatorDepositsPage setDepositRate(String value) {
        depositRateInput.sendKeys(Keys.ARROW_RIGHT);
        depositRateInput.sendKeys(Keys.ARROW_RIGHT);
        for (int i = 0; i <= 2; i++) {
            depositRateInput.sendKeys(Keys.BACK_SPACE);
        }
        depositRateInput.setValue(value);
        return this;
    }

    public CalculatorDepositsPage checkFinalSum(String value) {
        Double amount = Double.valueOf(value);
        NumberFormat numberFormatter =NumberFormat.getNumberInstance(Locale.CANADA_FRENCH);//currency format ### ###,##
        String amountOut = numberFormatter.format(amount);
        depositSumAtPeriodEndOutput.shouldHave(text(amountOut));
        return this;
    }
}
