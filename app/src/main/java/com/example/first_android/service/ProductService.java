package com.example.first_android.service;

import com.example.first_android.data.Product;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface ProductService {

    @POST("product/create")
    Call<Product> createProduct(@Body Product product);

    @GET("product/getAll")
    Call<List<Product>> getAllProducts();

    @GET("product/getById/{id}")
    Call<Product> getProductById(@Path("id") int id);
}

