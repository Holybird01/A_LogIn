package com.bigademo.datetimepicker.wheel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;



import com.bigademo.datetimepicker.wheel.TYWheelView;
import com.bigademo.datetimepicker.wheel.adapter.TYArrayWheelAdapter;
import com.bigademo.datetimepicker.wheel.listener.TYOnItemSelectedListener;
import com.bigademo.tony.signin.R;

import java.util.ArrayList;
import java.util.List;

public class TYSingleCheckWheel2 extends TYBasePickerView implements View.OnClickListener {
	private OnJobSelectListener2 jobSelectListener2;
	private View btnSubmit, btnCancel;
	private static final String TAG_SUBMIT = "submit";
	private static final String TAG_CANCEL = "cancel";
	private TextView tvTitle;
	private TYWheelView wvLooper;
	private int currentindex;
	private ArrayList<String> list = new ArrayList<String>();

	public TYSingleCheckWheel2(Context context) {
		super(context);
		LayoutInflater.from(context).inflate(R.layout.pickerview_single_jobs, contentContainer);
		// -----确定和取消按钮
		btnSubmit = findViewById(R.id.btnSubmit);
		btnSubmit.setTag(TAG_SUBMIT);
		btnCancel = findViewById(R.id.btnCancel);
		btnCancel.setTag(TAG_CANCEL);
		// 滚轮
		wvLooper = (TYWheelView) findViewById(R.id.job);
		btnSubmit.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		// 顶部标题
		tvTitle = (TextView) findViewById(R.id.tvTitle);
		TYArrayWheelAdapter<String> TYArrayWheelAdapter = new TYArrayWheelAdapter<String>(list);
		wvLooper.setAdapter(TYArrayWheelAdapter);
		wvLooper.setTextSize(14);
		wvLooper.setCyclic(false);
		wvLooper.setOnItemSelectedListener(new TYOnItemSelectedListener() {

			@Override
			public void onItemSelected(int index) {
				currentindex = index;
			}
		});
	}

	@Override
	public void onClick(View arg0) {
		String tag = (String) arg0.getTag();
		if (tag.equals(TAG_CANCEL)) {
			dismiss();
			return;
		} else {
			dismiss();
			if (jobSelectListener2 != null) {
				jobSelectListener2.onJobSelect(currentindex);
			}
			return;
		}
	}

	public interface OnJobSelectListener2 {
		public void onJobSelect(int index);
	}

	public void setJobSelectListener2(OnJobSelectListener2 jobSelectListener) {
		this.jobSelectListener2 = jobSelectListener;
	}

	public void setTitle(String title) {
		tvTitle.setText(title);
	}

	public void setData(List<String> list) {
		if (list != null) {
			this.list.addAll(list);
			TYArrayWheelAdapter<String> TYArrayWheelAdapter = new TYArrayWheelAdapter<String>(this.list);
			wvLooper.setAdapter(TYArrayWheelAdapter);
		}
	}
	
}
