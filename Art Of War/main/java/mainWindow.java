import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class mainWindow {
    Tablero campoDeJuego;
    DJ djmambo=new DJ();
    JFrame frame;
    JButton boton;
    JPanel panelCentral;
    ImageIcon titulo=new ImageIcon("src/main/resources/the art of war.jpg");
    public mainWindow(){
        djmambo.playMenu();
        frame=new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        boton=new JButton(new ImageIcon("src/main/resources/boton inicial.jpg"));
        boton.addActionListener(new empezar());
        frame.add(boton,BorderLayout.CENTER);
        frame.setSize(1260,901);
        frame.setVisible(true);
    }
    public class empezar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            campoDeJuego=new Tablero();
            frame.setVisible(false);

        }

    }
}
