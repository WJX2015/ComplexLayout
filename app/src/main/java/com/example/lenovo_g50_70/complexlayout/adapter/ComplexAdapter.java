package com.example.lenovo_g50_70.complexlayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lenovo_g50_70.complexlayout.bean.ComplexModel;
import com.example.lenovo_g50_70.complexlayout.R;
import com.example.lenovo_g50_70.complexlayout.bean.DataModelOne;
import com.example.lenovo_g50_70.complexlayout.bean.DataModelThree;
import com.example.lenovo_g50_70.complexlayout.bean.DataModelTwo;
import com.example.lenovo_g50_70.complexlayout.holder.BaseTypeHolder;
import com.example.lenovo_g50_70.complexlayout.holder.HolderOne;
import com.example.lenovo_g50_70.complexlayout.holder.HolderThree;
import com.example.lenovo_g50_70.complexlayout.holder.HolderTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.lenovo_g50_70.complexlayout.bean.ComplexModel.TYPE_ONE;
import static com.example.lenovo_g50_70.complexlayout.bean.ComplexModel.TYPE_THREE;
import static com.example.lenovo_g50_70.complexlayout.bean.ComplexModel.TYPE_TWO;

/**
 * Created by wjx on 2017/7/10.
 */

public class ComplexAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ComplexModel> mModels = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext;

    //用来存放Type
    private List<Integer> mTypes = new ArrayList<>();
    //用来记录每个Type的起始位置
    private Map<Integer, Integer> mMap = new HashMap<>();

    private List<DataModelOne> mList1 = new ArrayList<>();
    private List<DataModelTwo> mList2 = new ArrayList<>();
    private List<DataModelThree> mList3 = new ArrayList<>();

    public ComplexAdapter(Context context, List<ComplexModel> models) {
        mContext = context;
        mModels = models;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ONE:
                return new HolderOne(mInflater.inflate(R.layout.item_type_one, parent, false));
            case TYPE_TWO:
                return new HolderTwo(mInflater.inflate(R.layout.item_type_two, parent, false));
            case TYPE_THREE:
                return new HolderThree(mInflater.inflate(R.layout.item_type_three, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        int realPosition = position - mMap.get(type);

        switch (type) {
            case TYPE_ONE:
                ((HolderOne) holder).bindViewHolder(mList1.get(realPosition));
                break;
            case TYPE_TWO:
                ((HolderTwo) holder).bindViewHolder(mList2.get(realPosition));
                break;
            case TYPE_THREE:
                ((HolderThree) holder).bindViewHolder(mList3.get(realPosition));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mTypes.size();
    }

    /**
     * 适配器更新数据
     *
     * @param models
     */
    public void setDataList(List<ComplexModel> models) {
        mModels = models;
        notifyDataSetChanged();
    }

    /**
     * 多种Model适配数据
     *
     * @param list1
     * @param list2
     * @param list3
     */
    public void setDataList(List<DataModelOne> list1, List<DataModelTwo> list2, List<DataModelThree> list3) {
        mList1 = list1;
        mList2 = list2;
        mList3 = list3;
        addListByType(TYPE_ONE, mList1);
        addListByType(TYPE_TWO, mList2);
        addListByType(TYPE_THREE, mList3);
        notifyDataSetChanged();
    }

    /**
     * 保存每个Item的Type
     *
     * @param type
     * @param list
     */
    private void addListByType(int type, List list) {
        mMap.put(type, mTypes.size());
        for (int i = 0; i < list.size(); i++) {
            mTypes.add(type);
        }
    }

    /**
     * 复杂布局的实现
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return mTypes.get(position);
    }
}
