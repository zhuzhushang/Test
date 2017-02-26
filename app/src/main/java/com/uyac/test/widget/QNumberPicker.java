package com.uyac.test.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.uyac.test.R;

import java.lang.reflect.Field;

public class QNumberPicker extends NumberPicker {

//	private Context

	public QNumberPicker(Context context) {
		super(context);
	}

	public QNumberPicker(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public QNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public void addView(View child) {
		super.addView(child);
		updateView(child);
	}

	@Override
	public void addView(View child, int index,
						android.view.ViewGroup.LayoutParams params) {
		super.addView(child, index, params);
		updateView(child);
	}

	@Override
	public void addView(View child, android.view.ViewGroup.LayoutParams params) {
		super.addView(child, params);
		updateView(child);
	}

	public void updateView(View view) {
		if (view instanceof EditText) {
			// 这里修改字体的属性
			((EditText) view).setTextColor(this.getResources().getColor(
					R.color.red));
			// ((EditText) view).setTextSize();
		}
	}

	/**
	 * 设置分割线颜色
	 * 
	 * @param numberPicker
	 */
	public void setNumberPickerDividerColor(NumberPicker numberPicker) {
		NumberPicker picker = numberPicker;
		Field[] pickerFields = NumberPicker.class.getDeclaredFields();
		for (Field pf : pickerFields) {
			if (pf.getName().equals("mSelectionDivider")) {
				pf.setAccessible(true);
				try {
					// 设置分割线的颜色值
					pf.set(picker, ContextCompat.getColor(getContext(),R.color.red));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (Resources.NotFoundException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

}