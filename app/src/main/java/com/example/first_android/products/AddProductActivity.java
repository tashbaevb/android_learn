package com.example.first_android.products;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.first_android.R;
import com.example.first_android.data.Product;
import com.example.first_android.service.ProductService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.math.BigDecimal;

public class AddProductActivity extends AppCompatActivity {
    private EditText titleEditText, priceEditText, descriptionEditText;
    private Button addProductButton;
    private ProductService productService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        titleEditText = findViewById(R.id.titleEditText);
        priceEditText = findViewById(R.id.priceEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        addProductButton = findViewById(R.id.addProductButton);

        productService = new Retrofit.Builder()
                .baseUrl("http://192.168.0.103:8085/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductService.class);

        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String priceStr = priceEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                if (title.isEmpty() || priceStr.isEmpty()) {
                    Toast.makeText(AddProductActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                double price = Double.parseDouble(priceStr);

                Product newProduct = new Product(null, title, BigDecimal.valueOf(price), description);
                Call<Product> call = productService.createProduct(newProduct);
                call.enqueue(new Callback<Product>() {
                    @Override
                    public void onResponse(Call<Product> call, Response<Product> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(AddProductActivity.this, "Product added successfully", Toast.LENGTH_SHORT).show();
                            setResult(Activity.RESULT_OK);
                            finish();
                        } else {
                            Toast.makeText(AddProductActivity.this, "Failed to add product", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Product> call, Throwable t) {
                        Toast.makeText(AddProductActivity.this, "Network error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}


