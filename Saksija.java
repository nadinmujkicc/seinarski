import java.time.LocalDate;

public class Saksija extends Proizvod {
    private String materijal;
    private double volumenLitara;

    public Saksija(String ime, double cijena, int kolicina, LocalDate datum, String materijal, double volumen) {
        super(naziv, cena, kolicina, datumPrijema);
        this.materijal = materijal;
        this.volumenLitara = volumen;
    }

    @Override
    public String toString() {
        return "Saksija{" + naziv + ", materijal=" + materijal + ", volumen=" + volumenLitara + "L}";
 
   }
}