package interfazGraficaUsuario;

import convertidores.Inicio;
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
    private JLabel lblResultado,lblTitulo, lblDescripcion, lblnombre ;
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
        setBounds(300, 200, 500, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255,199,95));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        IngresarImagen[] imgIngresarImagen = new IngresarImagen[2];

        comboBoxMoneda = new JComboBox<String>();
        comboBoxMoneda.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBoxMoneda.setBounds(250,200,200,30);
        comboBoxMoneda.setModel(new DefaultComboBoxModel<String>(new String[]{
                "Pesos a Dolares", "Pesos a Euros", "Pesos a Libras", "Pesos a Yen", "Pesos a Won-Coreano",
                "Dolares a Pesos", "Euros a Pesos", "Libras  a Pesos", "Yen Japones a Pesos", "Won Sul-Coreano a Pesos"
        }));
        comboBoxMoneda.setToolTipText("");
        comboBoxMoneda.addItemListener(this);



        //label
        lblTitulo = new JLabel("Conversor de Moneda");
        lblTitulo.setBounds(100,25,300,30);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblResultado = new JLabel("");
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblResultado.setBounds(150,310,200,30);
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);

        lblDescripcion = new JLabel("Conversion");
        lblDescripcion.setBounds(80,170,280,30);
        lblDescripcion.setFont(new Font("Tahoma", Font.ITALIC, 15));

        lblnombre = new JLabel("Realizado por: Julian Lobon");
        lblnombre.setBounds(150,415,300,30);
        lblnombre.setFont(new Font("Tahoma", Font.ITALIC, 18));

        //botones
        btnConvertir = new JButton("Convertir");
        btnConvertir.setBorderPainted(false);
        btnConvertir.setBounds(220,250,50,50);
        btnConvertir.setBackground(new Color(255, 199,95));
        btnConvertir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvertir.addActionListener(this);
        imgIngresarImagen[0] = new IngresarImagen();
        imgIngresarImagen[0].crearImagen(btnConvertir, "/imagenes/convertir.png");

        btnRegresar = new JButton("Regresar");btnRegresar.setAlignmentY(0.0f);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setBorderPainted(false);
        btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegresar.setBounds(20,390,80,80);
        btnRegresar.setOpaque(true);
        btnRegresar.setBorder(null);
        btnRegresar.setBackground(new Color(255,199,95));
        btnRegresar.addActionListener(this);
        imgIngresarImagen[1] = new IngresarImagen();
        imgIngresarImagen[1].crearImagen(btnRegresar, "/imagenes/btnAtras.png");

        //donde el usuario ingresa los valores y se produce la conversion
        txtValorConvertido = new JTextField();
        txtValorConvertido.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtValorConvertido.setBounds(30,200,200,30);
        txtValorConvertido.setHorizontalAlignment(SwingConstants.CENTER);
        txtValorConvertido.addKeyListener(this);
        txtValorConvertido.setColumns(10);

        //agragando el contenido a la pantalla
        contentPane.setLayout(null);
        contentPane.add(lblTitulo);
        contentPane.add(comboBoxMoneda);
        contentPane.add(txtValorConvertido);
        contentPane.add(btnConvertir);
        contentPane.add(lblResultado);
        contentPane.add(lblDescripcion);
        contentPane.add(btnRegresar);
        contentPane.add(lblnombre);
    }

    //implementacion de metodos
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
            Inicio inicio = new Inicio();
            this.dispose();
        } else if (estaVacio) {
            lblResultado.setText("Ingrese un Valor  Valido");

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