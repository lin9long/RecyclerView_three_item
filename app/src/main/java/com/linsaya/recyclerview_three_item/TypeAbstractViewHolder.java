package com.linsaya.recyclerview_three_item;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/2/23.
 */

public abstract class TypeAbstractViewHolder<T> extends RecyclerView.ViewHolder{
    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void onBindView(T data);
}
