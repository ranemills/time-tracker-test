package com.mills.timetracker.test.tests;

import com.mills.timetracker.test.DriverProvider;
import com.mills.timetracker.test.lib.TimeTrackerPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

abstract class AbstractTestBase {

    protected TimeTrackerPage _timeTrackerPage;

    @BeforeAll
    static void setupDriver()
    {
        DriverProvider.getDriverProvider().setUp();
    }

    @AfterAll
    static void tearDownDriver()
    {
        DriverProvider.getDriverProvider().tearDown();
    }

    @BeforeEach
    public void goToPage() {
        _timeTrackerPage = TimeTrackerPage.goToPage();
    }

    @AfterEach
    public void clearData() {
        _timeTrackerPage.clearData();
    }
}
