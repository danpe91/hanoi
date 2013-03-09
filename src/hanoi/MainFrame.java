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

    private final int VELOCIDAD = 10;
    private JSpinner spinnerNroDiscos;
    private JLabel labelInformacion;
    private JLabel labelNroDiscos;
    private JButton botonIniciar;
    private HanoiPanel hanoiPanel;

    public MainFrame() {

        super("Inteligencia Artificial - Proyecto: Torres de Hanoi ");
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

        labelNroDiscos = new JLabel("Numero De Fichas");
        panelInferior.add(labelNroDiscos);

        spinnerNroDiscos = new JSpinner(new SpinnerNumberModel(8, 1, 8, 1));
        spinnerNroDiscos.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent ce) {

                hanoiPanel.pausarAnimacion();
                botonIniciar.setText("Iniciar");
                labelInformacion.setVisible(false);
                initializeDibujo();
                remove(hanoiPanel);
                add(hanoiPanel, BorderLayout.CENTER);
                mainSetVisible(true);

            }
        });

        panelInferior.add(spinnerNroDiscos);

        botonIniciar = new JButton("Iniciar");
        botonIniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (botonIniciar.getText().equals("Pausar")) {
                    
                    hanoiPanel.pausarAnimacion();
                    botonIniciar.setText("Continuar");
                    spinnerNroDiscos.setEnabled(true);
                } else {
                    
                    if (botonIniciar.getText().equals("Iniciar De Nuevo")) {
                        
                        initializeDibujo();
                        add(hanoiPanel, BorderLayout.CENTER);
                        botonIniciar.setText("Iniciar");
                        labelInformacion.setVisible(true);
                        mainSetVisible(true);
                        spinnerNroDiscos.setEnabled(true);
                    } else {
                        
                        hanoiPanel.iniciarAnimacion();
                        botonIniciar.setText("Pausar");
                        spinnerNroDiscos.setEnabled(false);
                    }
                }

            }
        });
        panelInferior.add(botonIniciar);

        labelInformacion = new JLabel("Terminado!");
        labelInformacion.setForeground(Color.GREEN);
        labelInformacion.setVisible(false);
        panelInferior.add(labelInformacion);


        add(panelInferior, BorderLayout.SOUTH);
        hanoiPanel = new HanoiPanel(8, VELOCIDAD, this);
        add(hanoiPanel, BorderLayout.CENTER);

        getRootPane().setDefaultButton(botonIniciar);

    }

    public void resolucionCompletada() {

        botonIniciar.setText("Iniciar De Nuevo");
        labelInformacion.setVisible(true);
    }

    private void initializeDibujo() {

        hanoiPanel = new HanoiPanel(Integer.parseInt(spinnerNroDiscos.getValue().toString()), VELOCIDAD, this);
    }

    private void mainSetVisible(boolean flag) {

        setVisible(flag);
    }
}
