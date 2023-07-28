package interfazGraficaUsuario;

import convertidores.ConversordeMoneda;
import convertidores.ConversordeTemperatura;
import convertidores.ConversorTiempo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InicioInterfaz extends JFrame  implements ActionListener {
    private JPanel contentPane;
    private JLabel lblConvesorTiempo;
    private JLabel lblConvesorMoneda;
    private JLabel lblConvesorTemperatura;
    JButton btnConvesorMoneda, btnConvesorTiempo, btnConvesorTemperatura;
    

    public InicioInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Conversores de Moneda, Tiempo, y Temperatura");
        iniciarComponente();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void iniciarComponente() {
        // tamaño de salida de la  pantalla
        setBounds(300, 200, 550, 650);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.menu);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        Color color = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        IngresarImagen[] btnIngresarImagen = new IngresarImagen[3];
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Texto
        JLabel lblNewLabel = new JLabel("Elija un conversor");
        lblNewLabel.setFont(new Font("Garamond", Font.BOLD, 25));
        lblNewLabel.setBounds(100,30,400,30);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel);

        lblConvesorMoneda = new JLabel("Convertirdor de Divisas");
        lblConvesorMoneda.setFont(new Font("Asix Founder Font", Font.BOLD, 15));
        lblConvesorMoneda.setBounds(50,130,200,30);
        lblConvesorMoneda.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblConvesorMoneda);

        lblConvesorTiempo = new JLabel("Convertir Tiempo");
        lblConvesorTiempo.setFont(new Font("Asix Founder Font", Font.BOLD, 15));
        lblConvesorTiempo.setBounds(50,335,200,30);
        lblConvesorTiempo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblConvesorTiempo);

        lblConvesorTemperatura = new JLabel("Convertir Temperatura");
        lblConvesorTemperatura.setFont(new Font("Asix Founder Font", Font.BOLD, 15));
        lblConvesorTemperatura.setBounds(50,505,200,30);
        lblConvesorTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblConvesorTemperatura);

        //botones
        btnConvesorMoneda = new JButton("");
        btnConvesorMoneda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvesorMoneda.setBorderPainted(false);
        btnConvesorMoneda.setOpaque(true);
        btnConvesorMoneda.setBorder(null);
        btnConvesorMoneda.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue()));
        btnConvesorMoneda.setBounds(300,90,150,150);
        btnIngresarImagen[0] = new IngresarImagen();
        btnIngresarImagen[0].crearImagen(btnConvesorMoneda, "/imagenes/Moneda.png");
        contentPane.add(btnConvesorMoneda);
        btnConvesorMoneda.addActionListener(this);

        btnConvesorTiempo = new JButton("");
        btnConvesorTiempo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvesorTiempo.setBorderPainted(false);
        btnConvesorTiempo.setFocusPainted(false);
        btnConvesorTiempo.setBounds(300,260,150,150);
        btnConvesorTiempo.setOpaque(true);
        btnConvesorTiempo.setBorder(null);
        btnIngresarImagen[1] = new IngresarImagen();
        btnIngresarImagen[1].crearImagen(btnConvesorTiempo, "/imagenes/Tiempo.png");
        contentPane.add(btnConvesorTiempo);
        btnConvesorTiempo.addActionListener(this);

        btnConvesorTemperatura = new JButton("");
        btnConvesorTemperatura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvesorTemperatura.setFocusPainted(false);
        btnConvesorTemperatura.setBorderPainted(false);
        btnConvesorTemperatura.setBounds(300,430,150,150);
        btnConvesorTemperatura.setOpaque(true);
        btnConvesorTemperatura.setBorder(null);
        btnIngresarImagen[2] = new IngresarImagen();
        btnIngresarImagen[2].crearImagen(btnConvesorTemperatura, "/imagenes/Temperatura.jpg");
        contentPane.add(btnConvesorTemperatura);
        btnConvesorTemperatura.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConvesorMoneda) {
             ConversordeMoneda conversorMoneda = new ConversordeMoneda();
        } else if (e.getSource() == btnConvesorTiempo) {
            ConversorTiempo conversorTiempo = new ConversorTiempo();
            ConversorTiempoInterfaz conversorTiempoInterfaz = new ConversorTiempoInterfaz();
            conversorTiempoInterfaz.setVisible(true);

        } else if (e.getSource() == btnConvesorTemperatura) {
           ConversordeTemperatura conversordeTemperatura = new ConversordeTemperatura();
           ConversorTemperaturaInterfaz conversorTemperaturaInterfaz = new ConversorTemperaturaInterfaz();
           conversorTemperaturaInterfaz.setVisible(true);
        }
        this.dispose();

    }
}