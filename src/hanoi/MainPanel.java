package hanoi;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class MainPanel extends javax.swing.JPanel {

    protected static final int LIMITE_FICHAS = 8;
    protected static final int LIMITE_TORRES = 3;
    protected static final int VELOCIDAD = 1;
    protected int velocidad;
    protected int noFichas;
    protected Image[] fichas;
    protected Image background;
    protected Image palito, palito2, palitoFinal1, palitoFinal2, palitoFinal3;

    public abstract void pausarAnimacion();

    public abstract void iniciarAnimacion();

    public abstract int posicionFichaX(int ficha, int torre);

    public abstract int posicionFichaY(int nivel);

    protected void initComponentes() {

        background = new ImageIcon(this.getClass().getResource("/files/background.png")).getImage();
        palito = new ImageIcon(this.getClass().getResource("/files/palito.png")).getImage();
        palito2 = new ImageIcon(this.getClass().getResource("/files/palito2.png")).getImage();
        palitoFinal1 = palito;
        palitoFinal2 = palito;
        palitoFinal3 = palito;
        
        fichas = new Image[LIMITE_FICHAS + 1];
        for (int i = 1; i <= LIMITE_FICHAS; i++) {
            ImageIcon ii = new ImageIcon(this.getClass().getResource("/files/" + i + ".png"));
            fichas[i] = ii.getImage();
        }
    }
}
