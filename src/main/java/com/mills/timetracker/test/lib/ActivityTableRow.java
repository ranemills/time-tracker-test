package com.mills.timetracker.test.lib;

import org.openqa.selenium.By;

import static com.mills.timetracker.test.DriverProvider.getWebDriver;

/**
 * Created by ryan on 06/05/17.
 */
public class ActivityTableRow {

    private String activityType;
    private String startTime;
    private String endTime;
    private String duration;
    private String notes;

    public ActivityTableRow(TimeTrackerPage page, int rowIndex)
    {
        activityType = getWebDriver().findElement(By.id("saved-activity-" + rowIndex + "-activity-type")).getText();
        startTime = getWebDriver().findElement(By.id("saved-activity-"+rowIndex+"-start-time")).getText();
        endTime = getWebDriver().findElement(By.id("saved-activity-"+rowIndex+"-end-time")).getText();
        duration = getWebDriver().findElement(By.id("saved-activity-"+rowIndex+"-duration")).getText();
        notes = getWebDriver().findElement(By.id("saved-activity-"+rowIndex+"-notes")).getText();
    }

    public String getActivityType() {
        return activityType;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDuration() {
        return duration;
    }

    public String getNotes() {
        return notes;
    }
}
