package com.example.minigiochi;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Memory extends AppCompatActivity {

    ImageButton [] bottoni;
    private ArrayList<Integer> immagini = new ArrayList<Integer>(30);
    private int [] immaginiSelezionate = new int[30];
    private int p1 = 0, p2 = 0;
    private boolean turno = true;
    private boolean pimaCarta = true;
    private int cartaGirata = -1;
    private ImageButton bottoneScelto1, bottoneScelto2;
    TextView tocca, vittoria;
    TextView player1, player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tocca = (TextView) findViewById(R.id.txtTurno);
        player1 = (TextView) findViewById(R.id.txtP1);
        player2 = (TextView) findViewById(R.id.txtP2);
        vittoria = (TextView) findViewById(R.id.txtVittoria);

        creaVettoreBottoni();
        unsort();


        ImageButton home = (ImageButton) findViewById(R.id.btnHomeM);
        ImageButton ret =(ImageButton) findViewById(R.id.btnRicaricaM);

        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent memory = new Intent(Memory.this, Memory.class);
                startActivity(memory);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(Memory.this,MainActivity.class);
                startActivity(home);
            }
        });
    }

    private void creaVettoreBottoni() //assegna i bottoni e dichira il clickListener
    {
        bottoni = new ImageButton[30];
        bottoni[0] = findViewById(R.id.img30);
        bottoni[1] = findViewById(R.id.img1);
        bottoni[2] = findViewById(R.id.img2);
        bottoni[3] = findViewById(R.id.img3);
        bottoni[4] = findViewById(R.id.img4);
        bottoni[5] = findViewById(R.id.img5);
        bottoni[6] = findViewById(R.id.img6);
        bottoni[7] = findViewById(R.id.img7);
        bottoni[8] = findViewById(R.id.img8);
        bottoni[9] = findViewById(R.id.img9);
        bottoni[10] = findViewById(R.id.img10);
        bottoni[11] = findViewById(R.id.img11);
        bottoni[12] = findViewById(R.id.img12);
        bottoni[13] = findViewById(R.id.img13);
        bottoni[14] = findViewById(R.id.img14);
        bottoni[15] = findViewById(R.id.img15);
        bottoni[16] = findViewById(R.id.img16);
        bottoni[17] = findViewById(R.id.img17);
        bottoni[18] = findViewById(R.id.img18);
        bottoni[19] = findViewById(R.id.img19);
        bottoni[20] = findViewById(R.id.img20);
        bottoni[21] = findViewById(R.id.img21);
        bottoni[22] = findViewById(R.id.img22);
        bottoni[23] = findViewById(R.id.img23);
        bottoni[24] = findViewById(R.id.img24);
        bottoni[25] = findViewById(R.id.img25);
        bottoni[26] = findViewById(R.id.img26);
        bottoni[27] = findViewById(R.id.img27);
        bottoni[28] = findViewById(R.id.img28);
        bottoni[29] = findViewById(R.id.img29);
        for (int i = 0; i < 30; i ++) {
            int finalI = i;
            bottoni[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cartaClicccata(bottoni[finalI], finalI);
                }
            });
        }
    }

    private void unsort()
    {
        immagini.add(R.drawable.stella);  //dichiarazione del vettore immagini
        immagini.add(R.drawable.luna);
        immagini.add(R.drawable.sole);
        immagini.add(R.drawable.quadrato);
        immagini.add(R.drawable.triangolo);
        immagini.add(R.drawable.pentagono);
        immagini.add(R.drawable.x);
        immagini.add(R.drawable.cerchio);
        immagini.add(R.drawable.cuore);
        immagini.add(R.drawable.fulmine);
        immagini.add(R.drawable.fumetto);
        immagini.add(R.drawable.frecciasu);
        immagini.add(R.drawable.casa);
        immagini.add(R.drawable.trismemory);
        immagini.add(R.drawable.forzamemory);
        immagini.add(R.drawable.fiore);
        immagini.add(R.drawable.frecciagiu);
        immagini.add(R.drawable.macchie);
        immagini.add(R.drawable.teschio);
        immagini.add(R.drawable.lucchetto);
        immagini.add(R.drawable.puntodomanda);
        immagini.add(R.drawable.puntoesclamativo);
        immagini.add(R.drawable.goccia);
        immagini.add(R.drawable.neve);
        immagini.add(R.drawable.benemale);
        immagini.add(R.drawable.occhiali);
        immagini.add(R.drawable.chiave);
        immagini.add(R.drawable.bomba);
        immagini.add(R.drawable.mela);
        immagini.add(R.drawable.occhio);

        Random r = new Random();
        for (int i = 0; i < 15; i ++)       //selezione di 15 immagini
        {
            int rnd = r.nextInt(immagini.size());
            immagini.remove(rnd);
        }
        for (int i = 0; i < 15; i ++)      //duplicazione delle immagini
        {
            immagini.add(immagini.get(i));
        }
        for (int i = 0; i < 30; i ++)      //presa casuale delle immagini
        {
            int rnd = r.nextInt(immagini.size());
            immaginiSelezionate[i] = immagini.get(rnd);
            immagini.remove(rnd);
        }
    }

    private void cartaClicccata(ImageButton b, int n) {
        b.setImageResource(immaginiSelezionate[n]);
        if (pimaCarta) //se è la prima carta girata memorizzo i parametri
        {

            cartaGirata = n;
            bottoneScelto1 = b;
            pimaCarta = false;
            bottoneScelto1.setClickable(false);
        } else {
            bottoneScelto2 = b;
            if (immaginiSelezionate[n] == immaginiSelezionate[cartaGirata])  //se le carte sono uguali
            {
                new Handler().postDelayed(new Runnable() { //aspetto 1 secondo
                    public void run() {
                        bottoneScelto2.setImageResource(0);  //elimino le immagini
                        bottoneScelto1.setImageResource(0);
                    }
                }, 1000);
                if (turno) {  //modifico i punteggi
                    p1++;
                    player1.setText("PLAYER 1: " + p1);
                    turno = true;
                    player2.setTextColor(Color.argb(50, 0, 0, 0));
                    player1.setTextColor(Color.argb(255, 0, 0, 0));
                } else {
                    p2++;
                    player2.setText("PLAYER 2: " + p2);
                    turno = false;
                    player1.setTextColor(Color.argb(50, 0, 0, 0));
                    player2.setTextColor(Color.argb(255, 0, 0, 0));
                }
                b.setClickable(false);
            } else  //se le carte sono diverse
            {
                new Handler().postDelayed(new Runnable() {  //aspetto un secondo
                    public void run() {
                        bottoneScelto2.setImageResource(R.drawable.retro_memory);  //rimetto il retro della carta
                        bottoneScelto1.setImageResource(R.drawable.retro_memory);
                    }
                }, 1000);
                if (turno)  //modifico i turni dei giocatori
                {
                    tocca.setText(R.string.toccap2);
                    player1.setTextColor(Color.argb(50, 0, 0, 0));
                    player2.setTextColor(Color.argb(255, 0, 0, 0));
                    turno = false;
                } else {
                    player2.setTextColor(Color.argb(50, 0, 0, 0));
                    player1.setTextColor(Color.argb(255, 0, 0, 0));
                    tocca.setText(R.string.toccap1);
                    turno = true;
                }
                bottoneScelto2.setClickable(true);
                bottoneScelto1.setClickable(true);
            }
            pimaCarta = true;
        }
        if (p1 + p2 == 15)  //controllo della fine delle carte 30 carte = 15 punti
        {
            if (p1 > p2) { //controllo vincite e modifica dei colori e testi
                player2.setTextColor(Color.argb(50, 0, 0, 0));
                player1.setTextColor(Color.argb(255, 0, 0, 0));
                tocca.setText("");
                vittoria.setText(R.string.vincep1);
            } else {
                player1.setTextColor(Color.argb(50, 0, 0, 0));
                player2.setTextColor(Color.argb(255, 0, 0, 0));
                tocca.setText("");
                vittoria.setText(R.string.vincep2);
            }
        }
    }
}
