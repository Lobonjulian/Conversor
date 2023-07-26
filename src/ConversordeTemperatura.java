public class ConversordeTemperatura {

    //constructor
    public ConversordeTemperatura() {
    }

    // proporciona métodos para convertir entre diferentes escalas de temperatura.
    public String CelsiuAFahrenheit(double celsius){
        return "" + ((celsius * 1.8)+32) +"°F";
    }
    public String FahrenheitACelsius(double fahrenheit) {
        return "" + ((fahrenheit - 32) / 1.8) + "ºC";
    }
    public String CelsiusAKevin(double celsius) {
        return "" + (celsius + 273.15) + "°K";
    }
    public String KelvinACelsius(double kelvin) {
        return "" + (kelvin - 273.15) + "ºC";
    }
    public String FahrenheitAKelvin(double fahrenheit) {
        return "" + (5 / 9 * (fahrenheit - 32) + 273.15) + "°K";
    }
    public String KelvinAFahrenheit(double kelvin) {
        return "" + (1.8 * (kelvin - 273.15) + 32) + "°F";

    }

}
