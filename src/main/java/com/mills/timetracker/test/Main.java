package com.mills.timetracker.test;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class Main {

    public static void main(String[] args) {
        LauncherDiscoveryRequest request =
            LauncherDiscoveryRequestBuilder.request()
                                           .selectors(
                                               selectPackage("com.mills.timetracker.test.tests")
                                           )
                                           .filters(includeClassNamePatterns(".*Test"))
                                           .build();

        Launcher launcher = LauncherFactory.create();

        // Register a listener of your choice
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        DriverProvider.getDriverProvider().setUp();

        launcher.execute(request, new TestExecutionListener[0]);

        DriverProvider.getDriverProvider().tearDown();

        listener.getSummary().printFailuresTo(new PrintWriter(System.out));
        listener.getSummary().printTo(new PrintWriter(System.out));
    }
}
