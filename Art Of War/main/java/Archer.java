import javax.swing.*;

public class Archer extends Unit{

    //builder
    public Archer(){
        super.tipo="arquero";
        super.id=2;
        super.hp=5;
        super.atk=4;
        super.armor=0;
        super.range=5;
        super.speed=1;
        super.icon=new ImageIcon("src/main/resources/arquero jugador.png");
    }
    //shows on console the information of the unit
    @Override
    public String toString() {
        return "Archer{" +
                "tipo='" + tipo + '\'' +
                ", hp=" + hp +
                ", atk=" + atk +
                ", armor=" + armor +
                ", range=" + range +
                ", speed=" + speed +
                ", posicion="+posicion[0]+","+posicion[1]+'}';
    }
}
