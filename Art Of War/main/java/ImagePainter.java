import javax.swing.*;
import java.awt.*;
import java.io.IOException;
class ImagePainter extends JComponent {
    //esta clase es para poner fondo a JFrame. Se copia y pega del internet
    private Image image;
    public ImagePainter(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
