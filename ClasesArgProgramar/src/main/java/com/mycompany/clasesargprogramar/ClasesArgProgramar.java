package com.mycompany.clasesargprogramar;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ClasesArgProgramar implements Metodos {

    private static final Scanner entrada = new Scanner(System.in);

    @Override
    public String[] borrarCorchetesArray(String[] texto) {
        if (texto.toString().contains("[") && entrada.toString().contains("]")) {
            Arrays.toString(texto).replaceAll("[\\[\\]]", "");

            return texto;
        }
        return null;
    }

    @Override
    public void operacionesFile(String operacion) throws IOException {
        Path unArchivo = Paths.get("archivoRandom.txt");

        switch (operacion) {
            case "existe":
                boolean existe = Files.exists(unArchivo, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
                System.out.println(existe);
                break;
            case "crear":
                Files.createFile(unArchivo);
                break;
            case "copiar":
                Path segundoArchivo = Paths.get("archivoSegundo.txt");
                Files.copy(unArchivo, segundoArchivo);
                break;
            case "mover":
                Path tercerArchivo = Paths.get("archivoTercero.txt");
                Files.move(unArchivo, tercerArchivo);
                break;
            case "eliminar":
                Files.delete(unArchivo);
                break;
        }
    }

    @Override
    public StringBuilder borrarCorchetes(StringBuilder entrada) {
        if (entrada.toString().contains("[") && entrada.toString().contains("]")) {
            entrada.deleteCharAt(0);
            entrada.deleteCharAt(entrada.length() - 1);

            return entrada;
        }
        return null;
    }

    public void OperacionC1A1() {
        int numeroInicio = 5, numeroFin = 14;

        while (numeroInicio < numeroFin) {
            System.out.print(numeroInicio + ", ");
            numeroInicio++;
        }

        System.out.print(numeroInicio);
    }

    public void OperacionC1A2() {
        System.out.println("Orden Par: ");
        int numeroInicio = 5, numeroFin = 14;

        numeroInicio += 1;

        while (numeroInicio < numeroFin) {
            System.out.print(numeroInicio + ", ");
            numeroInicio += 2;
        }

        System.out.print(numeroInicio);
    }

    public void OperacionC1A3() {
        int numeroInicio = 5, numeroFin = 14;

        System.out.println("Que orden desea?: (Sea par o impar)");
        String orden = entrada.nextLine().toLowerCase();

        switch (orden) {
            case "par" -> {
                System.out.println("Orden Par: ");
                numeroInicio += 1;
                while (numeroInicio < numeroFin) {
                    System.out.print(numeroInicio + ", ");
                    numeroInicio += 2;
                }
                System.out.print(numeroInicio);
            }
            case "impar" -> {
                System.out.println("Orden Impar: ");
                numeroFin = 13;
                while (numeroInicio < numeroFin) {
                    System.out.print(numeroInicio + ", ");
                    numeroInicio += 2;
                }
                System.out.print(numeroInicio);
            }
            default ->
                System.out.println("Respuesta incorrecta.");
        }
    }

    public void OperacionC1A4() {
        System.out.println("Orden Impar: ");
        int numeroInicio = 5, numeroFin = 14;

        numeroFin = 13;

        for (; numeroInicio < numeroFin; numeroInicio += 2) {
            System.out.print(numeroInicio + ", ");
        }

        System.out.println(numeroInicio);
    }

    public void OperacionC1B1() {
        int ingresos = 489083;
        int vehiculos = 3;
        int antiguedad = 4;
        int inmuebles = 3;
        boolean economiaPlena = true;

        if (ingresos >= 489083 && (vehiculos >= 3 && antiguedad < 5) && inmuebles >= 3 && economiaPlena == true) {
            System.out.println("Pertenece al segmento de ingresos altos.");
        } else {
            System.out.println("No pertenece al segmento de ingresos altos.");
        }
    }

    public void OperacionC3A1() {
        String palabra = "hola mundo";
        char letra = 'o';
        int contador = 0;

        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                contador++;
            }
        }

        System.out.println("La cantidad de apariciones de la letra " + "\'" + letra + "\'" + " en la palabra " + "\"" + palabra + "\"" + " es " + contador);
    }

    public void OperacionC3A2() {
        int numeroUno = 641, numeroDos = 123, numeroTres = 864;

        System.out.println("Que orden desea?: (Ascendente o Descendente)");
        String orden = entrada.nextLine().toLowerCase();

        switch (orden) {
            case "ascendente" -> {
                Integer numeros[] = new Integer[]{numeroUno, numeroDos, numeroTres};
                Arrays.sort(numeros);
                for (Integer numero : numeros) {
                    System.out.println("[" + numero + "]");
                }
            }
            case "descendente" -> {
                Integer numeros[] = new Integer[]{numeroUno, numeroDos, numeroTres};
                Arrays.sort(numeros, Collections.reverseOrder());
                for (Integer numero : numeros) {
                    System.out.println("[" + numero + "]");
                }
            }
            default ->
                System.out.println("Orden inexistente. Intente de nuevo.");
        }
    }

    public void OperacionC3A3() {
        System.out.println("Ingrese el tamaño del vector: ");
        int numeros[] = new int[entrada.nextInt()];

        System.out.println("Ingrese un numero X: ");
        int numeroX = entrada.nextInt();

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Ingrese el valor #" + (i + 1));
            numeros[i] = entrada.nextInt();
        }

        int resultado = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > numeroX) {
                resultado += numeros[i];
            }
        }

        System.out.println("La suma de todos los numeros mayores que " + numeroX + ", es igual a: " + resultado);
    }

    public void OperacionC3B1() {
        String[] abecedario = {"abcdefghijklmnopqrstuvwxyz"};
        String[] palabra = new String[1];

        StringBuilder abc = new StringBuilder();
        StringBuilder p = new StringBuilder();
        StringBuilder pC = new StringBuilder();
        StringBuilder pD = new StringBuilder();

        abc.append(Arrays.toString(abecedario));
        borrarCorchetes(abc);

        System.out.println("Ingrese la frase o palabra a codificar: ");
        palabra[0] = entrada.nextLine();

        System.out.println("Ingrese cuanto desplazamiento: ");
        int desplazamiento = entrada.nextInt();

        System.out.println("La palabra es: " + palabra[0]);

        System.out.println("");
        System.out.println("Codificando...");
        System.out.println("");

        p.append(Arrays.toString(palabra));
        borrarCorchetes(p);

        for (int i = 0; i < p.length(); i++) {
            char letra = p.charAt(i);
            int indice = abc.toString().indexOf(letra);

            if (indice >= 0) {
                int indiceCodificada = (indice + desplazamiento) % abc.length();
                char letraCodificada = abc.toString().charAt(indiceCodificada);
                pC.append(letraCodificada);
            } else {
                pC.append(letra);
            }
        }

        System.out.println("La palabra codificada es: " + pC);

        System.out.println("");

        System.out.println("Decodificando...");

        System.out.println("");

        for (int i = 0; i < p.length(); i++) {
            char letra = pC.charAt(i);
            int indice = abc.toString().indexOf(letra);

            if (indice >= 0) {
                int indiceDecodificado = (indice - desplazamiento);
                char letraDecodificada = abc.toString().charAt(indiceDecodificado);
                pD.append(letraDecodificada);
            } else {
                pD.append(letra);
            }
        }

        System.out.println("La palabra decodificada es: " + pD);
    }

    public void OperacionC4A1() {
        int numeroUno = 143, numeroDos = 641, numeroTres = 354;
        char orden = 'd';

        if (orden == 'a') {
            Integer numeros[] = new Integer[]{numeroUno, numeroDos, numeroTres};

            Arrays.sort(numeros);

            for (Integer numero : numeros) {
                System.out.println("[" + numero + "]");
            }
        } else if (orden == 'd') {
            Integer numeros[] = new Integer[]{numeroUno, numeroDos, numeroTres};

            Arrays.sort(numeros, Collections.reverseOrder());

            for (Integer numero : numeros) {
                System.out.println("[" + numero + "]");
            }
        } else {
            System.out.println("Orden inexistente o incorrecta.");
        }
    }

    public void OperacionC4A2() {
        System.out.println("Ingrese tres numeros: ");
        int numeroUno = entrada.nextInt();
        int numeroDos = entrada.nextInt();
        int numeroTres = entrada.nextInt();

        System.out.println("Ingrese el orden que desea: (A de ascendente o D de descendente)");
        char orden = entrada.next().toLowerCase().charAt(0);
        System.out.println(orden);

        if (orden == 'a') {
            Integer numeros[] = new Integer[]{numeroUno, numeroDos, numeroTres};

            Arrays.sort(numeros);

            for (Integer numero : numeros) {
                System.out.println("[" + numero + "]");
            }
        } else if (orden == 'd') {
            Integer numeros[] = new Integer[]{numeroUno, numeroDos, numeroTres};

            Arrays.sort(numeros, Collections.reverseOrder());

            for (Integer numero : numeros) {
                System.out.println("[" + numero + "]");
            }
        } else {
            System.out.println("Orden inexistente o incorrecta.");
        }
    }

    public void OperacionC4A3() {
        System.out.println("Ingrese tres numeros: ");
        int numeroUno = entrada.nextInt();
        int numeroDos = entrada.nextInt();
        int numeroTres = entrada.nextInt();

        if ((numeroUno == 0) & (numeroDos == 0) & (numeroTres == 0)) {
            int numeroX1 = 214;
            int numeroX2 = 613;
            int numeroX3 = 325;

            char orden = 'a';

            System.out.println("Los numeros seran por defecto: " + numeroX1 + ", " + numeroX2 + ", " + numeroX3 + ".");
            System.out.println("El orden por defecto sera: " + "\'" + orden + "\'");

            Integer numeros[] = new Integer[]{numeroX1, numeroX2, numeroX3};

            Arrays.sort(numeros);

            int i = 0;

            do {
                System.out.println("[" + numeros[i] + "]");
                i++;
            } while (i < numeros.length);
        } else {
            System.out.println("Ingrese el orden que desea: (A de Ascendente o D de Descendente)");
            char orden = entrada.next().toLowerCase().charAt(0);

            if (orden == 'a') {
                Integer numeros[] = new Integer[]{numeroUno, numeroDos, numeroTres};

                Arrays.sort(numeros);

                for (int i = 0; i < numeros.length; i++) {
                    System.out.println("[" + numeros[i] + "]");
                }
            } else if (orden == 'd') {
                Integer numeros[] = new Integer[]{numeroUno, numeroDos, numeroTres};

                Arrays.sort(numeros, Collections.reverseOrder());

                int i = 0;

                while (i < numeros.length) {
                    System.out.println("[" + numeros[i] + "]");
                    i++;
                }
            }
        }
    }

    public void OperacionC4B1y2() throws IOException {
        Path rutaArchivo = Path.of("C:\\Programacion\\archivoTXT.txt");

        List<String> lineas = Files.readAllLines(rutaArchivo);
        int resultado = 0;

        System.out.println("Ingrese que operacion desea: (Si multiplicar o sumar)");
        String tipoOperacion = entrada.nextLine();

        if (tipoOperacion.equals("multiplicar")) {
            resultado = 1;

            for (String entrada : lineas) {
                int numeros = Integer.parseInt(entrada);

                resultado *= numeros;
            }

            System.out.println(resultado);
        } else if (tipoOperacion.equals("sumar")) {
            for (String entrada : lineas) {
                int numeros = Integer.parseInt(entrada);

                resultado += numeros;
            }

            System.out.println(resultado);
        }
    }

    public void OperacionC4C1() throws IOException {
        String[] abecedario = {"abcdefghijklmnñopqrstuvwxyz"};
        borrarCorchetesArray(abecedario);

        String[] tipoDecision = new String[1];
        borrarCorchetesArray(tipoDecision);

        Integer[] desplazamiento = new Integer[1];
        String[] palabra = new String[1];

        Path unArchivo = Paths.get("C:\\Programacion\\archivoTXT2.txt");

        List<String> linea = Files.readAllLines(unArchivo);
        palabra = linea.toArray(new String[0]);

        System.out.println("Ingrese si quiere codificar o decodificar: ");
        tipoDecision[0] = entrada.nextLine();

        if (tipoDecision[0].toString().equals("codificar")) {
            System.out.println("Ingrese cuanto desplazamiento desea: ");
            desplazamiento[0] = entrada.nextInt();

            for (int i = 0; i < palabra[0].length(); i++) {
                char[] letra = {palabra[0].charAt(i)};
                Integer[] indice = new Integer[palabra[0].length()];

                for (int j = 0; j < letra.length; j++) {
                    indice[i] = abecedario[0].indexOf(letra[j]);
                }

                Integer[] indiceCodificado = new Integer[palabra[0].length()];
                String[] palabraCodificada = new String[palabra[0].length()];

                if (indice[i] >= 0) {
                    indiceCodificado[0] = (indice[i] + desplazamiento[0]);
                    char[] letraCodificada = {abecedario[0].charAt(indiceCodificado[0])};

                    palabraCodificada[i] = new String(letraCodificada);
                } else {
                    palabraCodificada[i] = new String(letra);
                }
                FileWriter escritor = new FileWriter("archivoTXT3.txt", true);
                
                escritor.write(palabraCodificada[i]);
                
                escritor.close();
            }
        } else if (tipoDecision[0].toString().equals("decodificar")) {
            System.out.println("Ingrese cuanto desplazamiento desea: ");
            desplazamiento[0] = entrada.nextInt();

            for (int i = 0; i < palabra[0].length(); i++) {
                char[] letra = {palabra[0].charAt(i)};
                Integer[] indice = new Integer[palabra[0].length()];

                for (int j = 0; j < letra.length; j++) {
                    indice[i] = abecedario[0].indexOf(letra[j]);
                }

                Integer[] indiceDecodificado = new Integer[palabra[0].length()];
                String[] palabraDecodificada = new String[palabra[0].length()];

                if (indice[i] >= 0) {
                    indiceDecodificado[0] = (indice[i] - desplazamiento[0]);
                    char[] letraDecodificada = {abecedario[0].charAt(indiceDecodificado[0])};

                    palabraDecodificada[i] = new String(letraDecodificada);
                } else {
                    palabraDecodificada[i] = new String(letra);
                }
                FileWriter escritor = new FileWriter("archivoTXT3.txt", true);
                
                escritor.write(palabraDecodificada[i]);
                
                escritor.close();
            }
        } else {
            System.out.println("Respuesta incorrecta o inexistente.");
        }
    }
    
    
}
