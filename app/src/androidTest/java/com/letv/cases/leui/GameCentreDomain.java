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


public class GameCentreDomain extends LetvTestCase{
    int count=0;


    BySelector download = By.clazz("android.widget.TextView").text(Pattern.compile("立即安装"));
    BySelector check1S = By.clazz("android.widget.TextView").text(Pattern.compile("安装|Install"));
    BySelector openApp = By.clazz("android.widget.TextView").text(Pattern.compile("立即打开|打开|Open"));

    @Test
    @CaseName("进入桌面游戏反复切换画面")
    public void testGameDeskSwitch() throws UiObjectNotFoundException, RemoteException {
        addStep("打开同游戏桌面");
        gotoHomeScreen("游戏");
        press_down(1);
            addStep("进入游戏");
            try {
                GameDeskSwitch();
            } catch (Exception e) {
                try {
                    count++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    addStep("打开游戏桌面");
                    gotoHomeScreen("游戏");
                    GameDeskSwitch();
                } catch (RuntimeException re) {
                    screenShot();
                    Assert.fail(re.getMessage());
                }
            }
    }
    public void GameDeskSwitch() throws UiObjectNotFoundException, RemoteException {
        String arrGameDeskSwitch[] = {"猜你喜欢","花式抽卡，欧气满满.*","与您一起，见证宝贝的点滴成长", "畅销榜", "大屏格斗更激爽！", "飙升榜","德州麻将斗地主，象棋斗牛赢三张","感受枪林弹雨的超神快感","热门榜","休闲益智"};
        for (int i = 0; i < arrGameDeskSwitch.length; i++) {
            press_back(2);
            press_down(6 + i);
            addStep("进入到" + arrGameDeskSwitch[i] + "切换3次");
            int GameDesk = phone.findObject(By.text(Pattern.compile(arrGameDeskSwitch[i]))).getParent().getChildCount()+3;
            check("未进入" + arrGameDeskSwitch[i], GameDesk != 0);
            press_right(GameDesk);
            press_left(GameDesk);
        }
        press_back(3);
    }

    @Test
    @CaseName("选择任意游戏进行安装下载")
    public  void testgameapp()throws UiObjectNotFoundException, RemoteException{
        addStep("打开同游戏桌面");
        gotoHomeScreen("游戏");
        press_down(1);
        UiObject2 game=waitForObj(By.res("com.stv.plugin.game:id/item_name").text("宝贝童话TV版"));
        game.click();
        game.click();
    }
}
