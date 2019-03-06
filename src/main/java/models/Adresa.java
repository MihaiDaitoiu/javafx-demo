package main.java.models;

public class Adresa {

    Long id;

    String tara;

    String oras;

    String strada;

    public Adresa(String tara, String oras, String strada) {
        this.tara = tara;
        this.oras = oras;
        this.strada = strada;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }
}
