package com.example.lenovo_g50_70.complexlayout.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lenovo_g50_70.complexlayout.bean.ComplexModel;

/**
 * Created by wjx on 2017/7/14.
 */

public abstract class BaseTypeHolder<T> extends RecyclerView.ViewHolder {

    public BaseTypeHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(T model);
}
