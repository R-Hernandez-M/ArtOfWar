import javax.swing.*;
public class Jinete extends Unit {
    //builder
    public Jinete() {
        super.tipo = "jinete";
        super.id=3;
        super.hp = 10;
        super.atk = 5;
        super.armor = 0;
        super.range=1;
        super.speed = 5;
        super.icon=new ImageIcon("src/main/resources/jinete jugador.png");
    }
    //show on console the info of the unit

    @Override
    public String toString() {
        return "Jinete{" +
                "tipo='" + tipo + '\'' +
                ", hp=" + hp +
                ", atk=" + atk +
                ", armor=" + armor +
                ", range=" + range +
                ", speed=" + speed +
                ", posicion="+posicion[0]+","+posicion[1]+'}';
    }
}