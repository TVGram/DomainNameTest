package com.letv.cases.leui;

import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.letv.common.AppName;
import com.letv.common.CaseName;
import com.letv.common.IntentConstants;
import com.letv.common.LetvTestCase;

import org.junit.Test;


public class APPGameCentreDomain extends LetvTestCase {
    int count=0;

    @Test
    @CaseName("游戏中心菜单列表遍列")
    public void testGameCenterlist()throws UiObjectNotFoundException, RemoteException {
        addStep("打开应用桌面");
        launchApp(AppName.GameCenter, IntentConstants.GameCenter);
        try {
            GameCenterlist();
        }
        catch (Exception e){
            try{
                count++;
                failCount(count,getIntParams("Loop"),e.getMessage());
                launchApp(AppName.GameCenter, IntentConstants.GameCenter);
                GameCenterlist();
            }
            catch (RuntimeException re){
                screenShot();
                junit.framework.Assert.fail(re.getMessage());

            }
        }
        exitApp();
    }
    public void GameCenterlist()throws UiObjectNotFoundException,RemoteException{
            addStep("进入游戏中心");
            press_up(1);
            String arr[] = {"推荐", "排行", "视频", "分类", "运动派", "体感"};
            for (int i = 0; i < arr.length; i++) {
                addStep("进入"+arr[i]+"列表");
                UiObject2 list = waitForObj(By.text(arr[i]));
                list.click();
                sleepInt(2);
                press_down(4);
                press_right(1);
                sleepInt(3);
            }
        }
}
