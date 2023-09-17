import java.util.*;

public class Exo3 {

    private static String userName = ""; // ex : CYPRIEN KELMA
    private static String userId = ""; // ex : X3B3478CE

    Exo3() {
        showExo3();
    }

    public void showExo3() {
        print("===========================================================================");
        print("Exercice 3 : Gestion d'un compte bancaire");
        print("===========================================================================\n\n\n");

        login();
        BanqueMenu menu1 = new BanqueMenu(userName, userId);
        menu1.showMenu();
    }

    public static void login() {
        print("----------------------------------------------------------------------------");
        print("Veuillez fournir vos identifiants de compte pour vous connecter :");
        print("----------------------------------------------------------------------------\n");

        Scanner sc = new Scanner(System.in);
        print("Entrez votre nom : ");
        userName = sc.nextLine();
        print("Entrez votre identifiant personelle :");
        userId = sc.nextLine();
        print("");
    }

    public static void print(String text) {
        System.out.println(text);
    }
}

class BanqueMenu {

    private String userName;
    private String userId;
    double currentBalance = 0.0;

    BanqueMenu(String uName, String uId) {
        this.userName = uName;
        this.userId = uId;
    }

    public void showMenu() {
        Scanner menuScanner = new Scanner(System.in);
        String option = "";

        print("===========================================================================");
        print("Bon retour parmis nous " + userName);
        print("===========================================================================");
        print("");
        print("S : Voir le solde actuel de votre compte");
        print("D : Déposer sur votre compte");
        print("R : Faire un retrait d'argent");
        print("Q : Quitter l'application");
        print("");

        while (!option.equals("q") && !option.equals("Q")) {
            print("===========================================================================");
            print("Selectionnez l'une des options ci-dessus :");
            print("===========================================================================");

            option = menuScanner.next();

            switch (option) {
                case "S":
                case "s":
                    print("-----------------------------");
                    print("Solde actuel : " + currentBalance);
                    print("-----------------------------");
                    print("\n");
                    break;

                case "D":
                case "d":
                    print("-----------------------------");
                    print("Entrez le montant à déposer : ");
                    print("-----------------------------");
                    print("\n");
                    double amountDeposited = menuScanner.nextDouble();
                    deposit(amountDeposited);
                    print("\n");
                    break;

                case "R":
                case "r":
                    print("-----------------------------");
                    print("Entrez le montant à retirer : ");
                    print("-----------------------------");
                    print("\n");
                    double amountWithdrawn = menuScanner.nextDouble();
                    withdraw(amountWithdrawn);
                    print("\n");
                    break;
                case "Q":
                case "q":
                    print("\n");
                    print("===========================================================================");
                    print("Vous avez été déconnecté avec succés. Merci pour votre confiance.");
                    print("===========================================================================");
                    option = "Q";
                    break;

                default:
                    print("Error, you're not allowed to do that. Please select a valid option.");
                    break;
            }
        }
        // TODO Proposer de soit relancer l'exo3 soit de revenir au menu pricipale du TD
    }

    void deposit(double amount) {
        if (amount <= 0) {
            print("Veuillez entrer un montant valide.");
        }
        currentBalance += amount;
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            print("Veuillez entrer un montant valide.");
            Scanner tmpScanner = new Scanner(System.in);
            double amountWithdrawn = tmpScanner.nextDouble();
            withdraw(amountWithdrawn);
        }
        if (currentBalance >= amount) {
            currentBalance -= amount;
        } else {
            print("Désolé, le solde de votre compte est insuffisant pour ce retrait");
            print("Retrait voulu : " + amount + "$");
            print("Solde actuelle : " + currentBalance + "$");
        }
    }

    public void print(String text) {
        System.out.println(text);
    }
}
