import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
public class Jugador {

    //Unit []ejercito=new Unit[10];
    Tablero mapa;
    boolean computadora;
    Scanner scan = new Scanner(System.in);

    public Jugador(boolean computadora) {
        this.computadora = computadora;
    }

    public int[] MoverAutomatico(int h, ArrayList<Unit> ejercito) {
        int[] nueva_posicion = ejercito.get(h).getPosicion();
        nueva_posicion[1] -= 2;
        ejercito.get(h).move(nueva_posicion);
        return nueva_posicion;
    }

    public int[] AtacarAutomatico(ArrayList<Unit> ejercito, int hh, int[][] ubicacionAliado) {
        int[] enemigoEncontrado = new int[2];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 16; j++) {
                if (ubicacionAliado[i][j] > 0) {
                    enemigoEncontrado[0] = i;
                    enemigoEncontrado[1] = j;
                    ejercito.get(hh).Attack(enemigoEncontrado);
                    break;
                } else {

                }
            }
        }
        return enemigoEncontrado;
    }


    public int[] MoverHumano(ArrayList<Unit> ejercito, int h,int[]a) {
        int b, c;
        int []nuevaPosicion=a;

        return nuevaPosicion;
    }
}/*
    public int[] AtacarHumano(int a){
        return ejercito[a].Atacar();
    }
    }*/