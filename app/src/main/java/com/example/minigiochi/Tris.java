package com.example.minigiochi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Tris extends AppCompatActivity {

    private boolean x = true;
    private TextView txtMessaggi;
    private Button a1, b1, c1, a2, b2, c2, a3, b3, c3;
    private char [][] segni = new char[3][3];
    private boolean vincita = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tris);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        for (int i = 0; i < 3; i ++)        //n == casella vuota
            for (int j = 0; j < 3; j ++)
                segni[i][j] = 'n';

        txtMessaggi = (TextView) findViewById(R.id.txtTesto);
        ImageButton home = (ImageButton) findViewById(R.id.btnHomeT);
        ImageButton ret =(ImageButton) findViewById(R.id.btnRicaricaT);

        home.setOnClickListener(new View.OnClickListener() {  //tornare alla home page
            @Override
            public void onClick(View v) {
                Intent home = new Intent(Tris.this,MainActivity.class);
                startActivity(home);
            }
        });

        ret.setOnClickListener(new View.OnClickListener() {  //ricominciare la partita
            @Override
            public void onClick(View v) {
                Intent tris = new Intent(Tris.this, Tris.class);
                startActivity(tris);
            }
        });

        a1 = (Button) findViewById(R.id.btna1);  //dichiarazione dei bottoni e del clickListener
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliccato(a1, 1, 1);
            }
        });
        b1 = (Button) findViewById(R.id.btnb1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliccato(b1, 2, 1);
            }
        });
        c1 = (Button) findViewById(R.id.btnc1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliccato(c1, 3, 1);
            }
        });
        a2 = (Button) findViewById(R.id.btna2);
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliccato(a2, 1, 2);
            }
        });
        b2 = (Button) findViewById(R.id.btnb2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliccato(b2, 2, 2);
            }
        });
        c2 = (Button) findViewById(R.id.btnc2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliccato(c2, 3, 2);
            }
        });
        a3 = (Button) findViewById(R.id.btna3);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliccato(a3, 1, 3);
            }
        });
        b3 = (Button) findViewById(R.id.btnb3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliccato(b3, 2, 3);
            }
        });
        c3 = (Button) findViewById(R.id.btnc3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliccato(c3, 3, 3);
            }
        });
    }

    private void cliccato(Button b, int lettera, int numero)
    {
        if (x) {        //se è il tunro di X impostaalcuni valori del bottone e i colori e il carattere nella matrice
            b.setBackgroundColor(Color.RED);
            b.setText(R.string.x);
            segni[lettera - 1][numero - 1] = 'x';
            txtMessaggi.setText(R.string.toccao);
            txtMessaggi.setTextColor(Color.BLUE);
        } else {      //stessa cose se è il turno di Y
            b.setBackgroundColor(Color.BLUE);
            b.setText(R.string.o);
            segni[lettera - 1][numero - 1] = 'O';
            txtMessaggi.setText(R.string.toccax);
            txtMessaggi.setTextColor(Color.RED);
        }
        x = !x;
        b.setClickable(false);
        controlloVincita();
    }

    private void controlloVincita()
    {
        for (int i = 0; i < 3; i ++)
        {
            if (segni[i][0] == 'x' && segni[i][1] == 'x' && segni[i][2] == 'x') //controll berticali
                vinceX();
            if (segni[i][0] == 'O' && segni[i][1] == 'O' && segni[i][2] == 'O')
                vinceY();
            if (segni[0][i] == 'x' && segni[1][i] == 'x' && segni[2][i] == 'x') //controlli orizzontali
                vinceX();
            if (segni[0][i] == 'O' && segni[1][i] == 'O' && segni[2][i] == 'O')
                vinceY();
        }
        if (segni[0][0] == 'x' && segni[1][1] == 'x' && segni[2][2] == 'x')  //controlli obliqui
            vinceX();
        if (segni[0][0] == 'O' && segni[1][1] == 'O' && segni[2][2] == 'O')
            vinceY();
        if (segni[0][2] == 'x' && segni[1][1] == 'x' && segni[2][0] == 'x')
            vinceX();
        if (segni[0][2] == 'O' && segni[1][1] == 'O' && segni[2][0] == 'O')
            vinceY();
        for (int i = 0; i < 3; i ++)  //coontrollo che tutte tutte le caselle siano piene
            for (int j = 0; j < 3; j ++)
            {
                if (segni[i][j] == 'n')
                    return;
            }
        pareggio();
    }

    private void vinceX() //imposto tutto rosso e scrittte di vittoria
    {
        a1.setClickable(false);
        a2.setClickable(false);
        a3.setClickable(false);
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        c1.setClickable(false);
        c2.setClickable(false);
        c3.setClickable(false);
        a1.setBackgroundColor(Color.RED);
        a2.setBackgroundColor(Color.RED);
        a3.setBackgroundColor(Color.RED);
        b1.setBackgroundColor(Color.RED);
        b2.setBackgroundColor(Color.RED);
        b3.setBackgroundColor(Color.RED);
        c1.setBackgroundColor(Color.RED);
        c2.setBackgroundColor(Color.RED);
        c3.setBackgroundColor(Color.RED);
        txtMessaggi.setText(R.string.vincex);
        txtMessaggi.setTextColor(Color.RED);
        vincita = true;
    }

    private void vinceY() //imposto tutto blu e scrittte di vittoria
    {
        a1.setClickable(false);
        a2.setClickable(false);
        a3.setClickable(false);
        b1.setClickable(false);
        b2.setClickable(false);
        b3.setClickable(false);
        c1.setClickable(false);
        c2.setClickable(false);
        c3.setClickable(false);
        a1.setBackgroundColor(Color.BLUE);
        a2.setBackgroundColor(Color.BLUE);
        a3.setBackgroundColor(Color.BLUE);
        b1.setBackgroundColor(Color.BLUE);
        b2.setBackgroundColor(Color.BLUE);
        b3.setBackgroundColor(Color.BLUE);
        c1.setBackgroundColor(Color.BLUE);
        c2.setBackgroundColor(Color.BLUE);
        c3.setBackgroundColor(Color.BLUE);
        txtMessaggi.setText(R.string.vinceo);
        txtMessaggi.setTextColor(Color.BLUE);
        vincita = true;
    }

    private void pareggio() //imposto tutto grigio e scrittte di pareggio
    {
        if (!vincita) {
            a1.setClickable(false);
            a2.setClickable(false);
            a3.setClickable(false);
            b1.setClickable(false);
            b2.setClickable(false);
            b3.setClickable(false);
            c1.setClickable(false);
            c2.setClickable(false);
            c3.setClickable(false);
            a1.setBackgroundColor(Color.GRAY);
            a2.setBackgroundColor(Color.GRAY);
            a3.setBackgroundColor(Color.GRAY);
            b1.setBackgroundColor(Color.GRAY);
            b2.setBackgroundColor(Color.GRAY);
            b3.setBackgroundColor(Color.GRAY);
            c1.setBackgroundColor(Color.GRAY);
            c2.setBackgroundColor(Color.GRAY);
            c3.setBackgroundColor(Color.GRAY);
            txtMessaggi.setText(R.string.pareggio);
            txtMessaggi.setTextColor(Color.GRAY);
        }
    }
}
