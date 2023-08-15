package com.example.sunflower_myself.adpater;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunflower_myself.R;
import com.example.sunflower_myself.vo.Plant;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> {

    private List<Plant> data;
    private OnItemClickListener mListener = null;
    public interface OnItemClickListener{
        void onItemCLick(View v, int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public PlantAdapter(List<Plant> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String plantName = data.get(position).getName();
        int imageRoute = data.get(position).getImageResource();
        holder.textViewItem.setText(plantName);
        holder.imageView.setImageResource(imageRoute);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItem;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewItem = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener != null){
                        mListener.onItemCLick(view, getAdapterPosition());
                    }
                }
            });
        }
    }
}