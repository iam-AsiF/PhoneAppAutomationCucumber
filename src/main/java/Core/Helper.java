package Core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Helper {

    DesiredCapabilities dc = new DesiredCapabilities();
    static AndroidDriver driver;

    public AndroidDriver apkLaunch() throws MalformedURLException, InterruptedException {
        dc.setCapability(MobileCapabilityType.UDID, "3300a9bf997622c3"); //cmd - adb devices
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "adb:SM-J700H");
        dc.setCapability("platformVersion", "11.0");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        // mFocus -- to get specific page activity -- cmd > adb shell > dumpsys window | grep -E "mCurrentFocus|mFocusedApp"
        Thread.sleep(6000);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), dc);
        return driver;
    }

}
