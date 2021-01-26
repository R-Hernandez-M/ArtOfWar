import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tablero {
    //crear jugadores
    Jugador player=new Jugador(false);
    Jugador cpu=new Jugador(true);
    //declaro las variables de imagenes necesarias
    ImageIcon[][] iconos = new ImageIcon[10][16];
    Image fondo = Toolkit.getDefaultToolkit().getImage("src/main/resources/fondo_2.png");
    Image icon = Toolkit.getDefaultToolkit().getImage("src/main/resources/hombre_de_armas.png");
    //declaro los botones necesarios
    JButton genericButton;
    JButton genericButton1;
    JButton genericButton2;
    JButton genericButton3;
    JButton[][] botones = new JButton[10][16];
    int[][] ubicacionAliado=new int[10][16];
    int[][] ubicacionEnemigo=new int[10][16];


    //declaro la ventana, los paneles necesarios y labels necesarios
    JFrame ventanaPrincipal;
    JPanel panelCentral;
    JPanel panelSur;
    JLabel paraMostrar1;
    //declaro los ejercitos de los jugadores
    ArrayList<Unit> ejercito1 = new ArrayList<Unit>(0);

    ArrayList <Unit> ejercito2=new ArrayList<Unit>(0);
    //variables varias que se volvieron necesarias para algunas funciones
    int h=0;
    int selector=0;
    int contadorEjercito=0;
    int hh=0;
    int selectorAccion=0;
    public Tablero(){
        //llena el tablero de imagenes transparentes
        for(int i=0;i<10;i++)
            ejercito1.add(new Unit());
        for (int i=0;i<10;i++){
            for (int j=1;j<15;j++){
                iconos[i][j]=new ImageIcon("src/main/resources/empty.png");
            }
        }
        for(int i=0;i<10;i++){
            for (int j=0;j<16;j++){
                ubicacionAliado[i][j]=0;
                ubicacionEnemigo[i][j]=0;
            }
        }
        //inicializa la ventana principal del tablero y define sus características
        ventanaPrincipal=new JFrame();
        ventanaPrincipal.setTitle("The Art of War 0.1 pre-alpha");
        ventanaPrincipal.setIconImage(icon);
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
        genericButton1=new JButton(new ImageIcon("src/main/resources/hombre_de_armas.png"));
        genericButton1.addActionListener(new agregarManAtArms());
        panelSur.add(genericButton1);
        genericButton2=new JButton(new ImageIcon("src/main/resources/arquero_jugador.png"));
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
                botones[i][j]=new JButton(this.iconos[i][j]);
                botones[i][j].setText(i+","+j);
                botones[i][j].setOpaque(false);
                botones[i][j].setContentAreaFilled(false);
                panelCentral.add(botones[i][j]);
                //paraMostrar1=new JLabel(getIconos()[i][j]);
                //paraMostrar1.setOpaque(false);
                //panelCentral.add(paraMostrar1);
            }
        }
        for (int i=0;i<10;i++){
            if((int)(Math.random()*2)==0) {
                ejercito2.add(new ManAtArms());
                int [] pos=new int[2];
                pos[0]=i;
                pos[1]=15;
                ejercito2.get(i).setPosicion(pos);
                ejercito2.get(i).setIcon(new ImageIcon("src/main/resources/hombre_de_armas_cpu.png"));
            }
            else {
                ejercito2.add(new Archer());
                int [] pos=new int[2];
                pos[0]=i;
                pos[1]=15;
                ejercito2.get(i).setPosicion(pos);
                ejercito2.get(i).setIcon(new ImageIcon("src/main/resources/arquero_cpu.png"));
            }
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
            String a=e.getActionCommand();
            int[]b=new int[2];
            b[0]=(int)a.charAt(0);
            b[1]=(int)a.charAt(2);
            if (selectorAccion==0){
                player.MoverHumano(ejercito1,hh,b);
            }
            else if(selectorAccion==1){

            }
            else if(selectorAccion==2){

            }
        }
    }
    public class moverJugador implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectorAccion=0;
        }
    }
    public class atacarJugador implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectorAccion=1;
        }
    }
    public class defenderJugador implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectorAccion=2;
        }
    }
    public class pasarTurno implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectorAccion=3;
        }
    }
    public class moverComputadora implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            int[]a=ejercito2.get(h).getPosicion();
            iconos[a[0]][a[1]]=new ImageIcon("src/main/resources/empty.png");
            a=cpu.MoverAutomatico(h,ejercito2);
            iconos[a[0]][a[1]]=ejercito2.get(h).getIcon();
            System.out.println(ejercito2.get(h).getPosicion()[0]+","+ejercito2.get(h).getPosicion()[1]);
            h++;
            if (h==10)
                h=0;
            actualizarTablero();
        }
    }
    public class atacarComputadora implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int[] as= cpu.AtacarAutomatico(ejercito2,hh,ubicacionAliado);
            if (ejercito2.get(hh).Attack(as)){
                    boolean f=ejercito1.get(ubicacionAliado[as[0]][as[1]]).receiveDamage(ejercito2.get(hh).getAtk());
                    if (f){
                        int[]a=ejercito1.get(ubicacionAliado[as[0]][as[1]]).getPosicion();
                        iconos[as[0]][as[1]]=new ImageIcon("src/main/resources/empty.png");
                        actualizarTablero();
                        System.out.println("ha muerto un soldado");
                        ubicacionAliado[as[0]][as[1]]=0;
                        for (int i=0;i<10;i++){
                            if (as==ejercito1.get(i).getPosicion()){
                                ejercito1.remove(i);
                            }
                        }
                    }
                    else{
                        System.out.println(ejercito1.get(ubicacionAliado[as[0]][as[1]]).getHp());
                    }
                }
            hh++;
            if(hh==10){
                hh=0;
                }
    }}
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
            this.ubicacionAliado[i][0]=ejercito1.get(i).getID();
        }
        for(int i=0;i<10;i++){
            this.iconos[i][15]=ejercito2.get(i).getIcon();
            this.ubicacionEnemigo[i][15]=ejercito2.get(i).getID();
        }
        for (int i=159;i>=0;i--){
            panelCentral.remove(i);
        }
        for(int i=0;i<10;i++){
            for (int j=0;j<16;j++){
                botones[i][j]=new JButton(this.iconos[i][j]);
                botones[i][j].setText(i+","+j);
                botones[i][j].setOpaque(false);
                botones[i][j].setContentAreaFilled(false);
                panelCentral.add(botones[i][j]);
                //paraMostrar1=new JLabel(getIconos()[i][j]);
                //paraMostrar1.setOpaque(false);
                //panelCentral.add(paraMostrar1);
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
        for (int i=159;i>=0;i--){
            panelCentral.remove(i);
        }
        for(int i=0;i<10;i++){
            for (int j=0;j<16;j++){
                botones[i][j]=new JButton(this.iconos[i][j]);
                botones[i][j].setText(i+","+j);
                botones[i][j].setOpaque(false);
                botones[i][j].setContentAreaFilled(false);
                panelCentral.add(botones[i][j]);
                //paraMostrar1=new JLabel(getIconos()[i][j]);
                //paraMostrar1.setOpaque(false);
                //panelCentral.add(paraMostrar1);
            }
        }
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
        else if(selector==2){
            ejercito1.remove(0);
            ejercito1.add(new Jinete());
        }
        //for (int i=0;i<10;i++)
        //    System.out.println(ejercito1.get(i));
        this.contadorEjercito++;
    }
    public void deleteBottomButton(){
        this.panelSur.remove(genericButton1);
        this.panelSur.remove(genericButton2);
        this.panelSur.remove(genericButton3);
        JButton prueba=new JButton("prueba Computadora");
        prueba.addActionListener(new moverComputadora());
        this.panelSur.add(prueba);
        JButton prueba1= new JButton("prueba ataque");
        prueba1.addActionListener(new atacarComputadora());
        this.panelSur.add(prueba1);
        for(int i=0;i<10;i++)
            System.out.println(ejercito1.get(i));
        JOptionPane.showMessageDialog(null,"Ejercito aliado lleno");

    }
}
