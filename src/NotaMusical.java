public class NotaMusical {

    private String nota, figura;
    private int octava;

    public NotaMusical(String nota, String figura, int octava) {
        this.nota = nota;
        this.figura = figura;
        this.octava = octava;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public int getOctava() {
        return octava;
    }

    public void setOctava(int octava) {
        this.octava = octava;
    }

    

    
    
}
