package entidades;

public class NotaMusical {

    private Notas nota;
    private Figura figura;
    private int octava;


    public NotaMusical(Notas nota, Figura figura, int octava) {
        this.nota = nota;
        this.figura = figura;
        this.octava = octava;
    }


    public Notas getNota() {
        return nota;
    }


    public void setNota(Notas nota) {
        this.nota = nota;
    }


    public Figura getFigura() {
        return figura;
    }


    public void setFigura(Figura figura) {
        this.figura = figura;
    }


    public int getOctava() {
        return octava;
    }


    public void setOctava(int octava) {
        this.octava = octava;
    }

    

    

    

    
    
}
