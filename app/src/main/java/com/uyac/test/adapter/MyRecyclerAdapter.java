package com.uyac.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uyac.test.R;
import com.uyac.test.model.TempModel;

import java.util.List;

/**
 * Created by noah on 2017/4/11.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{

    private Context context;
    private List<TempModel> mList;

    public MyRecyclerAdapter(Context context, List<TempModel> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_recycle_test,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.testView.setText(mList.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView testView;

        public ViewHolder(View itemView) {
            super(itemView);

            testView = (TextView) itemView.findViewById(R.id.textView4);
        }
    }


}
