package com.letv.cases.leui;

import android.content.Intent;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.IntentConstants;
import com.letv.common.LetvTestCase;
import com.letv.common.PkgName;

import org.junit.After;
import org.junit.Test;

import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;




public class SystemPlayRecordDomain extends LetvTestCase{

    int count=0;

    BySelector storageDeviceS = By.clazz("android.widget.TextView").text("存储设备");
    BySelector intStorageDeviceS = By.clazz("android.widget.TextView").text("本机存储");
    BySelector menuBartext = By.clazz("android.widget.TextView").text("按菜单键更多操作");
    BySelector extStorageDeviceS = By.text("USB");

    @Test
    @CaseName("打开播放记录")
    public void testPlayRecordOpen() throws UiObjectNotFoundException, RemoteException {
        addStep("进入播放记录");
        launchApp(AppName.PlayHistory,IntentConstants.PlayHistory);
        sleepInt(3);
        press_back(3);
    }

    @Test
    @CaseName("播放记录中标签切换")
    public void testPlayRecordSwitch() throws UiObjectNotFoundException, RemoteException {
        addStep("进入播放记录");
        launchApp(AppName.PlayHistory,IntentConstants.PlayHistory);

        addStep("播放记录中标签切换");
        UiObject2 supertv=phone.findObject(By.text("超级影视"));
        check("未进入超级影视",supertv!=null);
        press_right(1);
        press_left(1);
        sleepInt(3);
        press_down(1);
        addStep("标签切换");
        UiObject2 local=phone.findObject(By.text("本地"));
        check("未进入本地",local!=null);
        press_right(1);
        press_left(1);
        sleepInt(3);
        press_up(1);
        press_back(3);
    }

    @Test
    @CaseName("播放记录中播放")
    public void testPlayRecordPlay()throws UiObjectNotFoundException, RemoteException {
        addStep("进入播放记录");
        launchApp(AppName.PlayHistory,IntentConstants.PlayHistory);{
            try {
                PlayRecordPlay();
            }catch (Exception e){
                try {
                    count ++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    addStep("进入播放记录");
                    launchApp(AppName.PlayHistory,IntentConstants.PlayHistory);
                    PlayRecordPlay();
                }catch (RuntimeException re){
                    screenShot();
                    junit.framework.Assert.fail(re.getMessage());
                }
            }
        }
    }
    public void PlayRecordPlay()throws UiObjectNotFoundException,RemoteException{
        addStep("播放记录播放");
        UiObject2 supertv=phone.findObject(By.text("超级影视"));
        check("未进入超级影视",supertv!=null);
        press_center(1);
        press_right(2);
        press_center(2);
        sleepInt(15);
        exitApp();
        press_back(3);
    }
}
