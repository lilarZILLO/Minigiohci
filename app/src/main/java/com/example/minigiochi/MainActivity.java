package com.example.minigiochi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TextView txtTitolo = (TextView) findViewById(R.id.txtTitolo);
        ImageButton tris = (ImageButton) findViewById(R.id.btnTris);
        ImageButton forza4 = (ImageButton) findViewById(R.id.btnForza);
        ImageButton memory = (ImageButton) findViewById(R.id.btnMemory);

        tris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tris = new Intent(MainActivity.this, Tris.class);
                startActivity(tris);
            }
        });

        forza4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forza4 = new Intent(MainActivity.this, Forza.class);
                startActivity(forza4);
            }
        });

        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent memory = new Intent(MainActivity.this, Memory.class);
                startActivity(memory);
            }
        });
    }
}