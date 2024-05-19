package com.hernanboggini.convertor;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner teclado = new Scanner(System.in);
    //private  Calculos calculos = new Calculos();
    private int opciones = 0;
    private String validezNula = "Valor no valido intente nuevamente";
    private String historial =  "Estas son tus ultimas converciones";
    private String convercionesNoRealizadas = "Usted todavia no ha realizado ninguna convercion";
    private Archivo archivo;
    private String  resultadoConvercion;
    public MenuPrincipal(Archivo archivo){
        this.archivo = archivo;
    }
    public void menu(){




        System.out.println("_____________________________________________________");
        System.out.println("""
            Bienvenido al conversor de monedas
                            Ingrese una opcion a convertir
                            1  ARS>>>>>>>>>>>>>>USD
                            2  USD>>>>>>>>>>>>>>ARS
                            3  COP>>>>>>>>>>>>>>USD
                            4  USD>>>>>>>>>>>>>>COP
                            5  UYU>>>>>>>>>>>>>>USD
                            6  USD>>>>>>>>>>>>>>UYU
                            7  CLP>>>>>>>>>>>>>>USD
                            8  USD>>>>>>>>>>>>>>CLP
                            9  BRL>>>>>>>>>>>>>>USD
                            10 USD>>>>>>>>>>>>>>BRL
                            11 Conversión a su elección
                            12 Ver ultimas converciones
                            0  >>>>>>>>>>>>>>>>> Salida
            """);
        System.out.println("_________________________________________________________");

        if (teclado.hasNextInt()){
            int input = teclado.nextInt();
            teclado.nextLine();

            if (input >= 13 || input<0) {
                System.out.println(validezNula);
                menu();
            } else if (input == 12) {
                leerLista();

            } else if (input == 0) {
                System.out.println("Gracias por usar este sistema ");


            } else if (input < 12 && input > 0) {
                Calculo convercion = new Calculo();
                resultadoConvercion = "El resultado es; " +  convercion.ejecutarConvercion(input);
                System.out.println(resultadoConvercion);
                continuar();
            }
        }else {
            System.out.println(validezNula);
            teclado.next();
            menu();
        }

    }

    private void leerLista() {
        if (this.archivo.getLista().size() != 0){
            System.out.println(historial);
            for (String s : this.archivo.getLista()){
                System.out.println(s);
            }

            continuar();

        }else{
            System.out.println(convercionesNoRealizadas);
            continuar();
        }

    }
    public void continuar() {
        opciones = 0;
        System.out.println("""
                ¿Desea usted continuar?
                1) Menu
                2) Salir
                """);
        if (teclado.hasNextInt()) {
            opciones = teclado.nextInt();
            if (opciones < 1 || opciones > 2) {
                System.out.println(validezNula);
                continuar();
            } else {
                if (opciones == 1) {
                    archivo.addLista(resultadoConvercion);
                    archivo.listado();
                    menu();
                } else {
                    System.out.println("Gracias por usar mi Convertor");
                }

            }
        } else {
            System.out.println(validezNula);
            teclado.next();
            continuar();
        }

    }



}
    

