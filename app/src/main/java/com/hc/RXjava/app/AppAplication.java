package com.hc.RXjava.app;

import android.app.Application;

import com.hc.RXjava.ServerUtils.ServerConfig;

import commonlibrary.hyx.com.baselibrary.BaseConfig;
import commonlibrary.hyx.com.baselibrary.Constants;
import commonlibrary.hyx.com.baselibrary.HttpHead.HeadUtils;
import commonlibrary.hyx.com.baselibrary.HttpHead.HttpHeader;
import commonlibrary.hyx.com.baselibrary.HttpHead.InitData;
import commonlibrary.hyx.com.baselibrary.Utils.BaseSPUtil;
import commonlibrary.hyx.com.baselibrary.Utils.Uniqueidentifier;

/**
 * @author statham
 * @Email statham@maizuo.com
 * @date 2016/10/31 0031 15:40
 * @Description:
 */
public class AppAplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Uniqueidentifier un = new Uniqueidentifier(this);
        String EId = un.getDeviceID();

        InitData data = new InitData("m360","31","31","4.9",EId);

        BaseConfig.getInstance().InitBaseData(getApplicationContext(),data, ServerConfig.PHONEURI);
        HeadUtils.getInstance().init(getApplicationContext(),null,null,HeadUtils.getInstance().getHeaderObject());

    }


    //退出进程是调用
    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
