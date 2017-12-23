package cn.edu.gdmec.android.emulateaction;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
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
import android.util.Log;
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
    private UiObject result;

    @Test
    public void t1DisableDeviceManager() throws UiObjectNotFoundException, InterruptedException, RemoteException {
        // 初始化 UiDevice 实例
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        //最近运行程序
        mDevice.pressRecentApps();
        mDevice.swipe(200, 150, 200, 800, 40);
        sleep(50);
        mDevice.swipe(200, 150, 200, 800, 10);
        sleep(50);
        mDevice.swipe(200, 150, 200, 800, 20);
        sleep(50);
        mDevice.swipe(200, 150, 200, 800, 30);
        sleep(50);
        mDevice.swipe(200, 150, 200, 800, 50);
        sleep(50);
        result = mDevice.findObject(new UiSelector().textContains("全部清除"));
        result.clickAndWaitForNewWindow();
        // 按home键，返回到主界面
        mDevice.pressHome();
        result = mDevice.findObject(new UiSelector().textContains("设置"));
        result.clickAndWaitForNewWindow();
        sleep(500);
        mDevice.swipe(200, 700, 200, 100, 100);
        sleep(100);
        mDevice.swipe(200, 700, 200, 100, 100);
        sleep(100);
        mDevice.findObject(new UiSelector().textStartsWith("安全")).clickAndWaitForNewWindow();
        mDevice.swipe(200, 600, 200, 200, 50);
        sleep(100);
        mDevice.findObject(new UiSelector().textStartsWith("设备管理器")).clickAndWaitForNewWindow();
        UiScrollable list = new UiScrollable( new UiSelector().className("android.widget.ListView"));
        int count = list.getChildCount();
        for(int i=0;i<count;i++){
            UiObject apps = null;
            try {
                //这个listview会动态调整顺序，每次更改后把选中的排在前面，并且index好像是双倍的。
                //取消Sample Device Admin是会多弹出一个对话框，很坑。
                apps = list.getChildByInstance(new UiSelector().className("android.widget.LinearLayout"), 0);
//                try{
//                    result = apps.getChild(new UiSelector().textStartsWith("Dummy"));
//                    if(result.exists()){
//                        continue;
//                    }
//                    result = apps.getChild(new UiSelector().textStartsWith("Sample"));
//                    if(result.exists()){
//                        continue;
//                    }
//                }catch (UiObjectNotFoundException e){}

                apps.clickAndWaitForNewWindow();
                mDevice.swipe(200, 700, 200, 100, 100);
                sleep(100);
                try{
                    result = mDevice.findObject(new UiSelector().textStartsWith("取消激活"));
                    if(result==null||!result.exists()){
                        result = mDevice.findObject(new UiSelector().textStartsWith("取消"));
                        result.clickAndWaitForNewWindow();
                    }else{
                        result.clickAndWaitForNewWindow();
                        //取消Sample Device Admin是会多弹出一个对话框，很坑。
                        result = mDevice.findObject(new UiSelector().textStartsWith("确定"));
                        if(result.exists()){
                            result.clickAndWaitForNewWindow();
                        }else{
                            continue;
                        }
                    }
                }catch (UiObjectNotFoundException e){}
            } catch(UiObjectNotFoundException e) {}
        }
    }
    //@Test
    public void t2DeleteSms() throws UiObjectNotFoundException, InterruptedException {
        // 初始化 UiDevice 实例
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        // 按home键，返回到主界面
        mDevice.pressHome();
        mDevice.click(120,780);
        sleep(200);
        mDevice.swipe(200,200,200,200,200);
        mDevice.click(195,65);
        result = mDevice.findObject(new UiSelector().textStartsWith("删除"));
        result.clickAndWaitForNewWindow();
    }
}
