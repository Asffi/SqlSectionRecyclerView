package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.sqllite.adapter.MainAdapter;
import com.example.sqllite.databaseHandler.SqlHandler;
import com.example.sqllite.model.Items;
import com.example.sqllite.model.Products;
import com.example.sqllite.utils.RecyclerViewItemDecorator;
import com.example.sqllite.utils.SectionCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SqlHandler handler;
    MainAdapter adapter;
    List<Products> productsList;
    List<Items> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler= new SqlHandler(this);
        handler.addingDataInProduct();
        handler.addingDataInItems();
        productsList= handler.getAllData();

        getInit();

    }


    private void getInit() {

        recyclerView = findViewById(R.id.main_recyclerView);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter= new MainAdapter(this,productsList);
        recyclerView.setAdapter(adapter);


        RecyclerViewItemDecorator sectionItemDecoration =
                new RecyclerViewItemDecorator(getResources().getDimensionPixelSize(R.dimen.header),
                        true,
                        getSectionCallback(itemList));
        recyclerView.addItemDecoration(sectionItemDecoration);
    }

    /// item decoration
    private SectionCallback getSectionCallback(final List<Items> item) {
        return new SectionCallback() {
            @Override
            public boolean isSection(int position) {
                return position == 0
                        || item.get(position).getProductId() !=
                        item.get(position - 1).getProductId();
            }

            @Override
            public String getSectionHeader(int position) {
                return handler.getProductNameById(item.get(position).getProductId());
            }
        };
    }

}