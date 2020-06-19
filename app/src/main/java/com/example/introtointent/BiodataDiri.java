package com.example.introtointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class BiodataDiri extends AppCompatActivity {
    String[] daftarNegara = {
            "Australia", "Belanda", "China", "Denmark", "German", "Indonesia", "Jepang",
            "Kanada", "Malaysia", "Singapura"
    };

    String jenisKelamin, kebangsaan, hobby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata_diri);
        final TextView txtNama = (TextView) findViewById(R.id.txtNama);
        final TextView txtAlamat = (TextView) findViewById(R.id.txtAlamat);
        RadioGroup rbGrupJenisKelamin = (RadioGroup) findViewById(R.id.rbGrupJenisKelamin);
        final Spinner listNegara = (Spinner) findViewById(R.id.spinKebangsaan);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        final CheckBox kotakCoding = (CheckBox) findViewById(R.id.chkCoding);
        final CheckBox kotakTidur = (CheckBox) findViewById(R.id.chkTidur);
        final CheckBox kotakOther = (CheckBox) findViewById(R.id.chkOther);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, daftarNegara);
        listNegara.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kebangsaan = listNegara.getSelectedItem().toString();

                if(kotakCoding.isChecked() && kotakTidur.isChecked() && kotakOther.isChecked())
                    hobby = "Coding - Tidur - Other";
                else if(kotakCoding.isChecked() && kotakTidur.isChecked())
                    hobby = "Coding - Tidur";
                else if(kotakCoding.isChecked() && kotakOther.isChecked())
                    hobby = "Coding - Other";
                else if(kotakTidur.isChecked() && kotakOther.isChecked())
                    hobby = "Tidur - Other";
                else if(kotakCoding.isChecked())
                    hobby = "Coding ";
                else if (kotakTidur.isChecked())
                    hobby = "Tidur";
                else if(kotakOther.isChecked())
                    hobby = "Other";


                Intent i = new Intent(getApplicationContext(), Profile.class);
                i.putExtra("Nama", txtNama.getText().toString());
                i.putExtra("Alamat", txtAlamat.getText().toString());
                i.putExtra("JenisKelamin", jenisKelamin);
                i.putExtra("Kebangsaan", kebangsaan);
                i.putExtra("Hobby", hobby);

                startActivity(i);
            }
        });

        rbGrupJenisKelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbLakiLaki:
                        jenisKelamin = "Laki-Laki";
                        break;
                    case R.id.rbPerempuan:
                        jenisKelamin = "Perempuan";
                        break;
                }
            }
        });



    }
}
