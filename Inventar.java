import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Inventar {
    private List<Proizvod> proizvodi;

    public Inventar() {
        this.proizvodi = new ArrayList<>();
    }

    public void dodajProizvod(Proizvod p) {
        proizvodi.add(p);
    }

    public boolean prodajProizvod(String ime, int kolicina) {
        Iterator<Proizvod> it = proizvodi.iterator();
        while (it.hasNext()) {
            Proizvod p = it.next();
            if (p.getIme().equalsIgnoreCase(ime)) {
                if (p.getKolicina() >= kolicina) {
                    p.prodaj(kolicina);
                    if (p.getKolicina() == 0) {
                        it.remove(); // ukloni iz liste
                    }
                    return true;
                } else {
                    System.out.println("Nedovoljno na zalihi!");
                    return false;
                }
            }
        }
        System.out.println("Proizvod nije pronadjen.");
        return false;
    }

    public void ispisiSve() {
        for (Proizvod p : proizvodi) {
            System.out.println(p);
        }
    }

    public List<Proizvod> pretraziPoImenu(String kljuc) {
        List<Proizvod> rezultat = new ArrayList<>();
        for (Proizvod p : proizvodi) {
            if (p.getIme().toLowerCase().contains(kljuc.toLowerCase())) {
                rezultat.add(p);
            }
        }
        return rezultat;
    }

    public List<Proizvod> filtrirajPoCijeni(double min, double max) {
        List<Proizvod> rezultat = new ArrayList<>();
        for (Proizvod p : proizvodi) {
            if (p.getCijena() >= min && p.getCijena() <= max) {
                rezultat.add(p);
            }
        }
        return rezultat;
    }

    public void sacuvajUDatoteku(String imeDatoteke) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(imeDatoteke))) {
            for (Proizvod p : proizvodi) {
                bw.write(serialize(p));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Greska pri pisanju u datoteku: " + e.getMessage());
        }
    }

    private String serialize(Proizvod p) {
        return p.getClass().getSimpleName() + ";" + p.toString(); // prilagodi po potrebi
    }

    public void ucitajIzDatoteke(String imeDatoteke) {
        try (BufferedReader br = new BufferedReader(new FileReader(imeDatoteke))) {
            String linija;
            while ((linija = br.readLine()) != null) {
                Proizvod p = parseProizvod(linija);
                if (p != null) {
                    proizvodi.add(p);
                }
            }
        } catch (IOException e) {
            System.err.println("Greska pri citanju datoteke: " + e.getMessage());
        }
    }

    private Proizvod parseProizvod(String linija) {
        try {
            String[] dijelovi = linija.split(";");
            String tip = dijelovi[0];
            String[] podaci = dijelovi[1].replace("{", "").replace("}", "").split(", ");

            Map<String, String> map = new HashMap<>();
            for (String p : podaci) {
                String[] par = p.split("=");
                if (par.length == 2)
                    map.put(par[0].trim(), par[1].trim());
            }

            String ime = map.get("ime");
            double cijena = Double.parseDouble(map.get("cijena"));
            int kolicina = Integer.parseInt(map.get("kolicina"));
            String datumStr = map.get("datum");
            LocalDate datum = (datumStr == null || datumStr.equalsIgnoreCase("null"))
                    ? LocalDate.now()
                    : LocalDate.parse(datumStr);

            return switch (tip) {
                case "RezaniCvijet" -> new RezaniCvet(ime, cijena, kolicina, datum, map.get("boja"),
                        Double.parseDouble(map.get("visina")), VrstaCveca.valueOf(map.get("vrsta")),
                        Integer.parseInt(map.get("duzina")));
                case "SaksijskiCvijet" -> new SaksijskiCvet(ime, cijena, kolicina, datum, map.get("boja"),
                        Double.parseDouble(map.get("visina")), VrstaCveca.valueOf(map.get("vrsta")),
                        Double.parseDouble(map.get("precnik")));
                case "Zelenilo" -> new Zelenilo(ime, cijena, kolicina, datum, map.get("tipListova"));
                case "Gnojivo" ->
                    new Gnjojivo(ime, cijena, kolicina, datum, Double.parseDouble(map.get("tezina")), map.get("vrsta"));
                case "Svijeca" -> new Svijeca(ime, cijena, kolicina, datum, Integer.parseInt(map.get("trajanje")));
                case "Cestitka" -> new Cestitka(ime, cijena, kolicina, datum, map.get("poruka"));
                case "Posuda" -> new Saksija(ime, cijena, kolicina, datum, map.get("materijal"),
                        Double.parseDouble(map.get("volumen")));
                default -> null;
            };
        } catch (Exception e) {
            System.err.println("Greska u parsiranju linije: " + linija);
            return null;
        }
    }

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }
}
