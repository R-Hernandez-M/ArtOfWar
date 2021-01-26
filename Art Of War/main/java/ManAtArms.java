import javax.swing.*;

public class ManAtArms extends Unit {
    private String tipo;
    //builder
    public ManAtArms(){
        super.tipo="hombre de armas";
        super.id=1;
        super.hp=10;
        super.atk=5;
        super.armor=2;
        super.range=1;
        super.speed=2;
        super.icon=new ImageIcon("src/main/resources/hombre de armas jugador.png");
    }

    //shows on console the information of the unit
    @Override
    public String toString() {
        return "ManAtArms{" +
                "tipo='" + tipo + '\'' +
                ", hp=" + hp +
                ", atk=" + atk +
                ", armor=" + armor +
                ", range=" + range +
                ", speed=" + speed +
                ", posicion="+posicion[0]+","+posicion[1]+'}';
    }
}
