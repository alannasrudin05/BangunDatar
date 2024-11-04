package com.praktikum.bangundatar;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CardView btnSegitiga = findViewById(R.id.segitiga);
        CardView btnPersegi = findViewById(R.id.persegi);

        btnSegitiga.setOnClickListener(v ->{

            Intent intent = new Intent(MainActivity.this, SegitigaActivity.class);

            startActivity(intent);

        });



        btnPersegi.setOnClickListener(v ->{

            Intent intent = new Intent(MainActivity.this, PersegiActivity.class);

            startActivity(intent);

        });
    }
}