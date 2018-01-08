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

import java.util.regex.Pattern;

public class SystemMusicDomain extends LetvTestCase {
    int count=0;

    @Test
    @CaseName("进入应用打开音乐")
    public void testPlayMusicEnter() throws UiObjectNotFoundException, RemoteException {
            try {
                PlayMusicEnter();
            }catch (Exception e){
                try {
                    count ++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    PlayMusicEnter();
                }catch (RuntimeException re){
                    screenShot();
                    junit.framework.Assert.fail(re.getMessage());
                }
            }
    }
    public void PlayMusicEnter() throws UiObjectNotFoundException, RemoteException {
        gotoHomeScreen("应用");
        addStep("打开音乐");
        launchApp(AppName.Filemanager, IntentConstants.Filemanager);
        press_right(2);
        UiObject2 music=waitForObj(By.res("com.stv.filemanager:id/class_text").text("音乐"));
        music.click();
        music.click();
        sleepInt(5);
    }

    @Test
    @CaseName("音乐播放列表")
    public void testPlayMusicList() throws UiObjectNotFoundException, RemoteException {
        PlayMusicEnter();
        try {
            PlayMusicList();
        }catch (Exception e){
            try {
                count ++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("打开音乐");
                PlayMusicEnter();
                PlayMusicList();
            }catch (RuntimeException re){
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
    }
    public void PlayMusicList() throws UiObjectNotFoundException, RemoteException {
        addStep("打开音乐播放列表");
        press_down(1);
        press_center(1);
        sleepInt(2);
        press_down(1);
        sleepInt(6);
        press_left(1);
        UiObject2 musiclist =waitForObj(By.res("com.stv.music:id/play_list").text("播放列表"));
        check("未进入音乐播放列表",musiclist!=null);
        musiclist.click();
        sleepInt(10);
        press_back(4);
    }

    @Test
    @CaseName("音乐播放关屏听歌")
    public void testPlayMusicCloseScreen() throws UiObjectNotFoundException, RemoteException {
        PlayMusicEnter();
        try {
            PlayMusicCloseScreen();
        }catch (Exception e){
            try {
                count ++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("打开媒体中心");
                PlayMusicEnter();
                PlayMusicCloseScreen();
            }catch (RuntimeException re){
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
    }
    public void PlayMusicCloseScreen() throws UiObjectNotFoundException, RemoteException {
        addStep("打开音乐关屏听歌");
        press_down(1);
        press_center(1);
        sleepInt(2);
        press_down(1);
        sleepInt(6);
        UiObject2 close_screen =waitForObj(By.res("com.stv.music:id/close_screen_ib").text("关屏听歌"));
        check("未进入关屏听歌",close_screen!=null);
        close_screen.click();
        sleepInt(6);
        press_center(1);
        sleepInt(5);
        press_back(4);
    }

    @Test
    @CaseName("音乐播放循环")
    public void testPlayMusicCycle() throws UiObjectNotFoundException, RemoteException {
        PlayMusicEnter();
        try {
            PlayMusicCycle();
        }catch (Exception e){
            try {
                count ++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("打开音乐");
                PlayMusicEnter();
                PlayMusicCycle();
            }catch (RuntimeException re){
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
    }
    public void PlayMusicCycle() throws UiObjectNotFoundException, RemoteException {
        addStep("打开音乐循环播放");
        press_down(1);
        press_center(1);
        sleepInt(2);
        press_down(1);
        sleepInt(6);
        press_left(2);
        UiObject2 repeat_ib =waitForObj(By.res("com.stv.music:id/repeat_ib").text(Pattern.compile(".*循环")));
        check("未进入全部循环",repeat_ib!=null);
        repeat_ib.click();
        press_center(1);
        sleepInt(5);
        press_back(4);
    }

    @Test
    @CaseName("音乐播放发现")
    public void testPlayMusicFound() throws UiObjectNotFoundException, RemoteException {
        PlayMusicEnter();
        try {
            PlayMusicFound();
        }catch (Exception e){
            try {
                count ++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("打开音乐");
                PlayMusicEnter();
                PlayMusicFound();
            }catch (RuntimeException re){
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
    }
    public void PlayMusicFound() throws UiObjectNotFoundException, RemoteException {
        addStep("打开音乐发现");
        press_down(1);
        press_center(1);
        sleepInt(2);
        press_up(1);
        sleepInt(6);
        press_center(2);
        sleepInt(5);
        exitApp();
        press_back(4);
    }

}
