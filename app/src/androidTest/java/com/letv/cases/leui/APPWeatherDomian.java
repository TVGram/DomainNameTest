package com.letv.cases.leui;

import android.content.pm.LauncherApps;
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
import java.util.Random;
import java.util.regex.Pattern;


/**
 * Created by wangyaxiu on 2016/12/23.
 */

public class APPWeatherDomian extends  LetvTestCase{
   int count = 0;

    @Test
    @CaseName("应用桌面操作天气应用")
    public void testWeatherApp() throws UiObjectNotFoundException, RemoteException{
            try {
                addStep("打开应用桌面，进入天气应用");
                gotoHomeScreen("应用");
                launchApp(AppName.Weather, IntentConstants.WeatherCIBN);

                //更新天气和切换城市
                Weather();

                addStep("退出天气应用");
                press_back(2);
            } catch (Exception e) {
                try {
                    count++;
                    failCount(count, getIntParams("Loop"), e.getMessage());
                    addStep("打开应用桌面，进入天气应用");
                    //gotoHomeScreen("应用");
                    launchApp(AppName.Weather, IntentConstants.WeatherCIBN);

                    //更新天气和切换城市
                    Weather();

                    addStep("退出天气应用");
                    press_back(2);

                } catch (RuntimeException re) {
                    screenShot();
                    org.junit.Assert.fail(re.getMessage());
                }
            }

        }
    public String Weather() throws UiObjectNotFoundException, RemoteException {
        String cityName = null;
        addStep("更新天气");
        sleepInt(1);
        press_menu(1);
        press_up(1);
        UiObject2 update = phone.findObject(By.clazz("android.widget.TextView").text(Pattern.compile("更新|刷新")));
        if (update == null) sleepInt(1);
        check("更新和城市按钮不存在", update != null);
        update.click();
        sleepInt(5);

        addStep("切换城市");
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                press_menu(1);
                press_up(1);
                press_down(1);
                UiObject2 city = phone.findObject(By.clazz("android.widget.TextView").text("城市"));
                city.click();
                sleepInt(2);
                press_down(2);
                press_down(GenerateRandom(4));
                press_right(GenerateRandom(4));
                UiObject2 selectCity = phone.findObject(By.res(Pattern.compile("com.stv.weather:id/grid_city_text|sina.mobile.tianqitongstv:id/grid_city_text")).focused(true));
                cityName=selectCity.getText();
                addStep("查看"+cityName+"的天气");
                press_center(1);
                sleepInt(5);
                UiObject2 newCity=waitForObj(By.text(cityName));
                check("已选择的城市天气没有加载成功",newCity!=null);
            }
        }
        sleepInt(5);

        return cityName;
    }
}
