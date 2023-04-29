package com.mycompany.pruebasmain;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class SPruebaMain {

    public static void main(String[] args) {
        /*
        //Clase 4 - Argentina Programar
       
        //Consigna 1 - A
        Scanner entrada = new Scanner(System.in);
        
        int numero1 = 213, numero2 = 142, numero3 = 931;
        
        System.out.println("Ingrese el orden que desea: (A de Ascendente o D de Descendente)");
        char orden = entrada.next().toLowerCase().charAt(0);
        
        if (orden == 'a') {
            Integer numeros[] = new Integer[] {numero1, numero2, numero3};
            
            Arrays.sort(numeros);
            
            for (int i = 0; i < numeros.length; i++) {
                System.out.println(numeros[i]);
            }
        } else if (orden == 'd') {
            Integer numeros[] = new Integer[] {numero1, numero2, numero3};
            
            Arrays.sort(numeros, Collections.reverseOrder());
            
            for (int i = 0; i < numeros.length; i++) {
                System.out.println(numeros[i]);
            }
        } else {
            System.out.println("Orden inexistente.");
        }
        
        //Consigna 1 - B
        System.out.println("Ingrese tres numeros: ");
        int numeroUno = entrada.nextInt();
        int numeroDos = entrada.nextInt();
        int numeroTres = entrada.nextInt();
        
        System.out.println("Ingrese el orden que desea: (A de Ascendente o D de Descendente)");
        char ordenB = entrada.next().toLowerCase().charAt(0);
        
        if (ordenB == 'a') {
            Integer numeros[] = new Integer[] {numeroUno, numeroDos, numeroTres};
            
            Arrays.sort(numeros);
            
            for (int i = 0; i < numeros.length; i++) {
                System.out.println(numeros[i]);
            }
        } else if (ordenB == 'd') {
            Integer numeros[] = new Integer[] {numeroUno, numeroDos, numeroTres};
            
            Arrays.sort(numeros, Collections.reverseOrder());
            
            for (int i = 0; i < numeros.length; i++) {
                System.out.println(numeros[i]);
            }
        } else {
            System.out.println("Orden inexistente.");
        }

        //Consigna 1-C
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese tres numeros");
        int numeroX1 = entrada.nextInt();
        int numeroX2 = entrada.nextInt();
        int numeroX3 = entrada.nextInt();
        System.out.println("Se pondran numeros por defecto.");

        if ((numeroX1 | numeroX2 | numeroX3) == 0) {

            numeroX1 = 213;
            numeroX2 = 142;
            numeroX3 = 931;

            System.out.println("Ingrese el orden que desea: (A de Ascendente o D de Descendente)");
            char orden = entrada.next().toLowerCase().charAt(0);

            switch (orden) {
                case 'a' -> {
                    Integer numeros[] = new Integer[]{numeroX1, numeroX2, numeroX3};
                    Arrays.sort(numeros);
                    for (Integer numero : numeros) {
                        System.out.println(numero);
                    }
                }
                case 'd' -> {
                    Integer numeros[] = new Integer[]{numeroX1, numeroX2, numeroX3};
                    Arrays.sort(numeros, Collections.reverseOrder());
                    for (Integer numero : numeros) {
                        System.out.println(numero);
                    }
                }
                default ->
                    System.out.println("Orden inexistente.");
            }
        } else {
            System.out.println("Ingrese el orden que desea: (A de Ascendente o D de Descendente)");
            char ordenB = entrada.next().toLowerCase().charAt(0);

            switch (ordenB) {
                case 'a' -> {
                    Integer numeros[] = new Integer[]{numeroX1, numeroX2, numeroX3};
                    Arrays.sort(numeros);
                    for (Integer numero : numeros) {
                        System.out.println(numero);
                    }
                }
                case 'd' -> {
                    Integer numeros[] = new Integer[]{numeroX1, numeroX2, numeroX3};
                    Arrays.sort(numeros, Collections.reverseOrder());
                    for (Integer numero : numeros) {
                        System.out.println(numero);
                    }
                }
                default ->
                    System.out.println("Orden inexistente.");
            }
        }
         */
    }
}
