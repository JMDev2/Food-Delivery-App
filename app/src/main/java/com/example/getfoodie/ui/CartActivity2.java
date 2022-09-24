package com.example.getfoodie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.getfoodie.Adapter.CartListAdapter;
import com.example.getfoodie.Helper.ManagementCart;
import com.example.getfoodie.Interface.ChangeNumberItemsListener;
import com.example.getfoodie.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartActivity2 extends AppCompatActivity {
    private TextView itemsTotalTxt;
    private TextView deliveryServicesTxt;
    private TextView taxTxt;
    private TextView totalTxt;
    private TextView checkoutTxt;
    private RecyclerView recyclerView;
    private ScrollView scrollView;
    private TextView emptyCartTxt;


    private ManagementCart managementCart;
    private CartListAdapter cartListAdapter;
    double tax = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart2);

        managementCart=new ManagementCart(this);
        initViews();
        iniList();
        CalculateCart();
        bottmNavigation();

    }

    public void bottmNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.displyHomeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity2.this, CartActivity2.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity2.this, DisplayActivity.class));
            }
        });
    }




     private void initViews() {
        itemsTotalTxt = findViewById(R.id.items_total);
        deliveryServicesTxt = findViewById(R.id.delivery_services);
        taxTxt = findViewById(R.id.tax);
        totalTxt = findViewById(R.id.total);
        checkoutTxt  =findViewById(R.id.checkout);
        recyclerView = findViewById(R.id.cart_recyclerview);
        scrollView = findViewById(R.id.scrollview1);
        emptyCartTxt = findViewById(R.id.empty_cart);

    }
    public void iniList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        cartListAdapter = new CartListAdapter(managementCart.getListCart(),this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculateCart();
            }
        });
        recyclerView.setAdapter(cartListAdapter);
//        if (managementCart.getListCart().isEmpty()){
//            emptyCartTxt.setVisibility(View.VISIBLE);
//            scrollView.setVisibility(View.GONE);
//        }else {
//            emptyCartTxt.setVisibility(View.GONE);
//            scrollView.setVisibility(View.VISIBLE);
//        }

    }
    private void CalculateCart(){
        double PercentTax = 0.02;
        double delivery=10;


        tax = Math.round((managementCart.getTotalFee() * PercentTax) * 100)/100;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery) *100) /100;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100)/100;

        itemsTotalTxt.setText("$" +itemTotal);
        taxTxt.setText("$" + tax);
        deliveryServicesTxt.setText("$" + delivery);
        totalTxt.setText("$" + total);









    }
}