package com.hoperun.hormachine.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.blankj.utilcode.util.GsonUtils
import com.hoperun.hormachine.R
import com.hoperun.hormachine.adapter.ScreenAdapter
import com.hoperun.hormachine.base.BaseActivity
import com.hoperun.hormachine.entity.ScreenResponse
import com.hoperun.hormachine.net.IServiceImpl
import com.hoperun.hormachine.net.RequestServiceImpl
import com.hoperun.hormachine.view.SimpleDialog
import kotlinx.android.synthetic.main.activity_screen_layout.*
import kotlinx.coroutines.*
import kotlin.math.ceil
import kotlin.math.max

class ScreenActivity : BaseActivity() {

    private var mType = ""
    private var mLeftAdapter: ScreenAdapter? = null
    private var mRightAdapter: ScreenAdapter? = null

    //列数
    private var colNum = 7

    //行数
    private var rowNum = 10
    //每页总数
    private var perPageNum=colNum*rowNum
    //翻页时间
    private var pageTime=15000L

    companion object {
        fun actionStart(context: Context, type: String) {
            val intent = Intent(context, ScreenActivity::class.java)
            intent.putExtra("type", type)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_layout)
        initView()
        initDate()
    }


    fun initView() {
        mType = intent?.getStringExtra("type").toString()
        mLeftAdapter = ScreenAdapter()
        mRightAdapter = ScreenAdapter()
        leftRecyclerView.adapter = mLeftAdapter
        rightRecyclerView.adapter = mRightAdapter
        //设置为两列
        leftRecyclerView.layoutManager = GridLayoutManager(this, colNum)
        rightRecyclerView.layoutManager = GridLayoutManager(this, colNum)
        leftRecyclerView.post {
            val itemHeight = leftRecyclerView.height / rowNum
            mLeftAdapter?.setitemHeight(itemHeight)
        }
        rightRecyclerView.post {
            val itemHeight = rightRecyclerView.height / rowNum
            mRightAdapter?.setitemHeight(itemHeight)
        }
        GlobalScope.launch {


        }
    }


    fun initDate() {
        getScreenData()
    }

    fun getScreenData() {
       // showWait()
        RequestServiceImpl.BQGL_GetBQLCList(mMIPHandler, IServiceImpl.BQGL_GetBQLCList, mType)
    }


    @SuppressLint("SetTextI18n")
    fun setDate(screenResponse: ScreenResponse) {

        //车间名称
        workshopNameTv.text = screenResponse.Result?.LCMC
        //总台数
        machineNumTv.text = screenResponse.Result?.ZTS.toString()
        //开台数
        openNumTv.text = screenResponse.Result?.KTS.toString()
        //开台率
        openPercentTv.text = screenResponse.Result?.KTL.toString()+"%"

        //计算总数
        val numLeft=screenResponse.Result?.LeftList?.size!!
        val numRight=screenResponse.Result?.RightList?.size!!
        val num = max(numLeft,numRight)
        //计算总页数
        val pageNum = ceil(num.toFloat() / (rowNum * colNum).toFloat()).toInt()
        var currentPage=1
        GlobalScope.launch(Dispatchers.Main) {
            repeat(pageNum){
                pageTV.text="$currentPage/$pageNum"
                val startIndex= (currentPage-1)*perPageNum
                val endIndex= startIndex+perPageNum

                val startIndexLeft=if(startIndex>numLeft){
                    numLeft
                }else{
                    startIndex
                }
                val endIndexLeft=if(endIndex>numLeft){
                    numLeft
                }else{
                    endIndex
                }
                val startIndexRight=if(startIndex>numRight){
                    numRight
                }else{
                    startIndex
                }
                val endIndexRight=if(endIndex>numRight){
                    numRight
                }else{
                    endIndex
                }

                val leftList=screenResponse.Result?.LeftList.subList(startIndexLeft,endIndexLeft)
                val righttList=screenResponse.Result?.RightList.subList(startIndexRight,endIndexRight)

                mLeftAdapter?.setNewData(leftList)
                mRightAdapter?.setNewData(righttList)
                delay(pageTime)
                currentPage++
               if(currentPage>pageNum){
                   getScreenData()

               }
            }

        }
    }


    override fun onPostHandle(requestType: Int, objBody: Any?, success: Boolean) {
        stopWait()
        if (success) {
            when (requestType) {
                IServiceImpl.BQGL_GetBQLCList -> try {
                    val screenResponse =
                        GsonUtils.fromJson(objBody.toString(), ScreenResponse::class.java)
                    if ("0" == screenResponse.Code) {
                        setDate(screenResponse)
                    } else {
                        toast(screenResponse.Message)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    toast("数据解析异常")
                }

            }
        } else {
            toast(objBody.toString())
        }

    }
}