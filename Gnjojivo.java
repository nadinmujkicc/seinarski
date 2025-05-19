import java.time.LocalDate;

public class Gnjojivo extends Proizvod {
    private double tezina;
    private String tipGnojiva;

    public Gnjojivo(String ime, double cijena, int kolicina, LocalDate dan, double tezina, String vrsta) {
        super(ime, cijena, kolicina, datum);
        this.tezina = tezina;
        this.tipGnojiva = vrsta;
    }

    public String toString() {
        return ToStringHelper.zaGnojivo(this);
    }

    public double getTezina() {
        return tezina;
    }

    public String getTipGnojiva() {
        return tipGnojiva;
    }

}
