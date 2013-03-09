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
public class MainFrame extends JFrame implements ActionListener, ChangeListener {

    private JSpinner spinnerNroDiscos;
    private JSpinner spinnerVelocidad;
    private JLabel labelInformacion;
    private JLabel labelNroDiscos;
    private JLabel labelVelocidad;
    private JButton botonIniciar;
    private HanoiPanel dibujo;
    private int velocidad = 5;

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
        spinnerNroDiscos.addChangeListener(this);
        panelInferior.add(spinnerNroDiscos);

        labelVelocidad = new JLabel("               Velocidad");
        panelInferior.add(labelVelocidad);

        spinnerVelocidad = new JSpinner(new SpinnerNumberModel(5, 1, 20, 1));
        spinnerVelocidad.addChangeListener(this);
        panelInferior.add(spinnerVelocidad);

        botonIniciar = new JButton("Iniciar");
        botonIniciar.addActionListener(this);
        panelInferior.add(botonIniciar);

        labelInformacion = new JLabel("Terminado!");
        labelInformacion.setForeground(Color.GREEN);
        labelInformacion.setVisible(false);
        panelInferior.add(labelInformacion);


        add(panelInferior, BorderLayout.SOUTH);
        dibujo = new HanoiPanel(8, velocidad, this);
        add(dibujo, BorderLayout.CENTER);

        getRootPane().setDefaultButton(botonIniciar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (botonIniciar.getText().equals("Pausar")) {
            dibujo.pausarAnimacion();
            botonIniciar.setText("Continuar");
        } else {
            if (botonIniciar.getText().equals("Iniciar De Nuevo")) {
                dibujo = new HanoiPanel(Integer.parseInt(spinnerNroDiscos.getValue().toString()), velocidad, this);
                add(dibujo, BorderLayout.CENTER);
                botonIniciar.setText("Iniciar");
                labelInformacion.setVisible(true);
                this.setVisible(true);
            } else {
                dibujo.iniciarAnimacion();
                botonIniciar.setText("Pausar");
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        if (e.getSource() == spinnerVelocidad) {

            velocidad = (Integer) spinnerVelocidad.getValue();
        }

        dibujo.pausarAnimacion();
        botonIniciar.setText("Iniciar");
        labelInformacion.setVisible(false);
        dibujo = new HanoiPanel(Integer.parseInt(spinnerNroDiscos.getValue().toString()), velocidad, this);
        add(dibujo, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void resolucionCompletada() {
        
        botonIniciar.setText("Iniciar De Nuevo");
        labelInformacion.setVisible(true);
    }
    
    public String toString() {
        
        return "MainFrame";
    }
}
