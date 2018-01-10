package com.letv.cases.leui;

import android.content.Intent;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.IntentConstants;
import com.letv.common.LetvTestCase;
import com.letv.common.PkgName;

import org.junit.After;
import org.junit.Test;

import java.util.Random;
import java.util.regex.Pattern;



public class APPTVmanagerDomain extends LetvTestCase{
    int count=0;
    @Test
    @CaseName("电视管家测试")
    public void testTVManger()throws UiObjectNotFoundException, RemoteException{
                    try {
                addStep("打开应用桌面，进入电视管家");
                launchApp(AppName.TvManager, IntentConstants.TvManager);
                UiObject2 OneKeyExam = waitForObj(By.res("com.stv.helper.main:id/onekey_exam_label").text(Pattern.compile("一键体检")));
                OneKeyExam.click();
                OneKeyExam.click();
                sleepInt(60);
                press_back(3);
            }catch (Exception e) {
                try {
                    count ++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    addStep("打开应用桌面，进入电视管家");
                    launchApp(AppName.TvManager, IntentConstants.TvManager);
                    UiObject2 OneKeyExam = waitForObj(By.res("com.stv.helper.main:id/onekey_exam_label").text(Pattern.compile("一键体检")));
                    OneKeyExam.click();
                    OneKeyExam.click();
                    sleepInt(60);
                    press_back(3);
                }catch (RuntimeException re) {
                    screenShot();
                    org.junit.Assert.fail(re.getMessage());
                }
            }
    }
}
