//package com.hoperun.hormachine.adapter;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import com.hoperun.preparedisplayNew.R;
//import com.hoperun.preparedisplayNew.entity.DisplayEntity;
//import com.hoperun.preparedisplayNew.util.Setting;
//
//import android.content.Context;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.AbsListView;
//import android.widget.BaseAdapter;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//public class SccjAdapter extends BaseAdapter {
//
//	/**
//	 * 行的高度
//	 **/
//	int normalItemHeight = 0;
//
//	Context mContext;
//	List<DisplayEntity> mList = new ArrayList<DisplayEntity>();
//
//	public SccjAdapter(Context context, List<DisplayEntity> list) {
//		mContext = context;
//		mList = list;
//
//	}
//
//	@Override
//	public int getCount() {
//		// TODO Auto-generated method stub
//		return mList.size();
//	}
//
//	@Override
//	public Object getItem(int position) {
//		// TODO Auto-generated method stub
//		return mList.get(position);
//	}
//
//	@Override
//	public long getItemId(int position) {
//		// TODO Auto-generated method stub
//		return position;
//	}
//
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		DisplayEntity displayEntity = (DisplayEntity) getItem(position);
//		View view;
//		final ViewHolder viewholder;
//		if (convertView == null) {
//			view = LayoutInflater.from(mContext).inflate(R.layout.item_layout,
//					parent, false);
//			view.setLayoutParams(new AbsListView.LayoutParams(
//					LayoutParams.MATCH_PARENT, normalItemHeight));
//			viewholder = new ViewHolder(view);
//			view.setTag(viewholder);
//		} else {
//			view = convertView;
//			viewholder = (ViewHolder) view.getTag();
//		}
//
//		// 对应值是STATE里的，0：正常，1：呼叫中，2：保全中，3：保全完成，4：停台
//		// 到时大屏下面分为正常(绿色)、呼叫中(蓝色)、保全中(紫色)、保全完成(黄色)、停台(红色
//		//剩下的是空白
//		switch (displayEntity.getSTATE()) {
//		case "0":
//			viewholder.layout.setBackgroundColor(mContext.getResources()
//					.getColor(R.color.green));
//			break;
//		case "1":
//			viewholder.layout.setBackgroundColor(mContext.getResources()
//					.getColor(R.color.blue_light));
//			break;
//		case "2":
//			viewholder.layout.setBackgroundColor(mContext.getResources()
//					.getColor(R.color.purple));
//			break;
//		case "3":
//			viewholder.layout.setBackgroundColor(mContext.getResources()
//					.getColor(R.color.yellow));
//			break;
//		case "4":
//			viewholder.layout.setBackgroundColor(mContext.getResources()
//					.getColor(R.color.red));
//			break;
//		default:
//			viewholder.layout.setBackgroundColor(mContext.getResources()
//					.getColor(R.color.white));
//			break;
//		}
//		if (!TextUtils.isEmpty(displayEntity.getMACHINENO())) {
//			viewholder.machineNoTv.setText(displayEntity.getMACHINENO());
//		} else {
//			viewholder.machineNoTv.setText("");
//		}
//
//		if (!TextUtils.isEmpty(displayEntity.getSTATEMSG())) {
//			viewholder.stateMsgTv.setText(displayEntity.getSTATEMSG());
//		} else {
//			viewholder.stateMsgTv.setText("");
//		}
//
//		return view;
//	}
//
//	public void setItemHeight(int height) {
//		normalItemHeight = height;
//
//	}
//
//	class ViewHolder {
//
//		LinearLayout layout;
//
//		TextView machineNoTv;
//		TextView stateMsgTv;
//
//		public ViewHolder(View view) {
//			layout = (LinearLayout) view.findViewById(R.id.layout);
//			machineNoTv = (TextView) view.findViewById(R.id.machineNoTv);
//			stateMsgTv = (TextView) view.findViewById(R.id.stateMsgTv);
//		}
//
//	}
//}
