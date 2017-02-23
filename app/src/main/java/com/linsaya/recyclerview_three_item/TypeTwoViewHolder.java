package com.linsaya.recyclerview_three_item;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.linsaya.recyclerview_three_item.domain.TestDataTwo;


public class TypeTwoViewHolder extends TypeAbstractViewHolder<TestDataTwo> {
    private TextView tv_name;
    private TextView tv_content;
    private ImageView avatar;

    public TypeTwoViewHolder(View itemView) {
        super(itemView);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        itemView.setBackgroundColor(Color.BLUE);
    }

    @Override
    public void onBindView(TestDataTwo data) {
        tv_name.setText(data.name);
        tv_content.setText(data.content);
        avatar.setBackgroundResource(data.avatarColor);
    }
}
