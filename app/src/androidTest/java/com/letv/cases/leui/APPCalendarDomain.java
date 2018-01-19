package com.letv.cases.leui;
import android.os.Build;
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

import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;


import java.util.Date;
import java.util.Calendar;

import java.text.SimpleDateFormat;

public class APPCalendarDomain extends LetvTestCase {
    int count = 0;

    @Test
    @CaseName("进入日历应用")
    public void testCalendarEnter() throws UiObjectNotFoundException, RemoteException {
        try {
            CalendarEnter();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                CalendarEnter();
            } catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
        press_back(3);
    }
    public void CalendarEnter() throws UiObjectNotFoundException, RemoteException {
        addStep("打开日历App");
        gotoHomeScreen("应用");
        launchApp(AppName.Calendar, IntentConstants.Calendar);
        sleepInt(2);
    }




    @Test
    @CaseName("多次进入日历应用，查看日历界面显示")
    public void testCalendarSelectData() throws UiObjectNotFoundException, RemoteException {
        addStep("打开日历App");
        gotoHomeScreen("应用");
        launchApp(AppName.Calendar, IntentConstants.Calendar);
        sleepInt(2);
        try {
            CalendarSelectData();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                CalendarSelectData();
            } catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
        press_back(3);
    }
    public void CalendarSelectData() throws UiObjectNotFoundException, RemoteException {

        addStep("选择日历中的任意日期进入");
        press_down(2);
        press_center(1);
        press_back(1);
        sleepInt(2);
    }



    @Test
    @CaseName("多次进入日历应用，查看日历界面显示")
    public void testCalendarLeftRight() throws UiObjectNotFoundException, RemoteException {
        addStep("打开日历App");
        gotoHomeScreen("应用");
        launchApp(AppName.Calendar, IntentConstants.Calendar);
        sleepInt(2);
        try {
            CalendarLeftRight();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                CalendarLeftRight();
            } catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
        press_back(3);
    }
    public void CalendarLeftRight() throws UiObjectNotFoundException, RemoteException {
        addStep("日历中上下左右键进行切换日期");
        press_down(GenerateRandom(7));
        sleepInt(2);
        press_up(GenerateRandom(7));
        sleepInt(2);
        press_right(GenerateRandom(7));
        sleepInt(2);
        press_left(GenerateRandom(7));
        sleepInt(2);
    }
}
