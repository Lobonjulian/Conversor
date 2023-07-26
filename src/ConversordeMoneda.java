
public class ConversordeMoneda {

    //definiendo  las tasas de conversión entre monedas.
    public enum TasadeCambio {
            COOaUSD(3948.4865 ,"Pesos a Dolares" ,"$"),
            COOaEUR(4369.4352 ,"Pesos a Euros", "€"),
            COOaGBP(5097.2824 ,"Pesos a Libras", "£"),
            COOaJPY( 28.075723 ,"Pesos a Yen", "¥"),
            COOaKWR(3.0975327 ,"Pesos a Yen", "₩"),
            USDABS(0.000253211 ,"Dolares a Pesos", "COP"),
            EURABS(0.000228863 ,"Euros a Pesos", "COP"),
            GBPABS(0.000196183, "Libras  a Pesos",  "COP"),
            JPYABS(0.0356180, "Yen Japones a Pesos",  "COP"),
            KWRABS(0.322838, "Won Sul-Coreano a Pesos",  "COP");

            //atributos
            private double valor;
            private String nombre;
            private String simbolo;

            //constructores
          TasadeCambio() {
          }

          TasadeCambio(double valor, String nombre, String simbolo) {
              this.valor = valor;
              this.nombre = nombre;
              this.simbolo = simbolo;
          }
            //getter y setter

          public double getValor() {
              return valor;
          }

          public String getNombre() {
              return nombre;
          }

          public String getSimbolo() {
              return simbolo;
          }
    }
}

//TODO: Datos del dia 26 jul 2023