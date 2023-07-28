package interfazGraficaUsuario;

import javax.swing.*;
import java.awt.*;

public class IngresarImagen {
    public void crearImagen(JButton boton, String obtenerImagen) {

        // La ruta de la imagen a ajustar
        ImageIcon icon = new ImageIcon(getClass().getResource(obtenerImagen));
        //Ajusta una imagen al tamaño del botón especificado.
        ImageIcon imagen = new ImageIcon(
                icon.getImage().getScaledInstance(boton.getWidth(),
                        boton.getHeight(), Image.SCALE_SMOOTH));

        boton.setIcon(imagen);

    }
}
