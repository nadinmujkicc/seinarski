import java.time.LocalDate;

public class Saksija extends Proizvod {
    private String materijal;
    private double volumenLitara;

    public Saksija(String ime, double cijena, int kolicina, LocalDate dan, String materijal, double volumen) {
        super(ime, cijena, kolicina, dan);
        this.materijal = materijal;
        this.volumenLitara = volumen;
    }

    @Override
    public String toString() {
        return ToStringHelper.zaSaksiju(this);

    }

    public String getMaterijal() {
        return materijal;
    }

    public double getVolumenLitara() {
        return volumenLitara;
    }
}