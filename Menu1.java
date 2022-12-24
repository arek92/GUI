package Menu1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu1 extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JPopupMenu popupMenu;
    JButton szukaj;
    JMenu menuPLik, menuNarzedzia, menuOpcje, menuPomoc, menuCzcionka;
    JMenuItem mOtworz, mZapisz, mWyjscie, mNarz1, mNarz2, mOpcja1, mOprogramie, mKopiuj, mWklej, mDolacz;
    JCheckBoxMenuItem chOpcja2, chZwiekszCzcionke;
    JTextArea notatnik;
    JTextField tSzukamy;
    String zaznaczonyTekst;
    // Scanner scanner = new Scanner(notatnik.getText());

    public Menu1() {
        setSize(700, 700);
        setTitle("Program");
        setLayout(null);

        menuBar = new JMenuBar();
        menuPLik = new JMenu("Plik");
        mOtworz = new JMenuItem("Otworz", 'O');

        mOtworz.addActionListener(this);
        mZapisz = new JMenuItem("Zapisz");
        mZapisz.addActionListener(this);

        mWyjscie = new JMenuItem("Wyjscie");
        mWyjscie.addActionListener(this);
        mWyjscie.setAccelerator(KeyStroke.getKeyStroke("alt F4"));

        menuPLik.add(mOtworz);
        menuPLik.add(mZapisz);
        menuPLik.addSeparator();
        menuPLik.add(mWyjscie);

        menuNarzedzia = new JMenu("Narzedzia");
        mNarz1 = new JMenuItem("Narz1");
        mNarz1.addActionListener(this);
        //mNarz1.setEnabled(false);

        menuCzcionka = new JMenu("Czcionka");
        menuCzcionka.addActionListener(this);

        mNarz2 = new JMenuItem("Narz2");
        mNarz2.addActionListener(this);
        menuNarzedzia.add(mNarz1);
        menuNarzedzia.add(mNarz2);

        mOprogramie = new JMenuItem("o Programie");
        mOprogramie.addActionListener(this);
        menuPomoc = new JMenu("Pomoc");
        menuPomoc.add(mOprogramie);

        chZwiekszCzcionke = new JCheckBoxMenuItem("Zwieksz czcionke");
        menuCzcionka.add(chZwiekszCzcionke);
        chZwiekszCzcionke.addActionListener(this);

        //Key accelerator skrot klawiszowy

        setJMenuBar(menuBar);//metoda sprawi ze zobaczymy pasek na ramce
        menuBar.add(menuPLik);
        menuBar.add(menuNarzedzia);
        menuBar.add(menuPomoc);
        menuBar.add(menuCzcionka);

        menuOpcje = new JMenu("Opcje");
        mOpcja1 = new JMenuItem("opcja1");
        chOpcja2 = new JCheckBoxMenuItem("opcja2");

        menuOpcje.add(mOpcja1);
        menuOpcje.add(chOpcja2);
        chOpcja2.addActionListener(this);
        menuNarzedzia.add(menuOpcje);

        notatnik = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(notatnik);
        scrollPane.setBounds(0, 0, 400, 400);
        add(scrollPane);

        tSzukamy = new JTextField();
        tSzukamy.setBounds(50, 500, 100, 20);
        add(tSzukamy);

        szukaj = new JButton("Szukaj");
        szukaj.setBounds(200, 500, 100, 20);
        szukaj.addActionListener(this);
        add(szukaj);

        popupMenu = new JPopupMenu();
        mKopiuj = new JMenuItem("Kopiuj");
        mKopiuj.addActionListener(this);
        mWklej = new JMenuItem("Wklej");
        mWklej.addActionListener(this);
        mDolacz = new JMenuItem("Dolacz");
        mDolacz.addActionListener(this);

        popupMenu.add(mKopiuj);
        popupMenu.add(mWklej);
        popupMenu.add(mDolacz);

        notatnik.setComponentPopupMenu(popupMenu);


    }

    public static void main(String[] args) {
        Menu1 menu1 = new Menu1();
        menu1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu1.getContentPane().setBackground(Color.BLUE);
        menu1.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == mOtworz) {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = fc.getSelectedFile();
                try {
                    Scanner scanner = new Scanner(plik);
                    while (scanner.hasNext()) {
                        notatnik.append(scanner.nextLine() + "\n");
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (source == mZapisz) {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File plik = fc.getSelectedFile();
                try {
                    PrintWriter pr = new PrintWriter(plik);
                    Scanner scanner = new Scanner(notatnik.getText());
                    while (scanner.hasNext()) {
                        pr.println(scanner.nextLine() + " \n");
                        pr.close();
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (source == mWyjscie) {
            int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz wyjsc ??", "Pytanie", JOptionPane.YES_NO_OPTION);
            if (odp == JOptionPane.YES_OPTION) {
                dispose();
            } else if (odp == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Jednak nie chciales wyjsc", "wiedzialem", JOptionPane.INFORMATION_MESSAGE);
            } else if (odp == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Tak nie robimy !!", "blad", JOptionPane.WARNING_MESSAGE);
            }
        } else if (source == chOpcja2) {
            if (chOpcja2.isSelected()) {
                mNarz1.setEnabled(true);
            } else if (!chOpcja2.isSelected()) {
                mNarz1.setEnabled(false);
            }
        } else if (source == mNarz2) {
            String sMetry = JOptionPane.showInputDialog("Podaj dlugosc w metrach");//show input zwraca String
            double metry = Double.parseDouble(sMetry);
            double stopy = metry / 0.0348;
            String sStopy = String.format("%2f", stopy);
            JOptionPane.showMessageDialog(null, "ilosc " + " " + metry + " " + " = " + " to " + sStopy + " " + "stop");

        } else if (source == mNarz1) {
            String imiePodane = JOptionPane.showInputDialog("Podaj imie");
            int liczbaLiter = imiePodane.length();
            JOptionPane.showMessageDialog(null, "liczba liter w imieniu " + imiePodane + " to : " + " " + liczbaLiter);

        } else if (source == mOprogramie) {
            JOptionPane.showMessageDialog(this, "Program ukazuje wykorzystanie JMenuBAr i JMenu \n werjsa 1.0", "tytul", JOptionPane.WARNING_MESSAGE);

        } else if (source == szukaj) {
            String tekst = notatnik.getText();
            String szukane = tSzukamy.getText();
            String wystapienia = "";
            int i = 0;
            int index;
            int startIndex = 0;
            while ((index = tekst.indexOf(szukane, startIndex)) != -1) { // jak nie znajdzie juz tekstu to bedzie minus jeden
                startIndex = index + szukane.length();
                i++;
                wystapienia = wystapienia + " " + index; //wystapienia bedzie to lista tekstowa
            }
            JOptionPane.showMessageDialog(null, szukane + " wystapilo " + i + " " + "razy : " + wystapienia);
        }
        if (source == mKopiuj)
            zaznaczonyTekst = notatnik.getSelectedText();
        else if (source == mWklej)
            notatnik.insert(zaznaczonyTekst, notatnik.getCaretPosition());
        else if (source == mDolacz)
            notatnik.append("\n" + zaznaczonyTekst);

        if (source == chZwiekszCzcionke) {
            Scanner scanner = new Scanner(notatnik.getText());
            if (chZwiekszCzcionke.isSelected()) {
                notatnik.setFont(new Font("Sanserif", Font.BOLD, 20));
            }
                if (!chZwiekszCzcionke.isSelected()) {
                    notatnik.setFont(null);
                    // }
                }
            }
        }
    }








