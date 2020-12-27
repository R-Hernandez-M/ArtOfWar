import java.util.Scanner;
public class Turno {
    int[]Atacado;
    int a;
    int b;
    Scanner scan=new Scanner(System.in);
    int puntos=50;
    Tablero mapa;
    Jugador j1;
    Jugador CPU;
    int Buscador_Unidad_J1=0;
    int Buscador_Unidad_CPU=0;
    int turnoID=0;
    boolean quedan_puntos=true;
    public Turno(Tablero mapa, Jugador j1, Jugador CPU){
        this.mapa=mapa;
        this.j1=j1;
        this.CPU=CPU;
        while (quedan_puntos){
            do{
                try{
                    System.out.println("introduzca una fila");
                    a=this.scan.nextInt();
                    if (a>10||a<1){
                        System.out.println("recuerde que debe ser en la fila entre 1 y 10");
                        throw new IllegalArgumentException();
                    }
                    System.out.println("introduzca una columna");
                    b=this.scan.nextInt();
                    if (b>2||b<1){
                        System.out.println("recuerde que debe ser en la columna 1 o 2");
                        throw new IllegalArgumentException();
                    }
                    mapa.Rellenar(a,b);
                    break;
                }catch (Exception e){
                    //System.out.println("recuerde introducir un número natural");
                    this.scan.nextLine();
                }
            }while (true);
            puntos-=5;
            if (puntos<1){
                quedan_puntos=false;
            }
        }
        j1.setEjercito(mapa);
        mapa.RellenarJugador2();
        CPU.setEjercito(mapa);
    }
    public Turno(Tablero mapa, Jugador j1, Jugador CPU,boolean test) {
        this.mapa = mapa;
        this.j1 = j1;
        this.CPU = CPU;
        char [][]aux=this.mapa.getTablero();
        for (int i=1;i<11;i++){
            for (int j=1;j<2;j++){
                aux[i][j]="A".charAt(0);
            }
        }
    }
    public void CambioDeTurno(){
        if (turnoID==0){
            int a;
            int b;
            System.out.println("Es el turno del jugador 1");
            System.out.println("Que desea hacer?\nmover unidad=0;atacar=1;pasar>=2");
            int accion=scan.nextInt();
            while (accion<2){
                if(accion==0){
                    int[] posicion=j1.getEjercito()[Buscador_Unidad_J1].getPosicion();
                    int[] temp=j1.MoverHumano(Buscador_Unidad_J1);
                    char[][] temporal=mapa.getTablero();
                    temporal[posicion[0]][posicion[1]]="-".charAt(0);
                    temporal[temp[0]][temp[1]]="A".charAt(0);
                    mapa.setTablero(temporal);
                    System.out.println(mapa);
                    temporal=null;
                    temp=null;
                    posicion=null;
                    System.out.println("Desea atacar?\nsi=0;no>=1");
                    int pregunta=scan.nextInt();
                    if (pregunta==0){
                        accion++;
                    }
                    else{
                        accion=2;
                    }
                }
                else if(accion==1){
                    Atacado=j1.AtacarHumano(Buscador_Unidad_J1);
                    for (int i=0;i<CPU.getEjercito().length;i++){
                        if(CPU.getEjercito()[i].getPosicion()==Atacado){
                            if(CPU.getEjercito()[i].RecibirDanno(j1.getEjercito()[Buscador_Unidad_J1].getAtaque())){
                                char [][]temp=mapa.getTablero();
                                temp[CPU.getEjercito()[i].getPosicion()[0]][CPU.getEjercito()[i].getPosicion()[1]]="-".charAt(0);
                                mapa.setTablero(temp);
                                System.out.println(mapa);
                                //CPU.getEjercito()[i]=null;

                            }
                            break;
                        }
                    }
                    accion++;
                }
            }
            if (accion>=2){
                System.out.println("Turno siguiente");
            }
            this.turnoID++;
            Buscador_Unidad_J1++;
            if(Buscador_Unidad_J1==10)
                Buscador_Unidad_J1=0;
        }
        else{
            System.out.println("Es el turno de la CPU");

            CPU.setEjercito(mapa);
            int[] posicion=CPU.getEjercito()[0].getPosicion();
            char[][] temporal=mapa.getTablero();
            temporal[posicion[0]][posicion[1]]="-".charAt(0);
            int[] temp=CPU.MoverAutomatico(0);
            temporal[temp[0]][temp[1]]="E".charAt(0);
            mapa.setTablero(temporal);
            System.out.println(mapa);
            //scan.nextLine();
            Atacado=CPU.AtacarAutomatico();
            if (Atacado[0]!=0){
                char [][]aux=mapa.getTablero();
                for(int i=0;i<j1.getEjercito().length;i++){
                    if(Atacado==j1.getEjercito()[i].getPosicion()){
                        if (j1.getEjercito()[1].RecibirDanno(CPU.getEjercito()[Buscador_Unidad_CPU].getAtaque())) {
                            aux[CPU.getEjercito()[Buscador_Unidad_CPU].getPosicion()[0]][CPU.getEjercito()[Buscador_Unidad_CPU].getPosicion()[1]] = "-".charAt(0);
                            mapa.setTablero(aux);
                            System.out.println(mapa);
                            break;
                        }
                    }
                }
            }
            System.out.println(mapa);
            //scan.nextLine();
            System.out.println("turno Siguiente");
            this.turnoID--;
            Buscador_Unidad_CPU++;
            if(Buscador_Unidad_CPU==10)
                Buscador_Unidad_CPU=0;

        }
    }
    public Tablero getMapa() {
        return mapa;
    }
    public void setMapa(Tablero mapa) {
        this.mapa = mapa;
    }
    public Jugador getCPU() {
        return CPU;
    }
    public Jugador getJ1() {
        return j1;
    }
    public boolean Victory(){
        int k=j1.ejercito.length;
        int f=CPU.ejercito.length;
        Boolean Continue=true;
        if (turnoID==0){
            for (int i=0;i<CPU.ejercito.length;i++){
                if (CPU.ejercito[i]==null){
                    k--;
                    if (k==0){
                        Continue=false;
                        System.out.println("!VICTORIA!");
                    }
                }
            }
        }
        else{
            for (int i=0;i<j1.ejercito.length;i++){
                if (j1.ejercito[i]==null){
                    f--;
                    if (f==0){
                        Continue=false;
                        System.out.println("DERROTA...");
                    }
                }
            }
        }
        return Continue;
    }
}
