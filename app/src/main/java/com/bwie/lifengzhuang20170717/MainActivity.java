package com.bwie.lifengzhuang20170717;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private List<User> mList;
    private CheckBox allChecked;
    private TextView allPrice;
    private ProgressBar mProgressBar;
    private Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                mProgressBar.setVisibility(View.GONE);
                for (int i = 0; i < 10; i++) {
                    mList.add(new User(false,R.mipmap.ic_launcher,20));
                }
            }
        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
        allChecked = (CheckBox) findViewById(R.id.all_check);
        allPrice = (TextView) findViewById(R.id.all_price);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        initData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        mAdapter = new MyAdapter(MainActivity.this,mList);
        mRecyclerView.setAdapter(mAdapter);
        allChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    for (int i = 0; i < mList.size(); i++) {
//                        mList.get(i).setChecked(false);
                        mList.get(i).setChecked(true);
                        mAdapter.notifyDataSetChanged();
                        allPrice.setText("合计"+mList.size()*20);
                    }
                }else{
                    for (int i = 0; i < mList.size(); i++) {
//                        mList.get(i).setChecked(false);
                        mList.get(i).setChecked(false);
                        mAdapter.notifyDataSetChanged();
                        allPrice.setText("合计"+mList.size()*0);
                    }
                }
            }
        });
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int itemCount = recyclerView.getAdapter().getItemCount();
                if(itemCount == 10){
                    mProgressBar.setVisibility(View.INVISIBLE);
                    mHandler.sendEmptyMessageDelayed(0,2000);
                }
            }
        });
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add(new User(false,R.mipmap.ic_launcher,20));
        }
    }
}
