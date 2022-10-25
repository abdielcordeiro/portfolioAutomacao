package br.com.abdiel.mobile.core.managers;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerManager {

    private static AppiumDriverLocalService appiumService;
    private static final AppiumServiceBuilder appiumBuilder = new AppiumServiceBuilder();

    public AppiumServerManager() {}

    public AppiumDriverLocalService setService(){
        appiumBuilder.withIPAddress("127.0.0.1");
        appiumBuilder.usingAnyFreePort();

        appiumService = AppiumDriverLocalService.buildService(appiumBuilder);
        appiumService.start();

        return appiumService;
    }

    public void stopService(){ appiumService.stop();}
}
