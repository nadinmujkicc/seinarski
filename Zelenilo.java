import java.time.LocalTime;

public class Zelenilo extends Proizvod {
    private String tipListova;

    public Zelenilo(String naziv, double cijena, int kolicina, LocalTime datumPrijema, String tipListova) {
        super(naziv, cijena, kolicina, datumPrijema);
        this.tipListova = tipListova;
    }

    public String toString() {
        return "Zelenilo{" + naziv + ", tipListova=" + tipListova + "}";
    }

}
