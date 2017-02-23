package com.linsaya.recyclerview_three_item;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.linsaya.recyclerview_three_item.domain.TestDataThree;

/**
 * Created by Administrator on 2017/2/23.
 */

public class TypeThreeViewHolder extends TypeAbstractViewHolder<TestDataThree> {
    private TextView tv_name;
    private TextView tv_content;
    private ImageView iv_avatar;
    private ImageView iv_content;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        iv_avatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        iv_content = (ImageView) itemView.findViewById(R.id.iv_content);
        itemView.setBackgroundColor(Color.GREEN);
    }

    @Override
    public void onBindView(TestDataThree data) {
        tv_name.setText(data.name);
        tv_content.setText(data.content);
        iv_avatar.setBackgroundResource(data.avatarColor);
        iv_content.setBackgroundResource(data.contentColor);
    }
}
