package com.hoperun.hormachine.net;

import org.json.JSONObject;

import android.os.Handler;

public class RequestServiceImpl {

    /**
     * 登录请求
     *
     * @param handler
     * @param account  员工工号
     * @param password 密码
     */
    public static void login(Handler handler, int requestType, String account, String password) {

        JSONObject inputInfo = new JSONObject();

        try {
            inputInfo.put("YHM", account);
            inputInfo.put("YHKL", password);
        } catch (Exception e) {
            // TODO: handle exception
        }
        String methodName = "Login_M";

        IServiceImpl.callWebMethod(handler, requestType, inputInfo, methodName);
    }

    /**
     * 无密码登录
     *
     * @param handler
     * @param requestType
     * @param account
     */
    public static void login(Handler handler, int requestType, String account) {

        JSONObject inputInfo = new JSONObject();

        try {
            inputInfo.put("GH", account);

        } catch (Exception e) {
            // TODO: handle exception
        }
        String methodName = "Login_Quick";

        IServiceImpl.callWebMethod(handler, requestType, inputInfo, methodName);
    }


    /**
     * 获取新版本
     *
     * @param handler
     * @param requestType
     */
    public static void getNewVersion(Handler handler, int requestType) {

        JSONObject inputInfo = new JSONObject();

        String methodName = "GetUpgradeInfoByPreserveShop";

        IServiceImpl.callWebMethod(handler, requestType, inputInfo, methodName);
    }

    /**
     * 获取横机保全查询数据
     * @param handler
     * @param requestType
     * @param LCDM
     */
    public static void BQGL_GetBQLCList(Handler handler, int requestType, String LCDM) {

        JSONObject inputInfo = new JSONObject();
        try {
            inputInfo.put("LCDM", LCDM);
        } catch (Exception e) {
            // TODO: handle exception
        }
        String methodName = "BQGL_GetBQLCList";

        IServiceImpl.callWebMethod(handler, requestType, inputInfo, methodName);
    }

}
