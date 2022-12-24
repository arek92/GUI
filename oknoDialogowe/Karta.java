package oknoDialogowe;

public class Karta {
    private int numerKarty;
    private int pin;
    private int saldo;

    public Karta(int numerKarty, int pin,int saldo) {
        this.numerKarty = numerKarty;
        this.pin = pin;
        this.saldo = saldo;
    }

    public int getNumerKarty() {
        return numerKarty;
    }


    public int getPin() {
        return pin;
    }


    public int getSaldo() {
        return saldo;
    }
}
