import java.io.*;
import java.util.*;

public class Inventar {
    private List<Proizvod> proizvodi;

    public Inventar() {
        proizvodi = new ArrayList<>();
    }

    public void dodajProizvod(Proizvod proizvod) {
        proizvodi.add(proizvod);
    }

    public void ukloniProizvod(Proizvod proizvod) {
        proizvodi.remove(proizvod);
    }

    public boolean prodajProizvod(String naziv, int kolicina) {
        for (Proizvod p : proizvodi) {
            if (p.getNaziv().equalsIgnoreCase(naziv) && p.getKolicina() >= kolicina) {
                p.setKolicina(p.getKolicina() - kolicina);
                return true;
            }
        }
        return false;
    }

    public void ispisiVse() {
        for (Proizvod p : proizvodi) {
            System.out.println(p);
        }
    }

    public List<Proizvod> pretraziPoImenu(String key) {
        List<Proizvod> pronadjeni = new ArrayList<>();
        for (Proizvod p : proizvodi) {
            if (p.getNaziv().toLowerCase().contains(key.toLowerCase())) {
                pronadjeni.add(p);
            }
        }
        return pronadjeni;
    }

    public List<Proizvod> pretraziPoCeni(double min, double max) {
        List<Proizvod> pronadjeni = new ArrayList<>();
        for (Proizvod p : proizvodi) {
            if (p.getCena() >= min && p.getCena() <= max) {
                pronadjeni.add(p);
            }
        }
        return pronadjeni;
    }

    public List<Proizvod> pretraziPoKolicini(int min, int max) {
        List<Proizvod> pronadjeni = new ArrayList<>();
        for (Proizvod p : proizvodi) {
            if (p.getKolicina() >= min && p.getKolicina() <= max) {
                pronadjeni.add(p);
            }
        }
        return pronadjeni;
    }

    public void shraniVDatoteku(String imeDatoteke) {
        try (BufferedWriter oos = new BufferedWriter(new FileWriter(imeDatoteke))) {
            for (Proizvod p : proizvodi) {
                oos.write(p.toString());
                oos.newLine();
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom pisanja v datoteku: " + e.getMessage());
        }
    }
    //TODO UCitaj iz datoteke
    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }
}
