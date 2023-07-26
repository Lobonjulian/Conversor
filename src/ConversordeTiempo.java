import java.text.DecimalFormat;

public class ConversordeTiempo {

    //
    public ConversordeTiempo() {
    }
    // se proporcionan métodos para convertir entre diferentes escalas de tiempo.
    public String ConvertirSegundo(double segundos, String conversor){
        double resultado = segundos;
        DecimalFormat format = new DecimalFormat("#,##0.000");
        switch (conversor){
            case "Segundos":
                resultado = segundos;
                break;
            case "Minutos":
                resultado = segundos / 60;
                break;
            case "Horas":
                resultado = segundos / (60 * 60);
                break;
            case "Días":
                resultado = segundos / (24 * 60 * 60);
                break;
            case "Semanas":
                resultado = segundos / (7 * 24 * 60 * 60);
                break;
            case "Meses":
                resultado = segundos / (30 * 24 * 60 * 60);
                break;
            case "Años":
                resultado = segundos / (365 * 24 * 60 * 60);
                break;
        }
        return format.format(resultado);
    }
    public String ConvertirHora(double hora, String conversor){
        double resultado = hora;
        DecimalFormat format = new DecimalFormat("#,##0.000");
        switch (conversor){
            case "Segundos":
                resultado = hora;
                break;
            case "Minutos":
                resultado = hora * 60;
                break;
            case "Horas":
                resultado = hora;
                break;
            case "Días":
                resultado = hora / 24;
                break;
            case "Semanas":
                resultado = hora / 168;
                break;
            case "Meses":
                resultado = hora / 730;
                break;
            case "Años":
                resultado = hora / 8760;
                break;
        }
        return "" + format.format(resultado);
    }

    public String ConvertirDia(double dia, String conversor){
        double resultado = dia;
        DecimalFormat format = new DecimalFormat("#,##0.000");
        switch (conversor){
            case "Segundos":
                resultado = dia * 86400;
                break;
            case "Minutos":
                resultado = dia * 1440;
                break;
            case "Horas":
                resultado = dia * 24;
                break;
            case "Días":
                resultado = dia;
                break;
            case "Semanas":
                resultado = dia / 7;
                break;
            case "Meses":
                resultado = dia / 30.417;
                break;
            case "Años":
                resultado = dia / 365;
                break;
        }
        return"" + format.format(resultado);
    }

    public String ConvertirSemana(double semana, String conversor){
        double resultado = semana;
        DecimalFormat format = new DecimalFormat("#,##0.000");
        switch (conversor){
            case "Segundos":
                resultado = semana * 604800;
                break;
            case "Minutos":
                resultado = semana * 1209600;
                break;
            case "Horas":
                resultado = semana * 168;
                break;
            case "Días":
                resultado = semana;
                break;
            case "Semanas":
                resultado = semana;
                break;
            case "Meses":
                resultado = semana / 4;
                break;
            case "Años":
                resultado = semana / 52;
                break;
        }
        return"" + format.format(resultado);

    }

    public String ConvertirMeses(double mes, String conversor){
        double resultado = mes;
        DecimalFormat format = new DecimalFormat("#,##0.000");
        switch (conversor){
            case "Segundos":
                resultado = mes * 2592000;
                break;
            case "Minutos":
                resultado = mes * 604800;
                break;
            case "Horas":
                resultado = mes * 1209600;
                break;
            case "Días":
                resultado = mes * 30.417;
                break;
            case "Semanas":
                resultado = mes * 4.345;
                break;
            case "Meses":
                resultado = mes;
                break;
            case "Años":
                resultado = mes / 12;
                break;
        }
        return"" + format.format(resultado);

    }

    public String ConvertirYears(double año, String conversor){
        double resultado = año;
        DecimalFormat format = new DecimalFormat("#,##0.000");
        switch (conversor){
            case "Segundos":
                resultado = año * 31536000;
                break;
            case "Minutos":
                resultado = año * 525600;
                break;
            case "Horas":
                resultado = año * 8760;
                break;
            case "Días":
                resultado = año * 365;
                break;
            case "Semanas":
                resultado = año * 52.143;
                break;
            case "Meses":
                resultado = año * 12;
                break;
            case "Años":
                resultado = año;
                break;
        }
        return"" + format.format(resultado);

    }




}

