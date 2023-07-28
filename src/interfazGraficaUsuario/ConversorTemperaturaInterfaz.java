package interfazGraficaUsuario;

import convertidores.ConversordeTemperatura;
import convertidores.Inicio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ConversorTemperaturaInterfaz extends JFrame implements ActionListener, ItemListener, KeyListener {

    private JPanel contentPane;
    private JTextField txtValorConvertido;
    private JButton btnConvertir,btnRegresar;
    JComboBox<String> comboBoxTemp1, comboBoxTemp2;
    private JLabel lblResultado;
    ConversordeTemperatura conversion;

    public ConversorTemperaturaInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponente();
        setTitle("Conversor de Temperatura");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void iniciarComponente() {
        setBounds(300,200,570,500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 199, 95));
        contentPane.setBorder(new EmptyBorder(5,5,5,5));

        setContentPane(contentPane);
        IngresarImagen[] imgIngresarImagen = new IngresarImagen[2];

        comboBoxTemp1 = new JComboBox<>();
        comboBoxTemp1.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBoxTemp1.setModel(new DefaultComboBoxModel<>(new String[]{
                "Celsius a Fahrenheit", "Celsius a Kelvin", "Fahrenheit a Celsius",
                "Kelvin a Celsius", "Kelvin a Fahrenheit"
        }));

        comboBoxTemp1.setBounds(50,150,140,30);
        contentPane.add(comboBoxTemp1);
        comboBoxTemp1.addItemListener(this);

        comboBoxTemp2 = new JComboBox<>();
        comboBoxTemp2.setFont(new Font("Tahoma",Font.BOLD, 15));
        comboBoxTemp2.setModel(new DefaultComboBoxModel<>(new String[]{"Fahrenheit", "Kelvin", "Celsius"}));
        comboBoxTemp2.setBounds(50,200,140,30);
        contentPane.add(comboBoxTemp2);
        comboBoxTemp2.addItemListener(this);

        //Botones
        btnConvertir = new JButton();
        btnConvertir.setBorderPainted(false);
        btnConvertir.setBounds(150, 236, 49, 49);
        //btnConvertir.setBackground(new Color(240, 255, 240));
        btnConvertir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvertir.addActionListener(this);
        getContentPane().add(btnConvertir);

        btnRegresar = new JButton();
        btnRegresar.setAlignmentY(0.0f);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setBorderPainted(false);
        btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegresar.setBounds(20, 350, 50, 50);
        btnRegresar.setOpaque(true);
        btnRegresar.setBorder(null);
        //btnRegresar.setBackground(new Color(240, 255, 240));
        btnRegresar.addActionListener(this);
        imgIngresarImagen[1] = new IngresarImagen();
        imgIngresarImagen[1].crearImagen(btnRegresar, "/imagenes/btnAtras.png");
        getContentPane().add(btnRegresar);

        //Label
        JLabel lblA = new JLabel("a");
        lblA.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblA.setHorizontalAlignment(SwingConstants.CENTER);
        lblA.setBounds(162, 156, 46, 28);
        contentPane.add(lblA);

        JLabel lblTitulo = new JLabel("CONVERSOR DE TEMPERATURA");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(56, 15, 301, 34);
        contentPane.add(lblTitulo);

        txtValorConvertido = new JTextField();
        txtValorConvertido.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtValorConvertido.setHorizontalAlignment(SwingConstants.CENTER);
        txtValorConvertido.setBounds(103, 90, 169, 28);
        contentPane.add(txtValorConvertido);
        txtValorConvertido.setColumns(10);
        txtValorConvertido.addKeyListener(this);
    }

    //implementacion de metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        conversion = new ConversordeTemperatura();
        boolean estaVacio = txtValorConvertido.getText().isEmpty();
        String resultado = "No es una conversion valida";

        if (e.getSource() == btnConvertir && !estaVacio) {
            try {
                Double valor = Double.parseDouble(txtValorConvertido.getText());
                String temp1 = (String) comboBoxTemp1.getSelectedItem();
                String temp2 = (String) comboBoxTemp2.getSelectedItem();

                switch (temp1) {
                    case "Celsius":
                        switch (temp2) {
                            case "Fahrenheit":
                                resultado = conversion.CelsiuAFahrenheit(valor);
                                break;
                            case "Kelvin":
                                resultado = conversion.CelsiusAKevin(valor);
                                break;
                        }
                        break;
                    case "Fahrenheit":
                        switch (temp2) {
                            case "Celsius":
                                resultado = conversion.FahrenheitACelsius(valor);
                                break;
                            case "Kelvin":
                                resultado = conversion.FahrenheitAKelvin(valor);
                                break;
                        }
                        break;
                    case "Kelvin":
                        switch (temp2) {
                            case "Celsius":
                                resultado = conversion.KelvinACelsius(valor);
                                break;
                            case "Fahrenheit":
                                resultado = conversion.KelvinAFahrenheit(valor);
                                break;
                        }
                        break;
                }
                lblResultado.setText(resultado);
            } catch (NumberFormatException ex) {
                lblResultado.setText("Parametro ingresado no es valido");

            }
        } else if (e.getSource() == btnConvertir && estaVacio) {
            lblResultado.setText("Ingresa un valor");
        } else if (btnRegresar == e.getSource()) {
            Inicio inicio = new Inicio();
            this.dispose();

        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        boolean numeros = key >= 48 && key <= 59;
        boolean puntoYnegativo = key >= 45 && key <= 46;

        if (!(numeros || puntoYnegativo)) {
            e.consume();

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
