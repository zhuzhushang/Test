package com.uyac.test.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uyac.test.R;
import com.uyac.test.model.TestModel;

import java.util.List;

/**
 * Created by Administrator on 2017/1/30.
 */

public class MyBaseAdapter  extends BaseAdapter {




    private Context context;
    private LayoutInflater inflater;
    private List<TestModel> list;
    private int layoutID;

    public  MyBaseAdapter(Context context,List<TestModel> list,int layoutID)
    {
        this.context = context;
        this.list = list;
        this.layoutID = layoutID;
        inflater = LayoutInflater.from(this.context);

    }


    public List<TestModel> getList() {
        return list;
    }


    public void setList(List<TestModel> list) {
        this.list = list;

        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return null == list?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null == list?null:list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub


        ViewHolder viewHolder;
        TestModel model = list.get(position);

        if(convertView == null)
        {
            convertView = inflater.inflate(layoutID, null);
            viewHolder = new ViewHolder();
            viewHolder.initView(convertView);

            Log.e("----------","convertView == null");
            convertView.setTag(viewHolder);

        }else
        {
            Log.e("!!!!!!!!!!","!!!!!!!!!!!!!!!!");

            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv.setText(model.getName());

        return convertView;
    }


    public class ViewHolder
    {


        private TextView tv;


        private void initView(View convertView)
        {

            tv = (TextView) convertView.findViewById(R.id.item_test_tv);

        }

    }

}
