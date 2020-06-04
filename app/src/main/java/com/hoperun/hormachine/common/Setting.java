package com.hoperun.hormachine.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Xml;


public class Setting {

 //  private static String URL = "http://192.168.136.31:802/FKMService.svc";

    /**
     * 现场环境
     **/
  // private static String URL = "http://10.10.151.50:8001/FKMService.svc";
    //外网测试环境
   private static String URL = "http://58.213.72.26:27493/FKMService.svc";
    //陈兴
     //private static String URL = "http://10.20.40.99:27493/FKMService.svc";
   // private static String URL = "http://10.20.40.17:27493/FKMService.svc";



    public static String OPT_FLAG = "OPT_FLAG";
    public static String MSG_INFO = "MSG_INFO";

    // 后台问题可能存在超时10秒的情况，需要延长一下

    private static int SOCKET_TIMEOUT = 60000;

    private static int REQUEST_RATE = 10000;
    private static int FRESH_PAGE_RATE = 10000;

    public static String TYPE_CP = "0";
    public static String TYPE_XB = "1";

    public static String mCurrentTM = "";
    public static String mCurrentHYH = "";
    public static String mCurrentHH = "";

    public static String getUrl() {
        return URL;
    }

    public static int getSocketTimeout() {
        return SOCKET_TIMEOUT;
    }

    public static int getRequestRate() {
        return REQUEST_RATE;
    }

    public static int getPageRate() {
        return FRESH_PAGE_RATE;
    }

    private static void setUrl(String url) {
        URL = url;
    }





}
