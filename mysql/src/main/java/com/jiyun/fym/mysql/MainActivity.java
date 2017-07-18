package com.jiyun.fym.mysql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Bean.IntegBean.InfoListBean> list = new ArrayList<>();
    private ListView listview;
    private String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "http://172.16.45.16:8080/jsonstring/qingqiu.json";
                try {
                    URL u = new URL(url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) u.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String string = "";
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((string = bufferedReader.readLine()) != null) {
                            stringBuffer.append(string);
                        }
                        st = stringBuffer.toString();
                        Log.e("tag", st);
                        Gson gson = new Gson();
                        final Bean bean = gson.fromJson(st, Bean.class);
                        list.addAll(bean.getInteg().getInfoList());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                MyAdapter adapter = new MyAdapter(MainActivity.this, list);
                                listview.setAdapter(adapter);
                            }
                        });
                        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                listview.removeView(view);
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
    }
}
