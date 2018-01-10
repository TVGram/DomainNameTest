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

public class DesktopFindvideoDomain extends LetvTestCase {

    int count =0;
    @Test
    @CaseName("找视频桌面海报浏览")
    public void testFindvideoPoster() throws UiObjectNotFoundException, RemoteException {
        addStep("打开找视频桌面");
        gotoHomeScreen("找视频");
        try {
            FindvideoPoster();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("打开找视频桌面");
                gotoHomeScreen("找视频");
                FindvideoPoster();
            } catch (RuntimeException re) {
                screenShot();
                org.junit.Assert.fail(re.getMessage());
            }
        }

    }
    public void FindvideoPoster() throws UiObjectNotFoundException, RemoteException {
        press_down(1);
        UiObject2 poster_large=waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.newvideo:id/poster_large"));
        check("未进入海报",poster_large!=null);
        press_right(2);
        press_back(3);

        press_down(2);
        UiObject2 poster_1=waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.newvideo:id/poster_1"));
        check("未进入海报",poster_1!=null);
        press_right(2);
        press_back(3);

        press_down(3);
        UiObject2 item_1=waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.newvideo:id/item_1"));
        check("未进入海报",item_1!=null);
        press_right(3);
        press_back(3);
    }


    @Test
    @CaseName("找视频桌面海报播放")
    public void testFindvideoPlay() throws UiObjectNotFoundException, RemoteException {
        addStep("打开找视频桌面播放");
        gotoHomeScreen("找视频");
        try {
            FindvideoPlay();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("打开找视频桌面播放");
                gotoHomeScreen("找视频");
                FindvideoPlay();
            } catch (RuntimeException re) {
                screenShot();
                org.junit.Assert.fail(re.getMessage());
            }
        }
    }
    public void FindvideoPlay() throws UiObjectNotFoundException, RemoteException {
        press_down(1);
        UiObject2 poster_large=waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.newvideo:id/poster_large"));
        check("未进入海报",poster_large!=null);
        poster_large.click();
        poster_large.click();
        sleepInt(20);
        exitApp();
        press_back(3);
    }
}
