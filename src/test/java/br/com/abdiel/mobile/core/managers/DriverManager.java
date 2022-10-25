package br.com.abdiel.mobile.core.managers;

import br.com.abdiel.mobile.core.managers.Enum.DeviceType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class DriverManager {

    private AppiumDriver<MobileElement> driver;
    private final AppiumServerManager appiumServerManager;
    private final CapabilitiesManager capabilitiesManager;

    public DriverManager(){
        appiumServerManager = new AppiumServerManager();
        capabilitiesManager = new CapabilitiesManager();
    }

    public AppiumDriver<MobileElement> createDriver(DeviceType type) {
        return (driver == null) ? driver = device(type) : driver;
    }

    private AppiumDriver<MobileElement> device(DeviceType type){
        switch (type){
            case ANDROID:
            case EMULADOR_ANDROID:
                driver = new AndroidDriver<MobileElement>(appiumServerManager.setService(), capabilitiesManager.setCapabilities(type));
                break;
            default:
                System.out.println("Device não cadastrado para automação!!!");
        }
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.closeApp();
            appiumServerManager.stopService();
        }
    }

}