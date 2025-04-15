package hu.szamalk.modell;

import java.util.Comparator;

public class Szobor extends Mukincs implements Comparable<Szobor>{
    String anyag;
    int szazad;
    public Szobor(String alkoto, String cim, Kategoria kategoria,  String anyag, int szazad) throws NemMegfeleloSzazadException {
        super(alkoto, cim, kategoria);
        this.anyag=anyag;
        if(szazad>21){
            throw new NemMegfeleloSzazadException("a század nagyobb mint 21");
        }
        else{
        this.szazad=szazad;}
    }
    public Szobor(String alkoto, String cim, Kategoria kategoria,  String anyag) {
        super(alkoto, cim, kategoria);
        this.anyag=anyag;
        this.szazad=20;
    }

    public String getAnyag() {
        return anyag;
    }

    public int getSzazad() {
        return szazad;
    }

    @Override
    public int compareTo(Szobor o) {
        return CharSequence.compare(this.anyag, o.anyag);

    }
    //public void szazadszerint(){
      //  return Comparator<Szobor> szazadszerint=Comparator.comparingInt(Szobor::getSzazad);
    //}

    //public void szazadszerint(){
      //  return Comparator<Szobor> szazadszerint=Comparator.comparing(Szobor::getAnyag);
    //}


}

class NemMegfeleloSzazadException extends Exception {
    public  NemMegfeleloSzazadException(String message) {
        super(message);
    }}
