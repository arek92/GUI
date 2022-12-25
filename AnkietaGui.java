import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnkietaGui extends JFrame implements ActionListener {

    JLabel czyPolskaWygraLabel;
    JLabel liczbaGlosowLabel;
    JLabel liloscGlosow;
    JLabel liczbaGlosowTak;
    JLabel liczbaGlosowNie;
    JLabel liczbaGlosowTakLabel;
    JLabel liczbaGlosowNieLabel;
    JButton bTak, bNie;
    JProgressBar barTak, barNie;
    int liczbaGlosow = 0;
    int iloscGlosowTak;
    int iloscGlosowNie;


    public AnkietaGui() {
        setSize(500, 500);
        setTitle("Ankieta");
        setLayout(null);

        czyPolskaWygraLabel = new JLabel("Czy Polska wygra z Francja?");
        czyPolskaWygraLabel.setFont(new Font("Sanserif", Font.BOLD, 20));
        czyPolskaWygraLabel.setBounds(100, 30, 300, 40);
        add(czyPolskaWygraLabel);

        liloscGlosow = new JLabel("Ilosc glosow oddanych ");
        liloscGlosow.setFont(new Font("Sanserif", Font.BOLD, 10));
        liloscGlosow.setBounds(50, 300, 200, 20);
        add(liloscGlosow);

        liczbaGlosowTak = new JLabel("Ilosc glosow na Tak ");
        liczbaGlosowTak.setFont(new Font("Sanserif", Font.BOLD, 10));
        liczbaGlosowTak.setBounds(50, 350, 250, 20);
        add(liczbaGlosowTak);

        liczbaGlosowNie = new JLabel("ilosc glosow na Nie ");
        liczbaGlosowNie.setFont(new Font("Sanserif", Font.BOLD, 10));
        liczbaGlosowNie.setBounds(50, 400, 250, 20);
        add(liczbaGlosowNie);


        bTak = new JButton("Tak");
        bTak.setBounds(50, 100, 100, 20);
        bTak.addActionListener(this);
        add(bTak);

        bNie = new JButton("Nie");
        bNie.setBounds(300, 100, 100, 20);
        bNie.addActionListener(this);
        add(bNie);


        liczbaGlosowTakLabel = new JLabel("Liczba glosow na tak : ");
        liczbaGlosowTakLabel.setBounds(250, 350, 300, 20);
        liczbaGlosowTakLabel.setText(String.valueOf(0));
        add(liczbaGlosowTakLabel);

        liczbaGlosowNieLabel = new JLabel("Liczba glosow na nie : ");
        liczbaGlosowNieLabel.setBounds(250, 400, 300, 20);
        liczbaGlosowNieLabel.setText(String.valueOf(0));
        add(liczbaGlosowNieLabel);

        liczbaGlosowLabel = new JLabel();
        liczbaGlosowLabel.setBounds(250, 300, 300, 20);
        liczbaGlosowLabel.setText(String.valueOf(0));
        add(liczbaGlosowLabel);


        barTak = new JProgressBar();
        barTak.setBounds(50, 200, 100, 20);
        barTak.setBackground(Color.GREEN);
        barTak.setFont(new Font("Sanserif", Font.BOLD, 15));
        barTak.setForeground(Color.green);
        barTak.setStringPainted(true);
        add(barTak);

        barNie = new JProgressBar();
        barNie.setBounds(300, 200, 100, 20);
        barNie.setBackground(Color.RED);
        barNie.setForeground(Color.red);
        barNie.setFont(new Font("Sanserif", Font.BOLD, 15));
        barNie.setStringPainted(true);
        add(barNie);


    }

    public static void main(String[] args) {
        AnkietaGui ankietaGui = new AnkietaGui();
        ankietaGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ankietaGui.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        Object source = e.getSource();


        double ileProcentStawiaNaFrancjeNaPoczatku = 0.00;
        double liczbaProcentRazem = 100.00;
        double ileProcentStawiaNaPolskeNaPoczatku = 0.00;


        if (source == bTak) {
            liczbaGlosowLabel.setText(String.valueOf(liczbaGlosow++));
            liczbaGlosowTakLabel.setText(String.valueOf(iloscGlosowTak++));
            liczbaGlosowNieLabel.setText(String.valueOf(iloscGlosowNie));
            double procent = liczbaProcentRazem / liczbaGlosow;
            barTak.setValue((int) Double.parseDouble(String.valueOf(Math.round(iloscGlosowTak*procent))));
            barNie.setValue((int) Double.parseDouble(String.valueOf(Math.round(iloscGlosowNie*procent))));


        } else if (source == bNie) {
            liczbaGlosowLabel.setText(String.valueOf(liczbaGlosow++));
            liczbaGlosowNieLabel.setText(String.valueOf(iloscGlosowNie++));
            liczbaGlosowTakLabel.setText(String.valueOf(iloscGlosowTak));
            double procent = liczbaProcentRazem / liczbaGlosow;
            barTak.setValue((int) Double.parseDouble(String.valueOf(Math.round(iloscGlosowNie*procent))));
            barNie.setValue((int) Double.parseDouble(String.valueOf(Math.round(iloscGlosowTak*procent))));
        }

    }
}










