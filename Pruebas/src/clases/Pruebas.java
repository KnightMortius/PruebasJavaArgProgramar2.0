package clases;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class Pruebas {

    private static final Scanner entrada = new Scanner(System.in);

    public void CantidadDeLetras() {
        int contador = 0;

        System.out.println("Ingrese la frase o palabra: ");
        String palabra = entrada.nextLine();

        System.out.println("Ingrese la letra a verificar cuantas veces ha sido repetida: ");
        char letra = entrada.next().charAt(0);

        for (int i = 0; i < palabra.length(); i++) {
            char letraLeida = palabra.charAt(i);

            if (letraLeida == letra) {
                contador++;
            }
        }
        System.out.println("La palabra es: " + palabra + ", contiene la letra: " + letra + ", y se repite un total de: " + contador);
    }

    public void numerosenOrden() {
        System.out.println("Ingrese el tamaño de cuantos numeros desea en el Array: ");
        Integer numeros[] = new Integer[entrada.nextInt()];

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Ingrese el valor #" + (i + 1));
            numeros[i] = entrada.nextInt();
        }

        System.out.println("Desea de forma ascendente o descendente?: ");
        String orden = entrada.next().toLowerCase();

        switch (orden) {
            case "ascendente" -> {
                Arrays.sort(numeros);
                for (Integer numero : numeros) {
                    System.out.println("[" + numero + "]");
                }
            }
            case "descendente" -> {
                Arrays.sort(numeros, Collections.reverseOrder());
                for (Integer numero : numeros) {
                    System.out.println("[" + numero + "]");
                }
            }
            default ->
                System.out.println("Comando introducido erroneo.");
        }
    }

    public void SumatoriaVectores() {
        System.out.println("Ingrese un numero X: ");
        Integer numeroX = entrada.nextInt();

        System.out.println("Ingrese el tamaño de la array: ");
        Integer numeros[] = new Integer[entrada.nextInt()];

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Ingrese el valor #" + (i + 1));
            numeros[i] = entrada.nextInt();
        }

        int resultado = 0;

        for (Integer numero : numeros) {
            if (numero > numeroX) {
                resultado += numero;
            }
        }

        System.out.println("La sumatoria de los numeros mayores que " + numeroX + " es: " + resultado);
    }

    public void CodificacionYDecodificacion() {
        String abecedario = "abcdefghijklmnopqrstuvwxyz";
        String palabraCodificada = "";

        System.out.println("Ingrese la frase o palabra: ");
        String palabra = entrada.nextLine();

        System.out.println("Cuanto desplazamiento desea?: ");
        int desplazamiento = entrada.nextInt();

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            int indice = abecedario.indexOf(letra);

            if (indice >= 0) {

                int indiceCodificado = (indice + desplazamiento);
                char letraCodificada = abecedario.charAt(indiceCodificado);
                palabraCodificada += letraCodificada;
            } else {
                palabraCodificada += letra;
            }
        }

        System.out.println("La palabra codificada es: " + palabraCodificada);

        System.out.println("Desea decodificarlo?: ");
        String orden = entrada.next().toLowerCase();

        if (orden.equals("si")) {
            String palabraDecodificada = "";

            for (int i = 0; i < palabra.length(); i++) {
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
            
            System.out.println(palabraDecodificada);
            
        } else if (orden.equals("no")) {
            System.out.println("Programa finalizado.");
        } else {
            System.out.println("Comando incorrecto.");
        }
    }
    
    public String[] CodificacionYDecodificacion2(String[] entrada, int desplazamiento) {
        StringBuilder abecedario = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
        StringBuilder palabraCodificada = new StringBuilder();        
        StringBuilder palabraDecodificada = new StringBuilder(); 
        
        for (String texto : entrada) {
            for (int i = 0; i < texto.length(); i++) {
                char letra = texto.charAt(i);
                int indice = abecedario.toString().indexOf(letra);
                
                if (indice >= 0) {
                    int indiceCodificado = (indice + desplazamiento);
                    
                } else {
                    palabraCodificada.append(letra);
                }
                
                System.out.println(palabraCodificada);
            }
        }
        
        return entrada;
    }
    
    
}
