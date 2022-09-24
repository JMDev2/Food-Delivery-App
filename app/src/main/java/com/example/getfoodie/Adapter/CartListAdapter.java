package com.example.getfoodie.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.getfoodie.Helper.ManagementCart;
import com.example.getfoodie.Interface.ChangeNumberItemsListener;
import com.example.getfoodie.R;
import com.example.getfoodie.models.Popular;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.CartListViewHolder> {
    private ArrayList<Popular> cartList;
    private ManagementCart managementCart;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<Popular> cartList, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.cartList = cartList;
        this.managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_viewholder,parent,false);
        return new CartListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(cartList.get(position).getTitle());
        holder.cartTotal.setText(String.valueOf(cartList.get(position).getFee()));
        holder.total.setText(String.valueOf(Math.round((cartList.get(position).getNumberInCart() * cartList.get(position).getFee())*100)/100));
        holder.cartNumber.setText(String.valueOf(cartList.get(position).getNumberInCart()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(cartList.get(position).getImage(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.image);

        holder.cartPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.plusNumberFood(cartList, position, changeNumberItemsListener);
            }

        });
        holder.cartMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.minusNumberFood(cartList, position, changeNumberItemsListener);


            }
        });





    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class CartListViewHolder extends RecyclerView.ViewHolder {
        private TextView title, cartTotal, cartMinus, cartPlus, cartNumber,total;
        private ImageView image;

        public CartListViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cartTitle);
            cartTotal = itemView.findViewById(R.id.cartTotal);
            cartMinus = itemView.findViewById(R.id.cartMinus);
            cartPlus = itemView.findViewById(R.id.cartPlus);
            cartNumber = itemView.findViewById(R.id.cartNumber);
            total = itemView.findViewById(R.id.total);
            image = itemView.findViewById(R.id.picCart);
        }
    }
}
