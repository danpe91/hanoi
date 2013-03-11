package hanoi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * Clase que crea la ventana con los componentes swing necesarios
 * para el funcionamiento e implementa algunos eventos necesarios 
 * para el funcionamiento
 */
public class MainFrame extends JFrame {

    public static final int SOLUTIONER_MODE = 0;
    public static final int INTERACTIVE_MODE = 1;
    private final int VELOCIDAD = 10;
    private int gameMode;
    private JSpinner spinnerNroDiscos;
    private JLabel labelInformacion;
    private JLabel labelNroDiscos;
    private JButton botonIniciar;
    private MainPanel hanoiPanel;

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
                new Menu().setVisible(true);
            }
        });

        labelNroDiscos = new JLabel("Numero De Fichas");
        panelInferior.add(labelNroDiscos);

        spinnerNroDiscos = new JSpinner(new SpinnerNumberModel(8, 1, 8, 1));
        spinnerNroDiscos.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent ce) {

                hanoiPanel.pausarAnimacion();
                botonIniciar.setText("Iniciar");
                botonIniciar.setMnemonic('i');
                labelInformacion.setVisible(false);
                initializeDibujo();
                remove(hanoiPanel);
                add(hanoiPanel, BorderLayout.CENTER);
                mainSetVisible(true);

            }
        });

        panelInferior.add(spinnerNroDiscos);

        botonIniciar = new JButton("Iniciar");
        botonIniciar.setMnemonic('i');
        if (gameMode == SOLUTIONER_MODE) {
            botonIniciar.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {

                    if (botonIniciar.getText().equals("Pausar")) {

                        hanoiPanel.pausarAnimacion();
                        botonIniciar.setText("Continuar");
                        botonIniciar.setMnemonic('c');
                        spinnerNroDiscos.setEnabled(true);
                    } else {

                        if (botonIniciar.getText().equals("Iniciar De Nuevo")) {

                            initializeDibujo();
                            add(hanoiPanel, BorderLayout.CENTER);
                            botonIniciar.setText("Iniciar");
                            botonIniciar.setMnemonic('i');
                            labelInformacion.setVisible(true);
                            mainSetVisible(true);
                            spinnerNroDiscos.setEnabled(true);
                        } else {

                            hanoiPanel.iniciarAnimacion();
                            botonIniciar.setText("Pausar");
                            botonIniciar.setMnemonic('p');
                            spinnerNroDiscos.setEnabled(false);
                        }
                    }

                }
            });
        } else {
        }

        panelInferior.add(botonIniciar);

        labelInformacion = new JLabel("Terminado!");
        labelInformacion.setForeground(Color.GREEN);
        labelInformacion.setVisible(false);
        panelInferior.add(labelInformacion);


        add(panelInferior, BorderLayout.SOUTH);
        hanoiPanel = (gameMode == SOLUTIONER_MODE)
                ? new HanoiPanel(8, VELOCIDAD, this)
                : new InteractivePanel(8, VELOCIDAD, this);

        add(hanoiPanel, BorderLayout.CENTER);

        getRootPane().setDefaultButton(botonIniciar);

    }

    public void resolucionCompletada() {

        botonIniciar.setText("Iniciar De Nuevo");
        botonIniciar.setMnemonic('i');
        labelInformacion.setVisible(true);
    }

    private void initializeDibujo() {

        hanoiPanel = (gameMode == SOLUTIONER_MODE)
                ? new HanoiPanel(Integer.parseInt(spinnerNroDiscos.getValue().toString()), VELOCIDAD, this)
                : new InteractivePanel(Integer.parseInt(spinnerNroDiscos.getValue().toString()), VELOCIDAD, this);
    }

    private void mainSetVisible(boolean flag) {

        setVisible(flag);
    }
}
