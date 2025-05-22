import java.time.LocalDate;

public class Saksija extends Proizvod {
    private String materijal;
    private double volumenLitara;

    public Saksija(String ime, double cijena, int kolicina, LocalDate dan, String materijal, double volumen) {
        super(ime, cijena, kolicina, dan);
        this.materijal = materijal;
        this.volumenLitara = volumen;
    }

    public static Saksija unesi() {
        String ime = UnosHelper.unesiTekst("Unesi ime: ");
        double cijena = UnosHelper.unesiDouble("Unesi cijenu: ");
        int kolicina = UnosHelper.unesiInt("Unesi količinu: ");
        LocalDate datum = LocalDate.now();
        String materijal = UnosHelper.unesiTekst("Materijal: ");
        double volumen = UnosHelper.unesiDouble("Volumen u litrima: ");
        return new Saksija(ime, cijena, kolicina, datum, materijal, volumen);
    }

    // @Override
    // public String toString() {
    // return ToStringHelper.zaSaksiju(this);

    // }

    @Override
    public String toString() {
        return "ime=" + ime + ", cijena=" + cijena + ", kolicina=" + kolicina + ", datum=" + datum +
                ", materijal=" + materijal + ", volumen=" + volumenLitara;
    }

    public String getMaterijal() {
        return materijal;
    }

    public double getVolumenLitara() {
        return volumenLitara;
    }
}