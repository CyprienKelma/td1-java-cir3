import java.util.*;

public class TD1 {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        showMainMenu();
    }

    public static void showMainMenu() {
        Scanner scannerMenu = new Scanner(System.in);
        int choice = 0;

        for (int i = 0; i < 10; i++) {
            print("");
        }

        print("===========================================================================");
        print("************************ TD 1 JAVA - PRISE EN MAIN ************************");
        print("********************** Cyprien Kelma - CIR3 2023/2024 *********************");
        print("===========================================================================\n\n");

        print("CHOIX DE L'EXERCICE : \n");
        print(" 1. Le calcul du périmètre et de l'aire d'un cercle");
        print(" 2. Pair/impair, positif/négatif ou nul");
        print(" 3. Gestion d'un compte bancaire");
        print(" 4. Un drôle de Black Jack\n\n");

        print("Entrez le numéro de l'exercice correspondant : ");
        choice = scannerMenu.nextInt();
        switch (choice) {
            case 1:
                Exo1 exo1 = new Exo1();
                break;
            case 2:
                Exo2 exo2 = new Exo2();
                break;
            case 3:
                Exo3 exo3 = new Exo3();
                break;
            case 4:
                Exo4 exo4 = new Exo4();
                break;
            default:
                print("Erreur : Entrez un numéro valide ! ");
                choice = scannerMenu.nextInt();
                break;
        }

    }

    public static void print(String text) {
        System.out.println(text);
    }

}
