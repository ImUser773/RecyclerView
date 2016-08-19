package com.iamdeveloper.applicationrecyclerview;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView linear,grid,staggered;
    String[] data = {"สวัสดีครับ","เราเคยรู้จักกันหรือป่าว","หน้าตาคุ้นๆ","แต่ผมมองคุณยังไม่ค่อยชัด","เงยหน้าซักนิดให้ผมมิสิทได้รู้จัก","อยากมองยิ่งนัก","ซักวินาทีอยากเห็นหน้า"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onBindView();
        onClickThis();
        onBindRecyclerView();
    }

    void onBindView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        linear = (ImageView) findViewById(R.id.linear);
        grid = (ImageView) findViewById(R.id.grid);
        staggered = (ImageView) findViewById(R.id.staggered);
    }

    void onBindRecyclerView(){
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);

    }

    void onClickThis(){
        linear.setOnClickListener(this);
        grid.setOnClickListener(this);
        staggered.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linear :
                layoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager);
                break;
            case R.id.grid :
                layoutManager = new GridLayoutManager(this,2);
                recyclerView.setLayoutManager(layoutManager);
                break;
            case R.id.staggered :
                layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                break;
        }
    }
}
