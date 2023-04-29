package com.mycompany.pruebasmain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PruebasSecundarias {

    private static final Scanner entrada = new Scanner(System.in);

    public void C1Consigna1A() {
        int numeroInicio = 5;
        int numeroFin = 14;

        System.out.println("Consigna 1 - A: ");

        while (numeroInicio < numeroFin) {
            System.out.print(numeroInicio + ", ");
            numeroInicio++;
        }

        System.out.println(numeroInicio);

    }

    public void C1Consigna1B() {
        System.out.println("Consigna 1 - B: ");

        int numeroInicio = 5;
        int numeroFin = 14;

        numeroInicio += 1;

        while (numeroInicio < numeroFin) {
            System.out.print(numeroInicio + ", ");
            numeroInicio += 2;
        }

        System.out.println(numeroInicio);

    }

    public void C1Consigna1C() {
        System.out.println("Consigna 1 - C: ");

        int numeroInicio = 5;
        int numeroFin = 14;

        System.out.println("Que orden desea? par o impar: ");
        String orden = entrada.next().toLowerCase();

        if (orden.equals("par")) {
            numeroInicio += 1;

            while (numeroInicio < numeroFin) {
                System.out.print(numeroInicio + ", ");
                numeroInicio += 2;
            }
            System.out.println(numeroInicio);

        } else if (orden.equals("impar")) {
            numeroFin = 13;

            while (numeroInicio < numeroFin) {
                System.out.print(numeroInicio + ", ");
                numeroInicio += 2;
            }

            System.out.println(numeroInicio);
        }
    }

    public void C1Consigna2A() {
        System.out.println("Consigna 2 - A: ");

        int ingresosMensuales = 489083;
        int vehiculos = 3;
        int antiguedad = 4;
        int inmuebles = 3;
        boolean economiaPlena = true; //Si contiene diferentes cosas dentro de la economia plena es aceptable.

        if ((ingresosMensuales >= 489083) && (vehiculos >= 3) && (antiguedad < 5) && (inmuebles >= 3) && (economiaPlena == true)) {
            System.out.println("Pertenece al segmento de ingresos altos.");
        } else {
            System.out.println("No pertenece al segmento de ingresos altos.");
        }
    }

    public void C3Consigna1A() {
        System.out.println("Consigna 1 - A");

        String frase = "Hola medica loca";
        char letra = 'a';
        int contador = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letra) {
                contador++;
            }
        }
        System.out.println("Se encuentra la letra " + letra + ", una cantidad de " + contador + " veces.");
    }

    public void C3Consigna1B() {
        System.out.println("Consigna 1 - B");

        int numeroUno = 200, numeroDos = 50, numeroTres = 80;

        System.out.println("Ingrese en que orden desea: (Sea ascendente o descendente)");
        String orden = entrada.next().toLowerCase();

        if (orden.equals("ascendente")) {
            int numeros[] = {numeroUno, numeroDos, numeroTres};

            Arrays.sort(numeros);

            for (int i = 0; i < numeros.length; i++) {
                System.out.println("[" + numeros[i] + "]");
            }
        } else if (orden.equals("descendente")) {
            Integer numeros[] = {numeroUno, numeroDos, numeroTres};

            Arrays.sort(numeros, Collections.reverseOrder());

            for (int i = 0; i < numeros.length; i++) {
                System.out.println("[" + numeros[i] + "]");
            }
        } else {
            System.out.println("Orden inexistente o incorrecta.");
        }
    }

    public void C3Consigna1C() {
        System.out.println("Consigna 1 - C: ");

        int numeros[] = new int[]{100, 200, 300};
        int numerosX = 200;
        int resultado = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > numerosX) {
                resultado += numeros[i];
            }
        }

        System.out.println("La suma de todos los numeros mayores que " + numerosX + " es: " + resultado);
    }

    public void C3Consigna2A() {
        System.out.println("Consigna 2 - A: ");

        String abecedario = "abcdefghijklmnopqrstuvwxyz";
        String palabraCodificada = "";
        
        System.out.println("Ingrese la frase o palabra: ");
        String frase = entrada.nextLine().toLowerCase();

        System.out.println("");
        System.out.println("La frase o palabra es: " + frase);
        System.out.println("");
        
        System.out.println("¿Cuantos desplazamientos desea?: ");
        int desplazamiento = entrada.nextInt();

        System.out.println("");
        System.out.println("Codificando...");
        System.out.println("");

        for (int i = 0; i < frase.length(); i++) {
            char letra = frase.charAt(i);
            int indice = abecedario.indexOf(letra);

            if (indice >= 0) {
                int indiceCodificado = (indice + desplazamiento);
                char letraCodificada = abecedario.charAt(indiceCodificado);
                palabraCodificada += letraCodificada;
            } else {
                palabraCodificada += letra;
            }
        }

        System.out.println("Codificado: " + palabraCodificada);
        System.out.println("");

        System.out.println("Desea decodificarlo?: ");
        String orden = entrada.next().toLowerCase();

        if (orden.equals("si")) {
            String palabraDecodificada = "";

            for (int i = 0; i < frase.length(); i++) {
                char letra = palabraCodificada.charAt(i);
                int indice = abecedario.indexOf(letra);

                if (indice >= 0) {
                    int indiceDecodificado = (indice - desplazamiento);
                    char letraDecodificada = abecedario.charAt(indiceDecodificado);
                    palabraDecodificada += letraDecodificada;
                } else {
                    palabraDecodificada += letra;
                }
            }
            
            System.out.println("");
            System.out.println("Decodificando...");
            
            System.out.println("");
            System.out.println("Decodificado: " + palabraDecodificada);
        } else if (orden.equals("no")) {
            System.out.println("Operacion exitosa.");
        } else {
            System.out.println("Respuesta invalida.");
        }
    }
}
