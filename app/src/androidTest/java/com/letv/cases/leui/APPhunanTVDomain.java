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

public class APPhunanTVDomain extends LetvTestCase {
        int count=0;

        @Test
        @CaseName("进入APP芒果TV")
        public void testHunanTV() throws UiObjectNotFoundException, RemoteException {
            gotoHomeScreen("应用");
        try{
            HunanTV();
        }
        catch (Exception e){
            try{
                count++;
                failCount(count,getIntParams("Loop"),e.getMessage());
                HunanTV();
            }
            catch (RuntimeException re){
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
        press_back(5);
         }
        public void HunanTV() throws UiObjectNotFoundException, RemoteException {
            addStep("进入APP芒果TV");
            launchApp(AppName.Hunantv, IntentConstants.Hunantv);
            sleepInt(10);
            press_right(5);
         }

}
