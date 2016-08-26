package com.iamdeveloper.applicationrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by IamDeveloper on 8/16/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private OnItemClick itemClick;
    private String[] data;
    private int[] viewType;

    public MyAdapter(String[] data, int[] viewType, OnItemClick itemClick) {
        this.data = data;
        this.viewType = viewType;
        this.itemClick = itemClick;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    public class TextHolder extends ViewHolder {
        public TextView textView;

        public TextHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.textView);
        }
    }

    public class ImageHolder extends ViewHolder {
        public ImageView imageView;

        public ImageHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case 0:
                View firstview = inflater.inflate(R.layout.content_text, parent, false);
                return new TextHolder(firstview);
            case 1:
                View secondview = inflater.inflate(R.layout.content_image, parent, false);
                return new ImageHolder(secondview);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.onItemClick(view, holder.getAdapterPosition());
            }
        });

        switch (holder.getItemViewType()) {
            case 0:
                TextHolder holder1 = (TextHolder) holder;
                holder1.textView.setText(data[position]);
                break;
            case 1:
                ImageHolder holder2 = (ImageHolder) holder;
                //holder2.imageView.setImage();
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    @Override
    public int getItemViewType(int position) {
        return viewType[position];
    }
}
