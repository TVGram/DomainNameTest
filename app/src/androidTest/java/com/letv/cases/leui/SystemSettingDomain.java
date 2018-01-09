package com.letv.cases.leui;

import android.os.Build;
import android.os.RemoteException;
import android.provider.Contacts;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.LetvTestCase;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.regex.Pattern;


public class SystemSettingDomain extends LetvTestCase {

    int count = 0;

    @Test
    @CaseName("设置网络播放测速")
    public void testSettingNetwork() throws UiObjectNotFoundException, RemoteException {
        gotoHomeScreen("应用");
        addStep("切换到应用桌面通过按键打开设置");
        for (int Loop = 0; Loop < getIntParams("Loop"); Loop++) {
            try {
                SettingNetwork();
            } catch (Exception e) {
                try {
                    count++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    gotoHomeScreen("应用");
                    addStep("切换到应用桌面通过按键打开设置");
                    SettingNetwork();
                } catch (RuntimeException re) {
                    screenShot();
                    junit.framework.Assert.fail(re.getMessage());
                }

            }
            press_back(3);
        }

    }
    public void SettingNetwork() throws UiObjectNotFoundException, RemoteException {
        phone.pressKeyCode(KEY_SETTING);
        sleepInt(1);
        addStep("进入系统设置网络");
        for (int i = 0; i < 6; i++) {
            UiObject2 network = waitForObj(By.res("com.stv.globalsetting:id/letv_setting_base_network"));
            if (network != null) {
                check("没有找到系统设置", network != null);
                network.click();
                break;
            } else {
                press_down(1);
            }
        }
        press_down(5);
        UiObject2 playspeed=waitForObj(By.res("eui.tv:id/textView").text("播放测速"));
        check("未进入播放测速",playspeed!=null);
        playspeed.click();
        playspeed.click();
        press_right(1);
        UiObject2 bt_start=waitForObj(By.res("com.stv.globalsetting:id/bt_start").text("开始测速"));
        check("未进入开始测速",bt_start!=null);
        bt_start.click();
        bt_start.click();
        sleepInt(33);
        press_back(3);
    }



    @Test
    @CaseName("设置网络诊断")
    public void testSettingNetworkDiagnose() throws UiObjectNotFoundException, RemoteException {
        gotoHomeScreen("应用");
        addStep("设置网络诊断");
        for (int Loop = 0; Loop < getIntParams("Loop"); Loop++) {
            try {
                SettingNetworkDiagnose();
            } catch (Exception e) {
                try {
                    count++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    gotoHomeScreen("应用");
                    addStep("切换到应用桌面通过按键打开设置");
                    SettingNetworkDiagnose();
                } catch (RuntimeException re) {
                    screenShot();
                    junit.framework.Assert.fail(re.getMessage());
                }

            }
            press_back(3);
        }

    }
    public void SettingNetworkDiagnose() throws UiObjectNotFoundException, RemoteException {
        phone.pressKeyCode(KEY_SETTING);
        sleepInt(1);
        addStep("设置网络诊断");
        for (int i = 0; i < 6; i++) {
            UiObject2 network = waitForObj(By.res("com.stv.globalsetting:id/letv_setting_base_network"));
            if (network != null) {
                check("没有找到系统设置", network != null);
                network.click();
                break;
            } else {
                press_down(1);
            }
        }
        press_down(4);
        UiObject2 detection=waitForObj(By.res("eui.tv:id/textView").text("网络诊断"));
        check("未进入播放测速",detection!=null);
        detection.click();
        detection.click();
        press_right(2);
        UiObject2 detection_btn=waitForObj(By.res("com.stv.globalsetting:id/detection_btn").text("开始诊断"));
        check("未进入开始测速",detection_btn!=null);
        detection_btn.click();
        detection_btn.click();
        sleepInt(33);
        press_back(3);
    }
}

