import java.time.LocalDate;

public class Cestitka extends Proizvod {
    private String poruka;

    public Cestitka(String ime, double cijena, int kolicina, LocalDate dan, String poruka) {
        super(ime, cijena, kolicina, dan);
        this.poruka = poruka;
    }

    @Override
    public String toString() {
        return ToStringHelper.zaCestitku(this);
    }

    public String getPoruka() {
        return poruka;
    }
}