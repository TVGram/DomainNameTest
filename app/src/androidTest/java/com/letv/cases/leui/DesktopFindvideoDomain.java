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

import java.util.regex.Pattern;

public class DesktopFindvideoDomain extends LetvTestCase {

    int count =0;
    @Test
    @CaseName("乐视视频里下载视频")
    public void testFindvideo() throws UiObjectNotFoundException, RemoteException {
        gotoHomeScreen("找视频");
        press_down(5);

    }


}
