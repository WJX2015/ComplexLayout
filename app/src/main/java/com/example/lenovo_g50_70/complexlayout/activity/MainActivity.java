package com.example.lenovo_g50_70.complexlayout.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.lenovo_g50_70.complexlayout.R;
import com.example.lenovo_g50_70.complexlayout.adapter.ComplexAdapter;
import com.example.lenovo_g50_70.complexlayout.bean.ComplexModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.lenovo_g50_70.complexlayout.bean.ComplexModel.TYPE_THREE;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ComplexAdapter mAdapter;

    private List<ComplexModel> mModels = new ArrayList<>();
    private int[] mColors = {android.R.color.holo_red_dark, android.R.color.holo_blue_dark,
            android.R.color.holo_orange_dark};
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    /**
     * 控件绑定
     */
    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mGridLayoutManager = new GridLayoutManager(this, 2);
        mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                //返回一个Item的跨度，即Item占据的列数
                int type = mRecyclerView.getAdapter().getItemViewType(position);

                if (type == TYPE_THREE) {
                    return mGridLayoutManager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mAdapter = new ComplexAdapter(this, mModels);
        mRecyclerView.setAdapter(mAdapter);

        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i = 0; i < 20; i++) {
            //Math.random()*3  随机生成 0 1 2
            int type = (int) (Math.random() * 3) + 1;
            ComplexModel model = new ComplexModel();
            model.setAvatarColor(mColors[type - 1]);
            model.setType(type);
            model.setName("name:" + i);
            model.setContent("content:" + i);
            model.setContentColor(mColors[(type - 1) % 3]);
            mModels.add(model);
        }
        mAdapter.setDataList(mModels);
    }
}
