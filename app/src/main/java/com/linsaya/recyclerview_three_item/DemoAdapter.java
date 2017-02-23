package com.linsaya.recyclerview_three_item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.linsaya.recyclerview_three_item.domain.TestDataOne;
import com.linsaya.recyclerview_three_item.domain.TestDataThree;
import com.linsaya.recyclerview_three_item.domain.TestDataTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */

public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;
   // private List<TestData> mdatas = new ArrayList<>();
    private final LayoutInflater inflater;
    private List<TestDataOne> list1 = new ArrayList<>();
    private List<TestDataTwo> list2 = new ArrayList<>();
    private List<TestDataThree> list3 = new ArrayList<>();
    private List<Integer> types = new ArrayList<>();
    private Map<Integer,Integer> mPosition = new HashMap<>();

    public DemoAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void addAll(List<TestDataOne> data1, List<TestDataTwo> data2, List<TestDataThree> data3) {
        this.list1 = data1;
        this.list2 = data2;
        this.list3 = data3;
       // mdatas.addAll(datas);
        addTypeByList(TYPE_ONE,list1);
        addTypeByList(TYPE_TWO,list2);
        addTypeByList(TYPE_THREE,list3);
    }

    public void addTypeByList(int type, List list) {
        mPosition.put(type,types.size());
        for (int i = 0; i < list.size(); i++) {
            types.add(type);
        }

    }

    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ONE:

                return new TypeOneViewHolder(inflater.inflate(R.layout.item_one, parent, false));
            case TYPE_TWO:

                return new TypeTwoViewHolder(inflater.inflate(R.layout.item_two, parent, false));
            case TYPE_THREE:

                return new TypeThreeViewHolder(inflater.inflate(R.layout.item_three, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       // ((TypeAbstractViewHolder) holder).onBindView(mdatas.get(position));
        int type = getItemViewType(position);
        int currPosition = position - mPosition.get(type);
        switch (type){
            case TYPE_ONE:
                ((TypeAbstractViewHolder) holder).onBindView(list1.get(currPosition));
                break;
            case TYPE_TWO:
                ((TypeAbstractViewHolder) holder).onBindView(list2.get(currPosition));
               break;
            case TYPE_THREE:
                ((TypeAbstractViewHolder) holder).onBindView(list3.get(currPosition));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return types.size();
    }

}
