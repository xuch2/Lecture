package com.example.recyclercash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ProductAdapter();

        adapter.addItem(new Product("필수 패키지 1", "Test",
                10000, 9900, R.drawable.cash1));
        adapter.addItem(new Product("필수 패키지 2", "Test",
                14000, 29200, R.drawable.cash2));
        adapter.addItem(new Product("필수 패키지 3", "Test",
                30000, 23000, R.drawable.cash3));
        adapter.addItem(new Product("필수 패키지 4", "Test",
                75658, 3300, R.drawable.cash4));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                Product item = (Product) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),
                        "Selected Item : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }
}