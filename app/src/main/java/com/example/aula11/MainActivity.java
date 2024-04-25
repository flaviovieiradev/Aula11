package com.example.aula11;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.ImageView;
import android.widget.RadioGroup;

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

        //Mapeando os componentes
        final TextView texto = (TextView) findViewById(R.id.textView);
        final RadioGroup grupo = (RadioGroup) findViewById(R.id.radioGroup);
        final ImageView im = (ImageView) findViewById(R.id.imageView);


        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (grupo.getCheckedRadioButtonId() == R.id.radio1) {
                    texto.setText(R.string.po);
                    im.setImageResource(R.drawable.m1);
                } else if (grupo.getCheckedRadioButtonId() == R.id.radio2) {
                    texto.setText(R.string.es);
                    im.setImageResource(R.drawable.m2);
                } else if (grupo.getCheckedRadioButtonId() == R.id.radio3) {
                    texto.setText(R.string.in);
                    im.setImageResource(R.drawable.m3);
                } else {
                    texto.setText(R.string.n);
                    im.setImageResource(R.drawable.ic_launcher_background);
                }

            }
        });
    }
}
