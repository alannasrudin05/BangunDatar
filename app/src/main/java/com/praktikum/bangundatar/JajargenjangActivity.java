package com.praktikum.bangundatar;

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

public class JajargenjangActivity extends AppCompatActivity {

    private EditText nilaiA, nilaiB, nilaiAlas, nilaiTinggi;
    private TextView kelilingHasil, luasHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jajargenjang);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nilaiA = findViewById(R.id.nilai_a);
        nilaiB = findViewById(R.id.nilai_b);
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

    }


    public void hitungKeliling(View view) {
        try {
            double a = Double.parseDouble(nilaiA.getText().toString());
            double b = Double.parseDouble(nilaiB.getText().toString());

            double keliling = 2 * (a + b) ;



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

            double luas = alas * tinggi;



            luasHasil.setText("Luas: " + ((luas % 1 == 0) ? String.format("%.0f", luas) : String.valueOf(luas)));
            luasHasil.setVisibility(View.VISIBLE); // Menampilkan TextView


        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan nilai yang valid", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetInput(View view) {
        nilaiA.getText().clear();
        nilaiB.getText().clear();
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