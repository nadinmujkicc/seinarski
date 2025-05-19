import java.util.Scanner;

public class UnosHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int unesiInt(String poruka) {
        while (true) {
            try {
                System.out.print(poruka);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Neispravan unos. Pokusaj ponovo (mora biti cijeli broj).");
            }
        }
    }

    public static double unesiDouble(String poruka) {
        while (true) {
            try {
                System.out.print(poruka);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Neispravan unos. Pokusaj ponovo (mora biti decimalni broj).");
            }
        }
    }

    public static String unesiTekst(String poruka) {
        System.out.print(poruka);
        return scanner.nextLine();
    }
}
