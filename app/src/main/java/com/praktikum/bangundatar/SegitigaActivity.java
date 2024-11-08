package com.praktikum.bangundatar;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import kotlin.reflect.KFunction;

public class SegitigaActivity extends AppCompatActivity {

    private EditText nilaiAb, nilaiBc, nilaiCa, nilaiAlas, nilaiTinggi;
    private TextView kelilingHasil, luasHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segitiga);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nilaiAb = findViewById(R.id.nilai_ab);
        nilaiBc = findViewById(R.id.nilai_bc);
        nilaiCa = findViewById(R.id.nilai_ca);
        kelilingHasil = findViewById(R.id.keliling_hasil);
        nilaiAlas = findViewById(R.id.nilai_alas);
        nilaiTinggi = findViewById(R.id.nilai_tinggi);
        luasHasil = findViewById(R.id.luas_hasil);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                onBackPressed();
            }
        });


//         Mendapatkan Intent yang memulai aktivitas ini
//        Intent intent = getIntent();

        // Mendapatkan data tambahan dari Intent
//        String nama = intent.getStringExtra("key_nama");
//        int umur = intent.getIntExtra("key_umur", 0); // 0 adalah nilai default jika data tidak ditemukan

        // Menampilkan data tambahan di TextView
//        TextView textView = findViewById(R.id.text_view);
//        textView.setText("Nama: " + nama + ", Umur: " + umur);


    }

    public void hitungKeliling(View view) {
        try {
            double ab = Double.parseDouble(nilaiAb.getText().toString());
            double bc = Double.parseDouble(nilaiBc.getText().toString());
            double ca = Double.parseDouble(nilaiCa.getText().toString());

            double keliling = ab + bc + ca;



            kelilingHasil.setText("Keliling: " + ((keliling % 1 == 0) ? String.format("%.0f", keliling) : String.valueOf(keliling)));
            kelilingHasil.setVisibility(View.VISIBLE); // Menampilkan TextView


        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan nilai yang valid", Toast.LENGTH_SHORT).show();
        }
    }

    public void hitungLuas(View view) {
        try {
            double alas = Double.parseDouble(nilaiAlas.getText().toString());
            double tinggi = Double.parseDouble(nilaiTinggi.getText().toString());

            double luas = 0.5 * alas * tinggi;



            luasHasil.setText("Luas: " + ((luas % 1 == 0) ? String.format("%.0f", luas) : String.valueOf(luas)));
            luasHasil.setVisibility(View.VISIBLE); // Menampilkan TextView


        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan nilai yang valid", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetInput(View view) {
        nilaiAb.getText().clear();
        nilaiBc.getText().clear();
        nilaiCa.getText().clear();
        kelilingHasil.setText("");
        kelilingHasil.setVisibility(View.GONE); // Menyembunyikan TextView kembali
    }

    public void resetInput2(View view) {
        nilaiAlas.getText().clear();
        nilaiTinggi.getText().clear();
        luasHasil.setText("");
        luasHasil.setVisibility(View.GONE); // Menyembunyikan TextView kembali
    }
}