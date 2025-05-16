import java.time.*;

public abstract class Proizvod {
    protected static String naziv;
    protected static double cena;
    protected int kolicina;
    protected static LocalTime datumPrijema;

    public Proizvod(String naziv, double cena, int kolicina, LocalTime datumPrijema) {
        Proizvod.naziv = naziv;
        Proizvod.cena = cena;
        this.kolicina = kolicina;
        Proizvod.datumPrijema = datumPrijema;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCena() {
        return cena;
    }

    public String cenaToString() {
        return String.format("%.2f", cena);
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String kolicinaToString() {
        return String.format("%d", kolicina);
    }

    public LocalTime getDatumPrijema() {
        return datumPrijema;
    }

    public String datumPrijemaToString() {
        return String.format("%02d:%02d", datumPrijema.getHour(), datumPrijema.getMinute());
    }

}
