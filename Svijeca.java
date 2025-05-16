import java.time.LocalDate;

public class Svijeca extends Proizvod {
    private int trajanjeUSatima;

    public Svijeca(String ime, double cijena, int kolicina, LocalDate datum, int trajanje) {
        super(naziv, cena, kolicina, datumPrijema);
        this.trajanjeUSatima = trajanje;
    }

    @Override
    public String toString() {
        return "Svijeca{" + naziv + ", trajanje=" + trajanjeUSatima + "h}";
    }
}