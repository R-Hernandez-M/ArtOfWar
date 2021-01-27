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
    public int[] MoverAutomatico(int h, ArrayList<Unit> ejercito,int[][] enemigo) {
        int[] nueva_posicion = ejercito.get(h).getPosicion();
        if (nueva_posicion[1]==0&&nueva_posicion[0]==0)
            return nueva_posicion;
        boolean noEsPosible=true;
        nueva_posicion[1] -= ejercito.get(h).getSpeed();
        if (nueva_posicion[1]<0)
            nueva_posicion[1]=0;
        while (noEsPosible){
            if(enemigo[nueva_posicion[0]][nueva_posicion[1]]==0){
                noEsPosible=false;
            }
            else {
                nueva_posicion[1]++;
            }
        }

        ejercito.get(h).move(nueva_posicion);
        return nueva_posicion;

    }
    public int[] AtacarAutomatico(ArrayList<Unit> ejercito, int hh, int[][] ubicacionAliado) {
        int[] enemigoEncontrado = {-1,-1};
        int[] ubActual=ejercito.get(hh).getPosicion();
        int range=ejercito.get(hh).getRange();
        int limXiz=0,limXder=0,limYiz=0,limYder=0;
        limXiz=ubActual[0]-range;
        if (limXiz<0)
            limXiz=0;
        limXder=ubActual[0]+range;
        if (limXder>9)
            limXder=9;
        limYiz=ubActual[1]-range;
        if (limYiz<0)
            limYiz=0;
        limYder=ubActual[1]+range;
        if (limYder>15)
            limYder=15;
        for (int i = limXiz; i < limXder; i++) {
            for (int j = limYiz; j < limYder; j++) {
                System.out.println("i: "+i+", j: "+j);
                if (ubicacionAliado[i][j] > 0) {
                    enemigoEncontrado[0] = i;
                    enemigoEncontrado[1] = j;
                    ejercito.get(hh).Attack(enemigoEncontrado);
                    break;
                }
            }
        }
        System.out.println("encontrado: "+enemigoEncontrado[0]+","+enemigoEncontrado[1]);
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