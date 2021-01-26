import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;

public class maintester {
    public static void main(String[] args) {
        JFrame ventanaInicial=new JFrame();
        ventanaInicial.setLayout(new BorderLayout());
        JButton botonCentral=new JButton(new ImageIcon("src/main/resources/boton inicial.jpg"));
        botonCentral.addActionListener(new empezar());
        ventanaInicial.add(botonCentral,BorderLayout.CENTER);
        ventanaInicial.setSize(1260,901);
        ventanaInicial.setVisible(true);
        //Tablero campoDeJuego=new Tablero();
       // campoDeJuego.addEjercitos();
        //terminamos de llenar el ejercito del usuario---------------------------------------------------------------------------
       // campoDeJuego.actualizarTablero();
    }
    public static class empezar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Tablero campoDeJuego=new Tablero();

        }

    }


}
