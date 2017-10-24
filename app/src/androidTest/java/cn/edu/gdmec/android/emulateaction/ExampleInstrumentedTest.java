package cn.edu.gdmec.android.emulateaction;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExampleInstrumentedTest {
    //设备实例
    private UiDevice mDevice;

    @Test
    public void t1DisableDeviceManager() throws UiObjectNotFoundException, InterruptedException {
        // 初始化 UiDevice 实例
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        // 按home键，返回到主界面
        mDevice.pressHome();
        UiObject result = mDevice.findObject(new UiSelector().textContains("设置"));
        result.clickAndWaitForNewWindow();
        mDevice.swipe(200, 800, 200, 400, 50);
        sleep(500);
        mDevice.swipe(200, 800, 200, 400, 50);
        sleep(500);
        mDevice.swipe(200, 800, 200, 400, 50);
        sleep(500);
        mDevice.swipe(200, 800, 200, 400, 50);
        sleep(500);
        mDevice.findObject(new UiSelector().textStartsWith("安全")).clickAndWaitForNewWindow();
        mDevice.findObject(new UiSelector().textStartsWith("设备管理器")).clickAndWaitForNewWindow();
        mDevice.findObject(new UiSelector().textStartsWith("MobileGuard")).clickAndWaitForNewWindow();
        mDevice.findObject(new UiSelector().textStartsWith("取消激活")).clickAndWaitForNewWindow();
    }

}
