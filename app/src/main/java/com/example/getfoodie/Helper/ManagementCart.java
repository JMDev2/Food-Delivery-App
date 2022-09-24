package com.example.getfoodie.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.getfoodie.Interface.ChangeNumberItemsListener;
import com.example.getfoodie.models.Popular;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(Popular popular){
        ArrayList<Popular> listPopular = getListCart();
        boolean existAlready = false;

        int n = 0;
        for (int i = 0; i < listPopular.size(); i++){
            if (listPopular.get(i).getTitle().equals(popular.getTitle())){
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready){
            listPopular.get(n).getNumberInCart(popular.getNumberInCart(popular.getNumberInCart(n)));
        }else {
            listPopular.add(popular);
        }
        tinyDB.putListObject("CardList", listPopular);
        Toast.makeText(context ,"Addedd to cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Popular> getListCart() {
        return tinyDB.getListObject("CartList");
    }


    public void plusNumberFood(ArrayList<Popular> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()+1);
        tinyDB.putListObject("cartlist", listFood);
        changeNumberItemsListener.changed();
    }
    public void minusNumberFood(ArrayList<Popular> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        if (listFood.get(position).getNumberInCart()==1){
        tinyDB.putListObject("cartlist", listFood);
        listFood.remove(position);
    }else{
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()-1);
            tinyDB.putListObject("cartlist", listFood);
            listFood.remove(position);
            changeNumberItemsListener.changed();
        }

    }
    public Double getTotalFee() {
        ArrayList<Popular> listFood = getListCart();
        double fee = 0;
        for (int i = 0; i < listFood.size(); i++) {
            fee = fee + (listFood.get(i).getFee() * listFood.get(i).getNumberInCart());
        }
        return fee;
    }

}
