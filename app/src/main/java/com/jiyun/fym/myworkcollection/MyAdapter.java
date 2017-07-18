package com.jiyun.fym.myworkcollection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by 冯玉苗 on 2017/7/2.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Bean.IntegBean.InfoListBean> list;
    private String url;
    private String param;

    public MyAdapter(Context context, List<Bean.IntegBean.InfoListBean> list) {
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
        viewholder.imageView.setTag(list.get(position).getIma_url());
        Async async=new Async(viewholder.imageView);
        async.execute(list.get(position).getIma_url());
//        Glide.with(context).load(list.get(position).getIma_url()).into(viewholder.imageView);
        return convertView;
    }

    class Viewholder {
        ImageView imageView;
        TextView title;
        TextView provide;
    }
    class Async extends AsyncTask<String,Void,Bitmap> {

        private final ImageView imag;
        private Bitmap bitmap;

        public Async(ImageView imageView) {
            this.imag=imageView;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                param = params[0];
                URL url=new URL(param);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode()==200){
                    InputStream inputStream=httpURLConnection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imag.getTag().equals(param)){
                imag.setImageBitmap(bitmap);
            }
        }
    }
}

