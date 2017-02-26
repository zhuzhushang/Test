package com.uyac.test.widget;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.PopupWindow;

import com.uyac.test.R;

import java.lang.reflect.Field;


/**
 * 退款/退货原因选择器
 *
 * @author wangyang
 */
public class ChooseRetuanMoneyReasonPop extends PopupWindow implements OnClickListener, OnValueChangeListener {

    private Context context;
    /***/
    private View view;
    /**
     * 下标
     */
    private int currentYear = 0;
    /**
     * 内容
     */
    private String[] years = {""};
    /**
     * 滚动日期控件
     */
    private QNumberPicker npReson;
    /**
     * 阴影层
     */
    private View viewShade;

    public ChooseRetuanMoneyReasonPop(Context context) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.pop_choose_return_money, null);
        viewShade = view.findViewById(R.id.v_pop_shade);
        view.findViewById(R.id.btn_ok).setOnClickListener(this);
        // 点击有效区域外则退出pop
        view.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int hight = view.findViewById(R.id.pop_layout).getTop();
                int point = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (point < hight) {
                        dismiss();
                    }
                }
                return true;
            }
        });

        npReson = (QNumberPicker) view.findViewById(R.id.np_reason);
        npReson.setOnValueChangedListener(this);
        npReson.setDisplayedValues(years);
        npReson.setMinValue(0);
        npReson.setMaxValue(years.length - 1);
        npReson.setValue(currentYear);
        npReson.setWrapSelectorWheel(true);
        npReson.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        setNumberPickerDividerColor(npReson, 0xffadabaa,context.getResources().getDimensionPixelOffset(R.dimen.divider_06));
        setContentView(view);
        setWidth(LayoutParams.MATCH_PARENT);
        setHeight(LayoutParams.MATCH_PARENT);
        setFocusable(true);
//		setAnimationStyle(R.style.AnimBottom);
        setBackgroundDrawable(new ColorDrawable(0));
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }


    /**
     * 设置NumberPicker分割线颜色和高度
     *
     * @param numberPicker：NumberPicker
     * @param color：分割线颜色  16位
     * @param heigth 分割线高度  px
     */
    public static void setNumberPickerDividerColor(NumberPicker numberPicker, int color,int heigth) {
        Field[] pickerFields = NumberPicker.class.getDeclaredFields();
        //分割线颜色
        for (Field SelectionDividerField : pickerFields) {
            if (SelectionDividerField.getName().equals("mSelectionDivider")) {
                SelectionDividerField.setAccessible(true);
                try {
                    SelectionDividerField.set(numberPicker, new ColorDrawable(color));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

        // 分割线高度
        for (Field pf : pickerFields) {
            if (pf.getName().equals("mSelectionDividerHeight")) {
                pf.setAccessible(true);
                try {

                    pf.set(numberPicker, heigth);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
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
                    pf.set(picker, ContextCompat.getColor(context, R.color.red));
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

    public void setData(String[] ye) {
        years = ye;
        npReson.setOnValueChangedListener(this);
        npReson.setDisplayedValues(years);
        npReson.setMinValue(0);
        npReson.setMaxValue(years.length - 1);
        npReson.setValue(currentYear);
        npReson.setWrapSelectorWheel(false);
        npReson.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        // TODO Auto-generated method stub
        viewShade.setVisibility(View.GONE);
        super.showAtLocation(parent, gravity, x, y);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(200);
                viewShade.startAnimation(anim);
                viewShade.setVisibility(View.VISIBLE);
            }
        }, 300);

    }

    @Override
    public void dismiss() {
        // TODO Auto-generated method stub
        AlphaAnimation anim = new AlphaAnimation(1.0f, 0.0f);
        anim.setDuration(200);
        anim.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
                viewShade.setVisibility(View.GONE);
                ChooseRetuanMoneyReasonPop.super.dismiss();
            }
        });
        viewShade.startAnimation(anim);
    }

    /**
     * 点击监听
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btn_ok:
                if (onReason != null) {
                    onReason.getSelect(years[currentYear]);
                }
                dismiss();
                break;
        }
    }

    /**
     * 监听选中
     */
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        // TODO Auto-generated method stub
        currentYear = newVal;

    }

    public OnReason onReason;

    public void setOnReason(OnReason onReason) {
        this.onReason = onReason;
    }

    public interface OnReason {
        public void getSelect(String content);
    }
}
