package br.com.abdiel.mobile.stepDefinitions;


import br.com.abdiel.mobile.core.cucumberTest.TestContext;
import br.com.abdiel.mobile.core.managers.Enum.DeviceType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;

public class Hooks {

    private AppiumDriver<MobileElement> driver;
    private TestContext testContext;

    public Hooks(TestContext context) {
        this.testContext = context;
    }

    @Before
    public void startTest() {
        driver = testContext.getDriverManager().createDriver(DeviceType.EMULADOR_ANDROID);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After(order = 0)
    public void stopTest() {
        testContext.getDriverManager().closeDriver();
    }

}
