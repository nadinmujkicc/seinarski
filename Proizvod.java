import java.time.*;

public abstract class Proizvod {
    protected String ime;
    protected double cijena;
    protected int kolicina;
    protected LocalDate datum;

    public Proizvod(String ime, double cijena, int kolicina, LocalDate datum) {
        this.ime = ime;
        this.cijena = cijena;
        this.kolicina = kolicina;
        this.datum = datum;
    }

    public String getIme() {
        return ime;
    }

    public void prodaj(int kolicina) {
        if (this.kolicina >= kolicina) {
            this.kolicina -= kolicina;
        } else {
            System.out.println("Nema dovoljno proizvoda na stanju.");
        }
    }

    public double getCijena() {
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

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
