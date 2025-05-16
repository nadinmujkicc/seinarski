import java.time.LocalDate;

public class Gnjojivo extends Proizvod {
    private double tezina;
    private String tipGnojiva;

    public Gnjojivo(String ime, double cijena, int kolicina, LocalDate datum, double tezina, String vrsta) {
        super(naziv, cena, kolicina, datumPrijema);
        this.tezina = tezina;
        this.tipGnojiva = vrsta;
    }

    public String toString() {
        return "Gnojivo{" + naziv + ", vrsta=" + tipGnojiva + ", tezina=" + tezina + "kg}";
    }

}
