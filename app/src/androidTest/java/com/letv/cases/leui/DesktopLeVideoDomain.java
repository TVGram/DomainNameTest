package com.letv.cases.leui;

import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiWatcher;

import com.letv.common.CaseName;
import com.letv.common.LetvTestCase;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DesktopLeVideoDomain extends LetvTestCase {
    int count=0;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        phone.registerWatcher("continueSee",continueSee);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        phone.removeWatcher("continueSee");
    }


    private final UiWatcher continueSee = new UiWatcher() {
        public boolean checkForCondition() {
            UiObject2 continueSeeing = phone.findObject(By.text(Pattern.compile("无品质继续.*")));
            if (continueSeeing !=null) {
                press_right(1);
                continueSeeing.click();
                continueSeeing.click();
                sleepInt(5);
                return true;
            } else {
                return false;
            }
        }
    };

    @Test
    @CaseName("进入桌面管理调整桌面乐见")
    public void testDeskSwitchLeVideo() throws UiObjectNotFoundException, RemoteException {
        addStep("进入管理桌面");
        gotoHomeScreen("应用");
        UiObject2 deskManager = waitForObj(By.res("com.stv.launcher:id/manager_bt"));
        check("桌面管理没有找到", deskManager != null);
        deskManager.click();
        deskManager.click();
        sleepInt(1);
        try {
//              if (LetvUI(6.5)){
            DeskSwitchLeVideo();
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
                DeskSwitchLeVideo();
            } catch (RuntimeException re) {
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
            press_back(2);
        }
    }
    public void DeskSwitchLeVideo() throws UiObjectNotFoundException, RemoteException {

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
            UiObject2 launchLeVideo = waitForObj(By.res("com.stv.launcher:id/tv_title").text("乐见")).getParent();
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
    @CaseName("视频桌面播放视频")
    public void testDesktopLeVideoPlay() throws UiObjectNotFoundException , RemoteException {
        gotoHomeScreen("乐见");
        press_back(3);
        press_down(1);
            try {
                LeVideoPlay();
            }catch (Exception e){
                try {
                    count ++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    gotoHomeScreen("乐见|视频");
                    press_down(1);
                    UiObject2 poster2=waitForObj(By.res("com.stv.plugin.video:id/poster_small_1"));
                    check("视频桌面没有找到海报", poster2 != null);
                    poster2.click();
                    poster2.click();
                    sleepInt(2);
                    updateAPP();
                    LeVideoPlay();
                }catch (RuntimeException re){
                    screenShot();
                    junit.framework.Assert.fail(re.getMessage());
                }
            }
        press_back(3);
    }
    public void LeVideoPlay() throws UiObjectNotFoundException , RemoteException {
        addStep("在视频桌面选择任意海报，进入");
        updateAPP();
        press_down(1);
        UiObject2 poster_small_3=waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.video:id/poster_small_3"));
        check("视频桌面没有找到海报", poster_small_3 != null);
        poster_small_3.click();
        poster_small_3.click();
        sleepInt(2);
        addStep("打开视频详情");
        UiObject2 play1 = waitForObj(By.text(Pattern.compile("第.*集|.*播放|预告")));
        if(play1!=null){
            check("Not open video detail", play1 != null);
            play1.click();
        }
        sleepInt(10);
        checkAccountLogin();
        sleepInt(5);
        addStep("返回点播桌面");
        exitApp();
        sleepInt(2);
        press_back(3);
    }


    @Test
    @CaseName("进入视频桌面海报浏览")
    public void testDesktopLePosters() throws UiObjectNotFoundException , RemoteException {
        gotoHomeScreen("乐见");
        press_back(3);
        try {
            LePosters();
        }catch (Exception e){
            try {
                count ++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("乐见|视频");
                LePosters();
            }catch (RuntimeException re){
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
        press_back(3);
    }
    public void LePosters() throws UiObjectNotFoundException , RemoteException {
        addStep("进入视频桌面海报浏览");
        press_down(1);
        press_center(1);
        sleepInt(3);
        exitApp();
        press_back(3);
        for(int j=0;j<8;j++) {
            for (int i = 0; i < 3; i++) {
                press_down(4+j);
                press_right(i);
                press_center(1);
                sleepInt(4);
                press_home(1);
                press_back(3);
                desktopVodplay();
            }
        }
    }

    @Test
    @CaseName("视频桌面搜索")
    public void testDesktopLeVideoSearch() throws UiObjectNotFoundException , RemoteException {
        gotoHomeScreen("乐见");
        press_back(3);
        try {
            LeVideoSearch();
        }catch (Exception e){
            try {
                count ++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("乐见|视频");
                LeVideoSearch();
            }catch (RuntimeException re){
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
        press_back(3);
    }
    public void LeVideoSearch() throws UiObjectNotFoundException , RemoteException {
        addStep("进入乐见搜索");
        press_down(2);
        UiObject2 poster_no_title_2=waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.video:id/poster_no_title_2"));
        check("未进乐见入搜索",poster_no_title_2!=null);
        poster_no_title_2.click();
        poster_no_title_2.click();
        sleepInt(2);
        press_back(3);
    }


    @Test
    @CaseName("视频桌面视频分类")
    public void testDeskLeVideoClassification() throws UiObjectNotFoundException , RemoteException {
        gotoHomeScreen("乐见");
        press_back(3);
        try {
            LeVideoClassification();
        }catch (Exception e){
            try {
                count ++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("乐见|视频");
                LeVideoClassification();
            }catch (RuntimeException re){
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
        press_back(3);
    }
    public void LeVideoClassification() throws UiObjectNotFoundException , RemoteException {
        addStep("进入乐见内容分类");
        press_down(2);
        UiObject2 poster_no_title_3=waitForObj(By.clazz("android.widget.FrameLayout").res("com.stv.plugin.video:id/poster_no_title_3"));
        check("未进入乐见内容分类",poster_no_title_3!=null);
        poster_no_title_3.click();
        poster_no_title_3.click();
        sleepInt(2);
        press_back(3);
    }


















    public void desktopVodplay()throws UiObjectNotFoundException, RemoteException{
        UiObject2 desktop1=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("乐见")).selected(true));
        UiObject2 desktop2=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("乐见")).focused(true));
        verify("没有返回到视频桌面", desktop1 != null || desktop2 != null);
    }



















    public void initClarity() throws UiObjectNotFoundException , RemoteException {
        gotoHomeScreen("视频|乐见");
        sleepInt(5);
        press_down(2);
        checkAccountLogin();
        addStep("进入视频桌面的搜索");
        UiObject2 search1 = waitForObj(By.res("com.stv.plugin.video:id/poster_no_title_2"));
        UiObject2 search2 = waitForObj(By.res("com.stv.plugin.video:id/poster_no_title_2"));
        verify("没有找到乐见桌面的搜索框",search1!=null||search2!=null);
        if(callShell("getprop ro.product.uitype").contains("cibn")){
            search2.click();
            search2.click();
        }else {
            search1.click();
            search1.click();
        }
        sleepInt(1);
        for (int i=0;i<3;i++) {
            UiObject2 update = phone.findObject(By.res("com.letv.leso:id/update"));
            if (update != null) {
                update.click();
                sleepInt(10);
            }
        }
        addStep("搜索WMNCQ，得到电视剧武媚娘传奇");
        // 首拼音搜索 武媚娘传奇
//        press_center(2);
        UiObject2 clear=phone.findObject(By.res("com.letv.leso:id/searchboard_clear_btn"));
        if(clear!=null){
            clear.click();
            clear.click();
        }

        UiObject2 W = waitForObj(By.clazz("android.widget.TextView").text("W"));
        UiObject2 M = waitForObj(By.clazz("android.widget.TextView").text("M"));
        UiObject2 N = waitForObj(By.clazz("android.widget.TextView").text("N"));
        UiObject2 C = waitForObj(By.clazz("android.widget.TextView").text("C"));
        UiObject2 Q = waitForObj(By.clazz("android.widget.TextView").text("Q"));
        W.click();W.click();M.click();M.click();N.click();N.click();C.click();C.click();Q.click();Q.click();
        sleepInt(1);

        addStep("进行播放视频，播放5分钟");
        UiObject2 playSets = waitForObj(By.text(Pattern.compile("武媚娘传奇.*")));
        verify("武媚娘传奇不存在",playSets!=null);
        playSets.click();
        sleepInt(1);
        press_right(1);
        press_center(2);
        sleepInt(3);
        UiObject2 advertising=phone.findObject(By.text("立即领取"));
        if(advertising!=null){
            press_right(2);
            press_center(1);
        }

        UiObject2 playDetail = waitForObj(By.clazz("android.widget.TextView").text("详情"));
        verify("未进入详情页", playDetail!=null);
        UiObject2 playNo = waitForObj(By.text(Pattern.compile("第.*集|播放")));
        String strPlayNo = playNo.getText();
        int num = getNumber(strPlayNo);
        press_center(1);
    }
    //截取字符串中的数字
    private int getNumber(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return Integer.parseInt(matcher.group(0));
        }
        return 0;
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
}
