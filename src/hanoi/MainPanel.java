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

    public abstract void pausarAnimacion();

    public abstract void iniciarAnimacion();

    public abstract int posicionFichaX(int ficha, int torre);

    public abstract int posicionFichaY(int nivel);

    protected void initComponentes() {

        fichas = new Image[LIMITE_FICHAS + 1];
        for (int i = 1; i <= LIMITE_FICHAS; i++) {
            ImageIcon ii = new ImageIcon(this.getClass().getResource("/files/" + i + ".png"));
            fichas[i] = ii.getImage();
        }
    }
}
