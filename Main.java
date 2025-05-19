import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static Inventar inventar = new Inventar();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean radi = true;
        while (radi) {
            System.out.println("\n--- MENI ---");
            System.out.println("1. Dodaj proizvod");
            System.out.println("2. Prodaj proizvod");
            System.out.println("3. Prikazi sve proizvode");
            System.out.println("4. Pretraga po imenu");
            System.out.println("5. Filtriranje po cijeni");
            System.out.println("6. Sacuvaj u datoteku");
            System.out.println("7. Ucitaj iz datoteke");
            System.out.println("0. Izlaz");
            System.out.print("Izbor: ");

            int izbor = Integer.parseInt(scanner.nextLine());
            switch (izbor) {
                case 1 -> dodajProizvod();
                case 2 -> prodajProizvod();
                case 3 -> inventar.ispisiSve();
                case 4 -> pretrazi();
                case 5 -> filtriraj();
                case 6 -> {
                    System.out.print("ime datoteke: ");
                    inventar.sacuvajUDatoteku(scanner.nextLine());
                }
                case 7 -> {
                    System.out.print("ime datoteke: ");
                    inventar.ucitajIzDatoteke(scanner.nextLine());
                }
                case 0 -> radi = false;
                default -> System.out.println("Nepoznata opcija.");
            }
        }
    }

    private static void dodajProizvod() {
        System.out.print("Unesi ime: ");
        String ime = scanner.nextLine();
        System.out.print("Unesi cijenu: ");
        double cijena = Double.parseDouble(scanner.nextLine());
        System.out.print("Unesi kolicinu: ");
        int kolicina = Integer.parseInt(scanner.nextLine());
        LocalDate datum = LocalDate.now();

        System.out.println("Odaberi tip proizvoda:");
        System.out.println(
                "1. Rezani cvijet\n2. Saksijski cvijet\n3. Zelenilo\n4. Gnojivo\n5. Svijeca\n6. cestitka\n7. Posuda");
        int tip = Integer.parseInt(scanner.nextLine());

        switch (tip) {
            case 1 -> {
                System.out.print("Boja: ");
                String boja = scanner.nextLine();
                System.out.print("Visina u cm: ");
                double visina = Double.parseDouble(scanner.nextLine());
                System.out.print("Duzina stabla: ");
                int duzina = Integer.parseInt(scanner.nextLine());
                System.out.print("Vrsta (RUZA, TULIPAN, ORHIDEJA...): ");
                VrstaCveca vrsta = VrstaCveca.valueOf(scanner.nextLine().toUpperCase());
                inventar.dodajProizvod(new RezaniCvet(ime, cijena, kolicina, datum, boja, visina, vrsta, duzina));
            }
            case 2 -> {
                System.out.print("Boja: ");
                String boja = scanner.nextLine();
                System.out.print("Visina u cm: ");
                double visina = Double.parseDouble(scanner.nextLine());
                System.out.print("Precnik saksije: ");
                double precnik = Double.parseDouble(scanner.nextLine());
                System.out.print("Vrsta (RUZA, TULIPAN, ORHIDEJA...): ");
                VrstaCveca vrsta = VrstaCveca.valueOf(scanner.nextLine().toUpperCase());
                inventar.dodajProizvod(new SaksijskiCvet(ime, cijena, kolicina, datum, boja, visina, vrsta, precnik));
            }
            case 3 -> {
                System.out.print("Tip listova: ");
                String tipListova = scanner.nextLine();
                inventar.dodajProizvod(new Zelenilo(ime, cijena, kolicina, datum, tipListova));
            }
            case 4 -> {
                System.out.print("Tezina u kg: ");
                double tezina = Double.parseDouble(scanner.nextLine());
                System.out.print("Vrsta gnojiva: ");
                String vrsta = scanner.nextLine();
                inventar.dodajProizvod(new Gnjojivo(ime, cijena, kolicina, datum, tezina, vrsta));
            }
            case 5 -> {
                System.out.print("Trajanje u satima: ");
                int trajanje = Integer.parseInt(scanner.nextLine());
                inventar.dodajProizvod(new Svijeca(ime, cijena, kolicina, datum, trajanje));
            }
            case 6 -> {
                System.out.print("Poruka: ");
                String poruka = scanner.nextLine();
                inventar.dodajProizvod(new Cestitka(ime, cijena, kolicina, datum, poruka));
            }
            case 7 -> {
                System.out.print("Materijal: ");
                String materijal = scanner.nextLine();
                System.out.print("Volumen u litrima: ");
                double volumen = Double.parseDouble(scanner.nextLine());
                inventar.dodajProizvod(new Saksija(ime, cijena, kolicina, datum, materijal, volumen));
            }
            default -> System.out.println("Nepoznat tip.");
        }
    }

    private static void prodajProizvod() {
        System.out.print("Unesi ime proizvoda: ");
        String ime = scanner.nextLine();
        System.out.print("Kolicina za prodaju: ");
        int kolicina = Integer.parseInt(scanner.nextLine());
        boolean uspjeh = inventar.prodajProizvod(ime, kolicina);
        if (uspjeh)
            System.out.println("Prodaja uspjesna.");
        else
            System.out.println("Nema dovoljno zaliha ili proizvod ne postoji.");
    }

    private static void pretrazi() {
        System.out.print("Unesi ime za pretragu: ");
        List<Proizvod> rezultat = inventar.pretraziPoImenu(scanner.nextLine());
        for (Proizvod p : rezultat)
            System.out.println(p);
    }

    private static void filtriraj() {
        System.out.print("Unesi minimalnu cijenu: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Unesi maksimalnu cijenu: ");
        double max = Double.parseDouble(scanner.nextLine());
        List<Proizvod> rezultat = inventar.filtrirajPoCijeni(min, max);
        for (Proizvod p : rezultat)
            System.out.println(p);
    }
}
