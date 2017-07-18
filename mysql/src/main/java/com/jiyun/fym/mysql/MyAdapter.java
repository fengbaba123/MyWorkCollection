package com.jiyun.fym.mysql;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by 冯玉苗 on 2017/7/2.
 */

public class MyAdapter extends BaseAdapter {
    String imguri = "http://172.16.45.16:8080/photo/";
    private Context context;
    private ArrayList<Bean.IntegBean.InfoListBean> list;

    public MyAdapter(Context context, ArrayList<Bean.IntegBean.InfoListBean> list) {
        this.context = context;
        this.list = list;
        Log.e("dgkjslsdjklasdhfklgja", list.size() + "");
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder viewholder = null;
        if (convertView == null) {
            viewholder = new Viewholder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            viewholder.imageView = (ImageView) convertView.findViewById(R.id.image_item);
            viewholder.title = (TextView) convertView.findViewById(R.id.title_item_item);
            viewholder.provide = (TextView) convertView.findViewById(R.id.provide);
            convertView.setTag(viewholder);
        } else {
            viewholder = (Viewholder) convertView.getTag();
        }
        viewholder.provide.setText(list.get(position).getIntegral());
        viewholder.title.setText(list.get(position).getGoods_name());
        Glide.with(context).load(imguri + list.get(position).getIma_url()).into(viewholder.imageView);
        return convertView;
    }

    class Viewholder {
        ImageView imageView;
        TextView title;
        TextView provide;
    }
}

