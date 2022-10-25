package br.com.abdiel.mobile.core.cucumberTest;

import br.com.abdiel.mobile.core.managers.DriverManager;

public class TestContext {

    private static DriverManager driverManager;

    public TestContext() {
        driverManager = new DriverManager();
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }
}