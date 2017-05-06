package com.mills.timetracker.test;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverProvider {

    private static DriverProvider _instance;
    private WebDriver _driver;

    public void setUp() {
        if(_driver == null) {
            _driver = new ChromeDriver();
        }
    }

    public void tearDown() {
        _driver.quit();
    }

    public static WebDriver getWebDriver()
    {
        return getDriverProvider()._driver;
    }

    public static DriverProvider getDriverProvider()
    {
        if(_instance == null) {
            _instance = new DriverProvider();
        }
        return _instance;
    }

}
