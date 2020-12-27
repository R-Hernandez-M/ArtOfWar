import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
public class Tablero {
    char [][]Tablero=new char [1][1];
    int a=12;
    int b=12;
    Scanner scan=new Scanner(System.in);
    public Tablero(){
        //a es fila mientras que b es columna
        Tablero=new char [this.a][this.b];
        for (int i=0;i<12;i++) {
            for (int j=0;j<12;j++){
                Tablero[i][j]="-".charAt(0);
            }
        }
        this.Tablero=Tablero;
    }
    public Tablero(int a,int b){
        //Scanner scan= new Scanner(System.in);
        //System.out.println("Tamaño del mapa:");
        //int a= scan.nextInt();
        Tablero=new char [a][b];
        for (int i=0;i<Tablero.length;i++) {
            for (int j=0;j<Tablero.length;j++){
                Tablero[i][j]="-".charAt(0);
            }
        }
        this.Tablero=Tablero;
    }
    public char[][] getTablero() {
        return Tablero;
    }
    //para colocar soldados
    public void Rellenar(int a, int b){
        if (Tablero[a][b]=="A".charAt(0))
        {
            System.out.println("ese espacio esta ocupado");
            throw new IllegalArgumentException();
        }
        else{
            Tablero[a][b]="A".charAt(0);
        }

    }
    //para colocar soldados enemigos
    public void RellenarJugador2(){
        int a;
        int b;
        int units_on_grid=0;
        boolean is_done=false;
        while (is_done==false){
            b=(int) (Math.random()*2)+9;
            a=(int) (Math.random()*10)+1;
            if (this.Tablero[a][b]=="E".charAt(0)){

            }
            else{
                this.Tablero[a][b]="E".charAt(0);
                units_on_grid++;
            }
            if (units_on_grid>=10){
                is_done=true;
            }
        }
    }
    public void setTablero(char[][] tablero) {
        Tablero = tablero;
    }
    @Override
    public String toString() {
        String c="";
        for (int i=1;i<11;i++){
            c+=("|"+this.Tablero[i][1]+"|"+"|"+this.Tablero[i][2]+"|"+"|"+this.Tablero[i][3]+"|"+"|"+this.Tablero[i][4]+"|"+"|"+this.Tablero[i][5]+"|"+"|"+this.Tablero[i][6]+"|"+"|"+this.Tablero[i][7]+"|"+"|"+this.Tablero[i][8]+"|"+"|"+this.Tablero[i][9]+"|"+"|"+this.Tablero[i][10]+"|\n");
        }
        return c;
    }
    //public Escombros//

}
