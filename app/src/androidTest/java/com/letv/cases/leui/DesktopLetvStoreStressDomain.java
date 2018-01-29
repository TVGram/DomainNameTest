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
    @CaseName("进入应用商店打开")
    public void testDesktopAppStoreOpen() throws UiObjectNotFoundException, RemoteException {
        addStep("打开LetvStore");
        gotoHomeScreen("应用");
        launchApp(AppName.LeStore, IntentConstants.LeStore);
            try{
                AppStoreOpen();
            }
            catch (Exception e){
                try{
                    count++;
                    failCount(count,getIntParams("Loop"),e.getMessage());
                    launchApp(AppName.LeStore, IntentConstants.LeStore);
                    AppStoreOpen();
                }
                catch (RuntimeException re){
                    screenShot();
                    Assert.fail(re.getMessage());
                }
            }

        press_back(1);
        sleepInt(2);
        exitApp();
        press_back(4);
    }
    public void AppStoreOpen() throws UiObjectNotFoundException, RemoteException {
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
        press_up(1);
        String arr[] = {"精品", "应用", "游戏","分类"};
        for (int i = 0; i < arr.length; i++) {
            UiObject2 arrLine = phone.findObject(By.text(arr[i]));
            arrLine.click();
            press_right(1);
            sleepInt(2);
        }
        exitApp();
    }

    @Test
    @CaseName("进入应用商店打开并下载应用")
    public void testDesktopAppStoreDownload() throws UiObjectNotFoundException, RemoteException {
        addStep("打开LetvStore");
        gotoHomeScreen("应用");
        launchApp(AppName.LeStore, IntentConstants.LeStore);
        try{
            AppStoreDownload();
        }
        catch (Exception e){
            try{
                count++;
                failCount(count,getIntParams("Loop"),e.getMessage());
                launchApp(AppName.LeStore, IntentConstants.LeStore);
                AppStoreDownload();
            }
            catch (RuntimeException re){
                screenShot();
                Assert.fail(re.getMessage());
            }
        }

        press_back(1);
        sleepInt(2);
        exitApp();
        press_back(4);
    }
    public void AppStoreDownload() throws UiObjectNotFoundException, RemoteException {
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
        exitApp();
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

    @Test
    @CaseName("LetvStore应用Update")
    public void testLetvStoreUpdate() throws UiObjectNotFoundException, RemoteException {
        addStep("打开LetvStore");
        gotoHomeScreen("应用");
        launchApp(AppName.LeStore, IntentConstants.LeStore);
        try{
            LetvStoreUpdate();
        }
        catch (Exception e){
            try{
                count++;
                failCount(count,getIntParams("Loop"),e.getMessage());
                gotoHomeScreen("应用");
                launchApp(AppName.LeStore, IntentConstants.LeStore);
                LetvStoreUpdate();
            }
            catch (RuntimeException re){
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
        press_back(3);
    }
    public void LetvStoreUpdate() throws UiObjectNotFoundException, RemoteException {
        BySelector upgradeBtnS = By.text(Pattern.compile("升 级|Upgrade"));
        UiObject2 upgradeBtn = phone.findObject(upgradeBtnS);
        if (upgradeBtn != null) {
            addStep("检测到升级按钮，升级乐视应用商店");
            clickAndWaitForNewWindow(upgradeBtn);
            sleepInt(60);
            press_right(4);
            sleepInt(10);
        }
        UiObject2 install = phone.findObject(By.text("一键安装"));
        if (install != null) {
            press_back(1);
            sleepInt(1);
        }
        press_up(2);
        UiObject2 appupdate=waitForObj(By.res("com.letv.tvos.appstore:id/mv_update"));
        if (appupdate!=null){
            appupdate.click();
            appupdate.click();
            press_down(1);
            UiObject2 one_appupdate=waitForObj(By.text("一键更新"));
            for (int i =0;i<6;i++){
                clickAndWaitForNewWindow(one_appupdate);
            }
        }
        exitApp();
        press_home(1);
        gotoHomeScreen("应用");
        press_back(3);
        press_down(1);
        UiObject2 cinbapp = waitForObj(By.res(Pattern.compile("com.stv.plugin.app:id/poster_cellview_label|com.stv.plugin.app:id/cellview_label")).text("CIBN高清影视"));
        check("未进入CIBN高清影视",cinbapp!=null);
        cinbapp.click();
        cinbapp.click();

        UiObject2 cibndownapp = waitForObj(By.res(Pattern.compile("com.letv.tvos.appstore:id/downloadTV")).text("下载"));
        if (cibndownapp!=null) {
            check("未进入下载", cibndownapp != null);
            cibndownapp.click();
            clickAndWaitForNewWindow(cibndownapp);
        }
        exitApp();

        gotoHomeScreen("应用");
        press_back(3);
        press_down(1);
        UiObject2 hushuoapp = waitForObj(By.res(Pattern.compile("com.stv.plugin.app:id/poster_cellview_label")).text("华数TV"));
        check("未进入华数TV",cinbapp!=null);
        hushuoapp.click();
        hushuoapp.click();
        UiObject2 agree = waitForObj(By.res("cn.com.wasu.main:id/btn_agree").text("同意"));
        if(agree!=null){
            agree.click();
            agree.click();
        }
        exitApp();
    }


    @Test
    @CaseName("LetvStore应用桌面浏览")
    public void testLetvStoreDesk() throws UiObjectNotFoundException, RemoteException {
        addStep("打开LetvStore");
        gotoHomeScreen("应用");
        try{
            LetvStoreDesk();
        }
        catch (Exception e){
            try{
                count++;
                failCount(count,getIntParams("Loop"),e.getMessage());
                gotoHomeScreen("应用");
            }
            catch (RuntimeException re){
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
        press_back(3);
    }
    public void LetvStoreDesk() throws UiObjectNotFoundException, RemoteException {

        press_down(4);
        for (int i =1;i<5;i++) {
            UiObject2 music_item = waitForObj(By.res("com.stv.plugin.app:id/music_item_0"+i));
            check("未进入应用桌面音乐",music_item!=null);
            music_item.click();
            music_item.click();
            sleepInt(5);
            press_home(1);
            sleepInt(2);
            if (i<5) {
                press_right(2);
            }
            else {
                break;
            }
        }
        UiObject2 music_item_05 = waitForObj(By.res("com.stv.plugin.app:id/music_item_05"));
        check("未进入应用桌面music_item_05",music_item_05!=null);
        music_item_05.click();
        music_item_05.click();
        sleepInt(5);
        press_home(1);
        sleepInt(2);
        press_back(3);
        gotoHomeScreen("应用");
        press_down(1);
        press_back(3);


        press_down(5);
        for (int i =1;i<5;i++) {
            UiObject2 health_life_item = waitForObj(By.res("com.stv.plugin.app:id/health_life_item_0"+i));
            check("未进入应用桌面健康",health_life_item!=null);
            health_life_item.click();
            health_life_item.click();
            sleepInt(5);
            press_home(1);
            sleepInt(2);
            if (i<5) {
                press_right(2);
            }
            else {
                break;
            }
        }
        UiObject2 health_life_item5 = waitForObj(By.res("com.stv.plugin.app:id/health_life_item_05"));
        check("未进入应用桌面健康",health_life_item5!=null);
        health_life_item5.click();
        health_life_item5.click();
        sleepInt(5);
        press_home(1);
        sleepInt(2);
        press_back(3);
        gotoHomeScreen("应用");
        press_down(1);
        press_back(3);



        press_down(6);
        for (int i =1;i<5;i++) {
            UiObject2 game_item = waitForObj(By.res("com.stv.plugin.app:id/game_item_0"+i));
            check("未进入应用桌面game",game_item!=null);
            game_item.click();
            game_item.click();
            sleepInt(5);
            press_home(1);
            sleepInt(2);
            if (i<5) {
                press_right(2);
            }
            else {
                break;
            }
        }
        UiObject2 game_item_05 = waitForObj(By.res("com.stv.plugin.app:id/game_item_05"));
        check("未进入应用桌面健康",game_item_05!=null);
        game_item_05.click();
        game_item_05.click();
        sleepInt(5);
        press_home(1);
        sleepInt(2);
        press_back(3);
        gotoHomeScreen("应用");
        press_down(1);
        press_back(3);





        press_down(7);
        for (int i =1;i<3;i++) {
            UiObject2 recommend_item = waitForObj(By.res("com.stv.plugin.app:id/recommend_item_0"+i));
            check("未进入应用桌面recommend",recommend_item!=null);
            recommend_item.click();
            recommend_item.click();
            sleepInt(5);
            press_home(1);
            sleepInt(2);
            if (i<5) {
                press_right(2);
            }
            else {
                break;
            }
        }
        UiObject2 recommend_item3 = waitForObj(By.res("com.stv.plugin.app:id/recommend_item_03"));
        check("未进入应用桌面recommend",recommend_item3!=null);
        recommend_item3.click();
        recommend_item3.click();
        sleepInt(5);
        press_home(1);
        sleepInt(2);
        press_back(3);

    }

}
