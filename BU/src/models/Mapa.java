
package models;


public class Mapa extends Item{
    private String tipoDeMapa;
    private String autor;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipoDeMapa() {
        return tipoDeMapa;
    }

    public void setTipoDeMapa(String tipoDeMapa) {
        this.tipoDeMapa = tipoDeMapa;
    }
}
