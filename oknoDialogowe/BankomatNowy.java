package oknoDialogowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankomatNowy extends JFrame implements ActionListener {


    OknoBankomatu oknoBankomatu = new OknoBankomatu(this);
    JLabel numerKarty, kodPin,nazwa;
    JTextField tNumerKarty;
    JPasswordField pin;
    JButton bZaloguj;




    public BankomatNowy() {
        setSize(400, 400);
        setTitle("Bankomat");
        setLayout(null);



        numerKarty = new JLabel("Numer Karty");
        numerKarty.setBounds(50, 200, 150, 20);
        add(numerKarty);

        kodPin = new JLabel("Kod pin");
        kodPin.setBounds(50, 250, 150, 20);
        add(kodPin);

        tNumerKarty = new JTextField();
        tNumerKarty.setBounds(150, 200, 100, 20);
        add(tNumerKarty);

        pin = new JPasswordField();
        pin.setBounds(150, 250, 100, 20);
        add(pin);

        bZaloguj = new JButton("Zaloguj");
        bZaloguj.setBounds(150, 300, 100, 20);
        bZaloguj.addActionListener(this);
        add(bZaloguj);

        nazwa = new JLabel();
        nazwa.setText("Bankomat");
        nazwa.setBounds(100,50,150,40);
        nazwa.setFont(new Font("Sanserfif",Font.BOLD,26));
        nazwa.setForeground(Color.BLUE);
        add(nazwa);







    }

    public static void main(String[] args) {
        BankomatNowy bankomatNowy = new BankomatNowy();
        bankomatNowy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bankomatNowy.setVisible(true);








    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Karta karta1 = new Karta(16129540, 2026, 2000);
        int numerKartyLiczba = karta1.getNumerKarty();
        int kodPinLiczba = karta1.getPin();
        int saldoLiczba = karta1.getSaldo();


        Object source = e.getSource();

        String numerKartyWpisany = tNumerKarty.getText(); // wpisany numer jest stringiem
        String pinWpisany = String.valueOf(pin.getPassword());

        if (source == bZaloguj) {
            if (numerKartyWpisany.equals(String.valueOf(numerKartyLiczba)) && pinWpisany.equals(String.valueOf(kodPinLiczba))) {
                oknoBankomatu.setVisible(true);
               tNumerKarty.setText(null);
               pin.setText(null);
            } else if (!numerKartyWpisany.equals(String.valueOf(numerKartyLiczba)) || !pinWpisany.equals(String.valueOf(kodPinLiczba))) {
                JOptionPane.showMessageDialog(null, "nieprawidlowy numer pin badz numer karty wpisz ponownie", "blad", JOptionPane.ERROR_MESSAGE);
                tNumerKarty.setText(null);
                pin.setText(null);


            }

        }

    }
}
