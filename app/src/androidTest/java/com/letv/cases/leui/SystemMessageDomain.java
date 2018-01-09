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
import java.util.regex.Pattern;

public class SystemMessageDomain extends LetvTestCase {
    int count=0;
    @Test
    @CaseName("消息进入")
    public void testMessageEnter()throws UiObjectNotFoundException,RemoteException {
        addStep("进入消息中心");
        launchApp(AppName.Message, IntentConstants.Message);
        sleepInt(5);
        press_back(3);
    }

    @Test
    @CaseName("消息压力测试")
    public void testMessageSwitch()throws UiObjectNotFoundException,RemoteException {
        addStep("消息中心标签切换");
        launchApp(AppName.Message, IntentConstants.Message);
        addStep("进入时间标签");
        UiObject2 time = phone.findObject(By.text(Pattern.compile("时间")));
        check("未进入时间", time != null);
        press_center(1);
        sleepInt(1);
        press_down(1);
        sleepInt(1);
        addStep("进入类型标签");
        UiObject2 type = phone.findObject(By.text(Pattern.compile("类型")));
        check("未进入时间", type != null);
        press_center(1);
        sleepInt(1);
        press_down(1);
        sleepInt(1);
        addStep("进入已读/未读标签");
        UiObject2 message = phone.findObject(By.text(Pattern.compile("已读/未读.*")));
        check("未进入时间", message != null);
        press_center(1);
        sleepInt(1);
        press_up(2);
        sleepInt(1);
        press_back(3);
    }

}




