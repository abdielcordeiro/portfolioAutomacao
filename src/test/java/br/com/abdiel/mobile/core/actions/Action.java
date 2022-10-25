package br.com.abdiel.mobile.core.actions;

import io.appium.java_client.MobileElement;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Action {

    public static boolean isVisibleElement(MobileElement element, int timeWaitInSeconds){

        try{
            return Awaitility.await()
                    .timeout(Duration.ofSeconds(timeWaitInSeconds))
                    .ignoreException(NoSuchElementException.class)
                    .until(element:: isDisplayed, displayed -> displayed);
        }catch (ConditionTimeoutException ignoree){
            return false;
        }
    }

}
