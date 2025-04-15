package hu.szamalk.modell;

import java.util.UUID;

public class Mukincs {
    UUID id;
    String alkoto;
    String cim;
    Kategoria kategoria;

    public Mukincs( String alkoto, String cim, Kategoria kategoria) {
        setId();
        this.alkoto = alkoto;
        this.cim = cim;
        this.kategoria = kategoria;
    }

    public UUID getId() {
        return id;
    }

    public String getAlkoto() {
        return alkoto;
    }

    public String getCim() {
        return cim;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public void setAlkoto(String alkoto) {
        this.alkoto = alkoto;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }
}
