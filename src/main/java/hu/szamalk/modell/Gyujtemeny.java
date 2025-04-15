package hu.szamalk.modell;

import java.util.List;

public class Gyujtemeny {
    List<Mukincs> mukincsek;

    public Gyujtemeny(List<Mukincs> mukincsek) {
        this.mukincsek = mukincsek;
    }

    public void mutargyFelvesz(Mukincs m){
        mukincsek.add(m);
    }

    @Override
    public String toString() {
        return "Gyujtemeny{" +
                "mukincsek=" + mukincsek +
                '}';
    }
}
