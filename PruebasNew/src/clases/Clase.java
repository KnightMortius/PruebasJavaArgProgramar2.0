package clases;

import java.util.Scanner;

public class Clase {

    private static Scanner entrada = new Scanner(System.in);

    public void Operacion() {
        String abecedario = "abcdefghijklmnñopqrstuvwxyz", palabraCodificada = "", palabraDecodificada = "";

        System.out.println("Ingrese frase o palabra: ");
        String palabra = entrada.nextLine();

        System.out.println("Ingrese cuanto desplazamiento desea?: ");
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

        System.out.println("Palabra codificada: " + palabraCodificada);

        System.out.println("Desea decodificar la palabra?: ");
        String decision = entrada.next();

        if (decision.equals("si")) {
            for (int i = 0; i < palabraCodificada.length(); i++) {
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

            System.out.println("Palabra decodificada: " + palabraDecodificada);
        } else if (decision.equals("no")) {
            System.out.println("Operacion completada exitosamente.");
        } else {
            System.out.println("Respuesta incorrecta.");
        }
    }
}
