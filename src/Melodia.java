public class Nota {

    private Nodo cabeza;

    public Nota() {
        cabeza = null;
    }

    public void agregarNodo(NotaMusical nota) {

        Nodo nodo = new Nodo(nota);

        if(cabeza == null) {
            cabeza = nodo;

        } else {
            Nodo actual = cabeza;

            while(actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nodo;
        }

        nodo.siguiente = null;

    }

    public void modificarNodo(Nodo nodo) {


    }

    public void eliminarNodo(Nodo nodo) {

        
    }
    
}
