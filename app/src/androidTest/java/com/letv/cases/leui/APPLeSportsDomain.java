package com.letv.cases.leui;

import android.os.Build;
import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.IntentConstants;
import com.letv.common.LetvTestCase;

import junit.framework.Assert;

import org.junit.Test;

import java.util.regex.Pattern;

public class APPLeSportsDomain extends LetvTestCase {

    int count = 0;
//    @Override
//    public void setUp() throws Exception {
//        super.setUp();
//        phone.registerWatcher("nexTime", nexTime);
//    }

//    @Override
//    public void tearDown() throws Exception {
//        super.tearDown();
//        phone.removeWatcher("nexTime");
//    }





//    private final UiWatcher nexTime = new UiWatcher() {
//        public boolean checkForCondition() {
//            UiObject2 nextTime = phone.findObject(By.text(Pattern.compile("下次再说|暂不领取|关闭弹窗")));
//            if (nextTime != null) {
//                nextTime.click();
//                nextTime.click();
//                sleepInt(5);
//                return true;
//            } else {
//                return false;
//            }
//        }
//    };

    //退出桌面赛事
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


    @Test
    @CaseName("从应用进入超级体育")
    public void testLanuchSport() throws UiObjectNotFoundException, RemoteException {
      try{
          LanuchSport();
      }
      catch (Exception e){
          try{
              count++;
              failCount(count,getIntParams("Loop"),e.getMessage());
              LanuchSport();
          }
          catch (RuntimeException re){
              screenShot();
              Assert.fail(re.getMessage());
          }
      }
    }
    public void LanuchSport()throws UiObjectNotFoundException,RemoteException{
        addStep("进入超级体育");
        launchApp(AppName.LeSports, IntentConstants.LeSports);
        upgrade();
        press_right(5);
        addStep("退出超级体育");
        press_back(1);
        sleepInt(2);
        exitAppt();
}


