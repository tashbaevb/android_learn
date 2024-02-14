package com.example.first_android;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.first_android.data.ProductData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class ProductActivity extends AppCompatActivity {

    interface RequestProduct {
        @GET("/product/getById/{id}")
        Call<ProductData> getProduct(@Path("id") String id);
    }

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);

        textView = findViewById(R.id.textView);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.102:8085")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestProduct requestProduct = retrofit.create(RequestProduct.class);

        requestProduct.getProduct("1").enqueue(new Callback<ProductData>() {
            @Override
            public void onResponse(Call<ProductData> call, Response<ProductData> response) {
                textView.setText(response.body().data.getTitle());
            }

            @Override
            public void onFailure(Call<ProductData> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}
