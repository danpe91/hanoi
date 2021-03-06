package hanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * Clase que implemente la funcionalidad del algoritmo para el acomodo de
 * torres de HanoiPanel asi como las animaciones necesarias.
 */
public class HanoiPanel extends MainPanel {

    private Timer timer;
    private Movimiento[] movimientos;
    private Posicion[] posiciones;
    private boolean movimientoCompletado;
    private int movimientoActual;
    private int ficha;
    private int paso;
    private int nm;
    private int x;
    private int y;
    private int[] fichasEnTorre;

    public HanoiPanel(final int noFichas, final int speed, final MainFrame mainFrame) {

        this.noFichas = noFichas;
        this.velocidad = speed;

        initComponentes();
        initComponentesAnimacion();
        timer = new Timer(VELOCIDAD, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                switch (paso) {
                    case 1:         // Movimiento hacia arriba
                        if (y > 30) {
                            y -= velocidad;
                            posiciones[ficha].setY(y);
                        } else {
                            if (movimientos[movimientoActual].getTorreOrigen() < movimientos[movimientoActual].getTorreDestino()) {
                                paso = 2;
                            } else {
                                paso = 3;
                            }
                        }
                        break;
                    case 2:         // Movimiento hacia derecha
                        if (x < posicionFichaX(ficha, movimientos[movimientoActual].getTorreDestino())) {
                            x += velocidad;
                            posiciones[ficha].setX(x);
                        } else {
                            paso = 4;
                        }
                        break;
                    case 3:         // Movimiento hacia izquierda
                        if (x > posicionFichaX(ficha, movimientos[movimientoActual].getTorreDestino())) {
                            x -= velocidad;
                            posiciones[ficha].setX(x);
                        } else {
                            paso = 4;
                        }
                        break;
                    case 4:         // Movimiento hacia abajo
                        int nivel = fichasEnTorre[movimientos[movimientoActual].getTorreDestino()] + 1;
                        if (y < posicionFichaY(nivel)) {
                            y += velocidad;
                            posiciones[ficha].setY(y);
                        } else {
                            movimientoCompletado = true;
                        }
                        break;
                }
                if (movimientoCompletado) {
                    paso = 1;
                    fichasEnTorre[movimientos[movimientoActual].getTorreDestino()]++;
                    fichasEnTorre[movimientos[movimientoActual].getTorreOrigen()]--;
                    movimientoActual++;
                    if (movimientoActual == (int) Math.pow(2, noFichas)) {
                        timer.stop();
                        mainFrame.resolucionCompletada();
                    } else {
                        movimientoCompletado = false;
                        ficha = movimientos[movimientoActual].getFicha();
                        x = posiciones[ficha].getX();
                        y = posiciones[ficha].getY();
                    }
                }
                repaint();
            }
        });
    }

    private void initComponentesAnimacion() {

        nm = 0;
        fichasEnTorre = new int[LIMITE_TORRES + 1];
        fichasEnTorre[1] = noFichas;
        fichasEnTorre[2] = 0;
        fichasEnTorre[3] = 0;
        ficha = 1;
        movimientos = new Movimiento[(int) Math.pow(2, noFichas)];
        algoritmoHanoi(noFichas, 1, 2, 3);
        posiciones = new Posicion[9];
        for (int i = 1; i <= noFichas; i++) {
            int w = noFichas - i + 1;
            posiciones[i] = new Posicion(posicionFichaX(i, 1), posicionFichaY(w));
        }
        x = posiciones[1].getX();
        y = posiciones[1].getY();
        movimientoActual = 1;
        movimientoCompletado = false;
        paso = 1;
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        
        setBackground(Color.DARK_GRAY);
        g.drawImage(background, 25, 70, this);
        g.drawImage(palitoFinal1, 45, 78, this);
        g.drawImage(palitoFinal2, 245, 78, this);
        g.drawImage(palitoFinal3, 445, 78, this);

        for (int i = noFichas; i >= 1; i--) {
            g.drawImage(fichas[i], posiciones[i].getX(), posiciones[i].getY(), this);
        }

        g.setColor(Color.WHITE);
        g.setFont(new java.awt.Font("Bitstream Charter", 1, 16));
        g.drawString("Origen", 115, 350);
        g.drawString("Auxiliar", 315, 350);
        g.drawString("Destino", 515, 350);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void algoritmoHanoi(int n, int origen, int temporal, int destino) {

        if (n == 0) {
            return;
        }
        algoritmoHanoi(n - 1, origen, destino, temporal);
        nm++;
        movimientos[nm] = new Movimiento(n, origen, destino);
        algoritmoHanoi(n - 1, temporal, origen, destino);
    }

    @Override
    public int posicionFichaX(int ficha, int torre) {

        int k = (torre - 1) * 200;
        switch (ficha) {
            case 1:
                return 110 + k;
            case 2:
                return 100 + k;
            case 3:
                return 90 + k;
            case 4:
                return 80 + k;
            case 5:
                return 70 + k;
            case 6:
                return 60 + k;
            case 7:
                return 50 + k;
            case 8:
                return 40 + k;
        }
        return 0;
    }

    @Override
    public int posicionFichaY(int nivel) {

        return nivel == 1 ? 260
                : nivel == 2 ? 233
                : nivel == 3 ? 206
                : nivel == 4 ? 179
                : nivel == 5 ? 152
                : nivel == 6 ? 125
                : nivel == 7 ? 98
                : nivel == 8 ? 71
                : 0;

    }

    @Override
    public void iniciarAnimacion() {

        timer.restart();
    }

    @Override
    public void pausarAnimacion() {

        timer.stop();
    }
}
