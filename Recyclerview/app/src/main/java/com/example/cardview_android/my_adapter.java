package com.example.cardview_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class my_adapter  extends RecyclerView.Adapter<FlowerViewHolder> {
    private Context mContext;
    private List<Data_class.FlowerData> mFlowerList;

    my_adapter(Context mContext, List<Data_class.FlowerData> mFlowerList) {
        this.mContext = mContext;
        this.mFlowerList = mFlowerList;
    }
    @Override
    public FlowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycleview_item, parent, false);
        return new FlowerViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final FlowerViewHolder holder, int position) {
        holder.mImage.setImageResource(mFlowerList.get(position).getFlowerImage());
        holder.mTitle.setText(mFlowerList.get(position).getFlowerName());
    }

    @Override
    public int getItemCount() {
        return mFlowerList.size();
    }
}


class FlowerViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mTitle;

    FlowerViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
    }
}
