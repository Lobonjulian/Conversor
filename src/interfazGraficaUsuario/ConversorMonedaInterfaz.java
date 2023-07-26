package interfazGraficaUsuario;

import convertidores.SistemaDeConversion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ConversorMonedaInterfaz extends JFrame implements ItemListener, KeyListener, ActionListener {

    private JPanel contentpane;
    private JComboBox<String> comboBoxMoneda;
    private JTextField txtValorConvertido;
    private JButton btnConvertir,btnRegresar;
    private JLabel lblResultado;
    private SistemaDeConversion conversion;

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
        setBounds(100, 100, 450, 300);
        contentpane = new JPanel();
        contentpane.setBackground(new Color(255, 255, 254));
        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentpane);
        //

        JLabel labelTitle = new JLabel("Conversor de Moneda");
        labelTitle.setBounds(30,45,440,100);
        labelTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        comboBoxMoneda = new JComboBox<String>();
        comboBoxMoneda.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBoxMoneda.setBounds(30,150,440,100);
        comboBoxMoneda.setModel(new DefaultComboBoxModel<String>(new String[]{
                "Pesos a Dolares", "Pesos a Euros", "Pesos a Libras", "Pesos a Yen", "Pesos a Won", "Pesos a Won-Coreano",
                "Dolares a Pesos", "Euros a Pesos", "Libras  a Pesos", "Yen Japones a Pesos", "Won Sul-Coreano a Pesos"
        }));

        comboBoxMoneda.setToolTipText("");
        comboBoxMoneda.addItemListener(this);

        txtValorConvertido = new JTextField();
        txtValorConvertido.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtValorConvertido.setBounds(30,170,140,30);
        txtValorConvertido.setHorizontalAlignment(SwingConstants.CENTER);
        txtValorConvertido.addKeyListener(this);
        txtValorConvertido.setColumns(10);

        //botones
        btnConvertir = new JButton("Convertir");
        btnConvertir.setBorderPainted(false);
        btnConvertir.setBounds(30,210,140,30);
        btnConvertir.setBackground(new Color(255, 255, 254));
        //todo:imah
        btnConvertir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvertir.addActionListener(this);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setBorderPainted(false);
        btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRegresar.setBounds(30,250,140,30);
        btnRegresar.setOpaque(true);
        btnRegresar.setBorder(null);
        btnRegresar.setBackground(new Color(255, 255, 254));
        btnRegresar.addActionListener(this);
        contentpane.add(btnRegresar);

        //label
        lblResultado = new JLabel("");
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblResultado.setBounds(30,290,440,100);
        lblResultado.setBackground(new Color(255, 255, 254));
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblImportante = new JLabel("IMPORTANTE");
        lblImportante.setBounds(80,130,80,30);
        lblImportante.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentpane.setLayout(null);
        contentpane.add(comboBoxMoneda);
        contentpane.add(txtValorConvertido);
        contentpane.add(btnConvertir);
        contentpane.add(lblResultado);
        contentpane.add(lblImportante);
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

    //implementacion de metodos de la interfaz grafica
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
