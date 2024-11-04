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

public class TrapesiumActivity extends AppCompatActivity {

    private EditText nilaiA, nilaiB, nilaiC,  nilaiD, nilaiA2, nilaiB2, nilaiTinggi;
    private TextView kelilingHasil, luasHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trapesium);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nilaiA = findViewById(R.id.nilai_a);
        nilaiB = findViewById(R.id.nilai_b);
        nilaiC = findViewById(R.id.nilai_c);
        nilaiD = findViewById(R.id.nilai_d);
        kelilingHasil = findViewById(R.id.keliling_hasil);
        nilaiA2 = findViewById(R.id.nilai_a2);
        nilaiB2 = findViewById(R.id.nilai_b2);
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
            double c = Double.parseDouble(nilaiC.getText().toString());
            double d = Double.parseDouble(nilaiD.getText().toString());

            double keliling = a + b + c + d;



            kelilingHasil.setText("Keliling: " + ((keliling % 1 == 0) ? String.format("%.0f", keliling) : String.valueOf(keliling)));
            kelilingHasil.setVisibility(View.VISIBLE); // Menampilkan TextView


        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan nilai yang valid", Toast.LENGTH_SHORT).show();
        }
    }

    public void hitungLuas(View view) {
        try {
            double a2 = Double.parseDouble(nilaiA2.getText().toString());
            double b2 = Double.parseDouble(nilaiB2.getText().toString());
            double tinggi = Double.parseDouble(nilaiTinggi.getText().toString());

            double luas = 0.5 * (a2 + b2) * tinggi;



            luasHasil.setText("Luas: " + ((luas % 1 == 0) ? String.format("%.0f", luas) : String.valueOf(luas)));
            luasHasil.setVisibility(View.VISIBLE); // Menampilkan TextView


        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan nilai yang valid", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetInput(View view) {
        nilaiA.getText().clear();
        nilaiB.getText().clear();
        nilaiC.getText().clear();
        nilaiD.getText().clear();
        kelilingHasil.setText("");
        kelilingHasil.setVisibility(View.GONE); // Menyembunyikan TextView kembali
    }

    public void resetInput2(View view) {
        nilaiA2.getText().clear();
        nilaiB2.getText().clear();
        nilaiTinggi.getText().clear();
        luasHasil.setText("");
        luasHasil.setVisibility(View.GONE); // Menyembunyikan TextView kembali
    }

}