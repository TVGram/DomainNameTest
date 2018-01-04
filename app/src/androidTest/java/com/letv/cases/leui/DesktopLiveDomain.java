package com.letv.cases.leui;

import android.os.Looper;
import android.os.RemoteException;
import android.provider.Contacts;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.letv.common.CaseName;
import com.letv.common.LetvTestCase;

import junit.framework.Assert;

import org.junit.Test;

import java.security.spec.ECField;
import java.util.Random;
import java.util.regex.Pattern;

public class DesktopLiveDomain extends LetvTestCase{

    BySelector letvS=By.pkg("com.letv.tv");
    BySelector homePageS = By.text("首页");
    BySelector exit = By.textContains("退出播放");
    BySelector leVideoS=By.text(Pattern.compile("乐视视频|乐视网TV版|超级影视"));
    BySelector backButtonS = By.text("退出播放");

    public int count=0;

    @Test
    @CaseName("Live桌面频道切换")
    public void testSwitchChannel() throws UiObjectNotFoundException, RemoteException {
        addStep("进入Live");
        gotoHomeScreen("首页");
        UiObject2 ok_button = waitForObj(By.text("确定"));
        if (ok_button != null) {
            verify("not found ok_button",ok_button != null);
            ok_button.click();
            ok_button.click();
        }
        try{
            SwitchChannel();
        }
        catch (Exception e){
                failCount(count, getIntParams("Loop"), e.getMessage());
        }
    }
    public void SwitchChannel() throws UiObjectNotFoundException, RemoteException{
            addStep("通过频道加减键");
            press_ch_up(GenerateRandom(10));
            press_ch_down(2);
            press_ch_down(GenerateRandom(10));
            press_ch_up(2);
            addStep("播放10s");
            sleepInt(10);
            press_back(1);
            addStep("通过数字小键盘换台");
            press_keyevent(1,KEY_NUM0);
            sleepInt(3);
            press_keyevent(1,KEY_NUM2);
            sleepInt(3);
            press_keyevent(1,KEY_NUM4);
            sleepInt(3);
            press_keyevent(1,KEY_NUM5);
            sleepInt(3);
            press_keyevent(1,KEY_NUM9);
            sleepInt(3);

            addStep("通过频道列表换台");
            press_center(1); //打开频道列表
            press_up(GenerateRandom(20));
            press_down(GenerateRandom(20));
            addStep("播放10s");
            sleepInt(10);
            press_back(1);

            addStep("退出live");
            press_back(1);
            exitApp();
    }


    @Test
    @CaseName("Live桌面节目单进行点播")
    public void testProgramme() throws UiObjectNotFoundException, RemoteException {
        addStep("进入Live");
        gotoHomeScreen("首页");
        sleepInt(6);
        press_down(1);
        sleepInt(2);
        UiObject2 programmes=waitForObj(By.res("com.letv.android.tv.letvlive:id/programs_title").text("节目单"));
        check("未发现节目单",programmes!=null);
        press_left(5);
        sleepInt(5);
        press_center(1);
        UiObject2 ok = waitForObj(By.text("我知道了"));
        if (ok != null) {
            verify("not found ok_button",ok != null);
            ok.click();
            ok.click();
        }
        sleepInt(10);
        press_back(2);
    }


