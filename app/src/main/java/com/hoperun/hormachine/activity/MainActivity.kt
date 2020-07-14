package com.hoperun.hormachine.activity

import android.annotation.SuppressLint
import android.os.Bundle
import com.blankj.utilcode.util.AppUtils
import com.hoperun.hormachine.R
import com.hoperun.hormachine.base.BaseActivity
import com.hoperun.hormachine.common.Setting
import com.hoperun.hormachine.entity.UpdateInfoBizData
import com.hoperun.hormachine.net.IServiceImpl
import com.hoperun.hormachine.net.RequestServiceImpl
import com.hoperun.hormachine.util.MIP_SystemUtils
import com.hoperun.hormachine.util.ParseUtils
import com.hoperun.hormachine.view.SimpleDialog
import com.zhuyu.downloadlibrary.DownloadDialog
import com.zhuyu.downloadlibrary.DownloadDialog.DownloadSimpleListener
import kotlinx.android.synthetic.main.main_activity.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initView()
   getNewVersion()


    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        versionTv.text = "当前版本：" +AppUtils.getAppVersionName()

        secondLl.setOnClickListener{
            ScreenActivity.actionStart(this,"F2")
        }
        thirdLl.setOnClickListener{
            ScreenActivity.actionStart(this,"F3")
        }

    }




    /**
     * 获取新版本
     */
    private fun getNewVersion() {
        showWait()
        RequestServiceImpl.getNewVersion(mMIPHandler, IServiceImpl.GET_NEW_VERSION)
    }


    override fun onPostHandle(requestType: Int, objBody: Any, error: Boolean) {
        stopWait()
        if (error) {
            when (requestType) {
                IServiceImpl.GET_NEW_VERSION -> try {
                    val bizData =
                        ParseUtils.parse(objBody.toString(), UpdateInfoBizData::class.java)
                    if ("0" == bizData.code) {
                        val updateInfo = bizData.result
                        if (updateInfo != null) {
                            val url =
                                Setting.getUrl().substring(0, Setting.getUrl().lastIndexOf("/") + 1) + updateInfo.url
                            val filename = url.substring(url.lastIndexOf("/") + 1)
                            // 文件保存在应用关联缓存目录
                            val filePath = getExternalFilesDir(null).toString() + "/" + filename
                            val version = updateInfo.versionNo
                            val curVersion = AppUtils.getAppVersionName()
                            if (curVersion != version) {
                                SimpleDialog.show(this, "应用有新版本，是否立刻升级？", { }) {
                                    val dowDialog = DownloadDialog.newInstance(url, filePath, false)
                                    dowDialog.setDownloadListener(object : DownloadSimpleListener {
                                        override fun onSuccess() {
                                            AppUtils.installApp(filePath)
                                        }

                                        override fun onError() {
                                            SimpleDialog.show(this@MainActivity, "下载失败！")
                                        }
                                    })
                                    dowDialog.show(supportFragmentManager, "DownLoad")
                                }
                            }
                        }
                    } else {
                        showErrorDialog(bizData.message, "检查新版本失败！")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    toast("数据解析异常")
                }

            }
        } else {
            when (requestType) {
                IServiceImpl.LOGIN_R ->  // showErrorDialog(objBody.toString(), "登录失败");
                    SimpleDialog.show(this, objBody.toString())
            }
        }

    }

}
