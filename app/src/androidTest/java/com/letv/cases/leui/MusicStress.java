package com.letv.cases.leui;

import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.IntentConstants;
import com.letv.common.LetvTestCase;

import org.junit.Test;

public class MusicStress extends LetvTestCase {
    int count=0;

    @Test
    @CaseName("媒体中心里播放音频")
    public void testPlayMusic() throws UiObjectNotFoundException, RemoteException {
        addStep("打开媒体中心");
        launchApp(AppName.Music,IntentConstants.Music);
        sleepInt(10);
        for (int Loop = 0; Loop < getIntParams("Loop"); Loop++) {
            System.out.println(".............looper : " + Loop);
            try {
                PlayMusic();
            }catch (Exception e){
                try {
                    count ++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    addStep("打开媒体中心");
                    launchApp(AppName.Music,IntentConstants.Music);
                    sleepInt(10);
                    PlayMusic();
                }catch (RuntimeException re){
                    screenShot();
                    junit.framework.Assert.fail(re.getMessage());
                }
            }
        }

    }
    public void PlayMusic() throws UiObjectNotFoundException, RemoteException {
        addStep("播放音频文件50s");
        press_center(1);
        sleepInt(10);
       addStep("暂停，继续播放音频文件循环5次");
        for (int i = 0;i<5;i++) {
            press_center(1);
            sleepInt(5);
            press_center(1);
            sleepInt(5);
//            phone.pressKeyCode(KEY_MEDIA_PLAY_PAUSE);
//            UiObject2 pause1 = waitForObj(By.res("com.tencent.qqmusictv.qing:id/play_full_screen_paly_btn"));
//            check("music isn't paused", pause1 != null);
//            pause1.click();
//            phone.pressKeyCode(KEY_MEDIA_PLAY_PAUSE);
//            sleepInt(5);
        }
        addStep("播放下一首音频文件5次");
        for (int i = 0;i<5;i++) {
            press_right(1);
            sleepInt(1);
        }
        addStep("播放上一首音频文件5次");
        for (int i = 0;i<5;i++) {
            press_left(1);
            sleepInt(1);
        }
    }
}
