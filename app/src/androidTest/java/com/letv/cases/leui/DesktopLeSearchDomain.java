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

public class DesktopLeSearchDomain extends LetvTestCase{
    int count=0;
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    @CaseName("进入桌面管理调整桌面搜索")
    public void testDeskSwitchScarch() throws UiObjectNotFoundException, RemoteException {
        addStep("进入管理桌面");
        gotoHomeScreen("应用");
        UiObject2 deskManager = waitForObj(By.res("com.stv.launcher:id/manager_bt"));
        check("桌面管理没有找到", deskManager != null);
        deskManager.click();
        deskManager.click();
        sleepInt(1);
        try {
//              if (LetvUI(6.5)){
            DeskSwitchScarch();
//                }else {
//                DeskSwitch();
//                }
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("应用");
                UiObject2 deskManager1 = waitForObj(By.res("com.stv.launcher:id/manager_bt"));
                check("桌面管理没有找到", deskManager1 != null);
                deskManager1.click();
                deskManager1.click();
                sleepInt(1);
                DeskSwitchScarch();
            } catch (RuntimeException re) {
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
            press_back(2);
        }
    }
    public void DeskSwitchScarch() throws UiObjectNotFoundException, RemoteException {

        for(int i =0;i<4;i++) {
            sleepInt(2);
            UiObject2 launchLeVideo = waitForObj(By.res("com.stv.launcher:id/tv_title").text("应用")).getParent();
            if(launchLeVideo.isFocused()){
                press_center(1);
                press_right(3);
                press_center(1);
                press_left(1);
                press_center(1);
                press_right(3);
                press_down(1);
                press_center(1);
                break;
            }
            else {
                press_right(1);
            }
        }
        sleepInt(2);
        for(int j=0;j<3;j++) {
            sleepInt(2);
            UiObject2 launchLeVideo = waitForObj(By.res("com.stv.launcher:id/tv_title").text("搜索")).getParent();
            if(launchLeVideo.isFocused()){
                press_center(1);
                press_up(1);
                press_right(3);
                press_center(1);
                break;
            }
            else {
                press_left(1);
            }
        }

    }

    @Test
    @CaseName("搜索桌面进入桌面搜索")
    public void testSearchDesktop() throws UiObjectNotFoundException, RemoteException {
        gotoHomeScreen("搜索");
        try {
            SearchDesktop();
            }
        catch (Exception e) {
            try {
                count ++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("搜索");
                SearchDesktop();
            }catch (RuntimeException re){
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
        press_back(4);
    }
    public void SearchDesktop() throws UiObjectNotFoundException, RemoteException{
        addStep("打开搜索桌面点击搜索");
        sleepInt(2);
        press_down(1);
        addStep("进入乐看搜索");
        UiObject2 leSearch = waitForObj(By.res(Pattern.compile("com.stv.plugin.search:id/search_box|com.stv.plugin.search:id/search_box_notice")));
        check("没有找到搜索框", leSearch != null);
        leSearch.click();
        sleepInt(2);
        UiObject2 leSo = phone.findObject(By.pkg(Pattern.compile("com.letv.leso|com.letv.search.plugin|")));
        check("未进入乐看搜索", leSo != null);
        sleepInt(5);
        UiObject2 update = phone.findObject(By.text("马上体验"));
        if (update != null) {
            update.click();
            sleep(70);
            press_up(1);
            press_center(1);
        }
        press_back(3);
    }


    @Test
    @CaseName("搜索桌面进入海报浏览")
    public void testSearchDesktopPoster() throws UiObjectNotFoundException, RemoteException {
        gotoHomeScreen("搜索");
        try {
            SearchDesktopPoster();
        }
        catch (Exception e) {
            try {
                count ++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("搜索");
                SearchDesktopPoster();
            }catch (RuntimeException re){
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
        press_back(4);
    }
    public void SearchDesktopPoster() throws UiObjectNotFoundException, RemoteException{
        addStep("浏览搜索桌面各个海报");
        UiObject2 desktop1=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("搜索")).selected(true));
        UiObject2 desktop2=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("搜索")).focused(true));
        verify("没有返回到搜索桌面", desktop1 != null || desktop2 != null);
        press_down(2);
        press_center(1);
        sleepInt(2);
        press_back(3);
        for(int i =5;i<14;i++){
            press_down(i);
            for(int j =0;j<5;j++){
                press_right(1);
                press_center(1);
                sleepInt(3);
                press_back(1);
            }
            press_back(3);
        }
        press_back(3);
    }

}
