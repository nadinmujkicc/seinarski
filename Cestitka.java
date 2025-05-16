import java.time.LocalDate;

public class Cestitka extends Proizvod {
    private String poruka;

    public Cestitka(String ime, double cijena, int kolicina, LocalDate datum, String poruka) {
        super(naziv, cena, kolicina, datumPrijema);
        this.poruka = poruka;
    }

    @Override
    public String toString() {
        return "Cestitka{" + naziv + ", poruka='" + poruka + "'}";
    }
}