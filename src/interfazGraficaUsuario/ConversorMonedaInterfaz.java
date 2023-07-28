package interfazGraficaUsuario;

import convertidores.SistemaDeConversion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ConversorMonedaInterfaz extends JFrame implements ItemListener, KeyListener, ActionListener {

    private JPanel contentPane;
    private JComboBox<String> comboBoxMoneda;
    private JTextField txtValorConvertido;
    private JButton btnConvertir,btnRegresar;
    private JLabel lblResultado;
    private SistemaDeConversion conversion;

    //  Conversion de la moneda
    public void asignarConversion(SistemaDeConversion conversion){
        this.conversion = conversion;
    }

    public ConversorMonedaInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Conversor de Moneda");
        iniciarComponente();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    // componentes de la interfaz gráfica.
    private void iniciarComponente() {
        setBounds(300, 200, 570, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255,199,95));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        IngresarImagen[] imgIngresarImagen = new IngresarImagen[2];

        comboBoxMoneda = new JComboBox<String>();
        comboBoxMoneda.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBoxMoneda.setBounds(220,200,200,25);
        comboBoxMoneda.setModel(new DefaultComboBoxModel<String>(new String[]{
                "Pesos a Dolares", "Pesos a Euros", "Pesos a Libras", "Pesos a Yen", "Pesos a Won-Coreano",
                "Dolares a Pesos", "Euros a Pesos", "Libras  a Pesos", "Yen Japones a Pesos", "Won Sul-Coreano a Pesos"
        }));

        comboBoxMoneda.setToolTipText("");
        comboBoxMoneda.addItemListener(this);

        txtValorConvertido = new JTextField();
        txtValorConvertido.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtValorConvertido.setBounds(30,200,180,25);
        txtValorConvertido.setHorizontalAlignment(SwingConstants.CENTER);
        txtValorConvertido.addKeyListener(this);
        txtValorConvertido.setColumns(10);

        //botones
        btnConvertir = new JButton("Convertir");
        btnConvertir.setBorderPainted(false);
        btnConvertir.setBounds(150,250,40,30);
        //btnConvertir.setBackground(new Color(255, 255, 255));
        btnConvertir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvertir.addActionListener(this);
        imgIngresarImagen[0] = new IngresarImagen();
        imgIngresarImagen[0].crearImagen(btnConvertir, "/imagenes/convertir.png");

        btnRegresar = new JButton("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setBorderPainted(false);
        btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegresar.setBounds(20,350,50,50);
        btnRegresar.setOpaque(true);
        btnRegresar.setBorder(null);
        // btnRegresar.setBackground(new Color(255,199,95));
        btnRegresar.addActionListener(this);
        imgIngresarImagen[1] = new IngresarImagen();
        imgIngresarImagen[1].crearImagen(btnRegresar, "/imagenes/btnAtras.png");
        contentPane.add(btnRegresar);

        //label
        JLabel labelTitle = new JLabel("Conversor de Moneda");
        labelTitle.setBounds(150,50,300,30);
        labelTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        lblResultado = new JLabel("");
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblResultado.setBounds(30,290,440,100);
        lblResultado.setBackground(new Color(255, 255, 254));
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblImportante = new JLabel("Conversion");
        lblImportante.setBounds(80,170,280,30);
        lblImportante.setFont(new Font("Tahoma", Font.ITALIC, 15));

        contentPane.setLayout(null);
        contentPane.add(labelTitle);
        contentPane.add(comboBoxMoneda);
        contentPane.add(txtValorConvertido);
        contentPane.add(btnConvertir);
        contentPane.add(lblResultado);
        contentPane.add(lblImportante);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String moneda = (String) comboBoxMoneda.getSelectedItem();
        boolean estaVacio = txtValorConvertido.getText().isEmpty();
        if (btnConvertir == e.getSource() && !estaVacio) {
            try {
                double importe = Double.parseDouble(txtValorConvertido.getText());
                String resultado = conversion.ConversordeMoneda(moneda, importe);
                lblResultado.setText(resultado);
            } catch (Exception ex) {
                lblResultado.setText("Error parametro no es Valido");
            }
        } else if (btnRegresar == e.getSource()) {
            InicioInterfaz inicio = new InicioInterfaz();
            this.dispose();
        } else if (estaVacio) {
            lblResultado.setText("Ingrese un Valor  Valido");

        }

    }

    //implementacion de metodos de la interfaz graficagit
    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyChar();
        boolean esNumero = key >= 48 && key <= 59;
        boolean punto = key == 46;

        if (!(esNumero || punto)) {
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
