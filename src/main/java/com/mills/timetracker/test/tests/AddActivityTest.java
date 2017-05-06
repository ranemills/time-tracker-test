package com.mills.timetracker.test.tests;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class AddActivityTest
    extends AbstractTestBase {

    @Test
    public void newActivityIsAddedToTable()
        throws Exception
    {
        assertThat(_timeTrackerPage.getSavedActivities(), hasSize(0));

        _timeTrackerPage.startRecording();
        Thread.sleep(1000);
        _timeTrackerPage.stopRecording();
        _timeTrackerPage.saveRecordedActivity();

        assertThat(_timeTrackerPage.getSavedActivities(), hasSize(1));
    }

    @Test
    public void newActivityUsesSelectedActivityType()
        throws Exception
    {
        String activityType = "activityType";

        _timeTrackerPage.addActivityType(activityType);

        _timeTrackerPage.startRecording();
        Thread.sleep(1000);
        _timeTrackerPage.stopRecording();
        _timeTrackerPage.saveRecordedActivity();

        assertThat(_timeTrackerPage.getSavedActivities().get(0).getActivityType(), is(activityType));
    }

}
