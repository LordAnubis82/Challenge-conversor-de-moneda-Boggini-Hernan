package com.hernanboggini.convertor;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Calculo {
    private ConsultaApi consultaapi = new ConsultaApi();
    private Divisas divisas = consultaapi.conseguirDivisas();
    private Scanner teclado = new Scanner(System.in);
    private String historial =  "Estas son tus ultimas converciones";
    private String validezNula = "Valor no valido intente nuevamente";
    private Archivo archivo;
    private boolean salida = false;
    // REDUCION DE DECIMALES
    private DecimalFormat decimal = new DecimalFormat("#.##");
    // MONTO MAXIMO
    public boolean controlDeMonto(double totalidad){
        boolean repetir = false;
        if (totalidad > 50000000){
            repetir = true;

            //MONTO MINIMO
        } else if (totalidad < 0) {
            repetir = true;
        }
        return repetir;

    }

    public String ejecutarConvercion(int input){

        String monedaEntrada = "";
        String monedaSalida = "";
        switch (input) {
            case 0:
                System.out.println("Gracias por utilisar nuestro sistema ");
                salida = true;
                break;
            case 1:
                monedaEntrada = "ARS";
                monedaSalida = "USD";
                break;
            case 2:
                monedaEntrada = "USD";
                monedaSalida = "ARS";
                break;
            case 3:
                monedaEntrada = "COP";
                monedaSalida = "USD";
                break;
            case 4:
                monedaEntrada = "USD";
                monedaSalida = "COP";
                break;
            case 5:
                monedaEntrada = "UYU";
                monedaSalida = "USD";
                break;
            case 6:
                monedaEntrada = "USD";
                monedaSalida = "UYU";
                break;
            case 7:
                monedaEntrada = "CLP";
                monedaSalida = "USD";
                break;
            case 8:
                monedaEntrada = "USD";
                monedaSalida = "CLP";
                break;
            case 9:
                monedaEntrada = "BRL";
                monedaSalida = "USD";
                break;
            case 10:
                monedaEntrada = "USD";
                monedaSalida = "BRL";
                break;
            case 11:
                System.out.println("Ingrese el codigo de moneda de entrada ");
                monedaEntrada = teclado.nextLine().toUpperCase();
                System.out.println("Ingrese el codigo de moneda de Salida ");
                monedaSalida = teclado.nextLine().toUpperCase();
            case 12:
                System.out.println(historial);
        }
        System.out.println("Ingrese el monto a cambiar");
        double totalidad = teclado.nextDouble();
        teclado.nextLine();
        return totalidad + monedaEntrada + " = " +  decimal.format (totalidad * divisas.getConversion_rates().get(monedaSalida)/
                divisas.getConversion_rates().get(monedaEntrada)) + " " + monedaSalida;

    }

}




