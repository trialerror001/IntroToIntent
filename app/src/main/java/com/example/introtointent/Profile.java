package com.example.introtointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView txtNama = (TextView) findViewById(R.id.textNama);
        TextView txtAlamat = (TextView) findViewById(R.id.textAlamat);
        TextView txtJenKel = (TextView) findViewById(R.id.textJenisKelamin);
        TextView txtKebangsaan = (TextView) findViewById(R.id.textKebangsaan);
        TextView txtHobby = (TextView) findViewById(R.id.textHobby);

        txtNama.setText(getIntent().getStringExtra("Nama"));
        txtAlamat.setText(getIntent().getStringExtra("Alamat"));
        txtJenKel.setText(getIntent().getStringExtra("JenisKelamin"));
        txtKebangsaan.setText(getIntent().getStringExtra("Kebangsaan"));
        txtHobby.setText(getIntent().getStringExtra("Hobby"));
    }
}
