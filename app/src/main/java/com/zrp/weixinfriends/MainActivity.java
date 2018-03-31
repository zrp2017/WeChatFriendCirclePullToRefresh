package com.zrp.weixinfriends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.zrp.weixinpulltofresh.adapter.RCommentAdapter;
import com.zrp.weixinpulltofresh.adapter.RCommentViewHolder;
import com.zrp.weixinpulltofresh.view.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private RCommentAdapter<String> mAdapter;
    private List<String> data;
    private RefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.refreshRecyclerview);
        refreshLayout = (RefreshLayout) findViewById(R.id.refreshlayout);
        data = new ArrayList<>();
        data.add("月亮之上");
        data.add("春风里");
        data.add("草原之上");
        data.add("风之子");
        data.add("追风的少年");
        data.add("康定情歌");
        data.add("情人");
        data.add("月亮之上");
        data.add("春风里");
        data.add("草原之上");
        data.add("风之子");
        data.add("追风的少年");
        data.add("康定情歌");
        data.add("情人");
        mAdapter = new RCommentAdapter<String>(this,R.layout.layout_recyclerview_item, data) {

            @Override
            public void convert(RCommentViewHolder vh, int position) {
                vh.setText(R.id.tv,data.get(position));
            }
        };
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        mAdapter.addHeaderView(imageView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(mAdapter);
        refreshLayout.setOnRefreshListener(new RefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);
            }
        });
    }
}
