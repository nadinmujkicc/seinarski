import java.time.LocalDate;

public class Cestitka extends Proizvod {
    private String poruka;

    public Cestitka(String ime, double cijena, int kolicina, LocalDate dan, String poruka) {
        super(ime, cijena, kolicina, dan);
        this.poruka = poruka;
    }

    public static Cestitka unesi() {
        String ime = UnosHelper.unesiTekst("Vnesi ime: ");
        double cijena = UnosHelper.unesiDouble("Vnesi cijenu: ");
        int kolicina = UnosHelper.unesiInt("Vnesi kolicinu: ");
        LocalDate datum = LocalDate.now();
        String poruka = UnosHelper.unesiTekst("Poruka: ");
        return new Cestitka(ime, cijena, kolicina, datum, poruka);
    }

    // @Override
    // public String toString() {
    // return ToStringHelper.zaCestitku(this);
    // }

    @Override
    public String toString() {
        return "ime=" + ime + ", cijena=" + cijena + ", kolicina=" + kolicina + ", datum=" + datum +
                ", poruka=" + poruka;
    }

    public String getPoruka() {
        return poruka;
    }
}