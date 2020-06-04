/*
 * File name:  PMIPActivit.java
 * Copyright:  Copyright (c) 2006-2013 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2013-9-12
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.hoperun.hormachine.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hoperun.hormachine.util.SharedPreUtil;
import com.hoperun.hormachine.view.SimpleDialog;
import com.hoperun.hormachine.view.WaitDialog;

/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2013-9-12]
 */
public abstract class BaseActivity extends AppCompatActivity {
	private WaitDialog mWaitDialog;

	protected String TAG = "";
	
	protected String mYHM = "";
	protected String mXTYHID = "";
	protected String mXM = "";
	protected String mYHBH = "";
	//protected String mRYBH = "";
	public boolean isActivityDestroyed() {
		return isActivityDestroyed;
	}

	public void setActivityDestroyed(boolean isActivityDestroyed) {
		this.isActivityDestroyed = isActivityDestroyed;
	}

	protected boolean isActivityDestroyed = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		TAG = this.getClass().getName();
		// 设置界面无标�?
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 设置界面常亮
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		 mWaitDialog = new WaitDialog(this);
		 
		 initData();
		 
		super.onCreate(savedInstanceState);

	}

	
	
	private void  initData() {
		mYHM = (String) SharedPreUtil.getValue(this, "YHM", "");
		mXTYHID = (String) SharedPreUtil.getValue(this, "XTYHID", "");
		mXM= (String) SharedPreUtil.getValue(this, "XM", "");
		mYHBH= (String) SharedPreUtil.getValue(this, "YHBH", "");
		//mRYBH= (String) SharedPreUtil.getValue(this, "RYBH", "");
	}

	
	/**
	 * 显示加载圈圈...
	 */
	public void showWait() {
		mWaitDialog.show();
	}

	/**
	 * 停掉加载圈圈...
	 */
	public void stopWait() {
		mWaitDialog.dismiss();
	}

	/**
	 * 
	 * @param msg
	 * @param defaultMsg
	 */
	public void showErrorMsg(String msg,String defaultMsg) {
		
		if(!TextUtils.isEmpty(msg)){
			toast( msg);
		}else{
			toast( defaultMsg);
		}
		
	}
	
	/**
	 * 
	 * @param msg
	 * @param defaultMsg
	 */
	public void showErrorDialog(String msg,String defaultMsg) {
		
		if(!TextUtils.isEmpty(msg)){
			SimpleDialog.show(this, msg);
		}else{
			SimpleDialog.show(this, defaultMsg);
		}
		
	}
	
	
	
	public void toast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub

		super.onStart();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		isActivityDestroyed = true;
		super.onDestroy();
	}

	protected Handler mMIPHandler = new Handler() {

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.os.Handler#handleMessage(android.os.Message)
		 */
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			int requestType = msg.what;
			int errorCode = msg.arg1;

			Object retObj = msg.obj;
			try {
				if (errorCode == 0) {

					onPostHandle(requestType, retObj, true);

				} else {
					onPostHandle(requestType, retObj, false);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			super.handleMessage(msg);
		}

	};

	abstract public void onPostHandle(int requestType, Object objBody,
			boolean success) throws Exception;
}
