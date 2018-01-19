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

import org.junit.Test;

import java.util.regex.Pattern;


public class APPSearchDomain extends LetvTestCase {
    int count = 0;

    @Test
    @CaseName("进入应用搜索")
    public void testAPPSearchPoster() throws UiObjectNotFoundException, RemoteException {
        try {
//            AppSearch();
            SearchPoster();
        } catch (Exception e) {
            try {
                count++;
                failCount(count, getIntParams("Loop"), e.getMessage());
//                AppSearch();
                SearchPoster();
            } catch (RuntimeException re) {
                screenShot();
                junit.framework.Assert.fail(re.getMessage());
            }
        }
        press_back(4);
    }
    public void SearchPoster() throws UiObjectNotFoundException, RemoteException {
        launchApp(AppName.LeSo, IntentConstants.LeSo);
        press_down(4);
        press_right(4);
        press_down(1);
        press_left(4);
        press_down(2);
        press_up(4);
        press_back(3);
    }

    public void AppSearch()throws UiObjectNotFoundException, RemoteException{
        addStep("搜索");
        gotoHomeScreen("应用");
        press_down(5);
        UiObject2 watchingHot=waitForObj(By.res("com.stv.plugin.app:id/cellview_label").text("万象搜索"));
        watchingHot.click();
        watchingHot.click();
    }
}
