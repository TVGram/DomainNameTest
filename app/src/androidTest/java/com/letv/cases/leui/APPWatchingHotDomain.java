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

import java.util.regex.Pattern;

public class APPWatchingHotDomain extends LetvTestCase {


    int count =0;
    @Test
    @CaseName("霸屏榜进入")
    public void testWatchingHotEnter() throws UiObjectNotFoundException, RemoteException {
        addStep("打应用");
        try {
           launchApp(AppName.WatchingHot, IntentConstants.WatchingHot);
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                launchApp(AppName.WatchingHot, IntentConstants.WatchingHot);
            } catch (RuntimeException re) {
                screenShot();
                org.junit.Assert.fail(re.getMessage());
            }
        }

    }

    @Test
    @CaseName("霸屏榜霸屏海报浏览")
    public void testWatchingHotPoster() throws UiObjectNotFoundException, RemoteException {
        addStep("打应用");
        launchApp(AppName.WatchingHot, IntentConstants.WatchingHot);
//        WatchingHot();
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
        press_left(1);
        for (int i =0;i<3;i++) {
            press_right(8);
            press_down(1);
        }
    }

    @Test
    @CaseName("霸屏榜排行分类")
    public void testWatchingHotClassification() throws UiObjectNotFoundException, RemoteException {
        addStep("打应用");
        launchApp(AppName.WatchingHot, IntentConstants.WatchingHot);
//        WatchingHot();
        try {
            WatchingHotClassification();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                WatchingHot();
                WatchingHotClassification();
            } catch (RuntimeException re) {
                screenShot();
                org.junit.Assert.fail(re.getMessage());
            }
        }

    }
    public void WatchingHotClassification() throws UiObjectNotFoundException, RemoteException {
        addStep("霸屏榜排行分类");
        press_left(1);
        UiObject2 list = waitForObj(By.clazz("android.widget.TextView").text("分类排行"));
        list.click();
        list.click();
        press_center(1);
    }

    @Test
    @CaseName("霸屏榜霸屏电影")
    public void testWatchingHotMovie() throws UiObjectNotFoundException, RemoteException {
        addStep("打应用");
        launchApp(AppName.WatchingHot, IntentConstants.WatchingHot);
//        WatchingHot();
        try {
            WatchingHotMovie();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                WatchingHot();
                WatchingHotMovie();
            } catch (RuntimeException re) {
                screenShot();
                org.junit.Assert.fail(re.getMessage());
            }
        }

    }
    public void WatchingHotMovie() throws UiObjectNotFoundException, RemoteException {
        press_left(1);
        UiObject2 list = waitForObj(By.clazz("android.widget.TextView").text("分类排行"));
        list.click();
        list.click();
        press_center(1);
        int GameDesk = phone.findObject(By.text(Pattern.compile("霸屏电影"))).getParent().getChildCount()+3;
        check("未进入霸屏电影",GameDesk != 0);
        press_right(GameDesk);
        press_center(1);
        addStep("播放任意视频");
        UiObject2 playVideo1 = waitForObj(By.text(Pattern.compile(".*播放|播放|第.*集")));
        if(playVideo1!=null){
            check("can't find playvideo", playVideo1 != null);
            playVideo1.click();
        }else {
            UiObject2 videoBrowse= waitForObj(By.clazz("android.view.View"));
            check("can't find small window of vidoe", videoBrowse != null);
            videoBrowse.click();
            videoBrowse.click();
            sleep(1);
        }
        sleepInt(30);
        exitApp();
    }

    @Test
    @CaseName("霸屏榜霸屏电视剧")
    public void testWatchingHotTVseries() throws UiObjectNotFoundException, RemoteException {
        addStep("打应用");
        launchApp(AppName.WatchingHot, IntentConstants.WatchingHot);
//        WatchingHot();
        try {
            WatchingHotTVseries();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                WatchingHot();
                WatchingHotTVseries();
            } catch (RuntimeException re) {
                screenShot();
                org.junit.Assert.fail(re.getMessage());
            }
        }

    }
    public void WatchingHotTVseries() throws UiObjectNotFoundException, RemoteException {
        press_left(1);
        UiObject2 list = waitForObj(By.clazz("android.widget.TextView").text("分类排行"));
        list.click();
        list.click();
        press_center(1);
        press_down(1);
        int GameDesk = phone.findObject(By.text(Pattern.compile("霸屏电视剧"))).getParent().getChildCount()+3;
        check("未进入霸屏电影",GameDesk != 0);
        press_right(GameDesk);
        press_center(1);
        addStep("播放任意视频");
        UiObject2 playVideo1 = waitForObj(By.text(Pattern.compile(".*播放|播放|第.*集")));
        if(playVideo1!=null){
            check("can't find playvideo", playVideo1 != null);
            playVideo1.click();
        }else {
            UiObject2 videoBrowse= waitForObj(By.clazz("android.view.View"));
            check("can't find small window of vidoe", videoBrowse != null);
            videoBrowse.click();
            videoBrowse.click();
            sleep(1);
        }
        sleepInt(60);
        exitApp();
        press_back(3);
    }


    @Test
    @CaseName("霸屏榜霸屏节目")
    public void testWatchingHotShow() throws UiObjectNotFoundException, RemoteException {
        addStep("打应用");
        launchApp(AppName.WatchingHot, IntentConstants.WatchingHot);
//        WatchingHot();
        try {
            WatchingHotShow();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                WatchingHot();
                WatchingHotShow();
            } catch (RuntimeException re) {
                screenShot();
                org.junit.Assert.fail(re.getMessage());
            }
        }

    }
    public void WatchingHotShow() throws UiObjectNotFoundException, RemoteException {
        addStep("霸屏节目播放");
        press_right(2);
        press_center(1);
        addStep("播放任意视频");
        UiObject2 playVideo1 = waitForObj(By.text(Pattern.compile(".*播放|播放|第.*集")));
        if(playVideo1!=null){
            check("can't find playvideo", playVideo1 != null);
            playVideo1.click();
        }else {
            UiObject2 videoBrowse= waitForObj(By.clazz("android.view.View"));
            check("can't find small window of vidoe", videoBrowse != null);
            videoBrowse.click();
            videoBrowse.click();
            sleep(1);
        }
        sleepInt(60);
        exitApp();
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
