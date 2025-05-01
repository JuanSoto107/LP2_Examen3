import entidades.Figura;
import entidades.NotaMusical;
import entidades.Notas;

import DTOs.NotaMusicalDto;

public class Nodo {

    private NotaMusical notamusical;
    public Nodo siguiente;


    public Nodo(NotaMusical notamusical) {
        this.notamusical = notamusical;
    }


    public NotaMusical getNotamusical() {
        return notamusical;
    }


    public void setNotamusical(NotaMusical notamusical) {
        this.notamusical = notamusical;
    }

    public NotaMusicalDto toDTO() {
        return new NotaMusicalDto(
            notamusical.getNota(),
            notamusical.getFigura(), 
            notamusical.getOctava()
        );
    }

    

    

    

    
    
}
