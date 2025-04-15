package hu.szamalk.nézet;

import hu.szamalk.modell.Festmeny;
import hu.szamalk.modell.Gyujtemeny;
import hu.szamalk.modell.Kategoria;
import hu.szamalk.modell.Mukincs;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Konzol {
    Gyujtemeny gyujtemeny;

    public Konzol() {
        List<Mukincs> gyujtott=new ArrayList<Mukincs>();
        this.gyujtemeny=new Gyujtemeny(gyujtott);
    }
    public Konzol(String fajl) {
        beolvas(fajl);
    }

    private void beolvas(String fajl) throws IOException {
        List<String> sorok = Files.readAllLines(Path.of(fajl));
        ArrayList<Mukincs> gyujtemenyLista=new ArrayList<>();
        for (String sor : sorok) {
            String[] adat = sor.split(";");
            if(adat[0].equals("Festmeny")){
                gyujtemenyLista.add(new Festmeny(adat[1], adat[2], (Kategoria) adat[3], adat[4],adat[5]));

            }
            else{
                gyujtemenyLista.add(new Szobor(adat[1], adat[2], (Kategoria) adat[3], adat[4],Integer.parseInt(adat[5])));
            }
        }


    }

    public void konzolraIr(){
        System.out.println(gyujtemeny.toString());

    }

    public void fajlbaIr(){
        try(ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("Mukincs_gyujtemeny.dat"))){
            objKi.writeObject(this.gyujtemeny);
            System.out.println("gyüjtemény kiírva");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        public void makeStatisztika(){
            HashMap<String, ArrayList> statisztika = new HashMap<>();
            ArrayList<Festmeny> festmenyek= new ArrayList<>();
            for (int i = 0; i < festmenyek.length(); i++) {
                String kulcs=festmenyek[i].getTechnika();
                if(statisztika.containsKey(kulcs)){
                    ArrayList<String> ertek=statisztika.get(kulcs);
                    ertek.add(festmenyek[i].getSzerzo);
                    statisztika.put(kulcs, ertek);
                }
                else{
                    ArrayList<String> lista=new ArrayList<>();
                    lista.add(festmenyek[i].getSzerzo);
                    statisztika.put(kulcs, lista);
                }
            }
            for (Map.Entry<String, ArrayList> entry : statisztika.entrySet()) {
                String key = entry.getKey();
                ArrayList value = entry.getValue();
                System.out.printf("['%s'] = %d\n", key, value);
            }

        }
    }

}
