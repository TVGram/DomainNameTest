package com.letv.cases.leui;

import android.os.Build;
import android.os.RemoteException;
import android.provider.Contacts;
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

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;


public class DesktopGameCentreDomain extends LetvTestCase{
    int count=0;


    BySelector download = By.clazz("android.widget.TextView").text(Pattern.compile("立即安装"));
    BySelector check1S = By.clazz("android.widget.TextView").text(Pattern.compile("安装|Install"));
    BySelector openApp = By.clazz("android.widget.TextView").text(Pattern.compile("立即打开|打开|Open"));

    @Test
    @CaseName("进入桌面游戏我的游戏")
    public void testDesktopGameDeskMygame() throws UiObjectNotFoundException, RemoteException {
        addStep("打开同游戏桌面");
        gotoHomeScreen("游戏");
        press_down(1);
            addStep("进入游戏");
            try {
                GameDeskMygame();
            } catch (Exception e) {
                try {
                    count++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    addStep("打开游戏桌面");
                    gotoHomeScreen("游戏");
                    GameDeskMygame();
                } catch (RuntimeException re) {
                    screenShot();
                    Assert.fail(re.getMessage());
                }
            }
    }
    public void GameDeskMygame() throws UiObjectNotFoundException, RemoteException {
        addStep("游戏桌面我的游戏");
        press_down(3);
        UiObject2 mygame=waitForObj(By.res("com.stv.plugin.game:id/entrance_1"));
        check("",mygame!=null);
        mygame.click();
        mygame.click();
        desktop();
    }

    @Test
    @CaseName("进入游戏桌面排行榜")
    public void testDesktopGameDeskList() throws UiObjectNotFoundException, RemoteException {
        addStep("打开同游戏桌面");
        gotoHomeScreen("游戏");
        press_down(1);
        addStep("进入游戏");
        try {
            GameDeskList();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("打开游戏桌面");
                gotoHomeScreen("游戏");
                GameDeskList();
            } catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
    }
    public void GameDeskList() throws UiObjectNotFoundException, RemoteException {
        addStep("游戏桌面排行榜");
        press_down(3);
        UiObject2 classfisr=waitForObj(By.res("com.stv.plugin.game:id/entrance_2"));
        classfisr.click();
        classfisr.click();
        desktop();
    }


    @Test
    @CaseName("游戏桌面游戏大厅")
    public void testDesktopGameDeskHall() throws UiObjectNotFoundException, RemoteException {
        addStep("打开同游戏桌面");
        gotoHomeScreen("游戏");
        press_down(1);
        addStep("进入游戏");
        try {
            GameDeskHall();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("打开游戏桌面");
                gotoHomeScreen("游戏");
                GameDeskHall();
            } catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
    }
    public void GameDeskHall() throws UiObjectNotFoundException, RemoteException {
        addStep("游戏桌面游戏大厅");
        press_down(3);
        UiObject2 lobby=waitForObj(By.res("com.stv.plugin.game:id/entrance_3"));
        lobby.click();
        lobby.click();
        desktop();
    }

    @Test
    @CaseName("进入桌面游戏搜索")
    public void testDesktopGameDeskSearch() throws UiObjectNotFoundException, RemoteException {
        addStep("打开同游戏桌面");
        gotoHomeScreen("游戏");
        press_down(1);
        addStep("进入游戏");
        try {
            GameDeskSearch();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("打开游戏桌面");
                gotoHomeScreen("游戏");
                GameDeskSearch();
            } catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
    }
    public void GameDeskSearch() throws UiObjectNotFoundException, RemoteException {
        addStep("游戏桌面搜索");
        press_down(3);
        UiObject2 Search=waitForObj(By.res("com.stv.plugin.game:id/entrance_4"));
        Search.click();
        Search.click();
        desktop();
    }


