import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
public class Jugador {

    //Unit []ejercito=new Unit[10];
    Tablero mapa;
    boolean computadora;
    Scanner scan = new Scanner(System.in);
    //constructor
    public Jugador(boolean computadora) {
        this.computadora = computadora;
    }
    //acciones de la computadora
    public int[] MoverAutomatico(int h, ArrayList<Unit> ejercito) {
        int[] nueva_posicion = ejercito.get(h).getPosicion();
        nueva_posicion[1] -= ejercito.get(h).getSpeed();
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
    //acciones del jugador humano
    public boolean MoverHumano(ArrayList<Unit> ejercito, int h,int[]a) {
        /*int []nuevaPosicion=a;
        if (Math.abs(nuevaPosicion[0]-ejercito.get(h).getPosicion()[0])<=ejercito.get(h).getSpeed()&&Math.abs(nuevaPosicion[1]-ejercito.get(h).getPosicion()[1])<=ejercito.get(h).getSpeed())
            return true;
        else
            return false;*/
        return ejercito.get(h).move(a);
    }
    public boolean atacarHumano(ArrayList<Unit> ejercito, int h,int[]a){
        int []atacarPosicion=a;
        return ejercito.get(h).Attack(atacarPosicion);
    }
}/*
    public int[] AtacarHumano(int a){
        return ejercito[a].Atacar();
    }
    }*/