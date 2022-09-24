package com.example.getfoodie.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.getfoodie.R;
import com.example.getfoodie.models.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Context context;
    private List<Category> category = new ArrayList<>();

    public CategoryAdapter(Context context, List<Category> category) {
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewcategories, parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        holder.name.setText(category.get(position).getName());

        String picUrl = "";
        switch (position){
            case 0:{
                picUrl = "cat_1";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background));
                break;
            }
            case 1:{
                picUrl = "cat_2";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background2));
                break;
            }
            case 2:{
                picUrl = "cat_3";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background3));
                break;
            }
            case 3:{
                picUrl = "cat_4";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background4));
                break;
            }
            case 4:{
                picUrl = "cat_5";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background6));
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name;
        private ConstraintLayout mainlayout;
        private Context context;
        private List<Category> category = new ArrayList<>();
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.category_image);
            name = itemView.findViewById(R.id.category_name);
            mainlayout = itemView.findViewById(R.id.mainlayout);
        }
    }
}
