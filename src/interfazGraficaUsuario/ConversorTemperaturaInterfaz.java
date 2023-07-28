package interfazGraficaUsuario;

import convertidores.ConversordeTemperatura;
import convertidores.Inicio;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ConversorTemperaturaInterfaz extends JFrame implements ActionListener, ItemListener, KeyListener {

    private JComboBox<String> comboBoxTemp1, comboBoxTemp2;
    private JTextField txtValorConvertido;
    private JButton btnConvertir,btnRegresar;
    private JLabel lblResultado, lblTitulo, lblConexionA, lblnombre;

    public ConversorTemperaturaInterfaz() {
        getContentPane().setBackground(new Color(255, 150, 100));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponente();
        setTitle("Conversor de Temperatura");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    // componentes de la interfaz gráfica.
    private void iniciarComponente() {
        getContentPane().setLayout(null);
        setBounds(300,200,500,500);

        IngresarImagen[] imgIngresarImagen = new IngresarImagen[2];

        comboBoxTemp1 = new JComboBox<String>();
        comboBoxTemp1.setFont(new Font("Tahoma ", Font.BOLD, 15));
        comboBoxTemp1.setBounds(150,150,200,30);
        comboBoxTemp1.setModel(new DefaultComboBoxModel<String>(new String[]{
                "Celsius","Fahrenheit", "Kelvin" }));
        getContentPane().add(comboBoxTemp1);
        comboBoxTemp1.addItemListener(this);

        comboBoxTemp2 = new JComboBox<String>();
        comboBoxTemp2.setFont(new Font("Tahoma",Font.BOLD, 15));
        comboBoxTemp2.setModel(new DefaultComboBoxModel<>(new String[]{"Fahrenheit", "Kelvin", "Celsius"}));
        comboBoxTemp2.setBounds(150,220,200,30);
        getContentPane().add(comboBoxTemp2);
        comboBoxTemp2.addItemListener(this);

        //Label
        lblTitulo = new JLabel("Conversor de Temperatura");
        lblTitulo.setBounds(100, 25, 300, 30);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitulo);

        lblConexionA = new JLabel("A");
        lblConexionA.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblConexionA.setHorizontalAlignment(SwingConstants.CENTER);
        lblConexionA.setBounds(230, 190, 30, 20);
        getContentPane().add(lblConexionA);

        lblResultado = new JLabel("");
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultado.setBounds(150, 330, 200, 30);
        getContentPane().add(lblResultado);

        lblnombre = new JLabel("Realizado por: Julian Lobon");
        lblnombre.setBounds(150,415,300,30);
        lblnombre.setFont(new Font("Tahoma", Font.ITALIC, 18));
        getContentPane().add(lblnombre);

        //Botones
        btnConvertir = new JButton();
        btnConvertir.setBorderPainted(false);
        btnConvertir.setBounds(230, 275, 50, 50);
        btnConvertir.setBackground(new Color(255, 150, 100));
        btnConvertir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvertir.addActionListener(this);
        getContentPane().add(btnConvertir);
        imgIngresarImagen[0] = new IngresarImagen();
        imgIngresarImagen[0].crearImagen(btnConvertir, "/imagenes/convertir.png");

        btnRegresar = new JButton();
        btnRegresar.setAlignmentY(0.0f);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setBorderPainted(false);
        btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegresar.setBounds(20, 390, 80, 80);
        btnRegresar.setOpaque(true);
        btnRegresar.setBorder(null);
        btnRegresar.setBackground(new Color(250, 150, 100));
        imgIngresarImagen[1] = new IngresarImagen();
        imgIngresarImagen[1].crearImagen(btnRegresar, "/imagenes/btnAtras.png");
        btnRegresar.addActionListener(this);
        getContentPane().add(btnRegresar);

        //donde el usuario ingresa los valores y se produce la conversion
        txtValorConvertido = new JTextField();
        txtValorConvertido.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtValorConvertido.setHorizontalAlignment(SwingConstants.CENTER);
        txtValorConvertido.setBounds(150, 75, 200, 30);
        getContentPane().add(txtValorConvertido);
        txtValorConvertido.setColumns(10);
        txtValorConvertido.addKeyListener(this);
    }

    //implementacion de metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        ConversordeTemperatura conversion = new ConversordeTemperatura();
        boolean estaVacio = txtValorConvertido.getText().isEmpty();
        String resultado = "No es una conversion valida";

        if (e.getSource() == btnConvertir && !estaVacio) {
            try {
                Double valor = Double.parseDouble(txtValorConvertido.getText());
                String temperatura1 = (String) comboBoxTemp1.getSelectedItem();
                String temperatura2 = (String) comboBoxTemp2.getSelectedItem();

                switch (temperatura1) {
                    case "Celsius":
                        switch (temperatura2) {
                            case "Fahrenheit":
                                resultado = conversion.CelsiuAFahrenheit(valor);
                                break;
                            case "Kelvin":
                                resultado = conversion.CelsiusAKevin(valor);
                                break;
                        }
                        break;
                    case "Fahrenheit":
                        switch (temperatura2) {
                            case "Celsius":
                                resultado = conversion.FahrenheitACelsius(valor);
                                break;
                            case "Kelvin":
                                resultado = conversion.FahrenheitAKelvin(valor);
                                break;
                        }
                        break;
                    case "Kelvin":
                        switch (temperatura2) {
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
                lblResultado.setText("Valor ingresado no es valido");
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
        boolean punto = key >= 45 && key <= 46;

        if (!(numeros || punto)) {
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