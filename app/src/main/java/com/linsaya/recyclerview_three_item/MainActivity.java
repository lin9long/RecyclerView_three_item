package com.linsaya.recyclerview_three_item;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridLayout;

import com.linsaya.recyclerview_three_item.domain.TestDataOne;
import com.linsaya.recyclerview_three_item.domain.TestDataThree;
import com.linsaya.recyclerview_three_item.domain.TestDataTwo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private DemoAdapter adapter;
    int colorList[] = {android.R.color.holo_blue_light,
            android.R.color.holo_green_dark,
            android.R.color.holo_orange_dark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);
        final GridLayoutManager manager = new GridLayoutManager(this, 2);
//        rv.setLayoutManager(new LinearLayoutManager
//                (this,LinearLayoutManager.VERTICAL,false));
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = rv.getAdapter().getItemViewType(position);
                if (type == TestData.TYPE_THREE) {
                    //返回一个跨度值，跨度值为N，意思为占用N列的宽度
                    return manager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
        rv.setLayoutManager(manager);
        adapter = new DemoAdapter(this);
        initData();
        rv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = params.getSpanSize();
                int spanIndex = params.getSpanIndex();
                outRect.top = 20;
                if (spanSize != manager.getSpanCount()) {
                    if (spanIndex==1){
                        outRect.left = 10;
                    }else {
                        outRect.right = 10;
                    }
                }
            }
        });
        rv.setAdapter(adapter);


    }

    public void initData() {
//        List<TestData> list = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            //  int type = (int) (Math.random() * 3 + 1);
//            int type;
//            if (i <= 5) {
//                type = 1;
//            } else if (i < 20) {
//                type = 2;
//            } else {
//                type = 3;
//            }
//            TestData data = new TestData();
//            data.type = type;
//            data.contentColor = colorList[(type + 1) % 3];
//            data.avatarColor = colorList[type - 1];
//            data.name = "name:" + type;
//            data.content = "content:" + type;
//            list.add(data);
//        }

        List<TestDataOne> data1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestDataOne data = new TestDataOne();
            data.name = "name:" + i;
            data.content = "content:" + i;
            data1.add(data);
        }

        List<TestDataTwo> data2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestDataTwo data = new TestDataTwo();
            data.avatarColor = colorList[0];
            data.name = "name:" + i;
            data.content = "content:" + i;
            data2.add(data);
        }

        List<TestDataThree> data3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestDataThree data = new TestDataThree();
            data.contentColor = colorList[1];
            data.avatarColor = colorList[2];
            data.name = "name:" + i;
            data.content = "content:" + i;
            data3.add(data);
        }

        adapter.addAll(data1,data2,data3);
        adapter.notifyDataSetChanged();
    }
}
