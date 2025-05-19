import java.time.LocalDate;

import java.util.List;

public class Cvjecara {
    private static Inventar inventar = new Inventar();

    public static void main(String[] args) {
        boolean radi = true;
        while (radi) {

            System.out.println("1. Dodaj proizvod");
            System.out.println("2. Prodaj proizvod");
            System.out.println("3. Prikazi sve proizvode");
            System.out.println("4. Pretraga po imenu");
            System.out.println("5. Filtriranje po cijeni");
            System.out.println("6. Sacuvaj u datoteku");
            System.out.println("7. Ucitaj iz datoteke");
            System.out.println("0. Izlaz");
            int izbor = UnosHelper.unesiInt("Izbor: ");

            switch (izbor) {
                case 1 -> dodajProizvod();
                case 2 -> prodajProizvod();
                case 3 -> inventar.ispisiSve();
                case 4 -> pretrazi();
                case 5 -> filtriraj();
                case 6 -> inventar.sacuvajUDatoteku(UnosHelper.unesiTekst("Ime datoteke: "));
                case 7 -> inventar.ucitajIzDatoteke(UnosHelper.unesiTekst("Ime datoteke: "));
                case 0 -> radi = false;
                default -> System.out.println("Nepoznata opcija.");
            }
        }
    }

    private static void dodajProizvod() {
        String ime = UnosHelper.unesiTekst("Unesi ime: ");
        double cijena = UnosHelper.unesiDouble("Unesi cijenu: ");
        int kolicina = UnosHelper.unesiInt("Unesi kolicinu: ");
        LocalDate datum = LocalDate.now();

        System.out.println("Odaberi tip proizvoda:");
        System.out.println(
                "1. Rezani cvijet\n2. Saksijski cvijet\n3. Zelenilo\n4. Gnojivo\n5. Svijeca\n6. cestitka\n7. Posuda");
        int tip = UnosHelper.unesiInt("Izbor: ");

        switch (tip) {
            case 1 -> {
                String boja = UnosHelper.unesiTekst("Boja: ");
                double visina = UnosHelper.unesiDouble("Visina u cm: ");
                int duzina = UnosHelper.unesiInt("Duzina stabla: ");
                VrstaCveca vrsta = VrstaCveca
                        .valueOf(UnosHelper.unesiTekst("Vrsta (RUZA, TULIPAN, ORHIDEJA...): ").toUpperCase());
                inventar.dodajProizvod(new RezaniCvet(ime, cijena, kolicina, datum, boja, visina, vrsta, duzina));
            }
            case 2 -> {
                String boja = UnosHelper.unesiTekst("Boja: ");
                double visina = UnosHelper.unesiDouble("Visina u cm: ");
                double precnik = UnosHelper.unesiDouble("Precnik saksije: ");
                VrstaCveca vrsta = VrstaCveca
                        .valueOf(UnosHelper.unesiTekst("Vrsta (RUZA, TULIPAN, ORHIDEJA...): ").toUpperCase());
                inventar.dodajProizvod(new SaksijskiCvet(ime, cijena, kolicina, datum, boja, visina, vrsta, precnik));
            }
            case 3 -> {
                String tipListova = UnosHelper.unesiTekst("Tip listova: ");
                inventar.dodajProizvod(new Zelenilo(ime, cijena, kolicina, datum, tipListova));
            }
            case 4 -> {
                double tezina = UnosHelper.unesiDouble("Tezina u kg: ");
                String vrsta = UnosHelper.unesiTekst("Vrsta gnojiva: ");
                inventar.dodajProizvod(new Gnjojivo(ime, cijena, kolicina, datum, tezina, vrsta));
            }
            case 5 -> {
                int trajanje = UnosHelper.unesiInt("Trajanje u satima: ");
                inventar.dodajProizvod(new Svijeca(ime, cijena, kolicina, datum, trajanje));
            }
            case 6 -> {
                String poruka = UnosHelper.unesiTekst("Poruka: ");
                inventar.dodajProizvod(new Cestitka(ime, cijena, kolicina, datum, poruka));
            }
            case 7 -> {
                String materijal = UnosHelper.unesiTekst("Materijal: ");
                double volumen = UnosHelper.unesiDouble("Volumen u litrima: ");
                inventar.dodajProizvod(new Saksija(ime, cijena, kolicina, datum, materijal, volumen));
            }
            default -> System.out.println("Nepoznat tip.");
        }
    }

    private static void prodajProizvod() {
        String ime = UnosHelper.unesiTekst("Unesi ime proizvoda: ");
        int kolicina = UnosHelper.unesiInt("Kolicina za prodaju: ");
        boolean uspjeh = inventar.prodajProizvod(ime, kolicina);
        if (uspjeh)
            System.out.println("Prodaja uspjesna.");
        else
            System.out.println("Nema dovoljno zaliha ili proizvod ne postoji.");
    }

    private static void pretrazi() {
        List<Proizvod> rezultat = inventar.pretraziPoImenu(UnosHelper.unesiTekst("Unesi ime za pretragu: "));
        for (Proizvod p : rezultat)
            System.out.println(p);
    }

    private static void filtriraj() {
        double min = UnosHelper.unesiDouble("Unesi minimalnu cijenu: ");
        double max = UnosHelper.unesiDouble("Unesi maksimalnu cijenu: ");
        List<Proizvod> rezultat = inventar.filtrirajPoCijeni(min, max);
        for (Proizvod p : rezultat)
            System.out.println(p);
    }
}