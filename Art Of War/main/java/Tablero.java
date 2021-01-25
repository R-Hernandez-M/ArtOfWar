import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tablero {
    //declaro las variables de imagenes necesarias
    ImageIcon[][] iconos=new ImageIcon[10][16];
    Image fondo=Toolkit.getDefaultToolkit().getImage("src/main/resources/fondo_2.png");
    //declaro los botones necesarios
    JButton genericButton;
    JButton genericButton1;
    JButton genericButton2;
    JButton genericButton3;
    //declaro la ventana, los paneles necesarios y labels necesarios
    JFrame ventanaPrincipal;
    JPanel panelCentral;
    JPanel panelSur;
    JLabel paraMostrar1;
    //declaro los ejercitos de los jugadores
    ArrayList <Unit> ejercito1=new ArrayList<Unit>(0);
    ArrayList <Unit> ejercito2=new ArrayList<Unit>(0);
    //variables varias que se volvieron necesarias para algunas funciones
    int selector=0;
    int contadorEjercito=0;
    public Tablero(){
        //llena el tablero de imagenes transparentes
        for(int i=0;i<10;i++)
            ejercito1.add(new Unit());
        for (int i=0;i<10;i++){
            for (int j=1;j<15;j++){
                iconos[i][j]=new ImageIcon("src/main/resources/empty.png");
            }
        }
        //inicializa la ventana principal del tablero y define sus características
        ventanaPrincipal=new JFrame();
        ventanaPrincipal.setContentPane(new ImagePainter(fondo));
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLayout(new BorderLayout());
        ventanaPrincipal.setSize(1280,820);
        ventanaPrincipal.setResizable(false);
        //crea un panel central con un layout de grid para poner nuestras unidades
        panelCentral=new JPanel(new GridLayout(10,16));
        panelCentral.setOpaque(false);
        //coloca el panel central en la ventana principal
        ventanaPrincipal.add(panelCentral,BorderLayout.CENTER);
        //crea un panel para poner botones en la parte de abajo de la pantalla
        panelSur=new JPanel(new FlowLayout());
        panelSur.setBackground(Color.getHSBColor((float)0.57,(float)0.3,(float)0.3));
        //panelSur.setOpaque(false);
        //crea un par de botones para agregar unidades al ejercito del jugador y los agrega al panel sur
        genericButton1=new JButton(new ImageIcon("src/main/resources/hombre de armas.png"));
        genericButton1.addActionListener(new agregarManAtArms());
        panelSur.add(genericButton1);
        genericButton2=new JButton(new ImageIcon("src/main/resources/arquero.png"));
        genericButton2.addActionListener(new agregarArcher());
        panelSur.add(genericButton2);
        genericButton3=new JButton(new ImageIcon("src/main/resources/jinete.png"));
        genericButton3.addActionListener(new agregarJinete());
        panelSur.add(genericButton3);
        //añade el panel sur a la ventana principal
        ventanaPrincipal.add(panelSur,BorderLayout.SOUTH);
        //genericButton=new JButton();
        //panelSur.add(genericButton);
        //coloca cada imagen del tablero en un grid que esta en un jpanel en el centro del jframe principal
        for(int i=0;i<10;i++){
            for (int j=0;j<16;j++){
                genericButton=new JButton(this.iconos[i][j]);
                genericButton.setOpaque(false);
                panelCentral.add(genericButton);
                //paraMostrar1=new JLabel(getIconos()[i][j]);
                //paraMostrar1.setOpaque(false);
                //panelCentral.add(paraMostrar1);
            }
        }
        for (int i=0;i<10;i++){
            if((int)(Math.random()*2)==0)
                ejercito2.add(new ManAtArms());
            else
                ejercito2.add(new Archer());
        }
        ventanaPrincipal.setVisible(true);
        for(int i=0;i<10;i++){
            ejercito2.add(new ManAtArms());
        }
    }
    public ImageIcon[][] getIconos() {
        return iconos;
    }
    public void updatePosicion(int[] posicionAntigua, int []posicionNueva, int index, ArrayList<Unit> ejercito){
        iconos[posicionNueva[0]][posicionNueva[1]]=ejercito.get(index).getIcon();
        iconos[posicionAntigua[0]][posicionAntigua[0]]=new ImageIcon("src/main/resources/empty.png");


    }
    public void borrarUnidad(int []posicion){
        iconos[posicion[0]][posicion[1]]=new ImageIcon("src/main/resources/empty.png");
    }
    //listeners para botones de la UI
    public class escuchaBotones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    public class agregarManAtArms implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            addUnit(0);
            addEjercitos();
            actualizarTablero();
            if(contadorEjercito>9)
                deleteBottomButton();
        }

    }
    public class agregarArcher implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addUnit(1);
            addEjercitos();
            actualizarTablero();
            if(contadorEjercito>9)
                deleteBottomButton();
        }
    }
    public class agregarJinete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            addUnit(2);
            addEjercitos();
            actualizarTablero();
            if(contadorEjercito>9)
                deleteBottomButton();
        }

    }
    public void addEjercitos(){
        for(int i=0;i<10;i++){
            this.iconos[i][0]=ejercito1.get(i).getIcon();
        }
        for(int i=0;i<10;i++){
            this.iconos[i][15]=ejercito2.get(i).getIcon();
        }
        for (int i=159;i>=0;i--){
            panelCentral.remove(i);
        }
        for(int i=0;i<10;i++) {
            for (int j=0;j<16;j++){
                paraMostrar1=new JLabel(getIconos()[i][j]);
                paraMostrar1.setOpaque(false);
                panelCentral.add(paraMostrar1);
            }
        }
        //for(int i=0;i<10;i++){
           // for (int j=0;j<16;j++){
               // genericButton=new JButton(this.iconos[i][j]);
              //  genericButton.setOpaque(false);
             //   panelCentral.add(genericButton);
                //paraMostrar1=new JLabel(getIconos()[i][j]);
               // paraMostrar1.setOpaque(false);
               // panelCentral.add(paraMostrar1);
          // }
        //}

    }
    public void actualizarTablero(){
        SwingUtilities.updateComponentTreeUI(ventanaPrincipal);
    }
    public void addUnit(int selector){
        if (selector==0) {
            ejercito1.remove(0);
            ejercito1.add(new ManAtArms());
        }
        else if(selector==1) {
            ejercito1.remove(0);
            ejercito1.add(new Archer());
        }
        //for (int i=0;i<10;i++)
        //    System.out.println(ejercito1.get(i));
        this.contadorEjercito++;
    }
    public void deleteBottomButton(){
        this.panelSur.remove(genericButton1);
        this.panelSur.remove(genericButton2);
        this.panelSur.remove(genericButton3);
        this.panelSur.add(new JButton("boton genérico"));
    }
}
