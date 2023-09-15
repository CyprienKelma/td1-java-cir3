import java.util.*;

public class Exo2 {

    Exo2() {
        showExo2();
    }

    public void showExo2() {
        Scanner sc = new Scanner(System.in);

        print("===========================================================================");
        print("Exercice 2 :  Pair/impair, positif/négatif ou nul");
        print("===========================================================================\n\n");

        testNumber();
    }

    public void testNumber() {
        Scanner sc = new Scanner(System.in);
        int number = 0;

        print("Veuillez entrer un nombre (entier) :\n");
        String input = sc.nextLine();
        number = Integer.parseInt(input);

        if (number < 0) {
            print("Entier saisi incorrect");
            testNumber();
        } else {
            try {
                if (number % 2 == 0) {
                    print("Le nombre " + number + " est pair");
                } else {
                    print("Le nombre " + number + " est impair");
                }
            } catch (NumberFormatException e) {
                print("Entier saisi incorrect");
                testNumber();
            }
        }
    }

    public static void print(String text) {
        System.out.println(text);
    }
}