    @Test
    @CaseName("Live桌面九宫格进行点播")
    public void testNineGrid() throws UiObjectNotFoundException, RemoteException {
        addStep("切换到live桌面");
        gotoHomeScreen("首页");
        sleepInt(2);
            try {
                NineGrid();
            } catch (Exception e) {

                failCount(count++, getIntParams("Loop"), e.getMessage());
            }
        }
    public void NineGrid()throws UiObjectNotFoundException,RemoteException{
        //遥控器指示按键
        UiObject2 ok_button =waitForObj(By.text("确定"));
//        if (ok_button !=null){
//            verify("not found ok_button",ok_button != null);
//            ok_button.click();
//            ok_button.click();
//            }
            addStep("进入九宫格播放页面");
            press_center(1);
            press_left(3);
            press_up(2);
            press_down(1);
            press_center(1);
            press_right(2);
            sleepInt(1);
            press_center(1);
//            addStep("九宫格小窗口切换播放3分钟");
//            for(int i = 0 ; i < 3; i++) {
//                press_right(GenerateRandom(3));
//                press_down(GenerateRandom(5));
//                sleepInt(10);
//                press_left(GenerateRandom(3));
//                press_up(GenerateRandom(5));
//                sleepInt(10);
//            }
            addStep("返回全屏播放");
            press_back(1);
        }










    public void updateAPP() {
        UiObject2 update = phone.findObject(By.clazz("android.widget.Button").textContains("升级"));
        if (update!=null) {
            addStep("更新乐视视频应用");
            update.click();
            sleepInt(30);
            UiObject2 confirm = phone.findObject(By.clazz("android.widget.Button").textContains("确定"));
            if (confirm!=null) {
                confirm.click();
                sleepInt(5);
            }
            UiObject2 install = phone.findObject(By.clazz("android.widget.Button").textContains("安装"));
            if (install!=null) {
                install.click();
                sleepInt(15);
            }
            UiObject2 open = phone.findObject(By.clazz("android.widget.Button").textContains("打开"));
            if (open!=null) {
                open.click();
                sleepInt(5);
            }
            addStep("重新打开点播桌面");
            gotoHomeScreen("视频|乐见");
            sleepInt(5);
            UiObject2 play = phone.findObject(By.text(Pattern.compile("视频|乐见")));
            verify("Not on the VOD desktop", play!=null);
            play.click();
            sleepInt(5);
            press_center(1);
        }
    }
    public void checkAccountLogin(){
        UiObject2 loginNow = phone.findObject(By.clazz("android.widget.Button").text("立即登录"));
        if(loginNow!=null) {
            addStep("登录会员");
            loginNow.click();
            sleepInt(2);
            UiObject2 loginNow2 = phone.findObject(By.clazz("android.widget.Button").text("立即登录"));
            check("can't find loginNow.", loginNow2 != null);
            loginNow2.click();
            sleepInt(2);
            UiObject2 MTBFAccount = phone.findObject(By.text(Pattern.compile("MTBF.*")));
            if(MTBFAccount!=null){
                check("can't find loginNow.", MTBFAccount != null);
                MTBFAccount.click();
                sleepInt(2);
                UiObject2 passwd = phone.findObject(By.text("密        码")).getParent().findObject(By.clazz("android.widget.EditText"));
                if(passwd!=null){
                    passwd.setText(getStrParams("PASSWORD"));
                    sleepInt(1);
                }
            }else {
                UiObject2 login = phone.findObject(By.text(Pattern.compile(".*添加帐号.*|.*帐号密码登录.*|.*帐号登录.*")));
                if (login!=null) {
                    login.click();
                    sleepInt(2);
                }
                sleepInt(2);
                UiObject2 userName = phone.findObject(By.text("乐视帐号")).getParent().findObject(By.clazz("android.widget.EditText"));
                check("can't find userName.", userName != null);
                userName.setText(getStrParams("USERNAME"));
                sleepInt(2);
                press_down(1);
                UiObject2 passwd = phone.findObject(By.text("密        码")).getParent().findObject(By.clazz("android.widget.EditText"));
                check("can't find passwd.", passwd != null);
                passwd.setText(getStrParams("PASSWORD"));
                sleepInt(1);
                UiObject2 loginNow1 = phone.findObject(By.clazz("android.widget.Button").text("立即登录"));
                check("can't find loginNow.", loginNow1 != null);
                loginNow.click();
                sleepInt(1);
            }
        }
    }
    public void exitsportdeskPlay() {
        for (int j = 0; j < 6; j++) {
            press_back(1);
            UiObject2 exitPlay = phone.findObject(By.text(Pattern.compile("退出播放|是")));
            if (exitPlay != null) {
                sleepInt(2);
                exitPlay.click();
            }
            UiObject2 coming = phone.findObject(By.text(Pattern.compile("即将上映.*")));
            if (coming != null) break;
        }
    }


