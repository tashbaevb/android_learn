package com.example.first_android;

import android.content.Intent;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.airbnb.lottie.LottieAnimationView;
import com.example.first_android.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    LottieAnimationView lotty_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lotty_s = findViewById(R.id.lotty_m);

        lotty_s.setAnimation(R.raw.splash);

        lotty_s.animate().alpha(1f).withEndAction(new Runnable() {
            @Override
            public void run() {
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}