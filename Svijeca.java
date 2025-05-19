import java.time.LocalDate;

public class Svijeca extends Proizvod {
    private int trajanjeUSatima;

    public Svijeca(String ime, double cijena, int kolicina, LocalDate dan, int trajanje) {
        super(ime, cijena, kolicina, datum);
        this.trajanjeUSatima = trajanje;
    }

    @Override
    public String toString() {
        return ToStringHelper.zaSvijecu(this);
    }

    public int getTrajanjeUSatima() {
        return trajanjeUSatima;
    }
}