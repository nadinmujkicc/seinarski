import java.time.LocalDate;

public class Zelenilo extends Proizvod {
    private String tipListova;

    public Zelenilo(String ime, double cijena, int kolicina, LocalDate dan, String tipListova) {
        super(ime, cijena, kolicina, dan);
        this.tipListova = tipListova;
    }

    public static Zelenilo unesi() {
        String ime = UnosHelper.unesiTekst("Vnesi ime: ");
        double cijena = UnosHelper.unesiDouble("Vnesi cijenu: ");
        int kolicina = UnosHelper.unesiInt("Vnesi kolicinu: ");
        LocalDate datum = LocalDate.now();
        String tip = UnosHelper.unesiTekst("Tip listova: ");
        return new Zelenilo(ime, cijena, kolicina, datum, tip);
    }

    // @Override
    // public String toString() {
    // return ToStringHelper.zaZelenilo(this);
    // }
    @Override
    public String toString() {
        return "ime=" + ime + ", cijena=" + cijena + ", kolicina=" + kolicina + ", datum=" + datum +
                ", tipListova=" + tipListova;
    }

    public String getTipListova() {
        return tipListova;
    }
}