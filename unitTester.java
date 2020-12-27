import org.junit.Before;
import org.junit.Test;
import java.lang.Math;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class unitTester {
    Tablero mapa=new Tablero();
    Jugador j1=new Jugador(false);
    Jugador cpu=new Jugador(true);
    Turno arbitro=new Turno(mapa,j1,cpu,true);
    @Before
    public void initializer(){
        mapa.RellenarJugador2();
    }
    @Test
    public void test1(){
        System.out.println(mapa);
        cpu.setEjercito(mapa);
        int[] posicion=cpu.getEjercito()[0].getPosicion();
        char[][] temporal=mapa.getTablero();
        temporal[posicion[0]][posicion[1]]="-".charAt(0);
        int[] temp=cpu.MoverAutomatico(0);
        temporal[temp[0]][temp[1]]="E".charAt(0);
        mapa.setTablero(temporal);
        System.out.println(mapa);

    }
}
