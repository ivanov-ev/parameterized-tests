package ru.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setup() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1000";
        Configuration.timeout = 5000; //5 sec; default is 4 sec
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
