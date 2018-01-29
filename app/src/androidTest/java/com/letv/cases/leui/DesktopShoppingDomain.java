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
import junit.framework.Assert;
import org.junit.Test;
import java.util.regex.Pattern;


public class DesktopShoppingDomain extends LetvTestCase{
    int count;


    @Test
    @CaseName("进入桌面管理调整桌面购物")
    public void testDeskSwitchShoping() throws UiObjectNotFoundException, RemoteException {
        addStep("进入管理桌面");
        gotoHomeScreen("应用");
        UiObject2 deskManager = waitForObj(By.res("com.stv.launcher:id/manager_bt"));
        check("桌面管理没有找到", deskManager != null);
        deskManager.click();
        deskManager.click();
        sleepInt(1);
        try {
//              if (LetvUI(6.5)){
            DeskSwitchShoping();
//                }else {
//                DeskSwitch();
//                }
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                DeskSwitchShoping();
            } catch (RuntimeException re) {
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
            press_back(2);
        }
    }
    public void DeskSwitchShoping() throws UiObjectNotFoundException, RemoteException {

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
            UiObject2 launchLeVideo = waitForObj(By.res("com.stv.launcher:id/tv_title").text("购物")).getParent();
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
    @CaseName("进入购物桌面海报")
    public void testDesktopLeShopPoster()throws UiObjectNotFoundException,RemoteException {
        gotoHomeScreen("购物");
            try {
                LeShopPoster();
            } catch (Exception e) {
                try {
                    count++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    gotoHomeScreen("购物");
                    LeShopPoster();
                } catch (RuntimeException re) {
                    screenShot();
                    Assert.fail(re.getMessage());
                }
            }
    }
    public void LeShopPoster()throws UiObjectNotFoundException,RemoteException{
        press_back(2);
        addStep("进入购物桌面海报浏览");
        press_down(1);
        UiObject2 child_view0=waitForObj(By.res("com.stv.shopping:id/child_view0"));
        check("未进入面海报浏览0",child_view0!=null);
        child_view0.click();
        child_view0.click();
        sleepInt(1);
        press_back(3);

        press_down(1);
        UiObject2 child_view1=waitForObj(By.res("com.stv.shopping:id/child_view1"));
        check("未进入面海报浏览0",child_view1!=null);
        child_view1.click();
        child_view1.click();
        sleepInt(1);
        press_back(3);


        press_down(1);
        UiObject2 child_view2=waitForObj(By.res("com.stv.shopping:id/child_view2"));
        check("未进入面海报浏览0",child_view2!=null);
        child_view2.click();
        child_view2.click();
        sleepInt(1);
        press_back(3);

        press_down(1);
        UiObject2 child_view6=waitForObj(By.res("com.stv.shopping:id/child_view6"));
        check("未进入面海报浏览0",child_view6!=null);
        child_view6.click();
        child_view6.click();
        sleepInt(1);
        press_back(3);

        press_down(1);
        UiObject2 child_view7=waitForObj(By.res("com.stv.shopping:id/child_view7"));
        check("未进入面海报浏览0",child_view2!=null);
        child_view7.click();
        child_view7.click();
        sleepInt(1);
        press_back(3);

        for (int i=3;i<8;i++) {
            press_down(i);
            int GameDesk = phone.findObject(By.text(Pattern.compile("直降专区"))).getParent().getChildCount()-3;
            check("未进入直降专区", GameDesk != 0);
            for(int j=0;j<GameDesk;j++) {
                press_right(1);
                press_center(1);
                sleepInt(5);
                press_back(1);
            }
            press_back(3);
            desktop();
        }
        press_down(8);
        int GameDesk = phone.findObject(By.text(Pattern.compile("乐范专区"))).getParent().getChildCount()-3;
        check("未进入直降专区", GameDesk != 0);
        press_right(GameDesk);
        press_center(1);
        sleepInt(5);
        press_back(3);
        desktop();
    }

    public void desktop()throws UiObjectNotFoundException, RemoteException{
        sleepInt(4);
        exitApp();
        UiObject2 desktop1=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("购物")).selected(true));
        UiObject2 desktop2=phone.findObject(By.pkg("com.stv.launcher").text(Pattern.compile("购物")).focused(true));
        verify("没有返回到视频桌面", desktop1 != null || desktop2 != null);
    }

    @Test
    @CaseName("进入购物桌面个人中心")
    public void testDesktopLeShopPersonal()throws UiObjectNotFoundException,RemoteException {
        gotoHomeScreen("购物");
        press_down(1);
        try {
            LeShopPersonal();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("购物");
                LeShopPersonal();
            } catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
    }
    public void LeShopPersonal()throws UiObjectNotFoundException,RemoteException{
        addStep("进入购物桌面个人中心");
        press_down(1);
        UiObject2 personCenter=waitForObj(By.res("com.stv.shopping:id/child_view5"));
        check("未进入购物个人中心",personCenter!=null);
        personCenter.click();
        personCenter.click();
        sleepInt(1);
        UiObject2 pleaseLogin=waitForObj(By.text("请登录超级电视帐号"));
        UiObject2 pleaseOk=waitForObj(By.text("确定"));
        if(pleaseLogin!=null&&pleaseOk!=null) {
            pleaseOk.click();
            sleepInt(1);
            AccountLogin();
        }
        press_back(3);
    }


    @Test
    @CaseName("进入购物桌面全部商品")
    public void testDesktopLeShopAllgoods()throws UiObjectNotFoundException,RemoteException {
        gotoHomeScreen("购物");
        press_down(1);
        try {
            LeShopAllgoods();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("购物");
                LeShopAllgoods();
            } catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
    }
    public void LeShopAllgoods()throws UiObjectNotFoundException,RemoteException{
        addStep("进入购物桌面全部商品");
        press_down(2);
        UiObject2 allShop=waitForObj(By.res("com.stv.shopping:id/child_view4"));
        check("未进入全部商品",allShop!=null);
        allShop.click();
        allShop.click();
        sleepInt(1);
        press_back(3);

        addStep("进入购物桌面搜索");
        press_down(2);
        UiObject2 Search=waitForObj(By.res("com.stv.shopping:id/child_view3"));
        check("未进入全部商品",Search!=null);
        Search.click();
        Search.click();
        sleepInt(1);
        press_back(3);

    }


    @Test
    @CaseName("进入购物桌面搜索")
    public void testDesktopLeShopSearch()throws UiObjectNotFoundException,RemoteException {
        gotoHomeScreen("购物");
        press_down(1);
        try {
            LeShopSearch();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
                gotoHomeScreen("购物");
                LeShopSearch();
            } catch (RuntimeException re) {
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
    }
    public void LeShopSearch()throws UiObjectNotFoundException,RemoteException{
        addStep("进入购物桌面搜索");
        press_down(2);
        UiObject2 Search=waitForObj(By.res("com.stv.shopping:id/child_view3"));
        check("未进入全部商品",Search!=null);
        Search.click();
        Search.click();
        sleepInt(1);
        press_back(3);

    }


    public void AccountLogin() throws UiObjectNotFoundException,RemoteException{
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

}
