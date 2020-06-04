package com.hoperun.hormachine.view;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class TipsDialogFragment extends DialogFragment {
	
	private static View view;
	
	/**
	 * Create a new instance of TipsDialogFragment
	 * @return
	 */
	
	public static TipsDialogFragment newInstance(View v) {
		view = v;
		TipsDialogFragment fragment = new TipsDialogFragment();
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setStyle(STYLE_NO_TITLE, 0);
	}
	
	@Override
	public void onStart() {
		// 设置自定义的view
		
		if(view != null) {
			getDialog().setContentView(view);
		}
		// 背景设为透明色
		getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		super.onStart();
	}
}
