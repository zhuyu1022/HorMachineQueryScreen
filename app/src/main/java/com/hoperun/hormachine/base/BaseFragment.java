/*
 * File name:  BaseFragment.java
 * Copyright:  Copyright (c) 2006-2014 hoperun Inc,  All rights reserved
 * Description:  <描述>
 * Author:  ren_qiujing
 * Last modified date:  2014-5-5
 * Version:  <版本编号>
 * Edit history:  <修改内容><修改人>
 */
package com.hoperun.hormachine.base;

import android.os.Handler;
import android.os.Message;

import androidx.fragment.app.Fragment;


/**
 * <一句话功能简述>
 * 
 * @Description<功能详细描述>
 * 
 * @author ren_qiujing
 * @Version [版本号, 2014-5-5]
 */
public abstract class BaseFragment extends Fragment {

	public abstract void onKYScanListen(String resetStr);
	public abstract Object backValue();
	public abstract boolean onKeyBackDown();
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

			if (errorCode == 0) {
				onPostHandle(requestType, retObj, true);
			} else {
				onPostHandle(requestType, retObj, false);
			}
			super.handleMessage(msg);
		}

	};

	abstract public void onPostHandle(int requestType, Object objBody,
			boolean error);

}
