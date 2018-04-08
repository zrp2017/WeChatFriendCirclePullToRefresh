package com.zrp.weixinpulltofresh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class MultiCommonAdapter extends RCommentAdapter<Object> {
    private int itemSize;
    public MultiCommonAdapter(Context context, int itemSize) {
        super(context);
        this.itemSize = itemSize;
    }

    @Override
    public int getItemViewType(int position) {
        Integer headerOrFooterViewType = getHeaderOrFooterViewType(position);
        if (headerOrFooterViewType != null) return headerOrFooterViewType;
        return getItemType(position);
    }

    public abstract int getItemType(int position);
    public abstract int getLayoutIdByViewType(int viewType);

    //利用viewType返回layoutId,直接生成viewHolder
    @Override
    public RCommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            return new RCommentViewHolder(headerView,mItemClickListener,mItemLongClickListener);
        }
        if (viewType == TYPE_FOOTER) {
            return new RCommentViewHolder(footerView,mItemClickListener,mItemLongClickListener);
        }
        return new RCommentViewHolder(LayoutInflater.from(mContext).inflate(getLayoutIdByViewType(viewType), parent, false) ,mItemClickListener,mItemLongClickListener);
    }


    @Override
    public void onBindViewHolder(RCommentViewHolder holder, int position) {
        convert(holder, position);
    }
    @Override
    protected int getDataCount() {
        return itemSize;
    }

}
