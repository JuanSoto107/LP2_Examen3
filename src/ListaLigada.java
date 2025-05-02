import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import DTOs.NotaMusicalDto;

import entidades.NotaMusical;
import entidades.Figura;
import entidades.Notas;

import javax.swing.JTable;

public class ListaLigada {

    private Nodo cabeza;

    public ListaLigada() {
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

    private Nodo nodoseleccionado;

    public Nodo getnodoSeleccionado() {
        return nodoseleccionado;
    }

    public Nodo seleccionar(int i) {
        nodoseleccionado = null;
        Nodo actual = cabeza;

        int j = 0;

        while(j < i) {
            actual = actual.siguiente;
            j++;
        }

        nodoseleccionado = actual;

        return nodoseleccionado;
    }


    public void eliminarNodo(Nodo nodo) {
        Nodo actual = cabeza;
        Nodo anterior = null;

        while(actual != null) {
            if(actual == nodo) {
                if(anterior == null) {
                    cabeza = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }  
                break;
            }
            anterior = actual;
            actual = actual.siguiente;

        }
    }

    public int getLongitud() {

        int totalNodos = 0;
        Nodo actual = cabeza;

        while(actual != null) {
            totalNodos++;
            actual = actual.siguiente;
        }

        return totalNodos;
    }

    public boolean guardarJSON(String NombreArchivo) {

        NotaMusicalDto[] nmusicales = new NotaMusicalDto[getLongitud()];
        Nodo actual = cabeza;

        int fila = 0;

        while (actual != null) {
            nmusicales[fila] = actual.toDTO();
            fila++;
            actual = actual.siguiente;
        }

        return Archivo.guardarJson(NombreArchivo, nmusicales);
    }

    public void desdeJSON(String NombreArchivo) {
        List<NotaMusicalDto> NotasDto = Archivo.leerJson(NombreArchivo, new TypeReference<List<NotaMusicalDto>>() {
        });
        
        if(NotasDto != null) {
            cabeza = null;
            for(NotaMusicalDto dto : NotasDto) {
                NotaMusical notamusical = new NotaMusical(dto.getNota(), dto.getFigura(), dto.getOctava());
                Nodo nodo = new Nodo(notamusical);
                agregarNodo(nodo);
            }
        }
    
    }

    public Nodo getCabeza() {
        return cabeza;
    }            
    
}
