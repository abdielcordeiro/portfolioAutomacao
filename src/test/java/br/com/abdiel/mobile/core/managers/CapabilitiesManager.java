package br.com.abdiel.mobile.core.managers;

import br.com.abdiel.mobile.core.managers.Enum.DeviceType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {

    public CapabilitiesManager(){}
    public DesiredCapabilities setCapabilities(DeviceType type) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("language", "pt");
        capabilities.setCapability("locale", "br");

        switch (type) {
            case EMULADOR_ANDROID:
                capabilities.setCapability("deviceName", "mobile2");
                capabilities.setCapability("udid", "emulator-5554");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appPackage", "com.Advantage.aShopping");
                capabilities.setCapability("appActivity", ".SplashActivity");
                break;
            case EMULADOR_IOS:
                break;
            default:
                return null;
        }

        return capabilities;
    }

}
