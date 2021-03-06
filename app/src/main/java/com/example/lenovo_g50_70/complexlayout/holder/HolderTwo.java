package com.example.lenovo_g50_70.complexlayout.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo_g50_70.complexlayout.bean.ComplexModel;
import com.example.lenovo_g50_70.complexlayout.R;
import com.example.lenovo_g50_70.complexlayout.bean.DataModelTwo;

/**
 * Created by wjx on 2017/7/14.
 */

public class HolderTwo extends BaseTypeHolder<DataModelTwo> {

    public ImageView mImageView;
    public TextView mTextView;
    public TextView mView;

    public HolderTwo(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.image_view);
        mTextView = (TextView) itemView.findViewById(R.id.text_name);
        mView = (TextView) itemView.findViewById(R.id.text_content);
    }

    /**
     * 绑定ViewHolder
     *
     * @param model
     */
    @Override
    public void bindViewHolder(DataModelTwo model) {
        mImageView.setBackgroundResource(model.getAvatarColor());
        mTextView.setText(model.getName());
        mView.setText(model.getContent());
    }
}
