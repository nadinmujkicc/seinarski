import java.time.LocalDate;

public class SaksijskiCvet extends Cvet {
    private double precnikSaksije;

    public SaksijskiCvet(String ime, double cijena, int kolicina, LocalDate datum, String boja, double visina,
            VrstaCveca vrsta, double precnik) {
        super(ime, cijena, kolicina, datum, boja, visina, vrsta);
        this.precnikSaksije = precnik;
    }

    @Override
    public String toString() {
        return ToStringHelper.zaSaksijskiCvet(this);
    }

    public double getPrecnikSaksije() {
        return precnikSaksije;
    }

}
