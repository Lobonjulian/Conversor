package interfazGraficaUsuario;

import convertidores.ConversorTiempo;
import convertidores.Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorTiempoInterfaz extends JFrame implements ActionListener, ItemListener, KeyListener {
    private JComboBox<String> comboBoxTiempo1, comboBoxTiempo2;
    private JTextField txtValorConvertido;
    private JLabel lblResultado, lblTitulo, lblConexionDe, lblConexionA, lblnombre;
    private JButton btnConvertir, btnRegresar;

    public ConversorTiempoInterfaz() {
        getContentPane().setBackground(new Color(255, 255, 220));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponente();
        setTitle("Conversor de Tiempo");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void iniciarComponente() {
        getContentPane().setLayout(null);
        setBounds(300, 200, 500, 500);

        IngresarImagen[] imgIngresarImagen = new IngresarImagen[2];

        comboBoxTiempo1 = new JComboBox<String>();
        comboBoxTiempo1.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBoxTiempo1.setBounds(150, 150, 200, 30);
        comboBoxTiempo1.setModel(new DefaultComboBoxModel<String>(new String[] {
                "Minutos", "Segundos", "Horas", "Días", "Semanas", "Meses", "Años"}));
        getContentPane().add(comboBoxTiempo1);
        comboBoxTiempo1.addItemListener(this);

        comboBoxTiempo2 = new JComboBox<String>();
        comboBoxTiempo2.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBoxTiempo2.setModel(new DefaultComboBoxModel<String>(new String[] {
                "Segundos", "Minutos", "Horas", "Días", "Semanas", "Meses", "Años" }));
        comboBoxTiempo2.setBounds(150, 220, 200, 30);
        getContentPane().add(comboBoxTiempo2);
        comboBoxTiempo2.addItemListener(this);

        //label
        lblTitulo = new JLabel("Conversor de Tiempo");
        lblTitulo.setBounds(100, 25, 300, 30);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitulo);

        lblConexionDe = new JLabel("De");
        lblConexionDe.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblConexionDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblConexionDe.setBounds(230, 125, 30, 20);
        getContentPane().add(lblConexionDe);

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
        btnConvertir.setBounds(230, 270, 50, 50);
        btnConvertir.setBackground(new Color(255,255,220));
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
        btnRegresar.setBackground(new Color(255,255,220));
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
        ConversorTiempo conversor = new ConversorTiempo();
        boolean estaVacio = txtValorConvertido.getText().isEmpty();
        String resultado = "0";

        if (e.getSource() == btnConvertir && !estaVacio) {
            try {
                Double valor = Double.parseDouble(txtValorConvertido.getText());
                String tiempo1 = (String) comboBoxTiempo1.getSelectedItem();
                String unidadA = (String) comboBoxTiempo2.getSelectedItem();

                switch (tiempo1) {
                    case "Segundos":
                        resultado = conversor.ConvertirSegundo(valor, unidadA) + " " + unidadA;
                        break;
                    case "Minutos":
                        resultado = conversor.ConvertirMinuto(valor, unidadA) + " " + unidadA;
                        break;
                    case "Horas":
                        resultado = conversor.ConvertirHora(valor, unidadA) + " " + unidadA;
                        break;
                    case "Días":
                        resultado = conversor.ConvertirDia(valor, unidadA) + " " + unidadA;
                        break;
                    case "Semanas":
                        resultado = conversor.ConvertirSemana(valor, unidadA) + " " + unidadA;
                        break;
                    case "Meses":
                        resultado = conversor.ConvertirMeses(valor, unidadA) + " " + unidadA;
                        break;
                    case "Años":
                        resultado = conversor.ConvertirYears(valor, unidadA) + " " + unidadA;
                        break;
                    }

                }catch (NumberFormatException ex) {
                resultado = "No es un parámetro válido";
            }
                lblResultado.setText(resultado);
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
        boolean punto = key == 46;

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