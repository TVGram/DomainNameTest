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

import org.junit.Test;

public class APPScreenLIstDomain extends LetvTestCase {


    int count =0;
    @Test
    @CaseName("霸屏榜进入")
    public void testWatchingHotEnter() throws UiObjectNotFoundException, RemoteException {
        addStep("打应用");
//        launchApp(AppName.WatchingHot, PkgName.WatchingHot);

        try {
            WatchingHot();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                WatchingHot();
            } catch (RuntimeException re) {
                screenShot();
                org.junit.Assert.fail(re.getMessage());
            }
        }

    }




    @Test
    @CaseName("霸屏榜海报浏览")
    public void testWatchingHotPoster() throws UiObjectNotFoundException, RemoteException {
        addStep("打应用");
//        launchApp(AppName.WatchingHot, PkgName.WatchingHot);
        WatchingHot();
        try {
            WatchingHotPoster();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                WatchingHot();
                WatchingHotPoster();
            } catch (RuntimeException re) {
                screenShot();
                org.junit.Assert.fail(re.getMessage());
            }
        }

    }
    public void WatchingHotPoster() throws UiObjectNotFoundException, RemoteException {
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












    public void WatchingHot()throws UiObjectNotFoundException, RemoteException{
        addStep("霸屏榜");
        gotoHomeScreen("应用");
        press_down(5);
        UiObject2 watchingHot=waitForObj(By.res("com.stv.plugin.app:id/cellview_label").text("霸屏榜"));
        watchingHot.click();
        watchingHot.click();
    }

}
