package com.zrp.weixinpulltofresh.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zrp.weixinpulltofresh.listner.MyItemClickListener;
import com.zrp.weixinpulltofresh.listner.MyItemLongClickListener;

public class RCommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

    private SparseArray<View> mViews;
    private View mConvertView;
    private MyItemClickListener mListener;
    private MyItemLongClickListener mLongClickListener;


    public RCommentViewHolder(View itemView,MyItemClickListener listener,MyItemLongClickListener longClickListener) {
        super(itemView);
        mConvertView = itemView;
        mViews = new SparseArray<View>();
        this.mListener = listener;
        this.mLongClickListener = longClickListener;
        mConvertView.setOnClickListener(this);
        mConvertView.setOnLongClickListener(this);
    }


    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public RCommentViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public RCommentViewHolder setTextAndDrawableTop(int viewId, String text,int resTop) {
       /* TextView tv = getView(viewId);
        tv.setText(text);
        Drawable top = ResourcesCompat.getDrawable(MyApplication.getContext().getResources(),resTop, null);
        tv.setCompoundDrawablesWithIntrinsicBounds (null,top,null,null);*/
        return this;
    }

    public RCommentViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        //view.setImageResource(resId);
        view.setBackgroundResource(resId);
        return this;
    }

    /**
     * 使用Picasso加载网络图片
     */
    public void setImageUrl(Context context, int id, String url) {
        ImageView iv = getView(id);
        if (iv != null && url != null) {
           /* Glide.with(context)
                    .load(url)
                    .placeholder(R.drawable.touxiang1)
                    .crossFade()
                    .into(iv);*/
        }
    }

    /**
     * 给itemView中的子View添加点击事件
     */
    public RCommentViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * 点击监听
     */
    @Override
    public void onClick(View v) {
        if(mListener != null){
            mListener.onItemClick(v,getAdapterPosition());
        }
    }

    /**
     * 长按监听
     */
    @Override
    public boolean onLongClick(View arg0) {
        if(mLongClickListener != null){
            mLongClickListener.onItemLongClick(arg0, getAdapterPosition());
        }
        return true;
    }

}
