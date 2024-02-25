package com.example.first_android.kosmonavt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.first_android.databinding.KosmonavtBinding;

public class KosmonavtActivity extends AppCompatActivity {

    KosmonavtBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = KosmonavtBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnWriteWish.setOnClickListener(v -> {
            binding.etMyWish.setVisibility(View.VISIBLE);
            binding.btnPassWish.setVisibility(View.VISIBLE);

            binding.btnWriteWish.setVisibility(View.INVISIBLE);
        });


        binding.btnPassWish.setOnClickListener(v1 -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My message");
            emailIntent.putExtra(Intent.EXTRA_TEXT, binding.etMyWish.getText().toString());

            startActivity(emailIntent);
        });
    }
}
