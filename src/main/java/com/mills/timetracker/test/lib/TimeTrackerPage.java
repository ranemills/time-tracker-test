package com.mills.timetracker.test.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mills.timetracker.test.DriverProvider.getWebDriver;

public class TimeTrackerPage {

    private static final String URL = "http://localhost:63343/time-tracker/dist/index.html";

    private TimeTrackerPage()
    {

    }

    public static TimeTrackerPage goToPage()
    {
        getWebDriver().get(URL);
        return new TimeTrackerPage();
    }

    private static void clickButton(By btn)
    {
        getWebDriver().findElement(btn).click();
    }

    public List<String> getActivityTypes() {
        List<WebElement> activityTypeElements = getWebDriver().findElements(By.className("activity-type"));
        return activityTypeElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public TimeTrackerPage addActivityType(String activityType) {
        WebElement input = getWebDriver().findElement(By.id("add-activity-type-input"));
        input.sendKeys(activityType);
        clickButton(By.id("add-activity-type-button"));
        return this;
    }

    public void clearData() {
        clickButton(By.id("clear-data"));
    }

    public void startRecording() {
        clickButton(By.id("start-timing-btn"));
    }

    public void stopRecording() {
        clickButton(By.id("stop-timing-btn"));
    }

    public void saveRecordedActivity() {
        clickButton(By.id("save-activity-btn"));
    }

    public void discardRecordedActivity() {
        clickButton(By.id("discard-activity-btn"));
    }

    public List<ActivityTableRow> getSavedActivities()
    {
        int i = 0;
        List<ActivityTableRow> rows = new ArrayList<>();
        while (getWebDriver().findElements(By.id("saved-activity-" + i + "-row")).size() > 0) {
            rows.add(new ActivityTableRow(this, i));
            i++;
        }
        return rows;
    }

    public TestMode getTestMode() {
        return TestMode.startTestMode(this);
    }
}

class TestMode {

    private TimeTrackerPage _parent;

    private TestMode(TimeTrackerPage parent) {
        executeJavascript("enableTestMode()");
        _parent = parent;
    }

    public static TestMode startTestMode(TimeTrackerPage page)
    {
        return new TestMode(page);
    }

    public TimeTrackerPage endTestMode() {
        executeJavascript("disableTestMode()");
        return _parent;
    }

    private void executeJavascript(String script)
    {
        ((JavascriptExecutor) getWebDriver()).executeScript(script);
    }

}
