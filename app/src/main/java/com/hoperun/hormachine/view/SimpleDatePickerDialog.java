package com.hoperun.hormachine.view;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.widget.DatePicker;

public class SimpleDatePickerDialog {
	public static  void setDate(Context context) {
        //初始化日历信息
        Calendar calendar = Calendar.getInstance();
        //获取当前年月日
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        Log.d("setDate", year + "-" + month + "-" + day);
        /**context：当前上下文；
         callback：OnDateSetListener日期改变监听器；
         year：初始化的年；
         monthOfYear：初始化的月（从0开始计数，所以实际应用时需要加1）；
         dayOfMonth：初始化的日；
         */
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = year + "年" + (month + 1) + "月" + dayOfMonth + "日";
               
                
            }
        }, year, month, day);

        datePickerDialog.show();
    }
}
