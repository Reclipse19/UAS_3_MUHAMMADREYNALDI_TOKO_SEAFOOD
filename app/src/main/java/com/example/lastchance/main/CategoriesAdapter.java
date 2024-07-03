package com.example.lastchance.main;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastchance.R;
import com.example.lastchance.order.OrderActivity;
import com.example.lastchance.order.OrderActivity2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    List<ModelCategories> modelCategoriesList;
    Context ctx;

    private Map<String, Class<?>> categoryToActivityMap;

    public CategoriesAdapter(Context context, List<ModelCategories> items) {
        this.ctx = context;
        this.modelCategoriesList = items;

        categoryToActivityMap = new HashMap<>();
        categoryToActivityMap.put("Fresh Seafood 1", OrderActivity.class);
        categoryToActivityMap.put("Fresh Seafood 2", OrderActivity2.class);
        categoryToActivityMap.put("Informasi", InformasiActivity.class);
    }

    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_categories, parent, false);
        return new CategoriesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoriesAdapter.ViewHolder holder, int position) {
        final ModelCategories data = modelCategoriesList.get(position);
        holder.imageIcon.setImageResource(data.getiIcon());
        holder.tvName.setText(data.getStrName());

        holder.cvCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryName = data.getStrName();
                Log.d("CategoriesAdapter", "Clicked category: " + categoryName);
                Class<?> activityClass = categoryToActivityMap.get(categoryName);

                if (activityClass != null) {
                    try {
                        Intent intent = new Intent(ctx, activityClass);
                        intent.putExtra(OrderActivity.DATA_TITLE, categoryName);
                        ctx.startActivity(intent);
                        Log.d("CategoriesAdapter", "Starting activity: " + activityClass.getSimpleName());
                    } catch (Exception e) {
                        Log.e("CategoriesAdapter", "Error starting activity: ", e);
                    }
                } else {
                    Log.e("CategoriesAdapter", "No activity found for category: " + categoryName);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelCategoriesList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cvCategories;
        public TextView tvName;
        public ImageView imageIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            cvCategories = itemView.findViewById(R.id.cvCategories);
            tvName = itemView.findViewById(R.id.tvName);
            imageIcon = itemView.findViewById(R.id.imageIcon);
        }
    }
}
