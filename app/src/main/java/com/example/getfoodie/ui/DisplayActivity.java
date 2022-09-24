package com.example.getfoodie.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.getfoodie.Adapter.CategoryAdapter;
import com.example.getfoodie.Adapter.PopularAdapter;
import com.example.getfoodie.R;
import com.example.getfoodie.models.Category;
import com.example.getfoodie.models.Popular;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    RecyclerView CategoryrecyclerView, PopularRecyclerView;
    CategoryAdapter categoryAdapter;
    PopularAdapter popularAdapter;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        CategotyRecyclerView();
        popularRecyclerView();
        bottmNavigation();
    }

    public void bottmNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DisplayActivity.this, CartActivity2.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DisplayActivity.this, DisplayActivity.class));
            }
        });

    }



    private void CategotyRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        CategoryrecyclerView = findViewById(R.id.category_recyclerview);
        CategoryrecyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Category> category = new ArrayList<>();
        category.add(new Category("Pizza", "cat_1"));
        category.add(new Category("Hotdog", "cat_2"));
        category.add(new Category("Burger", "cat_3"));
        category.add(new Category("Drinks", "cat_4"));
        category.add(new Category("Donut", "pcat_5"));


        categoryAdapter = new CategoryAdapter(this, category);
        CategoryrecyclerView.setAdapter(categoryAdapter);

    }

    private void popularRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        PopularRecyclerView = findViewById(R.id.popular_recycler);
        PopularRecyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Popular> popular = new ArrayList<>();
        popular.add(new Popular("Pepperoni pizza", "pop_1", "slices peperoni, mozzerella cheese, fress oregano", 1200.00));
        popular.add(new Popular("Pepperoni", "pop_2", "slices peperoni, mozzerella cheese, fress oregano", 1200.00));
        popular.add(new Popular("pizza", "pop_3", "slices peperoni, mozzerella cheese, fress oregano", 1200.00));

        popularAdapter = new PopularAdapter(this, popular);
        PopularRecyclerView.setAdapter(popularAdapter);

    }
}