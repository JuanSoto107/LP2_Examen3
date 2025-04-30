public class Melodia {

    private Nodo cabeza;

    public Melodia() {
        cabeza = null;
    }

    public void agregarNodo(Nodo nodo) {

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

    public void almacenar() {

        Nodo actual = cabeza;

        while(actual != null) {
            actual.getNotamusical();
            actual = actual.siguiente;
        }
    }

    public void modificarNodo(Nodo nodo) {


    }

    public void eliminarNodo(Nodo nodo) {

        
    }
    
}
