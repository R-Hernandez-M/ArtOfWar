import javax.swing.*;
public class Jinete extends Unit {
    private String tipo;

    //builder
    public Jinete() {
        tipo = "jinete";
        super.hp = 10;
        super.atk = 5;
        super.armor = 1;
        super.range=1;
        super.speed = 5;
        super.icon=new ImageIcon("src/main/resources/jinete.jpg");
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
                '}';
    }
}
