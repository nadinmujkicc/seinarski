import java.time.LocalDate;

public class RezaniCvet extends Cvet {
    private int duzinaStabljike;

    public RezaniCvet(String ime, double cijena, int kolicina, LocalDate datum, String boja, double visina,
            VrstaCveca vrsta, int duzina) {
        super(ime, cijena, kolicina, datum, boja, visina, vrsta);
        this.duzinaStabljike = duzina;
    }

    @Override
    public String toString() {
        return ToStringHelper.zaRezaniCvet(this);
    }

    public int getDuzinaStabla() {
        return duzinaStabljike;
    }
}
