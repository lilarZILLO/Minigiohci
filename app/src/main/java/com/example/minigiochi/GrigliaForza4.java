package com.example.minigiochi;

import android.widget.ImageView;

public class GrigliaForza4 {
    private final int RIGHE = 6;
    private final int COLONNE = 7;
    private ImageView[][] griglia = new ImageView[COLONNE][RIGHE];
    private char[][] caselle = new char[7][6];
    private int tesseraGialla, tesseraViola;
    private boolean turno = true; //1 = giallo, 0 = viola

    public GrigliaForza4(ImageView[][] immages, int giallo, int viola) {
        griglia = immages;
        tesseraGialla = giallo;
        tesseraViola = viola;
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 6; j++)
                caselle[i][j] = 'n';
    }

    public void click(int n) {
        tesseraCaduta(n);
    }

    public void tesseraCaduta(int n) {   //posiziona la tessera nel posto giusto
        for (int i = 5; i >= 0; i--) {
            if (caselle[n][i] == 'n') {
                if (turno) {
                    griglia[n][i].setImageResource(tesseraGialla);
                    caselle[n][i] = 'g';
                } else {
                    griglia[n][i].setImageResource(tesseraViola);
                    caselle[n][i] = 'v';
                }
                turno = !turno;
                break;
            }
        }
    }

    public boolean getGiallo() {
        return turno;
    } //ritorna true se è il turno del giallo

    public boolean colonnaPiena(int n) {
        return !(caselle[n][0] == 'n');
    }  //ritorna true se la colonna è piena

    public String checkVincita() {
        for (int i = 0; i < 7; i++) {   //controllo verticali
            for (int j = 0; j < 3; j++) {
                if (caselle[i][j] == caselle[i][j + 1] && caselle[i][j] == caselle[i][j + 2] && caselle[i][j] == caselle[i][j + 3]) {
                    if (caselle[i][j] == 'g')
                        return "giallo";
                    else if (caselle[i][j] == 'v')
                        return "viola";
                }
            }
        }
        for (int i = 0; i < 4; i ++)    //controllo orizzontali
        {
            for (int j = 0; j < 6; j ++)
            {
                if (caselle[i][j] == caselle[i + 1][j] && caselle[i][j] == caselle[i + 2][j] && caselle[i][j] == caselle[i + 3][j])
                {
                    if (caselle[i][j] == 'g')
                        return "giallo";
                    else if (caselle[i][j] == 'v')
                        return "viola";
                }
            }
        }
        for (int i = 0; i < 4; i++)  //controllo diagonali /
        {
            for (int j = 0; j < 3; j ++)
            {
                if (caselle[i][j] == caselle[i + 1][j + 1] && caselle[i][j] == caselle[i + 2][j + 2] && caselle[i][j] == caselle[i + 3][j + 3])
                {
                    if (caselle[i][j] == 'g')
                        return "giallo";
                    else if (caselle[i][j] == 'v')
                        return "viola";
                }
            }
        }
        for (int i = 3; i < 7; i++)    //controllo diagonali \
        {
            for (int j = 0; j < 3; j ++)
            {
                if (caselle[i][j] == caselle[i - 1][j + 1] && caselle[i][j] == caselle[i - 2][j + 2] && caselle[i][j] == caselle[i - 3][j + 3])
                {
                    if (caselle[i][j] == 'g')
                        return "giallo";
                    else if (caselle[i][j] == 'v')
                        return "viola";
                }
            }
        }
        boolean continua = true;
        int cont = 0;
        while (cont < 7 && continua)
        {
            if (!colonnaPiena(cont))
                continua = false;
            cont ++;
        }
        if (continua)
            return "pareggio";
        return "nessuno";
    }
}
