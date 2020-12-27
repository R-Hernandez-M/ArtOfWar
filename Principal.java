public class Principal {
    public static void main(String[] args) {
        Tablero mapa=new Tablero();
        Jugador j1=new Jugador(false);
        Jugador CPU=new Jugador(true);
        Turno arbitro=new Turno(mapa,j1,CPU);
        System.out.println(mapa);
        while (arbitro.Victory()){
            arbitro.CambioDeTurno();
            arbitro.Victory();
        }
    }
}
