package com.hoperun.hormachine.adapter

import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.hoperun.hormachine.R
import com.hoperun.hormachine.entity.ScreenItem


/**
 * 描述：
 * 作者：ZHUYU
 * 日期：2019/9/29 10:35
 */
class ScreenAdapter : BaseQuickAdapter<ScreenItem, BaseViewHolder>(R.layout.list_item) {

    private var mSelected = -1
    private var itemHeight =10
    override fun convert(helper: BaseViewHolder, item: ScreenItem?) {
        val textView = helper.getView<TextView>(R.id.textview)
        textView.text = item?.JTH
        //状态：0-正常 1-呼叫中 2-保全开始 3-保全完成 4-停台
        when (item?.State) {
            "0" -> textView.background = ContextCompat.getDrawable(mContext, R.color.green)
            "1" -> textView.background = ContextCompat.getDrawable(mContext, R.color.blue_light)
            "2" -> textView.background = ContextCompat.getDrawable(mContext, R.color.purpleLight)
            "3" -> textView.background = ContextCompat.getDrawable(mContext, R.color.yellow)
            "4" -> textView.background = ContextCompat.getDrawable(mContext, R.color.red)
        }
        helper.itemView.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, itemHeight)


    }


    fun setitemHeight(height:Int){
        itemHeight=height
    }

    fun setCurrent(index: Int) {
        val lastSelected = mSelected
        mSelected = index
        notifyItemChanged(lastSelected)
        notifyItemChanged(mSelected)
    }
}