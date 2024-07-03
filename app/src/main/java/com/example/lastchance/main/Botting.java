package com.example.lastchance.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lastchance.R;
import com.example.lastchance.login.LoginActivity;

public class Botting extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.botting);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Botting.this, LoginActivity.class));
                finish();
            }
        }, 3000);
    }
}
