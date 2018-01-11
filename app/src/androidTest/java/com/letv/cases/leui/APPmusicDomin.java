package com.letv.cases.leui;

import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.IntentConstants;
import com.letv.common.LetvTestCase;

import org.junit.Test;


public class APPmusicDomin extends LetvTestCase {
    int count=0;

    @Test
    @CaseName("媒体中心里进入播放各列表音频")
    public void testSearchPlayMusic() throws UiObjectNotFoundException, RemoteException {
        addStep("打开媒体中心");
        launchApp(AppName.Music, IntentConstants.Music);
        sleepInt(8);
            try {
                SearchPlayMusic();
            }catch (Exception e){
                try {
                    failCount(count++, getIntParams("Loop"), e.getMessage());
                    addStep("打开媒体中心");
                    launchApp(AppName.Music,IntentConstants.Music);
                    sleepInt(10);
                    SearchPlayMusic();
                }catch (RuntimeException re){
                    screenShot();
                    junit.framework.Assert.fail(re.getMessage());
                }
            }

        press_back(4);
    }

    public void SearchPlayMusic() throws UiObjectNotFoundException, RemoteException {
        addStep("打开播放列表任意选择5首每首播放10秒");
        for(int i=0;i<5;i++) {
            press_menu(1);
            press_down(1);
            UiObject2 playlist = waitForObj(By.text("播放列表"));
            check(playlist != null);
            press_center(1);
            sleepInt(10);
        }
        press_menu(1);
        press_up(6);
        press_center(1);
        sleepInt(10);
    }

}
