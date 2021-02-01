package com.example.minigiochi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Forza extends AppCompatActivity {


    private ImageButton [] bottoni = new ImageButton[7];
    private GrigliaForza4 griglia;
    private int giallo = R.drawable.forzagialla, viola = R.drawable.forzaviola;
    ImageButton home;
    TextView txtTurno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forza);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        txtTurno = (TextView) findViewById(R.id.txtTurnoForza);

        creaTutto();

        bottoni[0].setOnClickListener(new View.OnClickListener() { //dichiarazione dei clickListener dei bottoni in alto
            @Override
            public void onClick(View v) {
                bottoneCliccato(0);
            }
        });
        bottoni[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottoneCliccato(1);
            }
        });
        bottoni[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottoneCliccato(2);
            }
        });
        bottoni[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottoneCliccato(3);
            }
        });
        bottoni[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottoneCliccato(4);
            }
        });
        bottoni[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottoneCliccato(5);
            }
        });
        bottoni[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottoneCliccato(6);
            }
        });

        home = (ImageButton) findViewById(R.id.btnHomeF);
        ImageButton ret =(ImageButton) findViewById(R.id.btnRicaricaF);

        home.setOnClickListener(new View.OnClickListener() {  //tornare alla home page
            @Override
            public void onClick(View v) {
                Intent home = new Intent(Forza.this,MainActivity.class);
                startActivity(home);
            }
        });

        ret.setOnClickListener(new View.OnClickListener() {  //ricomincire la partita
            @Override
            public void onClick(View v) {
                Intent forza4 = new Intent(Forza.this, Forza.class);
                startActivity(forza4);
            }
        });
    }

    public void creaTutto() {  //crea la matrice di immagini
        final int RIGHE = 6;
        final int COLONNE = 7;
        ImageView[][] aux = new ImageView[COLONNE][RIGHE];

        aux[0][0] = (ImageView) findViewById(R.id.imga1);
        aux[1][0] = (ImageView) findViewById(R.id.imgb1);
        aux[2][0] = (ImageView) findViewById(R.id.imgc1);
        aux[3][0] = (ImageView) findViewById(R.id.imgd1);
        aux[4][0] = (ImageView) findViewById(R.id.imge1);
        aux[5][0] = (ImageView) findViewById(R.id.imgf1);
        aux[6][0] = (ImageView) findViewById(R.id.imgg1);
        aux[0][1] = (ImageView) findViewById(R.id.imga2);
        aux[1][1] = (ImageView) findViewById(R.id.imgb2);
        aux[2][1] = (ImageView) findViewById(R.id.imgc2);
        aux[3][1] = (ImageView) findViewById(R.id.imgd2);
        aux[4][1] = (ImageView) findViewById(R.id.imge2);
        aux[5][1] = (ImageView) findViewById(R.id.imgf2);
        aux[6][1] = (ImageView) findViewById(R.id.imgg2);
        aux[0][2] = (ImageView) findViewById(R.id.imga3);
        aux[1][2] = (ImageView) findViewById(R.id.imgb3);
        aux[2][2] = (ImageView) findViewById(R.id.imgc3);
        aux[3][2] = (ImageView) findViewById(R.id.imgd3);
        aux[4][2] = (ImageView) findViewById(R.id.imge3);
        aux[5][2] = (ImageView) findViewById(R.id.imgf3);
        aux[6][2] = (ImageView) findViewById(R.id.imgg3);
        aux[0][3] = (ImageView) findViewById(R.id.imga4);
        aux[1][3] = (ImageView) findViewById(R.id.imgb4);
        aux[2][3] = (ImageView) findViewById(R.id.imgc4);
        aux[3][3] = (ImageView) findViewById(R.id.imgd4);
        aux[4][3] = (ImageView) findViewById(R.id.imge4);
        aux[5][3] = (ImageView) findViewById(R.id.imgf4);
        aux[6][3] = (ImageView) findViewById(R.id.imgg4);
        aux[0][4] = (ImageView) findViewById(R.id.imga5);
        aux[1][4] = (ImageView) findViewById(R.id.imgb5);
        aux[2][4] = (ImageView) findViewById(R.id.imgc5);
        aux[3][4] = (ImageView) findViewById(R.id.imgd5);
        aux[4][4] = (ImageView) findViewById(R.id.imge5);
        aux[5][4] = (ImageView) findViewById(R.id.imgf5);
        aux[6][4] = (ImageView) findViewById(R.id.imgg5);
        aux[0][5] = (ImageView) findViewById(R.id.imga6);
        aux[1][5] = (ImageView) findViewById(R.id.imgb6);
        aux[2][5] = (ImageView) findViewById(R.id.imgc6);
        aux[3][5] = (ImageView) findViewById(R.id.imgd6);
        aux[4][5] = (ImageView) findViewById(R.id.imge6);
        aux[5][5] = (ImageView) findViewById(R.id.imgf6);
        aux[6][5] = (ImageView) findViewById(R.id.imgg6);

        griglia = new GrigliaForza4(aux, giallo, viola);
        bottoni[0] = (ImageButton) findViewById(R.id.btnforza1);  //dichiarazione bottoni in alto
        bottoni[1] = (ImageButton) findViewById(R.id.btnforza2);
        bottoni[2] = (ImageButton) findViewById(R.id.btnforza3);
        bottoni[3] = (ImageButton) findViewById(R.id.btnforza4);
        bottoni[4] = (ImageButton) findViewById(R.id.btnforza5);
        bottoni[5] = (ImageButton) findViewById(R.id.btnforza6);
        bottoni[6] = (ImageButton) findViewById(R.id.btnforza7);
        for (int i = 0; i < 7; i++)
            bottoni[i].setBackgroundColor(Color.YELLOW);
    }

    public void bottoneCliccato(int n)
    {
        griglia.click(n);
        for (int i = 0; i < 7; i ++)
        {
            if (griglia.getGiallo()) {
                bottoni[i].setBackgroundColor(Color.rgb(255, 193, 7));  //modifica di colori e scritte in base al turno
                txtTurno.setText("TOCCA GIALLO");
            } else {
                bottoni[i].setBackgroundColor(Color.rgb(103, 58, 183));
                txtTurno.setText("TOCCA VIOLA");
            }
            if (griglia.colonnaPiena(i)) {
                bottoni[i].setClickable(false);
                bottoni[i].setBackgroundColor(Color.rgb(3, 169, 244));
                bottoni[i].setImageResource(0);
            }
        }
        if (griglia.checkVincita().equals("giallo")) {   //controllo delle vincite o pareggi
            txtTurno.setBackgroundColor(Color.rgb(255, 193, 7));
            txtTurno.setText("VINCE GIALLO");
            chiudiBottoni();
        }
        if (griglia.checkVincita().equals("viola")) {
            txtTurno.setBackgroundColor(Color.rgb(103, 58, 183));
            txtTurno.setText("VINCE VIOLA");
            chiudiBottoni();
        }
        if (griglia.checkVincita().equals("pareggio")) {
            txtTurno.setBackgroundColor(Color.GRAY);
            txtTurno.setText("PAREGGIO");
            chiudiBottoni();
        }
    }

    private void chiudiBottoni() //blocca tutti i bottoni dopo la fine di una partita
    {
        for (int i = 0; i < 7; i ++)
        {
            bottoni[i].setClickable(false);
            bottoni[i].setBackgroundColor(Color.rgb(3, 169, 244));
            bottoni[i].setImageResource(0);
        }
    }
}
