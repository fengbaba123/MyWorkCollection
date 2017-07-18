package com.jiyun.fym.myworkcollection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private String s;
    private int i=1;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();

    }

    private void initData() {
        final String ur="http://101.200.142.201/MyListLoadAuto/listload?userName=xingming&pageSize=10&page="+i;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url=new URL(ur);
                    HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                        InputStream inputStream=httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                        StringBuffer stringbuffer=new StringBuffer();
                    String string = "";
                        while ((string=bufferedReader.readLine())!=null){
                            stringbuffer.append(string);
                        }
                        s=stringbuffer.toString();
                        Log.e("TAG-------",s);
                        Gson gson=new Gson();
                        final Bean bean = gson.fromJson(s, Bean.class);
                        final List<Bean.IntegBean.InfoListBean> infoList = bean.getInteg().getInfoList();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter = new MyAdapter(MainActivity.this,infoList);
                                listview.setAdapter(adapter);
                            }
                        });
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void initView() {
        listview = (ListView) findViewById(R.id.listview);
        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                  if (scrollState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                        if (view.getLastVisiblePosition()==view.getCount()-1){
                             i++;
                            if (i<=3){
                                initData();
                            }

                        }
                  }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }
}
