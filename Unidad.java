import java.util.Arrays;
import java.util.Scanner;
public class Unidad {
    int ataque=3;
    int rango=1;
    int vida=2;
    int velocidad=2;
    Scanner scan=new Scanner(System.in);
    int []posicion=new int[2];
    Tablero mapa;
    public Unidad(int a, int b, Tablero mapa){
        posicion [0]=a;
        posicion [1]=b;
        this.mapa=mapa;
    }
    public int [] Mover(int a, int b){
        int []PosicionNueva={a,b};
        this.posicion=PosicionNueva;
        return this.posicion;
    }
    public int[] Atacar(){
        int a,b;
        do {
            try{
                System.out.println("introduzca la fila de la posición a atacar");
                a=scan.nextInt();
                System.out.println("introduzca la columna de la posición a atacar");
                b=scan.nextInt();
                if(this.mapa.getTablero()[a][b]=="E".charAt(0)){
                    break;
                }
                else{
                    System.out.println("no se puede atacar al vacio, aun desea atacar?\n si=0,no>=1");
                    int condicion=scan.nextInt();
                    if (condicion>0) {
                        return null;
                    }
                    else{
                        throw new IllegalArgumentException();
                    }
                }
            }catch (Exception e){
                scan.nextLine();
            }
        }while(true);
        int []posicion_enemigo={a,b};
        return posicion_enemigo;
    }
    public int[] AtacarIA(int a, int b){
            int []posicionEnemigo={a,b};
        return posicionEnemigo;
    }
    public int[] getPosicion() {
        return posicion;
    }
    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }
    public int getRango() {
        return rango;
    }
    public boolean RecibirDanno(int danno){
        this.vida-=danno;
        if (this.vida<1)
            return true;
        else
            return false;
    }
    public int getAtaque() {
        return ataque;
    }

    @Override
    public String toString() {
        String a=this.posicion[0]+","+posicion[1];
        return a;
    }
}
