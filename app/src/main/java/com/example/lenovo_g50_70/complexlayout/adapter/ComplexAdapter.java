package com.example.lenovo_g50_70.complexlayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lenovo_g50_70.complexlayout.bean.ComplexModel;
import com.example.lenovo_g50_70.complexlayout.R;
import com.example.lenovo_g50_70.complexlayout.holder.BaseTypeHolder;
import com.example.lenovo_g50_70.complexlayout.holder.HolderOne;
import com.example.lenovo_g50_70.complexlayout.holder.HolderThree;
import com.example.lenovo_g50_70.complexlayout.holder.HolderTwo;

import java.util.ArrayList;
import java.util.List;

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
        ((BaseTypeHolder) holder).bindViewHolder(mModels.get(position));
    }

    @Override
    public int getItemCount() {
        return mModels.size();
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
     * 复杂布局的实现
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return mModels.get(position).getType();
    }
}
