
import java.util.Comparator;
import java.util.List;

public class Cvjecara {
    private static Inventar inventar = new Inventar();

    public static void main(String[] args) {
        boolean radi = true;
        while (radi) {
            System.out.println();
            System.out.println("1. Dodaj proizvod");
            System.out.println("2. Prodaj proizvod");
            System.out.println("3. Prikazi vse proizvode");
            System.out.println("4. Sortiraj proizvode");
            System.out.println("5. Poiskaj po imenu");
            System.out.println("6. Filtriranje po ceni");
            System.out.println("7. Poiskaj po kolicini");
            System.out.println("8. Shrani u datoteku");
            System.out.println("9. Uvezi iz datoteke");
            System.out.println("0. Izhod");
            int izbor = UnosHelper.unesiInt("Izbor: ");
            System.out.println();

            switch (izbor) {
                case 1 -> dodajProizvod();
                case 2 -> prodajProizvod();
                case 3 -> inventar.ispisiSve();
                case 4 -> sort();
                case 5 -> pretrazi();
                case 6 -> filtrirajPoCeni();
                case 7 -> filtrirajPoKolicini();
                case 8 -> inventar.sacuvajUDatoteku(UnosHelper.unesiTekst("Ime datoteke: "));
                case 9 -> inventar.ucitajIzDatoteke(UnosHelper.unesiTekst("Ime datoteke: "));
                case 0 -> radi = false;
                default -> System.out.println("Nepoznata opcija.");
            }
        }
    }

    private static void dodajProizvod() {
        System.out.println("Odaberi tip proizvoda:");
        System.out.println(
                "1. Rezani cvijet\n2. Saksijski cvijet\n3. Zelenilo\n4. Gnojivo\n5. Svijeca\n6. cestitka\n7. Posuda");

        int tip = UnosHelper.unesiInt("Izbor: ");

        switch (tip) {
            case 1 -> inventar.dodajProizvod(RezaniCvet.unesi());
            case 2 -> inventar.dodajProizvod(SaksijskiCvet.unesi());
            case 3 -> inventar.dodajProizvod(Zelenilo.unesi());
            case 4 -> inventar.dodajProizvod(Gnjojivo.unesi());
            case 5 -> inventar.dodajProizvod(Svijeca.unesi());
            case 6 -> inventar.dodajProizvod(Cestitka.unesi());
            case 7 -> inventar.dodajProizvod(Saksija.unesi());
            default -> System.out.println("Nepoznat tip.");
        }
    }

    private static void prodajProizvod() {
        String ime = UnosHelper.unesiTekst("Vnesi ime proizvoda: ");
        int kolicina = UnosHelper.unesiInt("Kolicina za prodaju: ");

        boolean uspjeh = inventar.prodajProizvod(ime, kolicina);
        if (uspjeh) {
            System.out.println("Prodaja uspjesna.");
        } else {
            System.out.println("Neuspjesna prodaja: nema dovoljno zaliha ili proizvod ne postoji.");
        }
    }

    private static void pretrazi() {
        List<Proizvod> rezultat = inventar.pretraziPoImenu(UnosHelper.unesiTekst("Vnesi ime za pretragu: "));
        for (Proizvod p : rezultat) {
            System.out.println(p);

        }
    }

    private static void filtrirajPoCeni() {
        double min = UnosHelper.unesiDouble("Vnesi minimalnu cijenu: ");
        double max = UnosHelper.unesiDouble("Vnesi maksimalnu cijenu: ");
        List<Proizvod> rezultat = inventar.filtrirajPoCijeni(min, max);
        for (Proizvod p : rezultat) {
            System.out.println(p);

        }
    }

    private static void filtrirajPoKolicini() {
        double min = UnosHelper.unesiInt("Vnesi minimalnu kolicinu: ");
        double max = UnosHelper.unesiInt("Vnesi maksimalnu kolicinu: ");
        List<Proizvod> rezultat = inventar.filtrirajPoKolicini(min, max);
        for (Proizvod p : rezultat) {
            System.out.println(p);

        }
    }

    private static void sort() {

        System.out.println("Odaberi kriteriji za sortiranje:");
        System.out.println(
                "1. Cena\n2. Ime\n3. Kolicina");
        int tip = UnosHelper.unesiInt("Izbor: ");
        Comparator<Proizvod> comparator;
        switch (tip) {
            case 1 -> comparator = Comparator.comparing(Proizvod::getCijena);
            case 2 -> comparator = Comparator.comparing(Proizvod::getIme, String.CASE_INSENSITIVE_ORDER);
            case 3 -> comparator = Comparator.comparing(Proizvod::getKolicina);
            default -> {
                System.out.println("Nepoznat kriterij.");
                return;
            }
        }
        inventar.sortiraj(comparator);
        inventar.ispisiSve();

    }
}