import java.time.LocalDate;

public class SaksijskiCvet extends Cvet {
    private double precnikSaksije;

    public SaksijskiCvet(String ime, double cijena, int kolicina, LocalDate datum, String boja, double visina,
            VrstaCveca vrsta, double precnik) {
        super(ime, cijena, kolicina, datum, boja, visina, vrsta);
        this.precnikSaksije = precnik;
    }

    public static SaksijskiCvet unesi() {
        String ime = UnosHelper.unesiTekst("Vnesi ime: ");
        double cijena = UnosHelper.unesiDouble("Vnesi cijenu: ");
        int kolicina = UnosHelper.unesiInt("Vnesi kolicinu: ");
        LocalDate datum = LocalDate.now();
        String boja = UnosHelper.unesiTekst("Boja: ");
        double visina = UnosHelper.unesiDouble("Visina u cm: ");
        double precnik = UnosHelper.unesiDouble("Precnik saksije: ");
        VrstaCveca vrsta = VrstaCveca.valueOf(UnosHelper.unesiTekst("Vrsta (RUZA, TULIPAN...): ").toUpperCase());
        return new SaksijskiCvet(ime, cijena, kolicina, datum, boja, visina, vrsta, precnik);
    }

    // @Override
    // public String toString() {
    // return ToStringHelper.zaSaksijskiCvet(this);
    // }
    @Override
    public String toString() {
        return "ime=" + ime + ", cijena=" + cijena + ", kolicina=" + kolicina + ", datum=" + datum +
                ", boja=" + boja + ", visina=" + visina + ", vrsta=" + vrstaCveca + ", precnik=" + precnikSaksije;
    }

    public double getPrecnikSaksije() {
        return precnikSaksije;
    }

}
