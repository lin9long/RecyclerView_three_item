package com.linsaya.recyclerview_three_item;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.linsaya.recyclerview_three_item.domain.TestDataOne;

/**
 * Created by Administrator on 2017/2/23.
 */

public class TypeOneViewHolder extends TypeAbstractViewHolder<TestDataOne> {
    private TextView tv_name;
    private TextView tv_content;

    public TypeOneViewHolder(View itemView) {
        super(itemView);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        itemView.setBackgroundColor(Color.GRAY);
    }

    @Override
    public void onBindView(TestDataOne data) {
        tv_name.setText(data.name);
        tv_content.setText(data.content);
    }
}
