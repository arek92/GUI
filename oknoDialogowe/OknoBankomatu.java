package oknoDialogowe;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoBankomatu extends JDialog implements ActionListener {

    JButton bWyplata, bTelefon, bStanKonta, bWyjscie, bWplata, bInformacje;
    JLabel lOperacje;
    JComboBox listaKwotWyplata, listaKwotWplata;
    String kwotaWybrana, kwotaWplacana;
    int kwotaPoOperacji;


    public OknoBankomatu(JFrame owner) {
        super(owner, "Menu Glowne", true); //modalny
        setSize(1600, 1200);
        setLayout(null);

        bWyplata = new JButton("Wyplata");
        bWyplata.setBounds(50, 50, 100, 60);
        bWyplata.addActionListener(this);
        add(bWyplata);

        bTelefon = new JButton("Telefon");
        bTelefon.setBounds(50, 300, 100, 60);
        bTelefon.addActionListener(this);
        add(bTelefon);

        bStanKonta = new JButton("stan konta");
        bStanKonta.setBounds(1100, 50, 100, 60);
        bStanKonta.addActionListener(this);
        add(bStanKonta);

        bWyjscie = new JButton("Wyjscie");
        bWyjscie.setBounds(1100, 600, 100, 60);
        bWyjscie.addActionListener(this);
        add(bWyjscie);

        bWplata = new JButton("Wplatomat");
        bWplata.setBounds(1100, 300, 100, 60);
        bWplata.addActionListener(this);
        add(bWplata);

        bInformacje = new JButton("Informacje");
        bInformacje.setBounds(50, 600, 100, 60);
        bInformacje.addActionListener(this);
        add(bInformacje);

        lOperacje = new JLabel("Wybierz operacje");
        lOperacje.setBounds(500, 50, 200, 40);
        lOperacje.setFont(new Font("Sanserfif", Font.BOLD, 22));
        add(lOperacje);

        listaKwotWyplata = new JComboBox<>();
        listaKwotWyplata.setBounds(50, 150, 100, 20);
        listaKwotWyplata.addItem(50);
        listaKwotWyplata.addItem(100);
        listaKwotWyplata.addItem(150);
        listaKwotWyplata.addItem(200);
        listaKwotWyplata.addItem(500);
        add(listaKwotWyplata);
        listaKwotWyplata.setVisible(false);
        listaKwotWyplata.addActionListener(this);

        listaKwotWplata = new JComboBox<>();
        listaKwotWplata.setBounds(1100, 400, 100, 20);
        listaKwotWplata.addItem(50);
        listaKwotWplata.addItem(100);
        listaKwotWplata.addItem(150);
        listaKwotWplata.addItem(200);
        listaKwotWplata.addItem(500);
        add(listaKwotWplata);
        listaKwotWplata.setVisible(false);
        listaKwotWplata.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Karta karta1 = new Karta(16129540, 2026, 1000);
        int numerKartyLiczba = karta1.getNumerKarty();
        int kodPinLiczba = karta1.getPin();
        int saldoLiczbaNaPoczatku = karta1.getSaldo();
        int saldoPoOperacji = saldoLiczbaNaPoczatku + kwotaPoOperacji;
        Object source = e.getSource();
        if (source == bWyjscie) {
            int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz wyjsc ??", "Pytanie", JOptionPane.YES_NO_OPTION);
            if (odp == JOptionPane.YES_OPTION) {
                dispose();
            } else if (odp == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Wybierz operacje ", "zmiana", JOptionPane.INFORMATION_MESSAGE);

            }

        } else if (source == bInformacje) {
            JOptionPane.showMessageDialog(null, "Wlacicielem Konta jest Pan Arkadiusz Galus", "info ", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany by wykonac kolejna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
            dispose();

        } else if (source == bTelefon) {
            String kwotaDoladowania = JOptionPane.showInputDialog("Jaka kwota chcesz zasilic konto ?");
            String numerTelefonu = JOptionPane.showInputDialog("Podaj Numer telefonu jaki chcesz doladowac ");
            //String numerTelefonuNiepoprawny = String.valueOf(numerTelefonu.length() < 9);
            while ((numerTelefonu.length() != 9)) {
                JOptionPane.showMessageDialog(null, "Niepoprawny numer ! Wpisz poprawny numer telefonu majacy 9 cyfr", "error", JOptionPane.ERROR_MESSAGE);
                numerTelefonu = JOptionPane.showInputDialog("Podaj Numer telefonu jaki chcesz doladowac ");

            }
            if (numerTelefonu.length() == 9) {
                int kwotaDoladowaniaLiczba = Integer.parseInt(kwotaDoladowania);
                JOptionPane.showMessageDialog(null, "doladowales nastepujacy numer telefonu : " + " " + numerTelefonu + " " + "Stan Twojego konta to : " + " " + kwotaDoladowaniaLiczba + " zlotych");
                JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany by wykonac kolejna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }

        } else if (source == bStanKonta) {
            JOptionPane.showMessageDialog(null, "Stan Twojego konta to : " + (saldoLiczbaNaPoczatku + kwotaPoOperacji) + " " + " zlotych", "info", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Kliknij wyjscie by wyjsc badz wybierz inna operacje", "info", JOptionPane.INFORMATION_MESSAGE);


        } else if (source == bWyplata) {
            JOptionPane.showMessageDialog(null, "Wybierz kwote jaka chcesz wyplacic z poniższej listy", "info", JOptionPane.INFORMATION_MESSAGE);
            //add(listaKwotWyplata);
            listaKwotWyplata.setVisible(true);
        }

        if (source == listaKwotWyplata) {
            int kwotaJakaDysponujesz = saldoLiczbaNaPoczatku + kwotaPoOperacji;
            kwotaWybrana = listaKwotWyplata.getSelectedItem().toString();

            if (kwotaJakaDysponujesz < Integer.parseInt(kwotaWybrana)) {
                JOptionPane.showMessageDialog(null, "brak srodkow na koncie aby wyplacic taka kwote - sprawdz stan konta klikajac stan konta", "blad", JOptionPane.ERROR_MESSAGE);
            } else {

                if (kwotaWybrana.equals("50")) {
                    int kwotaWyplac50 = (int) listaKwotWyplata.getItemAt(0);
                    kwotaPoOperacji -= kwotaWyplac50;
                    int coZrobic = JOptionPane.showConfirmDialog(null, "Czy wyswietlic potwierdzenie operacji ? ", "info", JOptionPane.YES_NO_OPTION);
                    if (coZrobic == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Wyplaciles " + kwotaWyplac50 + " " + " zlotych" + " " + " srodki dostepne po operacji to : " + " " + (saldoLiczbaNaPoczatku + kwotaPoOperacji));
                        JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        listaKwotWyplata.setVisible(false);

                    } else if (coZrobic == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        listaKwotWyplata.setVisible(false);


                    }
                } else if (kwotaWybrana.equals("100")) {
                    int kwotaWyplac100 = (int) listaKwotWyplata.getItemAt(1);
                    kwotaPoOperacji -= kwotaWyplac100;
                    int coZrobic = JOptionPane.showConfirmDialog(null, "Czy wyswietlic potwierdzenie operacji ? ", "info", JOptionPane.YES_NO_OPTION);
                    if (coZrobic == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Wyplaciles " + kwotaWyplac100 + " " + " zlotych" + " " + " srodki dostepne po operacji to : " + " " + (saldoLiczbaNaPoczatku + kwotaPoOperacji));
                        JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        listaKwotWyplata.setVisible(false);

                    } else if (coZrobic == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        listaKwotWyplata.setVisible(false);

                        // JOptionPane.showMessageDialog(null, "Wyplaciles " + kwotaWyplac100 + " " + " zlotych " + " stan Twojego konta to " + (saldoLiczbaNaPoczatku + kwotaPoOperacji));

                    }
                } else if (kwotaWybrana.equals("150")) {
                    int kwotaWyplac150 = (int) listaKwotWyplata.getItemAt(2);
                    kwotaPoOperacji -= kwotaWyplac150;
                    int coZrobic = JOptionPane.showConfirmDialog(null, "Czy wyswietlic potwierdzenie operacji ? ", "info", JOptionPane.YES_NO_OPTION);
                    if (coZrobic == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Wyplaciles " + kwotaWyplac150 + " " + " zlotych" + " " + " srodki dostepne po operacji to : " + " " + (saldoLiczbaNaPoczatku + kwotaPoOperacji));
                        JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        listaKwotWyplata.setVisible(false);

                    } else if (coZrobic == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        listaKwotWyplata.setVisible(false);
                    }

                } else if (kwotaWybrana.equals("200")) {
                    int kwotaWyplac200 = (int) listaKwotWyplata.getItemAt(3);
                    kwotaPoOperacji -= kwotaWyplac200;
                    int coZrobic = JOptionPane.showConfirmDialog(null, "Czy wyswietlic potwierdzenie operacji ? ", "info", JOptionPane.YES_NO_OPTION);
                    if (coZrobic == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Wyplaciles " + kwotaWyplac200 + " " + " zlotych" + " " + " srodki dostepne po operacji to : " + " " + (saldoLiczbaNaPoczatku + kwotaPoOperacji));
                        JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        listaKwotWyplata.setVisible(false);

                    } else if (coZrobic == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        listaKwotWyplata.setVisible(false);
                    }
                } else if (kwotaWybrana.equals("500")) {
                    int kwotaWyplac500 = (int) listaKwotWyplata.getItemAt(4);
                    kwotaPoOperacji -= kwotaWyplac500;
                    int coZrobic = JOptionPane.showConfirmDialog(null, "Czy wyswietlic potwierdzenie operacji ? ", "info", JOptionPane.YES_NO_OPTION);
                    if (coZrobic == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Wyplaciles " + kwotaWyplac500 + " " + " zlotych" + " " + " srodki dostepne po operacji to : " + " " + (saldoLiczbaNaPoczatku + kwotaPoOperacji));
                        JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        listaKwotWyplata.setVisible(false);

                    } else if (coZrobic == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        listaKwotWyplata.setVisible(false);

                    }
                }


            }


        } else if (source == bWplata) {
            JOptionPane.showMessageDialog(null, "Wybierz kwote jaka chcesz wplacic z poniższej listy", "info", JOptionPane.INFORMATION_MESSAGE);
            //add(listaKwotWyplata);
            listaKwotWplata.setVisible(true);

        }
        if (source == listaKwotWplata) {
            kwotaWplacana = listaKwotWplata.getSelectedItem().toString();
            if (kwotaWplacana.equals("50")) {
                int kwotaWplac50 = (int) listaKwotWplata.getItemAt(0);
                kwotaPoOperacji += kwotaWplac50;
                //int kwotaJakaDysponujesz = saldoLiczbaNaPoczatku + kwotaPoOperacji;
                int coZrobic = JOptionPane.showConfirmDialog(null, "Czy wyswietlic potwierdzenie operacji ? ", "info", JOptionPane.YES_NO_OPTION);
                if (coZrobic == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Wyplaciles " + kwotaWplac50 + " " + " zlotych" + " " + " srodki dostepne po operacji to : " + " " + (saldoLiczbaNaPoczatku + kwotaPoOperacji));
                    JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    listaKwotWplata.setVisible(false);

                } else if (coZrobic == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    listaKwotWplata.setVisible(false);


                }
            } else if (kwotaWplacana.equals("100")) {
                int kwotaWplac100 = (int) listaKwotWplata.getItemAt(1);
                kwotaPoOperacji += kwotaWplac100;
                int coZrobic = JOptionPane.showConfirmDialog(null, "Czy wyswietlic potwierdzenie operacji ? ", "info", JOptionPane.YES_NO_OPTION);
                if (coZrobic == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Wyplaciles " + kwotaWplac100 + " " + " zlotych" + " " + " srodki dostepne po operacji to : " + " " + (saldoLiczbaNaPoczatku + kwotaPoOperacji));
                    JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    listaKwotWplata.setVisible(false);

                } else if (coZrobic == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    listaKwotWplata.setVisible(false);

                }
            } else if (kwotaWplacana.equals("150")) {
                int kwotaWplac150 = (int) listaKwotWplata.getItemAt(2);
                kwotaPoOperacji += kwotaWplac150;
                int coZrobic = JOptionPane.showConfirmDialog(null, "Czy wyswietlic potwierdzenie operacji ? ", "info", JOptionPane.YES_NO_OPTION);
                if (coZrobic == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Wyplaciles " + kwotaWplac150 + " " + " zlotych" + " " + " srodki dostepne po operacji to : " + " " + (saldoLiczbaNaPoczatku + kwotaPoOperacji));
                    JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    listaKwotWplata.setVisible(false);

                } else if (coZrobic == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    listaKwotWplata.setVisible(false);
                }
            } else if (kwotaWplacana.equals("200")) {
                int kwotaWplac200 = (int) listaKwotWplata.getItemAt(3);
                kwotaPoOperacji += kwotaWplac200;
                int coZrobic = JOptionPane.showConfirmDialog(null, "Czy wyswietlic potwierdzenie operacji ? ", "info", JOptionPane.YES_NO_OPTION);
                if (coZrobic == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Wyplaciles " + kwotaWplac200 + " " + " zlotych" + " " + " srodki dostepne po operacji to : " + " " + (saldoLiczbaNaPoczatku + kwotaPoOperacji));
                    JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    listaKwotWplata.setVisible(false);

                } else if (coZrobic == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    listaKwotWplata.setVisible(false);
                }
            } else if (kwotaWplacana.equals("500")) {
                int kwotaWplac500 = (int) listaKwotWplata.getItemAt(4);
                kwotaPoOperacji += kwotaWplac500;
                int coZrobic = JOptionPane.showConfirmDialog(null, "Czy wyswietlic potwierdzenie operacji ? ", "info", JOptionPane.YES_NO_OPTION);
                if (coZrobic == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Wyplaciles " + kwotaWplac500 + " " + " zlotych" + " " + " srodki dostepne po operacji to : " + " " + (saldoLiczbaNaPoczatku + kwotaPoOperacji));
                    JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    listaKwotWplata.setVisible(false);

                } else if (coZrobic == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Zostaniesz wylogowany - Odbierz pieniadze, by wykonac inna operacje zaloguj sie ponownie", "info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    listaKwotWplata.setVisible(false);
                }
            }
        }
    }
}
   
