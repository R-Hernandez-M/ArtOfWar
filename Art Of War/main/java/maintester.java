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
        Tablero campoDeJuego=new Tablero();
        campoDeJuego.addEjercitos();
        //terminamos de llenar el ejercito del usuario---------------------------------------------------------------------------
        campoDeJuego.actualizarTablero();
    }


}
