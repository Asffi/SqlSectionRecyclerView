package com.example.sqllite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sqllite.R;
import com.example.sqllite.model.Items;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    List<Items> itemsList;
    Context context;

    public ItemAdapter(List<Items> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_holder,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.availableStock.setText("Stock Available : " + itemsList.get(position).getBoxSize());
        holder.itemName.setText(itemsList.get(position).getName());
        holder.itemSqCode.setText("SKU Code : " + itemsList.get(position).getSkuCode());

        Glide.with(context)
                .load(itemsList.get(position).getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName, itemSqCode, availableStock, totalPcs;
        public ImageView itemImage;
        public EditText edCtn, edPcs, edBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            totalPcs = itemView.findViewById(R.id.totalPcs);
            availableStock = itemView.findViewById(R.id.availableStock);
            itemName = itemView.findViewById(R.id.itemName);
            itemSqCode = itemView.findViewById(R.id.itemSqCode);
            edCtn = itemView.findViewById(R.id.edCtn);
            edPcs = itemView.findViewById(R.id.edPcs);
            edBox = itemView.findViewById(R.id.edBox);
            itemImage = itemView.findViewById(R.id.itemImage);
        }
    }
}
