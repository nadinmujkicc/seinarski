import java.time.LocalDate;

public class Svijeca extends Proizvod {
    private int trajanjeUSatima;

    public Svijeca(String ime, double cijena, int kolicina, LocalDate dan, int trajanje) {
        super(ime, cijena, kolicina, dan);
        this.trajanjeUSatima = trajanje;
    }

    public static Svijeca unesi() {
        String ime = UnosHelper.unesiTekst("Vnesi ime: ");
        double cijena = UnosHelper.unesiDouble("Vnesi cijenu: ");
        int kolicina = UnosHelper.unesiInt("Vnesi kolicinu: ");
        LocalDate datum = LocalDate.now();
        int trajanje = UnosHelper.unesiInt("Trajanje u satima: ");
        return new Svijeca(ime, cijena, kolicina, datum, trajanje);
    }

    // @Override
    // public String toString() {
    // return ToStringHelper.zaSvijecu(this);
    // }
    @Override
    public String toString() {
        return "ime=" + ime + ", cijena=" + cijena + ", kolicina=" + kolicina + ", datum=" + datum +
                ", trajanje=" + trajanjeUSatima;
    }

    public int getTrajanjeUSatima() {
        return trajanjeUSatima;
    }
}