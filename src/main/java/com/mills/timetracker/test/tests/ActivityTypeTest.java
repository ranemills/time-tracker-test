package com.mills.timetracker.test.tests;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class ActivityTypeTest
    extends AbstractTestBase {

    @Test
    public void canAddNewActivityType() {
        String newActivityType = "testActivity";

        _timeTrackerPage.addActivityType(newActivityType);

        assertThat(_timeTrackerPage.getActivityTypes(), hasItem(newActivityType));
    }

    @Test
    public void hasDefaultActivityType()
    {
        assertThat(_timeTrackerPage.getActivityTypes(), hasItem("Default"));
    }
}
