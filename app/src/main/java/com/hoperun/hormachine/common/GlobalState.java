/*
 * File name:  GlobalState.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  extends Android framework for define global state of this application.</br>It can be used by any context
 *              of this application</br>(need get/set method).  
 * Author:  Midnight
 * Last modified date:  2013-8-20
 * Version:  1.0
 * Edit history:  1.新建 -Midnight
 */
package com.hoperun.hormachine.common;

import android.app.Application;

import com.hoperun.hormachine.util.ExceptionManager.CrashHandler;

/**
 * 该类用于存放phone ，pad 共用的静态变量，GlobalState为继承Application的类
 * 注意在存储时，将该变量一并存储到sharePreference中，以便在内容消耗殆尽时，可以从本地获取该数据
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-11-12]
 */
public class GlobalState extends Application {
	/**
	 * GlobalState 单例，给外部使用
	 */
	private static GlobalState instance = null;
	/**
	 * 存储sharepreferen的名称
	 */
	private final String share_name = "data";

	/**布票最大重量**/
	private String maxRequireWeight;

//	public void setmaxRequireWeight(String maxRequireWeight) {
//		this.maxRequireWeight = maxRequireWeight;
//		setValue("maxRequireWeight", maxRequireWeight);
//	}
//	public String getmaxRequireWeight() {
//		if (TextUtils.isEmpty(maxRequireWeight)) {
//			maxRequireWeight = (String) getVaule("maxRequireWeight", "");
//		}
//		return maxRequireWeight;
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 获取单例
	 * @LastModifiedDate：2013-10-18
	 * @author wang_ling
	 * @EditHistory：<修改内容><修改人>
	 */
	public static GlobalState getInstance() {
		if (null == instance) {
			instance = new GlobalState();
		}
		return instance;
	}

//	public void setValue(String key, Object value) {
//
//		SharedPreferencesUtils.setValueToSharePre(this, share_name, key,
//				value);
//	}
//
//	public Object getVaule(String key, Object defValue) {
//		return SharedPreferencesUtils.getValeFromSharePre(this, share_name,
//				key, defValue);
//	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		GlobalState.setApplication(this);

		CrashHandler crashHandler = CrashHandler.getInstance();
		crashHandler.init(getApplicationContext());

	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
	}

	/**
	 * 
	 * 设置instance
	 * 
	 * @Description 设置instance
	 * 
	 * @param app
	 *            app
	 * @LastModifiedDate：2013-10-18
	 * @author wang_ling
	 * @EditHistory：<修改内容><修改人>
	 */
	public static void setApplication(Application app) {
		instance = (GlobalState) app;
	}
}