    public void enterLive() throws UiObjectNotFoundException {

        addStep("进入Live");
        UiObject2 homePage = waitForObj(By.text("首页"));
        if(homePage == null) {
            press_right(3);
            homePage = waitForObj(By.text("首页"));
            if(homePage == null) {
                press_left(5);
                homePage = waitForObj(By.text("首页"));
            }
        }
        verify("not found Live",homePage != null);
        homePage.click();
        homePage.click();
        sleepInt(20);
        press_right(1);

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

    public void loginAccount(){
        UiObject2 loginNow = phone.findObject(By.text("立即登录"));
        if(loginNow!=null) {
            addStep("登录会员");
            loginNow.click();
            sleepInt(2);
            UiObject2 login = phone.findObject(By.text(Pattern.compile(".*添加帐号.*|.*帐号密码登录.*|.*其他帐号登录.*")));
            if (login!=null) {
                login.click();
                sleepInt(2);
            }
            sleepInt(2);
            UiObject2 userName = phone.findObject(By.text(Pattern.compile("乐视帐号|会员帐号"))).getParent().findObject(By.clazz("android.widget.EditText"));
            verify("can't find userName.", userName != null);
            userName.setText(getStrParams("USERNAME"));
            sleepInt(2);
            press_down(1);
            UiObject2 passwd = phone.findObject(By.text(Pattern.compile("密  .*码"))).getParent().findObject(By.clazz("android.widget.EditText"));
            verify("can't find passwd.", passwd != null);
            passwd.setText(getStrParams("PASSWORD"));
            sleepInt(1);
            UiObject2 loginNow1 = phone.findObject(By.clazz("android.widget.Button").text("立即登录"));
            verify("can't find loginNow.", loginNow1!=null);
            loginNow1.click();
            loginNow1.click();
            sleepInt(3);
        }
    }

    public void PlayVideo() throws UiObjectNotFoundException {
        UiObject2 video=waitForObj(By.res("com.letv.tv:id/item_firstpage_right_1_2"));
        check("未能要播放的视频", video != null);

        video.click();
        video.click();
        press_center(1);

        sleepInt(3);
        addStep("播放任意视频");
        UiObject2 playVideo1 = waitForObj(By.text(Pattern.compile("播放|第.*集")));
        if(playVideo1!=null){
            check("can't find playvideo", playVideo1 != null);
            playVideo1.click();
            sleepInt(40);

            // 跳过会员超高清看
            UiObject2 keepwatching = phone.findObject(By.textContains("无品质继续看"));
            if (keepwatching!=null) {
                addStep("跳过会员超清看");
                keepwatching.click();
                sleepInt(3);
            }

            UiObject2 later = phone.findObject(By.textContains("下次再说"));
            if (later!=null) {
                addStep("不购买会员");
                later.click();
                later.click();
                press_center(1);
                sleepInt(3);
            }
        }else {
            sleepInt(1);
            press_center(1);
            sleepInt(15);
            // 跳过会员超高清看
            UiObject2 keepwatching = phone.findObject(By.textContains("无品质继续看"));
            if (keepwatching!=null) {
                addStep("跳过会员超清看");
                keepwatching.click();
                sleepInt(3);
            }
            UiObject2 later = phone.findObject(By.textContains("下次再说"));
            if (later!=null) {
                addStep("不购买会员");
                later.click();
                later.click();
                press_center(1);
                sleepInt(3);
            }
            sleepInt(10);
        }
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
        sleepInt(1);
        press_back(1);
        press_center(1);

    }
}
