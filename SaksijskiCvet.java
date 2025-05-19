import java.time.LocalDate;

public class SaksijskiCvet extends Cvet {
    private double prečnikSaksije;

    public SaksijskiCvet(String ime, double cijena, int kolicina, LocalDate datum, String boja, double visina,
            VrstaCveca vrsta, double prečnik) {
        super(ime, cijena, kolicina, datum, boja, visina, vrsta);
        this.prečnikSaksije = prečnik;
    }

    @Override
    public String toString() {
        return ToStringHelper.zaSaksijskiCvet(this);
    }

    public double getPrečnikSaksije() {
        return prečnikSaksije;
    }

}
