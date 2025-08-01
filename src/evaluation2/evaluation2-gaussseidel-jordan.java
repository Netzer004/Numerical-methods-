package com.mycompany.mavenproject3;

import java.text.DecimalFormat;
import java.util.*;

public class Mavenproject3 {
    public static void main(String[] args) {
        String pregunta;
        DecimalFormat df = new DecimalFormat("#.000000");
        System.out.println("\t\tInstituto Tecnol\u00f3gico de Culiac\u00e1n");
        System.out.println("\t\tIngenieria en Sistemas ");
        System.out.println("{nombre}");
        System.out.println("M\u00e9todos n\u00famericos");
        System.out.println("{horario}");

        Scanner leer = new Scanner(System.in);

        int metodo;
        System.out.println("Teclee la pregunta");
        pregunta = leer.nextLine();

        System.out.print("""
                Selecione el metodo para realizar el problema: 
                (1)->Metodo Gauss Jordan
                (2)->Metodo Gauss Seidel
                (0)->Salir
                Opcion-> """);
        metodo = leer.nextInt();
        while (true) {
            switch (metodo) {
                case 1:
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("""
                            \t\tInstituto Tecnol\u00f3gico de Culiac\u00e1n
                            \t\tIngenieria en Sistemas 
                            Brandon Gael Uriarte Lopez
                            M\u00e9todos n\u00famericos
                            De 13:00 a 14:00 horas. 
                            """);
                    System.out.println("------------------------------------------------------------------");
                    int Orden = 0;

                    System.out.println("Se ha seleccionado Metodo Gauss Jordan, ingrese los siguientes datos: ");
                    System.out.println("Elija el orden de la matriz");
                    Orden = leer.nextInt();
                    String[] concepto = new String[Orden];

                    for (int i = 0; i < Orden; i++) {
                        System.out.println("ingrese el concepto de " + (i + 1));
                        concepto[i] = leer.next();
                    }
                    System.out.println("------------------------------------------------------------------");

                    double matriz[][] = new double[Orden][Orden + 1];
                    for (int i = 0; i < Orden; i++) {
                        for (int j = 0; j < Orden + 1; j++) {
                            System.out.println("inserte el dato " + "[" + (i + 1) + "]" + "[" + (j + 1) + "]");
                            matriz[i][j] = leer.nextDouble();
                        }
                    }
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("PREGUNTA: " + pregunta);
                    System.out.println("Matriz inicial");
                    for (int i = 0; i < Orden; i++) {
                        for (int j = 0; j < Orden + 1; j++) {
                            System.out.print("[" + matriz[i][j] + "]  ");
                        }
                        System.out.println(" ");
                    }
                    double piv = 0;
                    double Ecero = 0;
                    // n  son las filas, filas izquierda derecha
                    for (int k = 0; k < Orden - 1; k++) {

                        piv = matriz[k][k];
                        for (int f = k + 1; f < Orden; f++) {
                            Ecero = matriz[f][k];
                            for (int c = k; c < Orden + 1; c++) {
                                matriz[f][c] = (piv * matriz[f][c]) - (Ecero * matriz[k][c]);
                            }
                        }
                    }
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("matriz ceros diagonal abajo");
                    for (int i = 0; i < Orden; i++) {
                        for (int j = 0; j < Orden + 1; j++) {
                            System.out.print("[" + matriz[i][j] + "] ");
                        }
                        System.out.println(" ");
                    }

                    double factor = 0;
                    for (int k = Orden - 1; k >= 1; k--) {
                        piv = matriz[k][k];
                        for (int f = 0; f < k; f++) {
                            factor = matriz[f][k] / piv;
                            for (int c = k - 1; c < Orden + 1; c++) {
                                matriz[f][c] = matriz[f][c] - (factor * matriz[k][c]);
                            }
                        }
                    }
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Matriz ceros diagonal arriba");
                    for (int i = 0; i < Orden; i++) {
                        for (int j = 0; j < Orden + 1; j++) {
                            System.out.print("[" + matriz[i][j] + "] ");
                        }
                        System.out.println(" ");
                    }

                    for (int f = 0; f < Orden; f++) {
                        matriz[f][Orden] = matriz[f][Orden] / matriz[f][f];
                        matriz[f][f] = matriz[f][f] / matriz[f][f];
                    }
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Matriz identidad");
                    for (int i = 0; i < Orden; i++) {
                        for (int j = 0; j < Orden + 1; j++) {
                            System.out.print("[" + matriz[i][j] + "] ");
                        }
                        System.out.println();
                    }
                    System.out.println("Resultados: ");
                    for (int i = 0; i < Orden; i++) {
                        System.out.println(concepto[i] + " = " + matriz[i][Orden]);
                    }
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("------------------------------------------------------------------");
                    System.out.print("""
                            Selecione el metodo para realizar el problema: 
                            (1)->Metodo Gauss Jordan
                            (2)->Metodo Gauss Seidel
                            (0)->Salir
                            Opcion-> """);
                    metodo = leer.nextInt();
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("------------------------------------------------------------------");

                    break;


                case 2:

                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Seleccione un metodo valido (1,2,0)...");
            }
        }
    }
}