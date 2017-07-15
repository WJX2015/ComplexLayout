package com.example.lenovo_g50_70.complexlayout.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo_g50_70.complexlayout.bean.ComplexModel;
import com.example.lenovo_g50_70.complexlayout.R;
import com.example.lenovo_g50_70.complexlayout.bean.DataModelThree;

/**
 * Created by wjx on 2017/7/14.
 */

public class HolderThree extends BaseTypeHolder<DataModelThree> {

    public ImageView mImageView;
    public ImageView mImage;
    public TextView mTextView;
    public TextView mView;

    public HolderThree(View itemView) {
        super(itemView);
        mImageView = (ImageView) itemView.findViewById(R.id.image_view);
        mTextView = (TextView) itemView.findViewById(R.id.text_name);
        mView = (TextView) itemView.findViewById(R.id.text_content);
        mImage = (ImageView) itemView.findViewById(R.id.image_content);
    }

    /**
     * 绑定ViewHolder
     *
     * @param model
     */
    @Override
    public void bindViewHolder(DataModelThree model) {
        mImageView.setBackgroundResource(model.getAvatarColor());
        mTextView.setText(model.getName());
        mView.setText(model.getContent());
        mImage.setBackgroundResource(model.getContentColor());
    }
}
