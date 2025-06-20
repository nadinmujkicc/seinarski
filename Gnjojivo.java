import java.time.LocalDate;

public class Gnjojivo extends Proizvod {
    private double tezina;
    private String tipGnojiva;

    public Gnjojivo(String ime, double cijena, int kolicina, LocalDate dan, double tezina, String vrsta) {
        super(ime, cijena, kolicina, dan);
        this.tezina = tezina;
        this.tipGnojiva = vrsta;
    }

    public static Gnjojivo unesi() {
        String ime = UnosHelper.unesiTekst("Vnesi ime: ");
        double cijena = UnosHelper.unesiDouble("Vnesi cijenu: ");
        int kolicina = UnosHelper.unesiInt("Vnesi kolicinu: ");
        LocalDate datum = LocalDate.now();
        double tezina = UnosHelper.unesiDouble("Tezina u kg: ");
        String vrsta = UnosHelper.unesiTekst("Vrsta gnojiva: ");
        return new Gnjojivo(ime, cijena, kolicina, datum, tezina, vrsta);
    }

    // public String toString() {
    // return ToStringHelper.zaGnojivo(this);
    // }
    @Override
    public String toString() {
        return "ime=" + ime + ", cijena=" + cijena + ", kolicina=" + kolicina + ", datum=" + datum +
                ", tezina=" + tezina + ", vrsta=" + tipGnojiva;
    }

    public double getTezina() {
        return tezina;
    }

    public String getTipGnojiva() {
        return tipGnojiva;
    }

}
