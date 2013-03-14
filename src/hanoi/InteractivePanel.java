package hanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

/*
 * Clase que implemente la funcionalidad del algoritmo para el acomodo de
 * torres de HanoiPanel asi como las animaciones necesarias.
 */
public class InteractivePanel extends MainPanel {

    private Timer timer;
    private Timer timer2;   // Cuenta el tiempo en solucionar
    private Movimiento movimiento;
    private Posicion[] posiciones;
    private boolean movimientoCompletado;
    private long tiempo;
    private int torreOrigen;
    private int torreDestino;
    private int ficha;
    private int paso;
    private int x;
    private int y;
    private int[] fichasEnTorre;
    private int numeroDeMovimientos;

    public InteractivePanel(final int noFichas, final int speed, final MainFrame mainFrame) {

        this.noFichas = noFichas;
        this.velocidad = speed;
        this.numeroDeMovimientos = 0;
        this.tiempo = 0;

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
                            if (movimiento.getTorreOrigen() < movimiento.getTorreDestino()) {
                                paso = 2;
                            } else {
                                paso = 3;
                            }
                        }
                        break;
                    case 2:         // Movimiento hacia derecha
                        if (x < posicionFichaX(ficha, movimiento.getTorreDestino())) {
                            x += velocidad;
                            posiciones[ficha].setX(x);
                        } else {
                            paso = 4;
                        }
                        break;
                    case 3:         // Movimiento hacia izquierda
                        if (x > posicionFichaX(ficha, movimiento.getTorreDestino())) {
                            x -= velocidad;
                            posiciones[ficha].setX(x);
                        } else {
                            paso = 4;
                        }
                        break;
                    case 4:         // Movimiento hacia abajo
                        int nivel = fichasEnTorre[movimiento.getTorreDestino()] + 1;
                        if (y < posicionFichaY(nivel)) {
                            y += velocidad;
                            posiciones[ficha].setY(y);
                        } else {
                            movimientoCompletado = true;
                        }
                        break;
                }
                boolean stopTimer = false;

                if (movimientoCompletado) {

                    stopTimer = true;
                    paso = 1;
                    fichasEnTorre[movimiento.getTorreDestino()]++;
                    fichasEnTorre[movimiento.getTorreOrigen()]--;
                    movimientoCompletado = false;
                    ficha = movimiento.getFicha();
                    x = posiciones[ficha].getX();
                    y = posiciones[ficha].getY();
                }
                repaint();

                if (stopTimer) {

                    timer.stop();
                    if (verificarCompletado()) {

                        mainFrame.resolucionCompletada();
                        //Icon i = new ImageIcon(this.getClass().getResource("/images/" + "saurio" + ".png"));
                        new EndingScore(numeroDeMovimientos, tiempo, noFichas).setVisible(true);
                    }
                }
            }
        });

        timer2 = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                tiempo++;

            }
        });

        timer2.start();

    }

    private void initComponentesAnimacion() {

        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }

            private void formMouseClicked(MouseEvent evt) {

                int xClicked = evt.getX();
                int torre = getTorre(xClicked);
                int fichaSuperior;

                if (torre != 0) {

                    if (torreOrigen == 0) {

                        ficha = getFichaSuperior(posiciones, torre, true);
                        torreOrigen = torre;

                    } else {
                        torreDestino = torre;
                        fichaSuperior = getFichaSuperior(posiciones, torreDestino, false);

                        if (ficha <= fichaSuperior && torreOrigen != torreDestino) {

                            numeroDeMovimientos++;
                            movimiento = new Movimiento(ficha, torreOrigen, torreDestino);
                            if (movimiento.getTorreDestino() == 1) {
                                palitoFinal1 = palito2;
                                palitoFinal2 = palito;
                                palitoFinal3 = palito;
                            } else if (movimiento.getTorreDestino() == 2) {
                                palitoFinal2 = palito2;
                                palitoFinal1 = palito;
                                palitoFinal3 = palito;
                            } else if (movimiento.getTorreDestino() == 3) {
                                palitoFinal3 = palito2;
                                palitoFinal1 = palito;
                                palitoFinal2 = palito;
                            }
                            timer.restart();
                        }
                        torreOrigen = 0;
                    }
                }

            }
        });

        fichasEnTorre = new int[LIMITE_TORRES + 1];
        fichasEnTorre[1] = noFichas;
        fichasEnTorre[2] = 0;
        fichasEnTorre[3] = 0;
        ficha = 1;

        posiciones = new Posicion[9];
        for (int i = 1; i <= noFichas; i++) {
            int w = noFichas - i + 1;
            posiciones[i] = new Posicion(posicionFichaX(i, 1), posicionFichaY(w));
        }
        x = posiciones[1].getX();
        y = posiciones[1].getY();
        movimientoCompletado = false;
        paso = 1;
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        g.drawString("Número de movimientos: " + Integer.toString(numeroDeMovimientos), getWidth() - 200, 20);

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

    public int getTorre(int x) {

        if (x >= 40 && x <= 235) {
            return 1;
        }
        if (x >= 240 && x <= 435) {
            return 2;
        }
        if (x >= 440 && x <= 635) {
            return 3;
        }
        return 0;
    }

    private int getFichaSuperior(Posicion[] posiciones, int torreActual, boolean edit) {

        int fichaSuperior = 10, coordenadaDeFicha = 1000;
        for (int i = 1; i <= noFichas; i++) {

            if (getTorre(posiciones[i].getX()) == torreActual && posiciones[i].getY() <= coordenadaDeFicha) {

                if (edit) {
                    x = posiciones[i].getX();
                    y = posiciones[i].getY();
                }
                coordenadaDeFicha = posiciones[i].getY();
                fichaSuperior = i;
            }
        }

        return fichaSuperior;
    }

    private boolean verificarCompletado() {

        palitoFinal1 = palito;
        palitoFinal2 = palito;
        palitoFinal3 = palito;

        return fichasEnTorre[1] == 0 && fichasEnTorre[2] == 0 && fichasEnTorre[3] == noFichas;

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
