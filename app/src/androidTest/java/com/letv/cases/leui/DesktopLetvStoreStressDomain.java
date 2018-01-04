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

import junit.framework.Assert;

import org.junit.After;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
public class DesktopLetvStoreStressDomain extends LetvTestCase {
    int count=0;

    @Test
    @CaseName("LetvStore里下载应用")
    public void testDownloadApp() throws UiObjectNotFoundException, RemoteException {
        addStep("打开LetvStore");
        gotoHomeScreen("应用");
        launchApp(AppName.LeStore, IntentConstants.LeStore);
            try{
                DownloadApp();
            }
            catch (Exception e){
                try{
                    count++;
                    failCount(count,getIntParams("Loop"),e.getMessage());
                    launchApp(AppName.LeStore, IntentConstants.LeStore);
                    DownloadApp();
                }
                catch (RuntimeException re){
                    screenShot();
                    Assert.fail(re.getMessage());
                }
            }

        press_back(1);
        sleepInt(2);
        UiObject2 exitok = waitForObj(By.text("退出"));
        exitok.click();
        press_back(4);
    }
    public void DownloadApp() throws UiObjectNotFoundException, RemoteException {
        BySelector upgradeBtnS = By.text(Pattern.compile("升 级|Upgrade"));
        UiObject2 upgradeBtn = phone.findObject(upgradeBtnS);
        if (upgradeBtn != null) {
            addStep("检测到升级按钮，升级乐视应用商店");
            upgradeBtn.click();
            sleepInt(120);
            press_right(4);
            sleepInt(10);
        }
        UiObject2 install = phone.findObject(By.text("一键安装"));
        if (install != null) {
            press_back(1);
            sleepInt(1);
        }
//        UiObject2 manager = phone.findObject(storeS);
//        check("未能进入LetvStore主界面", manager != null);
        press_up(1);
        String arr[] = {"精品", "应用", "游戏","分类"};
        for (int i = 0; i < arr.length; i++) {
            UiObject2 arrLine = phone.findObject(By.text(arr[i]));
            arrLine.click();
            press_right(1);
            sleepInt(2);
        }
        press_up(1);
        press_right(1);
        sleepInt(1);
        addStep("搜索App");
        UiObject2 search = phone.findObject(By.res("com.letv.tvos.appstore:id/tv_search").text("搜索"));
        check("未进入搜索", search != null);
        search.click();
        search.click();
        sleepInt(1);
        UiObject2 D = waitForObj(By.text("D"));
        UiObject2 S = waitForObj(By.text("S"));
//        UiObject2 Y = waitForObj(By.text("Y"));
        D.click();
        D.click();
        S.click();
        S.click();

        press_right(2);
        press_down(1);
        UiObject2 apply = waitForObj(By.res("com.letv.tvos.appstore:id/tv_app_name").text("电视优化大师"));
        check("未进入下载应用中",apply!=null);
        apply.click();
        apply.click();
        sleepInt(2);
        UiObject2 down = waitForObj(By.res("com.letv.tvos.appstore:id/downloadTV").text("下载"));
        BySelector open = By.res("com.letv.tvos.appstore:id/downloadTV").text("打开");


        if (down != null) {
            check("安装按钮不存在", down != null);
            clickAndWaitForNewWindow(down);
            UiObject2 check2 = waitForObj(open, 30000L);
            check("网络不稳定安装未成功", check2 != null);
            check2.click();
        } else {
            UiObject2 check2 = waitForObj(open);
//            check("打开按钮不存在", check2 != null);
            check2.click();
            sleepInt(2);
        }

        sleepInt(2);
        press_back(4);
        sleepInt(4);
//
//        addStep("进入应用管理");
//        UiObject2 manage = waitForObj(By.res("com.letv.tvos.appstore:id/tv_manager").text("管理"));
//        check("未进入管理", manage != null);
//        manage.click();
//        manage.click();
//        sleepInt(2);
//        addStep("进入应用卸载");
//        press_right(3);
//        press_center(1);
//        sleepInt(3);
//        addStep("卸载APP应用");
//        UiObject2 TVmanager=waitForObj(By.res("com.letv.tvos.appstore:id/tv_myapp_item_appname").text("电视应用管家"));
//        check("未进入管理",TVmanager!=null);
//        TVmanager.click();
//        TVmanager.click();
//        sleepInt(2);
//
//        press_center(1);
//
//        UiObject2 off=waitForObj(By.text("卸载"));
//        check("未进入卸载界面",off!=null);
//        off.click();
//        off.click();
//        sleepInt(2);
//
//        UiObject2 offok=waitForObj(By.text("卸载"));
//        check("未进入卸载按钮",off!=null);
//        offok.click();
//
//        sleepInt(5);
//        press_back(2);
//        sleepInt(1);

    }
}
