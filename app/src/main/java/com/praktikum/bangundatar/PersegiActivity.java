package com.praktikum.bangundatar;

import android.content.Intent;
import android.os.Bundle;
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

public class PersegiActivity extends AppCompatActivity {

    private EditText nilaiSisi;
    private TextView kelilingHasil, luasHasil;

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

        nilaiSisi = findViewById(R.id.nilai_sisi);
        kelilingHasil = findViewById(R.id.keliling_hasil);
        luasHasil = findViewById(R.id.luas_hasil);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                onBackPressed();
            }
        });

    }

    public void hitungKeliling(View view) {
            try {
                double sisi = Double.parseDouble(nilaiSisi.getText().toString());

                double keliling = 4 * sisi;

                kelilingHasil.setText("Keliling: " + ((keliling % 1 == 0) ? String.format("%.0f", keliling) : String.valueOf(keliling)));
                kelilingHasil.setVisibility(View.VISIBLE); // Menampilkan TextView


            } catch (NumberFormatException e) {
                Toast.makeText(this, "Masukkan nilai yang valid", Toast.LENGTH_SHORT).show();
            }
        }

        public void hitungLuas(View view) {
            try {
                double sisi = Double.parseDouble(nilaiSisi.getText().toString());

                double luas = sisi * sisi;



                luasHasil.setText("Luas: " + ((luas % 1 == 0) ? String.format("%.0f", luas) : String.valueOf(luas)));
                luasHasil.setVisibility(View.VISIBLE); // Menampilkan TextView


            } catch (NumberFormatException e) {
                Toast.makeText(this, "Masukkan nilai yang valid", Toast.LENGTH_SHORT).show();
            }
        }

        public void resetInput(View view) {
            nilaiSisi.getText().clear();
            kelilingHasil.setText("");
            luasHasil.setText("");
            kelilingHasil.setVisibility(View.GONE); // Menyembunyikan TextView kembali
            luasHasil.setVisibility(View.GONE); // Menyembunyikan TextView kembali
        }

}