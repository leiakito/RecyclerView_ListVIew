package com.example.recyclerview.adapters;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.beans.ItemBean;

import java.util.List;

/*
    Author:leia
    Write The Code Change The World    
*/public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {
    private static final String TAG = "ListViewAdapter";
    private final List<ItemBean> mData;

    //构造方法 将IteamBean中的数据传过来
    public ListViewAdapter(List<ItemBean> data) {
        Log.d(TAG, "构造方法,在运行时自动执行");
        this.mData = data;
    }

    @NonNull
    @Override
    //这个方法是创建条目的view
    public ListViewAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                          int viewType) {
        //传进去的这个view就是条目的界面
        //两个步骤
        //1.拿到View 所谓的适配器 View.inflate 第一个参数为 parent.getContext()上下文对象
        // 第二个参数为 适配xml表 第三个为ViewGroup是否管理
        //return 返回一个InnerHolder对象 参数为view 我们设置的xml文件对象
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return new InnerHolder(view);
    }

    //这个方式是用于绑定holder一般用来设置数据
    @Override
    public void onBindViewHolder(@NonNull ListViewAdapter.InnerHolder holder, int position) {
            //在这里设置数据
            holder.setData(mData.get(position));
    }

    //返回条目个数
    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView icon;
        private final TextView title;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            //找到条目的控件
            icon = itemView.findViewById(R.id.list_view_icon);
            title = itemView.findViewById(R.id.list_view_title);

        }
        //这个方法用于设置数据
        public void setData(ItemBean itemBean) {
            //开始设置数据
            icon.setImageResource(itemBean.icon);
            title.setText(itemBean.title);
        }
    }
}
