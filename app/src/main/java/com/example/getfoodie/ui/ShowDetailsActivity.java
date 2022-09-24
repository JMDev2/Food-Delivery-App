package com.example.getfoodie.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.getfoodie.Helper.ManagementCart;
import com.example.getfoodie.R;
import com.example.getfoodie.models.Popular;

public class ShowDetailsActivity extends AppCompatActivity {
    private TextView title;
    private TextView fee;
    private TextView minus;
    private TextView add;
    private TextView numberText;
    private TextView description;
    private TextView addToCart;
    private ImageView image;

    private Popular object;
    int numberOrder = 1;
    private ManagementCart managementcart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        managementcart = new ManagementCart(this);
        initialiseView();

        getBundle();


    }

    private void getBundle() {
        object = (Popular) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getImage(), "drawable", this.getPackageName());

        Glide.with(this)
                        .load(drawableResourceId)
                                .into(image);

        title.setText(object.getTitle());
        fee.setText("$" +object.getFee());
        description.setText(object.getDescription());
        numberText.setText(String.valueOf(numberOrder));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder+1;
                numberText.setText(String.valueOf(numberOrder));

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOrder>1){
                    numberOrder = numberOrder-1;
                }
                numberText.setText(String.valueOf(numberOrder));

            }
        });


        //adding to cart
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementcart.insertFood(object);

            }

        });
    }

    private void initialiseView() {
        title = findViewById(R.id.title_txt);
        fee = findViewById(R.id.fee_txt);
        minus = findViewById(R.id.minus_txt);
        add = findViewById(R.id.plus_txt);
        numberText = findViewById(R.id.number_txt);
        description = findViewById(R.id.description_txt);
        addToCart = findViewById(R.id.add_to_cart);
        image = findViewById(R.id.image);
    }
}