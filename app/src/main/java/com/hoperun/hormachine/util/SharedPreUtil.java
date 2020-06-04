package com.hoperun.hormachine.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreUtil {

	public static final String USERBEAN = "userBean";
	/** 保存按钮权限 **/
	public static final String CM0140202 = "CM0140202";
	/** 员工工号 **/
	public static final String YHM = "YHM";
	
	public static final String XTYHID = "XTYHID";
	
	public static final String XM = "XM";
	/**车间***/
	public static final String BMMC = "BMMC";
	public static final String YHBH = "YHBH";
	//角色类型 挡车工，保全工
	public static final String QXMC = "QXMC";


	public static void putValue(Context context, String key, Object value) {
		String type = value.getClass().getSimpleName();
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		if ("Integer".equals(type)) {
			editor.putInt(key, (Integer) value);
		} else if ("Boolean".equals(type)) {
			editor.putBoolean(key, (Boolean) value);
		} else if ("String".equals(type)) {
			editor.putString(key, (String) value);
		} else if ("Float".equals(type)) {
			editor.putFloat(key, (Float) value);
		} else if ("Long".equals(type)) {
			editor.putLong(key, (Long) value);
		}
		editor.commit();
	}

	public static Object getValue(Context context, String key, Object defValue) {
		String type = defValue.getClass().getSimpleName();
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		// defValue为为默认值，如果当前获取不到数据就返回它
		if ("Integer".equals(type)) {
			return sharedPreferences.getInt(key, (Integer) defValue);
		} else if ("Boolean".equals(type)) {
			return sharedPreferences.getBoolean(key, (Boolean) defValue);
		} else if ("String".equals(type)) {
			return sharedPreferences.getString(key, (String) defValue);
		} else if ("Float".equals(type)) {
			return sharedPreferences.getFloat(key, (Float) defValue);
		} else if ("Long".equals(type)) {
			return sharedPreferences.getLong(key, (Long) defValue);
		}
		return null;
	}
}
