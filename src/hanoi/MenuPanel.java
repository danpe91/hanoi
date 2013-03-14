package hanoi;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    private BufferedImage fondo;

    public MenuPanel(BufferedImage fondo, int width, int height) {

        setSize(width, height);
        this.fondo = fondo;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), null);
    }
}
