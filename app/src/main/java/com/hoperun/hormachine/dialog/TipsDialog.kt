package com.hoperun.hormachine.dialog


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class TipsDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, 0)
    }

    override fun onStart() {
        // 设置自定义的view

        if (view != null) {
            dialog!!.setContentView(view!!)
        }
        // 背景设为透明色
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //3秒后关闭
        Handler().postDelayed(Runnable { dismiss() }, 3000)

        super.onStart()
    }


    companion object {

        private var view: View? = null

        /**
         * Create a new instance of TipsDialogFragment
         * @return
         */

        fun newInstance(v: View): TipsDialog {
            view = v
            return TipsDialog()
        }
    }
}
