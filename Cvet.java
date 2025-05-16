import java.time.LocalDate;

public abstract class Cvet extends Proizvod {
    protected String boja;
    protected double visina;
    protected  VrstaCveca vrstaCveca;

    public Cvet(String ime, double cijena, int kolicina, LocalDate datum, String boja, double visina,
            VrstaCveca vrsta) {
        super(naziv, cena, kolicina, datumPrijema);

        this.boja = boja;
        this.visina = visina;
        this.vrstaCveca = vrsta;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public double getVisina() {
        return visina;
    }

    public void setVisina(double visina) {
        this.visina = visina;
    }

    public VrstaCveca getVrstaCveca() {
        return vrstaCveca;
    }

    public void setVrstaCveca(VrstaCveca vrstaCveca) {
        this.vrstaCveca = vrstaCveca;
    }

}
