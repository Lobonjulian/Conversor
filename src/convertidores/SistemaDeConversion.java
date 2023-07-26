package convertidores;

import convertidores.ConversordeMoneda.TasadeCambio;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class SistemaDeConversion {

    //Crea un mapa de monedas con los nombres y valores de conversión.
    public static Map<String, Double> monedaCreada() {

        //Almacenamos las tasas de conversión en un mapa
        Map<String, Double> mapaMoneda = new HashMap<>();

        for (TasadeCambio moneda : TasadeCambio.values()) {
            mapaMoneda.put(moneda.getNombre(), moneda.getValor());
        }
        return mapaMoneda;

    }

    //Obtiene el objeto TasasDeConversion correspondiente al nombre de la moneda.
    public static TasadeCambio obtenerMoneda(String nombreMoneda) {
        for (TasadeCambio moneda : TasadeCambio.values()) {
            if (moneda.getNombre().equals(nombreMoneda)) {
                return moneda;
            }
        }
        //Accion cuando no se encuentra la moneda
        return null;

    }

    //  conversión de moneda según el tipo de cambio y el importe proporcionados.
    public String ConversordeMoneda(String tipoCambio,Double importe){

        Map<String, Double> mapaMoneda = monedaCreada();
        TasadeCambio moneda = obtenerMoneda(tipoCambio);
        DecimalFormat format = new DecimalFormat("#,##0.00");
        if(moneda != null){
            double valor = mapaMoneda.get(tipoCambio);
            double total = importe * valor;
            String simbolo = moneda.getSimbolo();
            return simbolo + " " + format.format(total);
        }else {
            return "No se encuetra la moneda";
        }
    }


}
