package com.letv.cases.leui;

import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.IntentConstants;
import com.letv.common.LetvTestCase;
import com.letv.common.PkgName;

import org.junit.Test;

public class SystemUpLoadDomain extends LetvTestCase {

    @Test
    @CaseName("系统更新")
    public void testSystemUpgrade() throws RemoteException {
        addStep("进入系统更新");
        press_back(3);
        launchApp(AppName.SystemUpdate, IntentConstants.SystemUpdate);
        addStep("点击离线更新");
        UiObject2 offineUpdate = waitForObj(By.text("离线更新"));
        verify("office update button does not exist",offineUpdate!=null);
        offineUpdate.click();
        sleepInt(1);
        offineUpdate = waitForObj(By.text("离线更新"),3000);
        if(offineUpdate != null){
            clickAndWaitForNewWindow(offineUpdate);
        }
        addStep("更新 update.zip");
        UiObject2 update = waitForObj(By.textContains("更新 update.zip"));
        verify("not found update package", update != null);
        update.click();
        sleepInt(1);
        update = waitForObj(By.textContains("更新 update.zip"),3000);
        if(update != null){
            clickAndWaitForNewWindow(update);
        }
        UiObject2 rebootUpdate = null;
        for(int i=0;i<50; i++){
            rebootUpdate = phone.findObject(By.text("重启更新"));
            if (rebootUpdate != null) {
                break;
            }
            sleepInt(5);
        }
        rebootUpdate = phone.findObject(By.text("重启更新"));
        verify("reboot update does not exist", rebootUpdate != null);
        rebootUpdate.click();
        sleepInt(1);
        rebootUpdate = phone.findObject(By.text("重启更新"));
        if(rebootUpdate != null){
            press_center(1);
        }
        addStep("更新成功");
    }
}
