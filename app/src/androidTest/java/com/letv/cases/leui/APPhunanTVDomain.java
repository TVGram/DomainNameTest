package com.letv.cases.leui;


import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.IntentConstants;
import com.letv.common.LetvTestCase;

import junit.framework.Assert;

import org.junit.Test;

public class APPhunanTVDomain extends LetvTestCase {
        int count=0;

        @Test
        @CaseName("进入儿童TV反复进入与切换画面")
        public void testChileSwichover() throws UiObjectNotFoundException, RemoteException {
        try{
            ChileSwichover();
        }
        catch (Exception e){
            try{
                count++;
                failCount(count,getIntParams("Loop"),e.getMessage());
                ChileSwichover();
            }
            catch (RuntimeException re){
                screenShot();
                Assert.fail(re.getMessage());
            }
        }
        press_back(5);
    }
    public void ChileSwichover() throws UiObjectNotFoundException, RemoteException {
        addStep("进入儿童TV");
        launchApp(AppName.hunantv, IntentConstants.hunantv);

    }

}
