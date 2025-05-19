import java.time.LocalDate;

public class Zelenilo extends Proizvod {
    private String tipListova;

    public Zelenilo(String ime, double cijena, int kolicina, LocalDate dan, String tipListova) {
        super(ime, cijena, kolicina, datum);
        this.tipListova = tipListova;
    }

    @Override
    public String toString() {
        return ToStringHelper.zaZelenilo(this);
    }

    public String getTipListova() {
        return tipListova;
    }
}