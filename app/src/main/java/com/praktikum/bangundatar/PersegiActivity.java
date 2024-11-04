package com.praktikum.bangundatar;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PersegiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_persegi);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Mendapatkan Intent yang memulai aktivitas ini
//        Intent intent = getIntent();

        // Mendapatkan data tambahan dari Intent
//        String nama = intent.getStringExtra("key_nama");
//        int umur = intent.getIntExtra("key_umur", 0); // 0 adalah nilai default jika data tidak ditemukan

        // Menampilkan data tambahan di TextView
//        TextView textView = findViewById(R.id.text_view);
//        textView.setText("Nama: " + nama + ", Umur: " + umur);

    }
}