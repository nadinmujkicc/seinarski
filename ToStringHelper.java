public class ToStringHelper {
    public static String zaProizvod(Proizvod p) {
        return "ime=" + p.getime() +
                ", cijena=" + p.getcijena() +
                ", kolicina=" + p.getKolicina() +
                ", datum=" + p.getdatum();
    }

    public static String zaRezaniCvet(RezaniCvet c) {
        return zaProizvod(c) +
                ", boja=" + c.getBoja() +
                ", visina=" + c.getVisina() +
                ", vrsta=" + c.getVrstaCveca() +
                ", duzina=" + c.getDuzinaStabla();
    }

    public static String zaSaksijskiCvet(SaksijskiCvet c) {
        return zaProizvod(c) +
                ", boja=" + c.getBoja() +
                ", visina=" + c.getVisina() +
                ", vrsta=" + c.getVrstaCveca() +
                ", precnik=" + c.getPrečnikSaksije();
    }

    public static String zaZelenilo(Zelenilo z) {
        return zaProizvod(z) + ", tipListova=" + z.getTipListova();
    }

    public static String zaGnojivo(Gnjojivo g) {
        return zaProizvod(g) + ", tezina=" + g.getTezina() + ", vrsta=" + g.getTipGnojiva();
    }

    public static String zaSvijecu(Svijeca s) {
        return zaProizvod(s) + ", trajanje=" + s.getTrajanjeUSatima();
    }

    public static String zaCestitku(Cestitka c) {
        return zaProizvod(c) + ", poruka=" + c.getPoruka();
    }

    public static String zaSaksiju(Saksija p) {
        return zaProizvod(p) + ", materijal=" + p.getMaterijal() + ", volumen=" + p.getVolumenLitara();
    }
}
