import java.util.Scanner;
import java.lang.Math;
public class Jugador {
    Unidad []ejercito=new Unidad[10];
    Tablero mapa;
    boolean computadora;
    Scanner scan=new Scanner(System.in);
    int selector_unidad=0;
    public Jugador(boolean computadora){
        this.computadora=computadora;

    }
    public int[] MoverAutomatico(int h) {
        int []nueva_posicion=ejercito[h].getPosicion();
        System.out.println(nueva_posicion[0]+","+nueva_posicion[1]);
        nueva_posicion[1]-=2;
        ejercito[h].setPosicion(nueva_posicion);
        return nueva_posicion;
    }
    public int[] AtacarAutomatico(){
        int [] enemigo_encontrado=new int[2];
        for (int i = ejercito[selector_unidad].getPosicion()[0] - 1; i < ejercito[selector_unidad].getPosicion()[0] + 1; i++) {
            for (int j = ejercito[selector_unidad].getPosicion()[1] - 1; j < ejercito[selector_unidad].getPosicion()[1] + 1; j++) {
                if (mapa.getTablero()[i][j] == "A".charAt(0)) {
                    enemigo_encontrado=ejercito[selector_unidad].AtacarIA(i,j);
                }
            }
        }
        return enemigo_encontrado;
    }
    public int[] MoverHumano(int a){
        int b,c;
        do{
            try{
                System.out.println("introduzca la fila de la posición a moverse");
                b=scan.nextInt();
                System.out.println("introduzca la columna de la posición a moverse");
                c=scan.nextInt();
                if (Math.abs(b-ejercito[1].getPosicion()[0])>2||Math.abs(c-ejercito[1].getPosicion()[1])>2){
                    System.out.println("No es posible moverse a esa posicion\nIntroduzca una posición nueva");
                    throw new IllegalArgumentException();
                }
                break;
            }catch (Exception e){
                scan.nextLine();
            }
        }while(true);
        return ejercito[a].Mover(b,c);
    }
    public int[] AtacarHumano(int a){
        return ejercito[a].Atacar();
    }
    public Unidad[] getEjercito() {
        return ejercito;
    }
    public void setEjercito(Tablero mapa) {
        this.mapa=mapa;
        int h=0;
        if (computadora){
            for (int i=0;i<10;i++){
                for (int j=0;j<10;j++){
                    if (this.mapa.getTablero()[i][j]=="E".charAt(0)) {
                        ejercito[h] = new Unidad(i, j, mapa);
                        h++;
                    }
                }
            }
        }
        else{
            for (int i=0;i<10;i++){
                for (int j=0;j<10;j++){
                    if (this.mapa.getTablero()[i][j]=="A".charAt(0)) {
                        ejercito[h] = new Unidad(i, j, mapa);
                        h++;
                    }
                }
            }
        }
    }
    public void setMapa(Tablero mapa) {
        this.mapa = mapa;
    }
}