    @Test
    @CaseName("进入桌面游戏海报浏览")
    public void testDesktopGameDeskPoster() throws UiObjectNotFoundException, RemoteException {
        addStep("打开同游戏桌面");
        gotoHomeScreen("游戏");
        press_down(1);
        addStep("进入游戏");
        try {
            GameDeskPoster();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                addStep("打开游戏桌面");
                gotoHomeScreen("游戏");
                GameDeskPoster();
            } catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
        press_back(3);
    }
    public void GameDeskPoster() throws UiObjectNotFoundException, RemoteException {
        addStep("游戏桌面海报浏览");
//        for(int i=1;i<=4;i++) {
//            press_down(1);
//            UiObject2 GameEntrance = waitForObj(By.res("com.stv.plugin.game:id/entrance_"+i));
//            check("未进入GameEntrance",GameEntrance!=null);
//            GameEntrance.click();
//            GameEntrance.click();
//            sleepInt(10);
//            press_home(1);
//            sleepInt(3);
//            press_back(3);
//            UiObject2 desktop1=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("游戏")).selected(true));
//            UiObject2 desktop2=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("游戏")).focused(true));
//            verify("没有返回到游戏桌面", desktop1 != null || desktop2 != null);
//        }


//        for(int j=1;j<=6;j++) {
//            press_down(2);
//            UiObject2 GamePoster = waitForObj(By.res("com.stv.plugin.game:id/poster_"+j));
//            check("未进入GamePoster",GamePoster!=null);
//            GamePoster.click();
//            GamePoster.click();
//            sleepInt(10);
//            press_home(1);
//            sleepInt(3);
//            press_back(3);
//            UiObject2 desktop1=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("游戏")).selected(true));
//            UiObject2 desktop2=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("游戏")).focused(true));
//            verify("没有返回到游戏桌面", desktop1 != null || desktop2 != null);
//        }
//
//        for(int k=1;k<=5;k++) {
//            press_down(5);
//            UiObject2 GameWonder = waitForObj(By.res("com.stv.plugin.game:id/wonder_"+k));
//            check("未进入GameWonder",GameWonder!=null);
//            GameWonder.click();
//            GameWonder.click();
//            sleepInt(10);
//            press_home(1);
//            sleepInt(3);
//            press_back(3);
//            UiObject2 desktop1=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("游戏")).selected(true));
//            UiObject2 desktop2=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("游戏")).focused(true));
//            verify("没有返回到游戏桌面", desktop1 != null || desktop2 != null);
//        }


        String arrGameDeskSwitch[] = {"猜你喜欢","花式抽卡，欧气满满.*","与您一起，见证宝贝的点滴成长", "畅销榜", "大屏格斗更激爽！", "飙升榜","德州麻将斗地主，象棋斗牛赢三张","感受枪林弹雨的超神快感","热门榜","休闲益智"};
        for (int i = 0; i < arrGameDeskSwitch.length; i++) {
            press_back(3);
            press_down(6 + i);
            addStep("进入到" + arrGameDeskSwitch[i] + "切换3次");
            int GameDesk = phone.findObject(By.text(Pattern.compile(arrGameDeskSwitch[i]))).getParent().getChildCount();
            check("未进入" + arrGameDeskSwitch[i], GameDesk != 0);
            for (int k=0;k<4;k++) {
                press_right(GameDesk);
                press_center(1);
                sleepInt(10);
                press_home(1);
                sleepInt(3);
            }
        }
    }

    @Test
    @CaseName("选择任意游戏进行安装下载打开")
    public  void testDesktopgameapp()throws UiObjectNotFoundException, RemoteException{
        addStep("打开同游戏桌面");
        gotoHomeScreen("游戏");
        press_down(1);
        UiObject2 game=waitForObj(By.res("com.stv.plugin.game:id/item_name").text("宝贝童话TV版"));
        game.click();
        game.click();
        UiObject2 downloadgame=waitForObj(By.res("com.letv.tvos.gamecenter:id/download_state").text("立即安装"));
        if(downloadgame != null) {
            downloadgame.click();
            sleepInt(3);
            addStep("打开App详情并安装并打开");
            UiObject2 download = waitForObj(By.res("com.android.packageinstaller:id/ok_button").text(Pattern.compile("安装")));
            if (download != null) {
                check("安装按钮不存在", download != null);
                clickAndWaitForNewWindow(download);
//            UiObject2 check2 = waitForObj(openApp, 30000L);
//            check("网络不稳定安装未成功", check2 != null);
//            check2.click();
            } else {
//            UiObject2 check2 = waitForObj(openApp);
//            check2.click();
                sleepInt(2);
            }
//        sleepInt(10);
            UiObject2 done_button = waitForObj(By.res("com.android.packageinstaller:id/done_button").text("完成"));
            check("未完成", done_button != null);
            done_button.click();
            done_button.click();
            addStep("退出游戏App");
            press_back(3);
        }else {
        sleepInt(10);
        press_home(1);
        }

    }

    public void desktop()throws UiObjectNotFoundException, RemoteException{
        sleepInt(4);
        exitApp();
        UiObject2 desktop1=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("游戏")).selected(true));
        UiObject2 desktop2=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("游戏")).focused(true));
        verify("没有返回到视频桌面", desktop1 != null || desktop2 != null);
    }
}
