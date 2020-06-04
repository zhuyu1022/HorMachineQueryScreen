package com.hoperun.hormachine.util.scan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Environment;
import android.util.Log;

public class LogUtil {
	/**
	 * 是否可以打log
	 */
	private static final boolean WRITE_LOG = true;

	/**
	 * 常量3
	 */
	private final static int num_3 = 3;

	/**
	 * 是否存储数据
	 */
	private static boolean hasLogFile = false;

	/**
	 * Tag
	 */
	private static String TAG = "LogUtil";
	static {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			hasLogFile = new File(Environment.getExternalStorageDirectory()
					.getAbsolutePath() + "/logfile").exists();
		}
	}

	/**
	 * <默认构造函数>
	 */
	private LogUtil() {
	}

	/**
	 * <一句话功能简述>
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param tag
	 *            tag
	 * @param msg
	 *            msg
	 * @LastModifiedDate：2013-10-18
	 * @author ren_qiujing
	 * @EditHistory：<修改内容><修改人>
	 */
	@SuppressWarnings("unused")
	public static void v(String tag, String msg) {
		if (WRITE_LOG || hasLogFile) {
			String className = "";
			String logInfo = "";

			String v_tag = tag;
			try {
				String fullClassName = Thread.currentThread().getStackTrace()[num_3]
						.getClassName();
				// 获取打印日志所在的类名
				className = fullClassName.substring(fullClassName
						.lastIndexOf(".") + 1);
				// 获取打印日志所在的方法名
				String methodName = Thread.currentThread().getStackTrace()[num_3]
						.getMethodName();
				// 获取日志所在的行号
				int lineNumber = Thread.currentThread().getStackTrace()[num_3]
						.getLineNumber();
				// 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
				logInfo = className + ":" + methodName + "() line("
						+ lineNumber + "):" + msg;

			} catch (Exception e) {
				className = tag;
				logInfo = msg;
				Log.e(TAG, "log error");
			}

			if (v_tag == null || "".equals(v_tag)) {
				v_tag = className;
			}

			Log.v(v_tag, logInfo);
		}
	}

	/**
	 * <一句话功能简述>
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param tag
	 *            tag
	 * @param msg
	 *            msg
	 * @param tr
	 *            tr
	 * @LastModifiedDate：2013-10-18
	 * @author ren_qiujing
	 * @EditHistory：<修改内容><修改人>
	 */
	@SuppressWarnings("unused")
	public static void v(String tag, String msg, Throwable tr) {
		if (WRITE_LOG || hasLogFile) {
			String className = "";
			String logInfo = "";

			String v_tag = tag;
			try {
				String fullClassName = Thread.currentThread().getStackTrace()[num_3]
						.getClassName();
				// 获取打印日志所在的类名
				className = fullClassName.substring(fullClassName
						.lastIndexOf(".") + 1);
				// 获取打印日志所在的方法名
				String methodName = Thread.currentThread().getStackTrace()[num_3]
						.getMethodName();
				// 获取日志所在的行号
				int lineNumber = Thread.currentThread().getStackTrace()[num_3]
						.getLineNumber();
				// 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
				logInfo = className + ":" + methodName + "() line("
						+ lineNumber + "):" + msg;

			} catch (Exception e) {
				className = tag;
				logInfo = msg;
				Log.e(TAG, "log error");
			}

			if (v_tag == null || "".equals(v_tag)) {
				v_tag = className;
			}

			Log.v(v_tag, logInfo, tr);
		}
	}

	/**
	 * <一句话功能简述>
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param tag
	 *            tag
	 * @param msg
	 *            msg
	 * @LastModifiedDate：2013-10-18
	 * @author ren_qiujing
	 * @EditHistory：<修改内容><修改人>
	 */
	@SuppressWarnings("unused")
	public static void d(String tag, String msg) {
		if (WRITE_LOG || hasLogFile) {
			String className = "";
			String logInfo = "";

			String v_tag = tag;
			try {
				String fullClassName = Thread.currentThread().getStackTrace()[num_3]
						.getClassName();
				// 获取打印日志所在的类名
				className = fullClassName.substring(fullClassName
						.lastIndexOf(".") + 1);
				// 获取打印日志所在的方法名
				String methodName = Thread.currentThread().getStackTrace()[num_3]
						.getMethodName();
				// 获取日志所在的行号
				int lineNumber = Thread.currentThread().getStackTrace()[num_3]
						.getLineNumber();
				// 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
				logInfo = className + ":" + methodName + "() line("
						+ lineNumber + "):" + msg;

			} catch (Exception e) {
				className = tag;
				logInfo = msg;
				Log.e(TAG, "log error");
			}

			if (tag == null || "".equals(tag)) {
				v_tag = className;
			}

			Log.d(v_tag, logInfo);
		}
	}

	/**
	 * <一句话功能简述>
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param tag
	 *            tag
	 * @param msg
	 *            msg
	 * @param tr
	 *            tr
	 * @LastModifiedDate：2013-10-18
	 * @author ren_qiujing
	 * @EditHistory：<修改内容><修改人>
	 */
	@SuppressWarnings("unused")
	public static void d(String tag, String msg, Throwable tr) {
		if (WRITE_LOG || hasLogFile) {
			String className = "";
			String logInfo = "";
			String v_tag = tag;
			try {
				String fullClassName = Thread.currentThread().getStackTrace()[num_3]
						.getClassName();
				// 获取打印日志所在的类名
				className = fullClassName.substring(fullClassName
						.lastIndexOf(".") + 1);
				// 获取打印日志所在的方法名
				String methodName = Thread.currentThread().getStackTrace()[num_3]
						.getMethodName();
				// 获取日志所在的行号
				int lineNumber = Thread.currentThread().getStackTrace()[num_3]
						.getLineNumber();
				// 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
				logInfo = className + ":" + methodName + "() line("
						+ lineNumber + "):" + msg;

			} catch (Exception e) {
				className = tag;
				logInfo = msg;
				Log.e(TAG, "log error");
			}

			if (v_tag == null || "".equals(v_tag)) {
				v_tag = className;
			}

			Log.d(v_tag, logInfo, tr);
		}
	}

	/**
	 * <一句话功能简述>
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param tag
	 *            tag
	 * @param msg
	 *            msg
	 * @LastModifiedDate：2013-10-18
	 * @author ren_qiujing
	 * @EditHistory：<修改内容><修改人>
	 */
	@SuppressWarnings("unused")
	public static void i(String tag, String msg) {
		if (WRITE_LOG || hasLogFile) {
			String className = "";
			String logInfo = "";
			String v_tag = tag;
			try {
				String fullClassName = Thread.currentThread().getStackTrace()[num_3]
						.getClassName();
				// 获取打印日志所在的类名
				className = fullClassName.substring(fullClassName
						.lastIndexOf(".") + 1);
				// 获取打印日志所在的方法名
				String methodName = Thread.currentThread().getStackTrace()[num_3]
						.getMethodName();
				// 获取日志所在的行号
				int lineNumber = Thread.currentThread().getStackTrace()[num_3]
						.getLineNumber();
				// 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
				logInfo = className + ":" + methodName + "() line("
						+ lineNumber + "):" + msg;

			} catch (Exception e) {
				className = tag;
				logInfo = msg;
				Log.e(TAG, "log error");
			}

			if (v_tag == null || "".equals(v_tag)) {
				v_tag = className;
			}

			Log.i(v_tag, logInfo);
		}
	}

	/**
	 * <一句话功能简述>
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param tag
	 *            tag
	 * @param msg
	 *            msg
	 * @param tr
	 *            tr
	 * @LastModifiedDate：2013-10-18
	 * @author ren_qiujing
	 * @EditHistory：<修改内容><修改人>
	 */
	@SuppressWarnings("unused")
	public static void i(String tag, String msg, Throwable tr) {
		if (WRITE_LOG || hasLogFile) {
			String className = "";
			String logInfo = "";
			String v_tag = tag;
			try {
				String fullClassName = Thread.currentThread().getStackTrace()[num_3]
						.getClassName();
				// 获取打印日志所在的类名
				className = fullClassName.substring(fullClassName
						.lastIndexOf(".") + 1);
				// 获取打印日志所在的方法名
				String methodName = Thread.currentThread().getStackTrace()[num_3]
						.getMethodName();
				// 获取日志所在的行号
				int lineNumber = Thread.currentThread().getStackTrace()[num_3]
						.getLineNumber();
				// 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
				logInfo = className + ":" + methodName + "() line("
						+ lineNumber + "):" + msg;

			} catch (Exception e) {
				className = tag;
				logInfo = msg;
				Log.e(TAG, "log error");
			}

			if (v_tag == null || "".equals(v_tag)) {
				v_tag = className;
			}

			Log.i(v_tag, logInfo, tr);
		}
	}

	/**
	 * <一句话功能简述>
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param tag
	 *            tag
	 * @param msg
	 *            msg
	 * @param tr
	 *            tr
	 * @LastModifiedDate：2013-10-18
	 * @author ren_qiujing
	 * @EditHistory：<修改内容><修改人>
	 */
	public static void e(String tag, String msg, Throwable tr) {
		String className = "";
		String logInfo = "";
		String v_tag = tag;
		try {
			String fullClassName = Thread.currentThread().getStackTrace()[num_3]
					.getClassName();
			// 获取打印日志所在的类名
			className = fullClassName
					.substring(fullClassName.lastIndexOf(".") + 1);
			// 获取打印日志所在的方法名
			String methodName = Thread.currentThread().getStackTrace()[num_3]
					.getMethodName();
			// 获取日志所在的行号
			int lineNumber = Thread.currentThread().getStackTrace()[num_3]
					.getLineNumber();
			// 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
			logInfo = className + ":" + methodName + "() line(" + lineNumber
					+ "):" + msg;

		} catch (Exception e) {
			className = tag;
			logInfo = msg;
			Log.e(TAG, "log error");
		}

		if (v_tag == null || "".equals(v_tag)) {
			v_tag = className;
		}

		Log.e(v_tag, logInfo, tr);
	}

	/**
	 * <一句话功能简述>
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param tag
	 *            tag
	 * @param msg
	 *            msg
	 * @LastModifiedDate：2013-10-18
	 * @author ren_qiujing
	 * @EditHistory：<修改内容><修改人>
	 */
	public static void e(String tag, String msg) {
		String className = "";
		String logInfo = "";
		String v_tag = tag;
		try {
			String fullClassName = Thread.currentThread().getStackTrace()[num_3]
					.getClassName();
			// 获取打印日志所在的类名
			className = fullClassName
					.substring(fullClassName.lastIndexOf(".") + 1);
			// 获取打印日志所在的方法名
			String methodName = Thread.currentThread().getStackTrace()[num_3]
					.getMethodName();
			// 获取日志所在的行号
			int lineNumber = Thread.currentThread().getStackTrace()[num_3]
					.getLineNumber();
			// 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
			logInfo = className + ":" + methodName + "() line(" + lineNumber
					+ "):" + msg;

		} catch (Exception e) {
			className = tag;
			logInfo = msg;
			Log.e(TAG, "log error");
		}

		if (v_tag == null || "".equals(v_tag)) {
			v_tag = className;
		}

		Log.e(v_tag, logInfo);
	}

	/**
	 * <一句话功能简述>
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param tag
	 *            tag
	 * @param msg
	 *            msg
	 * @LastModifiedDate：2013-10-18
	 * @author ren_qiujing
	 * @EditHistory：<修改内容><修改人>
	 */
	@SuppressWarnings("unused")
	public static void w(String tag, String msg) {
		if (WRITE_LOG || hasLogFile) {
			String className = "";
			String logInfo = "";
			String v_tag = tag;
			try {
				String fullClassName = Thread.currentThread().getStackTrace()[num_3]
						.getClassName();
				// 获取打印日志所在的类名
				className = fullClassName.substring(fullClassName
						.lastIndexOf(".") + 1);
				// 获取打印日志所在的方法名
				String methodName = Thread.currentThread().getStackTrace()[num_3]
						.getMethodName();
				// 获取日志所在的行号
				int lineNumber = Thread.currentThread().getStackTrace()[num_3]
						.getLineNumber();
				// 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
				logInfo = className + ":" + methodName + "() line("
						+ lineNumber + "):" + msg;

			} catch (Exception e) {
				className = tag;
				logInfo = msg;
				Log.e(TAG, "log error");
			}

			if (v_tag == null || "".equals(v_tag)) {
				v_tag = className;
			}

			Log.w(v_tag, logInfo);
		}
	}

	/**
	 * <一句话功能简述>
	 * 
	 * @Description<功能详细描述>
	 * 
	 * @param tag
	 *            tag
	 * @param msg
	 *            msg
	 * @param tr
	 *            tr
	 * @LastModifiedDate：2013-10-18
	 * @author ren_qiujing
	 * @EditHistory：<修改内容><修改人>
	 */
	@SuppressWarnings("unused")
	public static void w(String tag, String msg, Throwable tr) {
		if (WRITE_LOG || hasLogFile) {
			String className = "";
			String logInfo = "";
			String v_tag = tag;
			try {
				String fullClassName = Thread.currentThread().getStackTrace()[num_3]
						.getClassName();
				// 获取打印日志所在的类名
				className = fullClassName.substring(fullClassName
						.lastIndexOf(".") + 1);
				// 获取打印日志所在的方法名
				String methodName = Thread.currentThread().getStackTrace()[num_3]
						.getMethodName();
				// 获取日志所在的行号
				int lineNumber = Thread.currentThread().getStackTrace()[num_3]
						.getLineNumber();
				// 日志信息。包括了 方法名字 行数 时间 以及要打印的信息
				logInfo = className + ":" + methodName + "() line("
						+ lineNumber + "):" + msg;

			} catch (Exception e) {
				className = tag;
				logInfo = msg;
				Log.e(TAG, "log error");
			}

			if (v_tag == null || "".equals(v_tag)) {
				v_tag = className;
			}

			Log.w(v_tag, logInfo, tr);
		}
	}

	private static SimpleDateFormat myLogSdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");// 日志的输出格式
	private static SimpleDateFormat logfile = new SimpleDateFormat("yyyy-MM-dd");// 日志文件格式

	public static void saveLogToFile(String log) {

		File file = new File(Environment.getExternalStorageDirectory() + "/logcat.txt");

		if (file != null && file.length() > 50 * 1024 * 1024) {
			file.delete();
		}

		Date nowtime = new Date();
		String needWriteMessage = myLogSdf.format(nowtime) + "\r\n" + log;
		try {
			// 后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
			FileWriter filerWriter = new FileWriter(file, true);
			BufferedWriter bufWriter = new BufferedWriter(filerWriter);
			bufWriter.write(needWriteMessage);
			bufWriter.newLine();
			bufWriter.close();

			filerWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
