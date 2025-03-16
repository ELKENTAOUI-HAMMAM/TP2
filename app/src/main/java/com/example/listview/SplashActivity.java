package com.example.listview;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = findViewById(R.id.imageSplash);

        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationY", 0f, -20f, 0f);
        animator.setDuration(1000); // Durée totale en millisecondes
        animator.setRepeatCount(ObjectAnimator.INFINITE); // Répète l’animation en boucle
        animator.setRepeatMode(ObjectAnimator.REVERSE); // Monte et redescend
        animator.start();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent intent = new Intent(SplashActivity.this, ListPizzaActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
    }
}