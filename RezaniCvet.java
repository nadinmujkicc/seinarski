import java.time.LocalDate;

public class RezaniCvet extends Cvet {
    private int duzinaStabljike;

    public RezaniCvet(String ime, double cijena, int kolicina, LocalDate datum, String boja, double visina,
            VrstaCveca vrsta, int duzina) {
        super(ime, cijena, kolicina, datum, boja, visina, vrsta);
        this.duzinaStabljike = duzina;
    }

    // @Override
    // public String toString() {
    // return ToStringHelper.zaRezaniCvet(this);
    // }

    public int getDuzinaStabla() {
        return duzinaStabljike;
    }

    public static RezaniCvet unesi() {
        String ime = UnosHelper.unesiTekst("Vnesi ime: ");
        double cijena = UnosHelper.unesiDouble("Vnesi cenu: ");
        int kolicina = UnosHelper.unesiInt("Vnesi kolicinu: ");
        LocalDate datum = LocalDate.now();
        String boja = UnosHelper.unesiTekst("Boja: ");
        double visina = UnosHelper.unesiDouble("Visina u cm: ");
        int duzina = UnosHelper.unesiInt("Duzina stabla: ");
        VrstaCveca vrsta = VrstaCveca.valueOf(UnosHelper.unesiTekst("Vrsta (RUZA, TULIPAN...): ").toUpperCase());

        return new RezaniCvet(ime, cijena, kolicina, datum, boja, visina, vrsta, duzina);
    }

    @Override
    public String toString() {
        return "ime=" + ime + ", cijena=" + cijena + ", kolicina=" + kolicina + ", datum=" + datum +
                ", boja=" + boja + ", visina=" + visina + ", vrsta=" + vrstaCveca + ", duzina=" + duzinaStabljike;
    }
}
