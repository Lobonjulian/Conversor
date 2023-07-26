package interfazGraficaUsuario;

import convertidores.ConversordeMoneda;
import convertidores.ConversordeTemperatura;
import convertidores.ConversorTiempo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings("serial")
public class InicioInterfaz extends JFrame  implements ActionListener {
    private JPanel contentpane;
    private JLabel lblConvesordeTiempo;
    private JLabel lblConvesordeMoneda;
    private JLabel lblConvesordeTemperatura;
    JButton btnConvesordeMoneda, btnConvesordeTiempo, btnConvesordeTemperatura;
    

    public InicioInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Conversores de Moneda, Tiempo, Temperatura y Longitud");
        iniciarComponente();
        setResizable(false);
        setLocation(null);
    }

    private void iniciarComponente() {
        setBounds(300, 100, 450, 300);
        contentpane = new JPanel();
        contentpane.setBackground(SystemColor.menu);
        contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));

        Color color = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
        //AjustarImagen[] btnAjustado = new AjustarImagen[3];

        setContentPane(contentpane);
        contentpane.setLayout(null);

        //botones
        btnConvesordeMoneda = new JButton("");
        btnConvesordeMoneda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvesordeMoneda.setBorderPainted(false);
        btnConvesordeMoneda.setOpaque(true);
        btnConvesordeMoneda.setBorder(null);
        btnConvesordeMoneda.setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue()));
        btnConvesordeMoneda.setBounds(10,52,115,100);

        //btnAjustado[0] = new AjustarImagen();
        //		btnAjustado[0].AjustaImagen(btnConversorDeMoneda, "/imagenes/cambio-de-divisas.png");
        contentpane.add(btnConvesordeMoneda);

        btnConvesordeTiempo = new JButton("Conversor de Tiempo");
        btnConvesordeTiempo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvesordeTiempo.setBorderPainted(false);
        btnConvesordeTiempo.setFocusPainted(false);
        btnConvesordeTiempo.setBounds(280,52,115,100);
        btnConvesordeTiempo.setOpaque(true);
        btnConvesordeTiempo.setBorder(null);


        contentpane.add(btnConvesordeTiempo);

        btnConvesordeTemperatura = new JButton("Conversor de Temperatura");
        btnConvesordeTemperatura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConvesordeTemperatura.setFocusPainted(false);
        btnConvesordeTemperatura.setBorderPainted(false);
        btnConvesordeTemperatura.setBounds(290,50,115,100);
        btnConvesordeTemperatura.setOpaque(true);
        btnConvesordeTemperatura.setBorder(null);

        //btnAjustado[1] = new AjustarImagen();
        //btnAjustado[1].AjustaImagen(btnTemperatura, "/imagenes/termometro.png");
        //	btnTemperatura.addActionListener(this);


        contentpane.add(btnConvesordeTemperatura);

        //Label

        JLabel lblNewLabel = new JLabel("Elige un conversor");
        lblNewLabel.setFont(new Font("Garamond", Font.BOLD, 25));
        lblNewLabel.setBounds(70,10,200,30);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentpane.add(lblNewLabel);

        lblConvesordeMoneda = new JLabel("Conversor de Moneda");
        lblConvesordeMoneda.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblConvesordeMoneda.setBounds(10,10,200,30);
        lblConvesordeMoneda.setHorizontalAlignment(SwingConstants.CENTER);
        contentpane.add(lblConvesordeMoneda);

        lblConvesordeTiempo = new JLabel("Conversor de Tiempo");
        lblConvesordeTiempo.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblConvesordeTiempo.setBounds(280,10,200,30);
        lblConvesordeTiempo.setHorizontalAlignment(SwingConstants.CENTER);
        contentpane.add(lblConvesordeTiempo);

        lblConvesordeTemperatura = new JLabel("Conversor de Temperatura");
        lblConvesordeTemperatura.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblConvesordeTemperatura.setBounds(290,10,200,30);
        lblConvesordeTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
        contentpane.add(lblConvesordeTemperatura);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConvesordeMoneda) {
             ConversordeMoneda conversordeMoneda = new ConversordeMoneda();
        } else if (e.getSource() == btnConvesordeTiempo) {
           ConversorTiempo conversordeTiempo = new ConversorTiempo();
        } else if (e.getSource() == btnConvesordeTemperatura) {
           ConversordeTemperatura conversordeTemperatura = new ConversordeTemperatura();
        }
        this.dispose();

    }
}
