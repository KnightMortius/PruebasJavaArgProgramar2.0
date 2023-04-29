package clases;

public class Pila {
    // Nombre: Melvin Allende
    // Legajo: VINF013363
    // DNI: 42893232

    class Nodo {

        int info;
        Nodo sig;

    }

    private Nodo raiz;

    public Pila() {

        raiz = null;

    }

    public void apilar(int x) {

        Nodo nuevo;

        nuevo = new Nodo();
        nuevo.info = x;

        if (raiz == null) {

            nuevo.sig = null;
            raiz = nuevo;

        } else {

            nuevo.sig = raiz;
            raiz = nuevo;

        }
    }

    public int desapilar() { //Este método recorre la pila, retorna la cima y elimina el valor
        if (raiz != null) {
            int valor = raiz.info;
            raiz = raiz.sig;
            return valor; //Retorna el valor de la cima de la pila
        } else {
            System.out.println("La pila no tiene elementos.");
            return -1; //Retorna un valor que dice si la pila está vacia
        }
    }

    public void vercontenido() { //Este método muestra lo que contiene dentro de la pila
        if (raiz == null) {
            System.out.println("La pila no tiene elementos."); //Si la pila esta vacia devuelve que no tiene elementos
        } else {
            Nodo actual = raiz;
            System.out.println("Los elementos que se encuentran en la pila son: "); //Si la pila contiene valores dentro, devuelve una lista de esos valores
            while (actual != null) {
                System.out.print(actual.info + " ");
                actual = actual.sig;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Pila pila1 = new Pila();
        pila1.apilar(10);
        pila1.apilar(40);
        pila1.apilar(3);
        pila1.vercontenido();
        System.out.println("Cima de la pila: " + pila1.desapilar());
        pila1.vercontenido();
    }
}
