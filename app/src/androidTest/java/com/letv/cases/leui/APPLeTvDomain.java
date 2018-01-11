package com.letv.cases.leui;

import android.os.Build;
import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.IntentConstants;
import com.letv.common.LetvTestCase;

import org.junit.Test;

import java.util.regex.Pattern;

public class APPLeTvDomain extends LetvTestCase {
    int count=0;

    @Test
    @CaseName("乐视网TV版遍历菜单")
    public void testLetvTraverse() throws UiObjectNotFoundException,RemoteException {
        enter();
        loginAccount();
        UiObject2 clickO = phone.findObject(By.text("点击哦"));
        if(clickO!=null){
            press_back(1);
            sleepInt(1);
        }
            try {
                LetvTraverse();
            }catch (Exception e){
                try {
                    count ++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    enter();
                    loginAccount();
                    UiObject2 click1 = phone.findObject(By.text("点击哦"));
                    if(click1!=null){
                        press_back(1);
                        sleepInt(1);
                    }
                    LetvTraverse();
                }catch (RuntimeException re){
                    screenShot();
                    junit.framework.Assert.fail(re.getMessage());
                }
            }

    }

    public void LetvTraverse() throws UiObjectNotFoundException {
        String menus[] = { "首页","会员","分类", "发现", "我的" };
        for (int i = 0; i < menus.length; i++) {
            String menuName = menus[i];
            addStep("切换到" + menuName + "菜单");
            UiObject2 menu1 = waitForObj(By.text(Pattern.compile(menuName)));
            check("不存在" + menuName, menu1 != null);
            menu1.click();
            menu1.click();
            sleepInt(4);
            press_right(1);

        }
        for (int i = 0; i <5;i++){
            press_back(1);
            sleepInt(1);
            UiObject2 exit = phone.findObject(By.text("退出"));
            if(exit!=null)break;
        }
        UiObject2 exit1 = phone.findObject(By.text("退出"));
        check("退出不存在", exit1 != null);
        press_back(1);
        sleepInt(2);
        addStep("进入首页界面");
        UiObject2 homePage = phone.findObject(By.text("首页"));
        homePage.click();
        sleepInt(1);
        check("未能切换到首页界面", homePage.isSelected());
        press_up(2);
        UiObject2 video=waitForObj(By.res("com.letv.tv:id/item_firstpage_right_2_1"));
        check("未能要播放的视频", video != null);
        video.click();
        video.click();
        sleepInt(1);
        press_center(1);
        sleepInt(8);
        addStep("播放任意视频");
        UiObject2 playVideo1 = waitForObj(By.text(Pattern.compile(".*播放|播放|第.*集")));
        if(playVideo1!=null){
            check("can't find playvideo", playVideo1 != null);
            playVideo1.click();
        }else {
            UiObject2 videoBrowse= waitForObj(By.clazz("android.view.View"));
            check("can't find small window of vidoe", videoBrowse != null);
            videoBrowse.click();
            videoBrowse.click();
            sleep(1);
        }
        sleepInt(60);
        press_back(1);
        sleepInt(1);
        UiObject2 exit=null;
        for (int a=0;a<3;a++) {
            exit=phone.findObject(By.text("退出播放"));
            if (exit != null) {
                exit.click();
                break;
            }
            press_back(1);
        }
        sleepInt(1);
        UiObject2 firstPage =null;
        for (int b=0;b<3;b++) {
            firstPage = phone.findObject(By.text("首页"));
            if (firstPage != null) {
                break;
            }
            press_back(1);
        }
        sleepInt(2);
    }

    public void updateLeTV() throws UiObjectNotFoundException {
        UiObject2 UpdateButton = phone.findObject(By.textContains("立即升级"));
        if (UpdateButton!=null) {
            addStep("出现升级界面，开始升级");
            UpdateButton.click();
            sleepInt(15);
        }
        // 进入APP，激活会员
        for (int a = 0; a < 3; a++) {
            UiObject2 ignore = phone.findObject(By.textContains("跳过"));
            if (ignore!=null) {
                addStep("跳过激活会员");
                ignore.click();
                sleepInt(3);
            }
        }
        // 跳过会员超高清看
        UiObject2 keepwatching = phone.findObject(By.textContains("无品质继续看"));
        if (keepwatching!=null) {
            addStep("跳过会员超清看");
            keepwatching.click();
            sleepInt(3);
        }

    }

