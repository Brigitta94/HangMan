import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Incepe jocul spanzuratoarea. Ai 5 incercari pentru a descoperi cuvantul.");

        Scanner cititor = new Scanner(System.in);
        Random random = new Random();
        String[] variantePosibile = {"tastatura", "bicicleta", "televizor", "piropopircanita", "biblioteca", "masina", ""};
        String[] cuvant = {variantePosibile[random.nextInt(5 - 1)]};
        char[] litera = cuvant[0].toCharArray();
        char[] cuvantAfisat = new char[litera.length];
        Arrays.fill(cuvantAfisat, '_');
        int numarGreseli = 0;
        int numarIncercari = 5;
        while (true) {
            System.out.println("Te rog sa introduci o litera:");
            char literaIntrodusa = cititor.next().charAt(0);
            boolean cuvantulContineLitera = false;
            for (int i = 0; i < cuvantAfisat.length; i++) {
                if (literaIntrodusa == litera[i]) {
                    cuvantAfisat[i] = literaIntrodusa;
                    cuvantulContineLitera = true;
                }
            }
            if (!cuvantulContineLitera) {
                numarGreseli++;
                System.out.println("Aceasta litera nu se afla in cuvant, mai ai " + (numarIncercari - numarGreseli) + " incercari.");
            } else {
                System.out.println("Litera " + "'" + literaIntrodusa + "'" + " se afla in cuvant.");
            }
            if (numarGreseli < 5) {
                for (char c : cuvantAfisat) {
                    System.out.print(c);
                }
                System.out.println();
            } else {
                System.out.println("ATI PIERDUT JOCUL!");
                break;
            }
            boolean aiCastigat = true;
            for (int i = 0; i < litera.length; i++) {
                if (litera[i] != cuvantAfisat[i]) {
                    aiCastigat = false;
                    break;
                }
            }
            if (aiCastigat) {
                System.out.println("AI CASTIGAT JOCUL!");
                break;
            }
            System.out.println();
        }

    }
}
