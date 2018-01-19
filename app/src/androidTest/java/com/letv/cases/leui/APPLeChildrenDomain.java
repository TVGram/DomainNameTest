package com.letv.cases.leui;

import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.IntentConstants;
import com.letv.common.LetvTestCase;

import junit.framework.Assert;

import org.junit.Test;

import java.util.regex.Pattern;


public class APPLeChildrenDomain extends LetvTestCase {
    int count=0;

    @Test
    @CaseName("进入儿童TV反复进入与切换画面")
    public void testChileSwichover() throws UiObjectNotFoundException, RemoteException {
            try{
                ChileSwichover();
            }
            catch (Exception e){
                try{
                    count++;
                    failCount(count,getIntParams("Loop"),e.getMessage());
                    ChileSwichover();
                }
                catch (RuntimeException re){
                    screenShot();
                    Assert.fail(re.getMessage());
                }
            }
        press_back(5);
    }
    public void ChileSwichover() throws UiObjectNotFoundException, RemoteException {
        addStep("进入儿童TV");
        LanuchChildrenTV();
        launchApp(AppName.Weather, IntentConstants.WeatherCIBN);
        UiObject2 skip=waitForObj(By.res("com.letv.tv.lechild:id/register_sex_btn_skip"));
        if(skip!=null){
            skip.click();
            skip.click();
        }
        addStep("儿童TV反复切换画面");
        press_right(getRandom(20));
        press_left(getRandom(20));
        sleepInt(2);
    }
    public void LanuchChildrenTV()throws UiObjectNotFoundException, RemoteException{
        addStep("进入应用儿童TV");
        gotoHomeScreen("应用");
        retry();
        press_down(5);
        UiObject2 ChildrenTV=waitForObj(By.res("com.stv.plugin.app:id/cellview_label").text("儿童TV"));
        check("未进入儿童TV",ChildrenTV!=null);
        clickAndWaitForNewWindow(ChildrenTV);
        sleepInt(2);
    }

}
