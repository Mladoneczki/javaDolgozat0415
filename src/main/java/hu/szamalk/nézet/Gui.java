package hu.szamalk.nézet;

import hu.szamalk.modell.Kategoria;
import hu.szamalk.modell.Szobor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Gui {
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JButton felveszButton;
    private JMenuItem beolv;
    public Konzol konz;
    public Gui() {
        ini();

        beolv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fc = new JFileChooser();
                    fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
                    if(fc.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
                        File fajl = fc.getSelectedFile();
                        String eleres = fajl.getAbsolutePath();
                        {
                           konz= new Konzol(eleres);

                        }
                        }
                    }

                }
            };
        felveszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                konz.gyujtemeny.mutargyFelvesz(Szobor('ismeretlen', 'Nike', Kategoria.EREDETI, "MÁRVÁNY", -2));
                String szobor= "Ismeretlen";
                comboBox1.addItem(szobor);
            }
        });
    }



    private void ini() {
        JFrame form = new JFrame("Gyüjtemény");
        form.setSize(new Dimension(320, 240));
        form.setContentPane(mainPanel);
        form.setLocationRelativeTo(null);
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /* megnyomására meghívja a windowClosing() mást nem csinál */
        //form.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
 beolv=new JMenuItem("Beolvasás");
JMenuItem kilep= new JMenuItem("Kielepes");
JMenu menu=new JMenu("Menu");
menu.add(beolv);
menu.add(new JSeparator());
menu.add(kilep);
JMenuBar bar= new JMenuBar();
bar.add(menu);
form.setJMenuBar(bar);

        form.setVisible(true);


    }
    public static void main(String[] args) {
        new GuiForm();
    }
}