    public void loginAccount() throws UiObjectNotFoundException,RemoteException{
        UiObject2 loginNow = phone.findObject(By.text("立即登录"));
        if(loginNow!=null) {
            addStep("登录会员");
            loginNow.click();
            sleepInt(4);
            UiObject2 login = waitForObj(By.text(Pattern.compile(".*添加帐号.*|.*帐号密码登录.*|.*其他帐号登录.*")));
            if (login!=null) {
                login.click();
                sleepInt(2);
            }
            sleepInt(2);
            if(Build.DEVICE.contains("U4")){
                press_back(1);
            }
            UiObject2 userName =waitForObj(By.text(Pattern.compile("乐视帐号|会员帐号|超级电视帐号|帐        号"))).getParent().findObject(By.clazz("android.widget.EditText"));
            verify("can't find userName.", userName != null);
            userName.setText(getStrParams("USERNAME"));
            sleepInt(2);
            press_down(1);
            UiObject passwd=null;
            if(LetvUI(6.0)){
                passwd=phone.findObject(new UiSelector().className("android.widget.EditText").instance(1));
                check("can't find passwd.", passwd != null);
                sleepInt(2);
                if(Build.DEVICE.contains("U4")){
                    passwd = phone.findObject(new UiSelector().className("android.widget.EditText").instance(1));
                    check("can't find passwd.", passwd != null);
                    sleepInt(2);
                }
            }else {
                passwd = phone.findObject(new UiSelector().className("android.widget.EditText").instance(1));
                check("can't find passwd.", passwd != null);
                sleepInt(2);
            }
            passwd.setText(getStrParams("PASSWORD"));
            sleepInt(1);
            UiObject2 loginNow1 = phone.findObject(By.clazz("android.widget.Button").text("立即登录"));
            verify("can't find loginNow.", loginNow1!=null);
            press_down(1);
            press_center(1);
            sleepInt(7);
        }
    }

    public void enter() throws UiObjectNotFoundException {
        addStep("进入乐视视频");
        launchApp(AppName.LeTv, IntentConstants.LeTv);
        sleepInt(5);
        updateLeTV();
    }



    @Test
    @CaseName("乐视网TV版播放视频")
    public void testLetvPlayVideo() throws UiObjectNotFoundException,RemoteException {
        enter();
        loginAccount();
        UiObject2 clickO = phone.findObject(By.text("点击哦"));
        if(clickO!=null){
            press_back(1);
            sleepInt(1);
        }
            try {
                LetvPlayVideo();
            }catch (Exception e){
                try {
                    count ++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    enter();
                    loginAccount();
                    UiObject2 click1 = phone.findObject(By.text("点击哦"));
                    if(click1!=null){
                        press_back(1);
                        sleepInt(1);
                    }
                    LetvPlayVideo();
                }catch (RuntimeException re){
                    screenShot();
                    junit.framework.Assert.fail(re.getMessage());
                }
            }

    }

    public void LetvPlayVideo() throws UiObjectNotFoundException {
        String menus[] = { "首页","会员","分类", "发现", "我的" };
        for (int i = 0; i < menus.length; i++) {
            String menuName = menus[i];
            addStep("切换到" + menuName + "菜单");
            UiObject2 menu1 = waitForObj(By.text(Pattern.compile(menuName)));
            check("不存在" + menuName, menu1 != null);
            menu1.click();
            menu1.click();
            sleepInt(4);
            press_right(1);

        }
        for (int i = 0; i <5;i++){
            press_back(1);
            sleepInt(1);
            UiObject2 exit = phone.findObject(By.text("退出"));
            if(exit!=null)break;
        }
        UiObject2 exit1 = phone.findObject(By.text("退出"));
        check("退出不存在", exit1 != null);
        press_back(1);
        sleepInt(2);
        addStep("进入首页界面");
        UiObject2 homePage = phone.findObject(By.text("首页"));
        homePage.click();
        sleepInt(1);
        check("未能切换到首页界面", homePage.isSelected());
        press_up(2);
        UiObject2 video=waitForObj(By.res("com.letv.tv:id/item_firstpage_right_2_1"));
        check("未能要播放的视频", video != null);
        video.click();
        video.click();
        sleepInt(1);
        press_center(1);
        sleepInt(8);
        addStep("播放任意视频");
        UiObject2 playVideo1 = waitForObj(By.text(Pattern.compile(".*播放|播放|第.*集")));
        if(playVideo1!=null){
            check("can't find playvideo", playVideo1 != null);
            playVideo1.click();
        }else {
            UiObject2 videoBrowse= waitForObj(By.clazz("android.view.View"));
            check("can't find small window of vidoe", videoBrowse != null);
            videoBrowse.click();
            videoBrowse.click();
            sleep(1);
        }
        sleepInt(60);
        press_back(1);
        sleepInt(1);
        UiObject2 exit=null;
        for (int a=0;a<3;a++) {
            exit=phone.findObject(By.text("退出播放"));
            if (exit != null) {
                exit.click();
                break;
            }
            press_back(1);
        }
        sleepInt(1);
        UiObject2 firstPage =null;
        for (int b=0;b<3;b++) {
            firstPage = phone.findObject(By.text("首页"));
            if (firstPage != null) {
                break;
            }
            press_back(1);
        }
        sleepInt(2);
    }








}
