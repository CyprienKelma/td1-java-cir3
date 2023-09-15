import java.util.Scanner;

public class Exo1 {

    /* Exercice 1 : Le calcul du périmètre et de l'aire d'un cercle */

    private double radius;

    Exo1() {
        showExo1();
    }

    public void showExo1() {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int localChoice = 0;
        int nbrApprox = 0;

        print("===========================================================================");
        print("Exercice 1 : Le calcul du périmètre et de l'aire d'un cercle");
        print("===========================================================================\n\n");

        print("Entrer la valeur du rayon : ");
        radius = sc1.nextDouble();
        // print("Choisissez l'aproximation voulu (le nombre de chiffre après la
        // virgule) : ");
        // nbrApprox = sc1.nextInt();
        // String formatApprox = "%." + nbrApprox + "f";
        print("\n");
        print("Perimètre : " + String.format("%.3f", calculatePerimeter(radius)));
        print("Aire : " + String.format("%.3f", calculateArea(radius)));
        print("\n\n\n");

        print("Que voulez-vous faire ?");
        print(" 1. Rentrer une nouvelle valeur");
        print(" 2. Revenir au menu");
        localChoice = sc2.nextInt();
        if (localChoice == 1) {
            for (int i = 0; i < 10; i++) {
                print("");
            }
            showExo1();
        } else if (localChoice == 2) {
            TD1.showMainMenu();
        }
    }

    public double calculatePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    public double calculateArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public void print(String text) {
        System.out.println(text);
    }

}