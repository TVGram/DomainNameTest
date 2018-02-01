package com.letv.cases.leui;


import android.os.Build;
import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.letv.common.CaseName;
import com.letv.common.LetvTestCase;

import junit.framework.Assert;

import org.junit.Test;

public class DesktopSingalSourceDomain extends LetvTestCase {
    int count = 0;

    @Test
    @CaseName("信号源桌面热门推荐")
    public void testSingalSourceHot() throws UiObjectNotFoundException,RemoteException{
        addStep("切换到信号源桌面");
        gotoHomeScreen("首页");
        press_left(2);
        press_back(2);
        try {
            SignalsourcelHot();
            } catch (Exception e) {
                try {
                    count++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    addStep("切换到信号源桌面");
                    gotoHomeScreen("首页");
                    press_left(2);
                    press_back(1);
                    press_down(3);
                    SignalsourcelHot();
                }
                catch (RuntimeException re) {
                    screenShot();
                    Assert.fail(re.getMessage());
                }
            }
    }
    public void SignalsourcelHot() throws UiObjectNotFoundException,RemoteException {
        addStep("信号源桌面热门推荐");
        press_down(2);
        UiObject2 hot_item1=waitForObj(By.res("com.stv.signalsourcemanager:id/hot_item1"));
        check("未进入热门推荐",hot_item1!=null);
        press_right(2);
        press_down(1);
        press_left(1);
        press_center(1);
        sleepInt(5);
    }

    @Test
    @CaseName("信号源桌面精彩推荐")
    public void testSingalSourceWonderful() throws UiObjectNotFoundException,RemoteException{
        addStep("切换到信号源桌面");
        gotoHomeScreen("首页");
        press_left(2);
        press_back(3);
        try {
            SignalsourcelWonderful();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("切换到信号源桌面");
                gotoHomeScreen("首页");
                press_left(2);
                press_back(1);
                press_down(3);
                SignalsourcelWonderful();
            }
            catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
    }
    public void SignalsourcelWonderful() throws UiObjectNotFoundException,RemoteException {
        addStep("信号源桌面精彩推荐");
        press_down(3);
        UiObject2 recommend_iv=waitForObj(By.res("com.stv.signalsourcemanager:id/recommend_iv"));
        check("未进入热门推荐",recommend_iv!=null);
        press_right(2);
        press_down(1);
        press_left(2);
        press_center(1);
        sleepInt(5);
    }

    @Test
    @CaseName("信号源桌面海报")
    public void testSingalSourceAll() throws UiObjectNotFoundException,RemoteException{
        addStep("切换到信号源桌面");
        gotoHomeScreen("首页");
        press_left(2);
        press_back(3);
        try {
            SignalsourcelAll();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("切换到信号源桌面");
                gotoHomeScreen("首页");
                press_left(2);
                press_back(1);
                press_down(3);
                SignalsourcelAll();
            }
            catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
    }
    public void SignalsourcelAll() throws UiObjectNotFoundException,RemoteException {
        addStep("信号源桌面海报");
        press_down(1);
        press_right(1);
        press_down(5);
    }



}
