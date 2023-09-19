import java.util.*;

public class Exo4 {
    int playerMoney;
    boolean playerWon = false;
    int ennemyMoney;
    boolean ennemyWon = false;
    String ennemyName;
    int actualTour;

    Exo4(){
        showExo4();
    }

    public void showExo4(){
        print("===========================================================================");
        print("Exercice 4 : Un drôle de Black Jack");
        print("===========================================================================\n\n\n");

        print("Bienvenue sur Black-Dice, le jeux de Black-Jack qui vous rendra (peut-être) riche !");
        print("Que voulez-vous faire :\n");

        print("1. Lancer une partie");
        print("2. Quitter l'exercice\n");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1){
            chooseDifficulty();
        } else if(choice == 2){
            TD1.showMainMenu();
        } else {
            showExo4();
        }
    }

    public void chooseDifficulty(){
        print("\nPour commencer, veuiller choisir votre adversaire (entrez 1 ou 2) : \n");
        print("     1. Billy     (Mode NORMAL : égalité des chances et même somme de départ.)");
        print("     2. Borris    (Mode DIFFICILE : Selon les rumeurs, son dé \"fétiche\" n'est rien d'autre qu'un dé truqué.");
        print("                   Et sans vraiment savoir pourquoi, il commence avec plus d'argent.En bref un adversaire à fuir...)\n");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1){
            ennemyName = "Billy";
            actualTour = 1;
            startTheGame(false);
        } else if(choice == 2){
            ennemyName ="Borris";
            actualTour = 1;
            startTheGame(true);
        } else {
            chooseDifficulty();
        }
    }

    public void startTheGame(boolean hardMode){
        print("\nVous commencez avec 1000$. Pour gagner la partie, vous devez prendre tout les sous de votre adversaire");
        print("A chaque tour, vous choississez combien vous voulez miser et jouer vos lancer");
        print("Ensuite votre adversaire suivra la même mise et jouera à son tour aussi. Celui qui à le score le plus proche de 21 gagne le pot !");

        while(!ennemyWon && !playerWon){
            playATour(actualTour, hardMode);
        }
    }

    private void playATour(int actualTour, boolean hardMode) {
        boolean enemyTurn = false;
        int miseTour = 0;
        int lancer = 1;
        int playerTotal = 0;
        int ennemyTotal = 0;

        if(actualTour == 1){
            if(hardMode){
                ennemyMoney = 1300;
                playerMoney = 1000;
            } else {
                ennemyMoney = 1000;
                playerMoney = 1000;
            }
        }
        print("\n=================================================================");
        print("*****************************Tour N°" + actualTour + "********************************\n");

        print("Votre argent : " + playerMoney + "$");
        print("Réserve de l'adversaire : " + ennemyMoney + "$");
        print("Combien voulez vous miser sur ce tour :");
        Scanner sc = new Scanner(System.in);
        miseTour = sc.nextInt();
        print(ennemyName + " vous a suivi et mise aussi " + miseTour + "$");
        print("A vous de jouer ! \n");

        while(!enemyTurn){
            int choice = 0;
            print("___________Lancer N°" + lancer +"__Total : " + playerTotal + "__________");
            print("1. Lancer le dé");
            print("2. Passer au tour de l'adversaire");
            choice = sc.nextInt();
            if(choice == 1){
                int rollDice = rollNormalDice();
                print("Vous avez obtenu la valeur " + rollDice);
                playerTotal += rollDice;
                if(playerTotal == 21){
                    playerWon(true, miseTour);
                } else if(playerTotal > 21){
                    playerLose(miseTour, playerTotal);
                }
            } else{
                enemyTurn = true;
                break;
            }
        }
    }

    
    private void playerWon(boolean isBlackJack, int miseTour) {
    }

    private void playerLose(int miseTour, int playerTotal){

    }

    public int rollNormalDice(){
        // TODO
    }
    
    private int rollHardcoreDice() {
        // TODO
    }

    public void print(String text){
        System.out.println(text);
    }
}