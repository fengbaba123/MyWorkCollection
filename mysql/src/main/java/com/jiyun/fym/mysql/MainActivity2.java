package com.jiyun.fym.mysql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {


    private TextView result;
    private String name;
    private String title;
    private int id;
    private Sqllite sqllite;
    private Button insert;
    private Button delete;
    private Button update;
    private Button query;
    private SQLiteDatabase readableDatabase;
    private ListView listview;
    private ArrayList<String> list;
    private int anInt;
    private String name1;
    private String title1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sqllite = new Sqllite(this, "ch.db", null, 1);
        readableDatabase = sqllite.getReadableDatabase();
        list = new ArrayList<>();
        initView();
    }

    private void insert() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "黄宣");
        contentValues.put("title", "中国香港");
        readableDatabase.insert("lxy", null, contentValues);
    }

    private void query() {
        list.clear();
        Cursor ma = readableDatabase.query("lxy", null, null, null, null, null, null);

        while (ma.moveToNext()) {
//            String string = ma.getString(0);
            name1 = ma.getString(1);
//            title1 = ma.getString(2);
           list.add(name1);
        }
        refresh();
        ma.close();
    }
        private void refresh(){
            ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list);
            arrayAdapter.notifyDataSetChanged();
            listview.setAdapter(arrayAdapter);

        }

    private void initView() {
        listview = (ListView) findViewById(R.id.listview);
        insert = (Button) findViewById(R.id.insert);
        delete = (Button) findViewById(R.id.delete);
        update = (Button) findViewById(R.id.update);
        query = (Button) findViewById(R.id.query);
        result = (TextView) findViewById(R.id.result);
        insert.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        query.setOnClickListener(this);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                readableDatabase.delete("lxy","name=?",new String[]{list.get(position)});
                refresh();
                query();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                insert();
                break;
            case R.id.delete:
                deleted();
                break;
            case R.id.update:
                ContentValues contentValues=new ContentValues();
                contentValues.put("name","景甜");
                    readableDatabase.update("lxy",contentValues,"name=?",new String[]{"黄宣"});
                break;
            case R.id.query:
                query();
                break;
        }
    }

    private void deleted() {

    }
}
