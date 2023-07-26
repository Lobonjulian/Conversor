package interfazGraficaUsuario;

import convertidores.ConversorTiempo;
import convertidores.Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorTiempoInterfaz extends JFrame implements ActionListener, ItemListener, KeyListener {
    private JTextField txtValorConvertido;
    private JLabel lblResultado, lblTitulo;
    private JButton btnConvertir, btnRegresar;
    private JComboBox<String> comboBoxTemp1, comboBoxTemp2;

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
        setBounds(100, 100, 450, 300);

        //ajustarImagen[] imgAjustada = new AjustarImagen[2];
        comboBoxTemp1 = new JComboBox<String>();
        comboBoxTemp1.setFont(new Font("Tahoma", Font.BOLD, 13));
        comboBoxTemp1.setModel(new DefaultComboBoxModel<String>(new String[] {
                "Segundos", "Minutos", "Horas", "Días", "Semanas", "Meses", "Años"}));
        comboBoxTemp1.setBounds(88, 110, 183, 31);
        getContentPane().add(comboBoxTemp1);
        comboBoxTemp1.addItemListener(this);

        comboBoxTemp2 = new JComboBox<String>();
        comboBoxTemp2.setFont(new Font("Tahoma", Font.BOLD, 13));
        comboBoxTemp2.setModel(new DefaultComboBoxModel<String>(new String[] {
                "Segundos", "Minutos", "Horas", "Días", "Semanas", "Meses", "Años" }));
        comboBoxTemp2.setBounds(88, 183, 183, 31);
        getContentPane().add(comboBoxTemp2);
        comboBoxTemp2.addItemListener(this);

        //Botones
        btnConvertir = new JButton();
        btnConvertir.setBorderPainted(false);
        btnConvertir.setBounds(153, 225, 49, 49);
        btnConvertir.setBackground(new Color(255, 248, 220));
        //imgAjustada[0] = new AjustarImagen();
        //imgAjustada[0].AjustaImagen(btnConvertir, "/imagenes/flecha-de-bucle.png");
        btnConvertir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvertir.addActionListener(this);
        getContentPane().add(btnConvertir);

        btnRegresar = new JButton();
        btnRegresar.setAlignmentY(0.0f);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setBorderPainted(false);
        btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegresar.setBounds(0, 0, 49, 49);
        btnRegresar.setOpaque(true);
        btnRegresar.setBorder(null);
        btnRegresar.setBackground(new Color(255, 248, 220));
        //imgAjustada[1] = new AjustarImagen();
        //imgAjustada[1].AjustaImagen(btnRegresar, "/imagenes/atras.png");
        btnRegresar.addActionListener(this);
        getContentPane().add(btnRegresar);

        //label
        JLabel lblA = new JLabel("a");
        lblA.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblA.setHorizontalAlignment(SwingConstants.CENTER);
        lblA.setBounds(164, 152, 30, 20);
        getContentPane().add(lblA);

        lblResultado = new JLabel("");
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultado.setBounds(63, 265, 221, 76);
        getContentPane().add(lblResultado);

        lblTitulo = new JLabel("CONVERSOR DE TIEMPO");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(28, 11, 292, 35);
        getContentPane().add(lblTitulo);

        txtValorConvertido = new JTextField();
        txtValorConvertido.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtValorConvertido.setHorizontalAlignment(SwingConstants.CENTER);
        txtValorConvertido.setBounds(88, 68, 183, 31);
        getContentPane().add(txtValorConvertido);
        txtValorConvertido.setColumns(10);
        txtValorConvertido.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConversorTiempo conversor = new ConversorTiempo();
        boolean estaVacio = txtValorConvertido.getText().isEmpty();
        String resultado = "0";
        if (e.getSource() == btnConvertir && !estaVacio) {
            try {
                Double valor = Double.parseDouble(txtValorConvertido.getText());
                String unidadDe = (String) comboBoxTemp1.getSelectedItem();
                String unidadA = (String) comboBoxTemp2.getSelectedItem();
                switch (unidadDe) {
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
