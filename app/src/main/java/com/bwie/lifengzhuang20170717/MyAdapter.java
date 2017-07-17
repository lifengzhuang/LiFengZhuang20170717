package com.bwie.lifengzhuang20170717;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 类描述：
 * 创建人：李冯壮
 * 创建时间：2017/7/17 9:23
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private Context mContext;
    private List<User> mList;
    private View mView;
    public MyAdapter(Context context, List<User> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = View.inflate(mContext,R.layout.recycleview,null);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemImage.setImageResource(mList.get(position).getIamge());
        holder.itemPrice.setText("价格："+mList.get(position).getPrice());
        holder.itemCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mList.get(position).setChecked(b);
            }
        });
        holder.itemCheck.setChecked(mList.get(position).isChecked());
    }

    @Override
    public int getItemCount() {
        return mList.size() == 0 ? 0 : mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox itemCheck;
        ImageView itemImage;
        TextView itemPrice;
        CustomView mCustomView;
        public ViewHolder(View itemView) {
            super(itemView);
            itemCheck = (CheckBox) itemView.findViewById(R.id.item_check);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemPrice = (TextView) itemView.findViewById(R.id.item_price);
            mCustomView = (CustomView) itemView.findViewById(R.id.customview);
        }
    }
}
