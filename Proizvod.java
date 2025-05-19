import java.time.*;

public abstract class Proizvod {
    protected String ime;
    protected double cijena;
    protected int kolicina;
    protected static LocalTime datum;

    public Proizvod(String ime, double cijena, int kolicina, LocalTime datum) {
        this.ime = ime;
        this.cijena = cijena;
        this.kolicina = kolicina;
        this.datum = datum;
    }

    public String getime() {
        return ime;
    }

    public double getcijena() {
        return cijena;
    }

    public String cijenaToString() {
        return String.format("%.2f", cijena);
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

    public LocalTime getdatum() {
        return datum;
    }

    public String datumToString() {
        return String.format("%02d:%02d", datum.getHour(), datum.getMinute());
    }

}
