package hanoi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/*
 * Clase que crea la ventana con los componentes swing necesarios
 * para el funcionamiento e implementa algunos eventos necesarios 
 * para el funcionamiento
 */
public class MainFrame extends JFrame {

    public static final int SOLUTIONER_MODE = 0;
    public static final int INTERACTIVE_MODE = 1;
    private final int LIMITE_INFERIOR_SOLUCIONADOR = 4;
    private final int LIMITE_SUPERIOR_SOLUCIONADOR = 7;
    private final int LIMITE_INFERIOR_USUARIO = 3;
    private final int LIMITE_SUPERIOR_USUARIO = 6;
    private final int VELOCIDAD = 10;
    private int gameMode;
    private JLabel labelInformacion;
    private JButton botonIniciar;
    private MainPanel hanoiPanel;
    private Clip sonido;
    private Thread audioThread;

    public MainFrame(int gameMode) {

        super("Inteligencia Artificial - Proyecto: Torres de Hanoi ");

        this.gameMode = gameMode;
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {

        this.setSize(680, 450);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {

        JPanel panelInferior = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {

            @Override
            public void windowClosed(java.awt.event.WindowEvent evt) {
                
                sonido.stop();
                audioThread.stop();
                new Menu().setVisible(true);
            }
        });

        botonIniciar = new JButton((gameMode == SOLUTIONER_MODE) ? "Iniciar" : "Salir");
        botonIniciar.setMnemonic('i');
        if (gameMode == SOLUTIONER_MODE) {

            botonIniciar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {

                    if (botonIniciar.getText().equals("Pausar")) {

                        hanoiPanel.pausarAnimacion();
                        botonIniciar.setText("Continuar");
                        botonIniciar.setMnemonic('c');
                    } else {

                        if (botonIniciar.getText().equals("Iniciar De Nuevo")) {

                            initializeDibujo();
                            add(hanoiPanel, BorderLayout.CENTER);
                            botonIniciar.setText("Iniciar");
                            botonIniciar.setMnemonic('i');
                            labelInformacion.setVisible(true);
                            mainSetVisible(true);

                        } else {

                            hanoiPanel.iniciarAnimacion();
                            botonIniciar.setText("Pausar");
                            botonIniciar.setMnemonic('p');
                        }
                    }

                }
            });
        } else {

            botonIniciar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {

                    dispose();
                }
            });

        }

        panelInferior.add(botonIniciar);

        labelInformacion = new JLabel("Terminado!");
        labelInformacion.setForeground(Color.GREEN);
        labelInformacion.setVisible(false);
        panelInferior.add(labelInformacion);


        add(panelInferior, BorderLayout.SOUTH);

        hanoiPanel = (gameMode == SOLUTIONER_MODE)
                ? new HanoiPanel((new Random().nextInt(LIMITE_SUPERIOR_SOLUCIONADOR + 1 - LIMITE_INFERIOR_SOLUCIONADOR) + LIMITE_INFERIOR_SOLUCIONADOR), VELOCIDAD, this)
                : new InteractivePanel((new Random().nextInt(LIMITE_SUPERIOR_USUARIO + 1 - LIMITE_INFERIOR_USUARIO) + LIMITE_INFERIOR_USUARIO), VELOCIDAD, this);

        add(hanoiPanel, BorderLayout.CENTER);

        getRootPane().setDefaultButton(botonIniciar);

        audioThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    
                    sonido = AudioSystem.getClip();
                    File file = new File("src/files/spelunk.aiff");
                    sonido.open(AudioSystem.getAudioInputStream(file));
                    sonido.loop(Clip.LOOP_CONTINUOUSLY);
                } catch (Exception e) {
                    System.out.println("Ha ocurrido un error con el sonido.");
                }
            }
        });

        audioThread.start();

    }

    public void resolucionCompletada() {

        botonIniciar.setText("Iniciar De Nuevo");
        botonIniciar.setMnemonic('i');
        labelInformacion.setVisible(true);
    }

    private void initializeDibujo() {

        hanoiPanel = new HanoiPanel(hanoiPanel.noFichas, VELOCIDAD, this);
        labelInformacion.setText("");
    }

    private void mainSetVisible(boolean flag) {

        setVisible(flag);
    }
}
