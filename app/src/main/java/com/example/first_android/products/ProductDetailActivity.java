package com.example.first_android.products;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.first_android.R;
import com.example.first_android.data.Product;

public class ProductDetailActivity extends AppCompatActivity {
    private TextView titleTextView, priceTextView, descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        titleTextView = findViewById(R.id.titleTextView);
        priceTextView = findViewById(R.id.priceTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);

        Product product = (Product) getIntent().getSerializableExtra("product");
        if (product != null) {
            titleTextView.setText(product.getTitle());
            priceTextView.setText(String.valueOf(product.getPrice()));
            descriptionTextView.setText(product.getDescription());
        }
    }
}


