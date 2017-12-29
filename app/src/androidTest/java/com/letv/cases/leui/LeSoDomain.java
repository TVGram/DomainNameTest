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
/**
 * Created by wangyaxiu on 2016/12/14.
 */

public class LeSoDomain extends LetvTestCase{
    int count=0;
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    @CaseName("搜索桌面进入乐看搜索")
    public void testSearchExit() throws UiObjectNotFoundException, RemoteException {
        addStep("打开搜索桌面");
        gotoHomeScreen("搜索");
        try {
            sleepInt(2);
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
            } catch (Exception e) {
            failCount(count, getIntParams("Loop"), e.getMessage());
            }
            press_back(4);
    }


    @Test
    @CaseName("搜索桌面进入乐看搜索")
    public void testSearchPoster() throws UiObjectNotFoundException, RemoteException {
        addStep("打开搜索桌面");
        gotoHomeScreen("搜索");
        press_back(4);
        try {
            for(int i =5;i<14;i++){
                press_down(i);
                press_right(4);
                press_back(3);
            }
            press_down(1);
        } catch (Exception e) {
            failCount(count, getIntParams("Loop"), e.getMessage());
        }
        press_back(4);
    }




































    @Test
    @CaseName("从应用桌面打开乐看搜索，反复搜索")
    public void testLesoAppDesk() throws UiObjectNotFoundException, RemoteException {
    launchApp(AppName.LeSo, IntentConstants.LeSo);
    sleepInt(3);
    UiObject2 leSo = waitForObj(By.pkg("com.letv.leso"));
    verify("未进入乐看搜索", leSo != null);
    addStep("进入乐看搜索");
    UiObject2 search=null;
    search=waitForObj(By.res("com.letv.leso:id/search_box"));
    for (int i=0;i<5;i++){
        search=waitForObj(By.res("com.letv.leso:id/search_box"));
        if (search==null){
            sleepInt(3);
        }
    }
    verify("can't enter the leso", search != null);
    clickAndWaitForNewWindow(search);
    for (int Loop = 0; Loop < getIntParams("Loop"); Loop++) {
        System.out.println(".............looper : " + Loop);
        try {
            LesoAppDesk();
        }catch (Exception e){
            try {
                count ++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                launchApp(AppName.LeSo, PkgName.LeSo);
                sleepInt(1);
                UiObject2 leSo1 = waitForObj(By.pkg("com.letv.leso"));
                check("未进入乐看搜索", leSo1 != null);
                LesoAppDesk();
            }catch (RuntimeException re){
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
    }
    addStep("退出乐看搜索");
    press_back(2);
}

    public void LesoAppDesk() throws UiObjectNotFoundException, RemoteException {
        sleepInt(2);
        press_center(1);
        UiObject2 clear=null;
        clear = waitForObj(By.res(Pattern.compile("com.letv.leso:id/searchboard_clear_btn|com.letv.search.plugin:id/searchboard_clear_btn")));
        check("没有找到清空内容的按钮", clear != null);
        sleepInt(1);
        clear.click();
        clear.click();
        sleepInt(1);
        addStep("选择电视剧榜单");
        press_right(4);
        sleepInt(3);
        press_right(3);
        UiObject2 listAll = phone.findObject(By.clazz("android.widget.TextView").textContains("全部"));
        check("全部榜单不存在",listAll!=null);
        listAll.click();
        listAll.click();
        sleepInt(2);
        press_down(3);
        press_center(1);
        sleepInt(2);
        press_left(5);
        clear.click();
        clear.click();
        addStep("搜索WMNCQ，得到电视剧武媚娘传奇");
        // 首拼音搜索 武媚娘传奇
        UiObject2 W = phone.findObject(By.clazz("android.widget.TextView").text("W"));
        UiObject2 M = phone.findObject(By.clazz("android.widget.TextView").text("M"));
        UiObject2 N = phone.findObject(By.clazz("android.widget.TextView").text("N"));
        UiObject2 C = phone.findObject(By.clazz("android.widget.TextView").text("C"));
        UiObject2 Q = phone.findObject(By.clazz("android.widget.TextView").text("Q"));
        W.click();W.click();M.click();M.click();N.click();N.click();C.click();C.click();Q.click();Q.click();
        sleepInt(3);
        UiObject2 playSets = waitForObj(By.text(Pattern.compile("武媚娘传奇.*")));
        verify ("搜索结果不存在",playSets!=null);
        press_back(1);
    }

}
