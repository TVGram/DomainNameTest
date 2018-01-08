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

import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;




public class SystemThemesDomian extends LetvTestCase{
    int count=0;

    @Test
    @CaseName("主题商店进入")
    public void testThemesEnter()throws UiObjectNotFoundException, RemoteException{
        addStep("切换到应用桌面");
        gotoHomeScreen("应用");
        deskNO();
        try {
            ThemesEnter();
        } catch (Exception e) {
            try {
                failCount(count++, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("应用");
                deskNO();
                ThemesEnter();
            } catch (RuntimeException re) {
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
    }
    public void ThemesEnter()throws UiObjectNotFoundException, RemoteException{
        press_down(1);
        press_back(2);
        press_down(5);
        UiObject2 themes = phone.findObject(By.res("com.stv.plugin.app:id/cellview_label").text("主题"));
        check("未进入主题",themes != null);
        themes.click();
        sleepInt(2);
        press_right(2);
        press_back(3);
    }

    @Test
    @CaseName("主题商店全部")
    public void testThemesAll()throws UiObjectNotFoundException, RemoteException{
        addStep("切换到应用桌面");
        gotoHomeScreen("应用");
        deskNO();
            try {
                ThemesAll();
            } catch (Exception e) {
                try {
                    failCount(count++, getIntParams("Loop"), e.getMessage());
                    gotoHomeScreen("应用");
                    deskNO();
                    ThemesAll();
                } catch (RuntimeException re) {
                    screenShot();
                    junit.framework.Assert.fail(re.getMessage());
                }
            }

    }
    public void ThemesAll()throws UiObjectNotFoundException, RemoteException{
        press_down(1);
        press_back(2);
        press_down(5);
        UiObject2 themes = phone.findObject(By.res("com.stv.plugin.app:id/cellview_label").text("主题"));
        check("未进入主题",themes != null);
        themes.click();
        sleepInt(2);
        press_right(2);

        addStep("进入全部主题");
        UiObject2 allThemes = waitForObj(By.res("com.stv.thememanager:id/fl_theme_all"));
        verify("没有找到全部",allThemes!= null);
        sleepInt(1);
        allThemes.click();
        sleepInt(5);
        press_back(3);
    }

    @Test
    @CaseName("主题商店排行榜")
    public void testThemesList()throws UiObjectNotFoundException, RemoteException{
        addStep("切换到应用桌面");
        gotoHomeScreen("应用");
        deskNO();
        try {
            ThemesList();
        } catch (Exception e) {
            try {
                failCount(count++, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("应用");
                deskNO();
                ThemesList();
            } catch (RuntimeException re) {
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
    }
    public void ThemesList()throws UiObjectNotFoundException, RemoteException{
        press_down(1);
        press_back(2);
        press_down(5);
        UiObject2 themes = phone.findObject(By.res("com.stv.plugin.app:id/cellview_label").text("主题"));
        check("未进入主题",themes != null);
        themes.click();
        sleepInt(2);
        press_right(2);

        addStep("进入主题排行榜");
        UiObject2 fl_theme_rank = waitForObj(By.res("com.stv.thememanager:id/fl_theme_rank"));
        verify("没有找到主题排行榜",fl_theme_rank!= null);
        sleepInt(1);
        fl_theme_rank.click();
        sleepInt(3);
        press_back(3);
    }

    @Test
    @CaseName("测试主题商店我的")
    public void testThemesMy()throws UiObjectNotFoundException, RemoteException{
        addStep("切换到应用桌面");
        gotoHomeScreen("应用");
        deskNO();
        try {
            ThemesMy();
        } catch (Exception e) {
            try {
                failCount(count++, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("应用");
                deskNO();
                ThemesMy();
            } catch (RuntimeException re) {
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
    }
    public void ThemesMy()throws UiObjectNotFoundException, RemoteException{
        press_down(1);
        press_back(2);
        press_down(5);
        UiObject2 themes = phone.findObject(By.res("com.stv.plugin.app:id/cellview_label").text("主题"));
        check("未进入主题",themes != null);
        themes.click();
        sleepInt(2);
        press_right(2);

        addStep("进入主题我的");
        UiObject2 myThemes = waitForObj(By.res("com.stv.thememanager:id/fl_theme_self"));
        verify("没有找到我的",myThemes!= null);
        sleepInt(1);
        myThemes.click();
        sleepInt(2);
        press_back(4);
    }

    @Test
    @CaseName("测试主题首页推荐")
    public void testThemesPoster()throws UiObjectNotFoundException, RemoteException{
        addStep("切换到应用桌面");
        gotoHomeScreen("应用");
        deskNO();
        try {
            ThemesPoster();
        } catch (Exception e) {
            try {
                failCount(count++, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("应用");
                deskNO();
                ThemesPoster();
            } catch (RuntimeException re) {
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
    }
    public void ThemesPoster()throws UiObjectNotFoundException, RemoteException{
        press_down(1);
        press_back(2);
        press_down(5);
        UiObject2 themes = phone.findObject(By.res("com.stv.plugin.app:id/cellview_label").text("主题"));
        check("未进入主题",themes != null);
        themes.click();
        sleepInt(2);
        press_right(1);
        addStep("进入主题首页推荐");
        UiObject2 poster = waitForObj(By.res("com.stv.thememanager:id/pv_poster"));
        verify("没有找到主题首页推荐",poster!= null);
        sleepInt(1);
        poster.click();
        sleepInt(4);
        press_back(3);
    }

    public void deskNO() {
        UiObject2 deskno = phone.findObject(By.text("重试"));
        for (int i = 0; i < 3; i++) {
            if (deskno != null) {
                deskno.click();
                sleepInt(5);
            }
        }
    }
}