    @Test
    @CaseName("超级体育视频反复播放")
    public void testEntryMatch() throws UiObjectNotFoundException ,RemoteException{
        addStep("进入超级体育");
        launchApp(AppName.LeSports, IntentConstants.LeSports);
        upgrade();
        press_right(1);
        sleepInt(1);
        try{
            EntryMatch();
        }
        catch (Exception e){
            try{
                count++;
                failCount(count,getIntParams("Loop"),e.getMessage());
                addStep("进入超级体育");
                launchApp(AppName.LeSports, IntentConstants.LeSports);
                EntryMatch();
            }
            catch (RuntimeException re){
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
    }
    public void EntryMatch() throws UiObjectNotFoundException,RemoteException{
            addStep("进入赛事");
            sleepInt(2);
            UiObject2 playing = waitForObj(By.res("com.lesports.tv:id/lesports_tab_game_hall").text("比赛大厅"));
            verify("未进入比赛大厅",playing !=null);
            playing.click();
            press_down(3);
            press_center(1);
            sleepInt(10);
            press_back(1);//退出播放
            addStep("退出赛事播放");
            UiObject2 exitplaying =waitForObj(By.text(Pattern.compile("退出播放")));
            if (exitplaying !=null) {
                exitplaying.click();
                exitplaying.click();
                sleepInt(1);
            }
            else {
                press_left(1);
                press_center(1);
                sleepInt(1);
            }
        press_back(3);
        sleepInt(1);
        exitAppt();
    }



    public void PersonData() throws RemoteException, UiObjectNotFoundException {
        addStep("进入用户信息界面");
        press_up(1);
        press_right(6);
        UiObject2 persondata =phone.findObject(By.res(Pattern.compile("com.lesports.tv:id/iv_navigation_user_avatar")));
        UiObject2 login1=waitForObj(By.res("com.lesports.tv:id/tv_navigation_login").text("登录"));
        if (persondata != null){
            check("未进入用户信息界面",persondata!=null);
            persondata.click();
            persondata.click();
        }
        else if(login1!=null){
            check("未进入用户登录界面",login1!=null);
            login1.click();
            login1.click();
            AccountLogin938();
//            sleepInt(1);
            press_right(1);
            UiObject2 persondata2 = waitForObj(By.res(Pattern.compile("com.lesports.tv:id/iv_navigation_user_avatar")));
            check("未进入用户信息界面2",persondata2!=null);
            persondata2.click();
            persondata2.click();
        }
        press_right(3);
    }
    public void AccountLogin938() throws UiObjectNotFoundException,RemoteException{
        UiObject2 letvAccount = waitForObj(By.clazz("android.widget.TextView").text(Pattern.compile("帐号.*|帐户: .*|超级电视帐号|会员帐号")));
        check("can't find letvAccount.", letvAccount!=null);
        sleepInt(1);
        for(int j=0;j<3;j++){
            UiObject2 accountUsed = phone.findObject(By.text("选择要登录的帐号"));     //删除帐号登陆
            if (accountUsed != null){
                press_right(1);
                check("there is no account loged in before", accountUsed != null);
                press_menu(1);
                sleepInt(1);
                UiObject2 delAccount = phone.findObject(By.res(Pattern.compile("eui.tv:id/list_item_1_title|com.stv.t2.account:id/menu_item_delete")));
                check("there is no account loged in before", delAccount != null);
                sleepInt(1);
                delAccount.click();
                sleepInt(1);
                UiObject2 confirm = phone.findObject(By.text("确定"));
                check("delete account note don't exists", confirm != null);
                confirm.click();
                sleepInt(1);
            }else {
                break;
            }
        }
        UiObject2 quitBtn1 = phone.findObject(By.clazz("android.widget.TextView").text("退出登录"));   //退出帐号登陆
        if (quitBtn1!=null) {
            addStep("已存在乐视帐号，退出登录");
            press_right(5);
            press_center(1);
            sleepInt(2);
            UiObject2 confirm = phone.findObject(By.clazz("android.widget.Button").text(Pattern.compile("确定|退出")));
            check("can't find confirm.", confirm != null);
            confirm.click();
            sleepInt(4);
        }
        UiObject2 login = null;
        for (int a=0;a<3;a++){
            login = phone.findObject(By.text(Pattern.compile("添加帐号|帐号密码登录|.*帐号登录.*")));//其他帐号登录注册
            if (login!=null) {
                addStep("使用账号密码登录");
                login.click();
                sleepInt(2);
                break;
            }
//            launchApp(AppName.LeAccount,IntentConstants.LeAccount);
            SuperTV();
        }
        if(Build.DEVICE.contains("U4")){
            press_back(1);
        }
        sleepInt(2);
        UiObject2 userName = phone.findObject(By.text(Pattern.compile("乐视帐号|会员帐号|超级电视帐号|帐        号"))).getParent().findObject(By.clazz("android.widget.EditText"));
        check("can't find userName.", userName != null);
        userName.setText(getStrParams("USERNAME"));
        sleepInt(2);
        press_down(1);

        UiObject passwd1=phone.findObject(new UiSelector().className("android.widget.EditText").instance(1));

        check("can't find passwd.", passwd1!=null);
        sleepInt(2);
        passwd1.setText(getStrParams("PASSWORD"));
        sleepInt(1);
        UiObject2 loginNow = phone.findObject(By.clazz("android.widget.Button").text("立即登录"));
        check("can't find loginNow.", loginNow!=null);
        sleepInt(1);
        UiObject2 cancelBtn = phone.findObject(By.clazz("android.widget.TextView").text("取消"));
        loginNow.click();
        //loginNow.click();
        sleepInt(1);
        press_center(1);
        for(int i=0;i<120;i++){
            sleep(1);
            UiObject2 quitBtn = phone.findObject(By.clazz("android.widget.TextView").text("退出登录"));
            if(quitBtn!=null){
                break;
            }
        }
        if (cancelBtn!=null) {
            cancelBtn.click();
            sleepInt(4);
        }

    }
    public void SuperTV(){
        gotoHomeScreen("应用");
        press_down(3);
        addStep("进入乐视帐号");
        UiObject2 superTV = waitForObj(By.res("com.stv.plugin.app:id/cellview_label").text("超级电视帐号"));
        check("未进入乐视帐号",superTV!=null);
        superTV.click();
        superTV.click();
        sleepInt(2);
    }

    //CIBN超级体育升级
    public void upgrade(){
        UiObject2 upgrade =waitForObj(By.text("升级"));
        UiObject2 upgradeok =waitForObj(By.text("确定"));
        if(upgradeok!=null&&upgrade !=null){
            check("安装按钮不存在", upgradeok != null);
            clickAndWaitForNewWindow(upgradeok);
            UiObject2 nowintall=waitForObj(By.text(Pattern.compile("现在安装")),30000L);
            check("网络不稳定安装未成功", nowintall != null);
            nowintall.click();
        }
        UiObject2 nowintall=waitForObj(By.text(Pattern.compile("现在安装")));
        if(nowintall!=null){
            check("未进入现在安装", nowintall != null);
            nowintall.click();
            sleepInt(3);
        }
    }
    //CIBN超级体育退出
    public void exitAppt(){
        press_back(1);
        sleepInt(2);
        UiObject2 exitok=waitForObj(By.res("com.stv.bootadmanager:id/btn_app_exit_exit").text(Pattern.compile("退出.*")));
        if(exitok!=null){
            press_down(1);
            exitok.click();
            exitok.click();
            sleepInt(2);
        }
        else{
            press_center(1);
            sleepInt(2);
        }
    }

}