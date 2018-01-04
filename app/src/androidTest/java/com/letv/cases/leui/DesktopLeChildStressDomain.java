package com.letv.cases.leui;

import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.IntentConstants;
import com.letv.common.LetvTestCase;
import com.letv.common.PkgName;

import junit.framework.Assert;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by pc7 on 7/28/17.
 */

public class DesktopLeChildStressDomain extends LetvTestCase {
    int count = 0;

    @Test
    @CaseName("进入儿童桌面")
    public void testChildDesktop() throws UiObjectNotFoundException, RemoteException {
            addStep("切换到儿童桌面");
            gotoHomeScreen("儿童");
            press_down(1);
            press_back(3);
            try{
                ChildDesktop();
            }
            catch (Exception e){
                try{
                    count++;
                    failCount(count,getIntParams("Loop"),e.getMessage());
                    ChildDesktop();
                }
                catch (RuntimeException re){
                    screenShot();
                    Assert.fail(re.getMessage());
                }
            }
            press_back(4);
    }
    public void ChildDesktop() throws UiObjectNotFoundException, RemoteException {

        addStep("进入儿童桌面播放记录");
        press_down(3);
        UiObject2 item_history = waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.kids:id/item_history"));
        check("未进入儿童桌面播放记录",item_history!=null);
        item_history.click();
        item_history.click();
        desktop();

        addStep("进入儿童桌面搜索");
        press_down(3);
        UiObject2 entrance_5 = waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.kids:id/entrance_5"));
        check("未进入儿童桌面搜索",entrance_5!=null);
        entrance_5.click();
        entrance_5.click();
        desktop();

//        addStep("进入儿童桌面分类");
//        press_down(3);
//        UiObject2 entrance_4 = waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.kids:id/entrance_4"));
//        check("未进入儿童桌面分类",entrance_4!=null);
//        entrance_4.click();
//        entrance_4.click();
//        gotoHomeScreen("儿童");
//        desktop();

        addStep("进入儿童桌面儿童TV");
        press_down(3);
        UiObject2 entrance_3 = waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.kids:id/entrance_3"));
        check("未进入儿童桌面儿童TV",entrance_3!=null);
        entrance_3.click();
        entrance_3.click();
        desktop();


        addStep("进入儿童桌面时间控制");
        press_down(3);
        UiObject2 entrance_2 = waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.kids:id/entrance_2"));
        check("未进入儿童桌面时间控制",entrance_2!=null);
        entrance_2.click();
        entrance_2.click();
        desktop();
        press_back(4);

        press_down(4);
        for (int i =0;i<5;i++){
            sleepInt(2);
            press_down(1);
            press_right(3);
            press_left(3);
            UiObject2 desktop1=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("儿童")).selected(true));
            UiObject2 desktop2=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("儿童")).focused(true));
            verify("没有返回到视频桌面", desktop1 != null || desktop2 != null);
        }
    }
    public void desktop()throws UiObjectNotFoundException, RemoteException{
        sleepInt(3);
        press_back(4);
        UiObject2 desktop1=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("儿童")).selected(true));
        UiObject2 desktop2=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("儿童")).focused(true));
        verify("没有返回到视频桌面", desktop1 != null || desktop2 != null);
    }
}


