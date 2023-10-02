import java.util.*;

public class Exo4 {
    int playerMoney;
    boolean playerWon = false;
    int ennemyMoney;
    boolean ennemyWon = false;
    String ennemyName;
    int actualTour;

    public boolean isHardMode = false;

    Exo4() {
        showExo4();
    }

    // TODO add functions for when the user or the bot have 0 money left
    // TODO do a win or loose menu for the entire game (from 1000$ to ...)
    public void showExo4() {
        print("===========================================================================");
        print("Exercice 4 : Un drôle de Black Jack");
        print("===========================================================================\n\n\n");

        print("Bienvenue sur Black-Dice, le jeux de Black-Jack qui vous rendra (peut-être) riche !");
        print("Que voulez-vous faire :\n");

        print("1. Lancer une partie");
        print("2. Quitter l'exercice\n");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            chooseDifficulty();
        } else if (choice == 2) {
            TD1.showMainMenu();
        } else {
            showExo4();
        }
    }

    public void chooseDifficulty() {
        print("\nPour commencer, veuiller choisir votre adversaire (entrez 1 ou 2) : \n");
        print("     1. Billy     (Mode NORMAL : égalité des chances et même somme de départ.)");
        print("     2. Borris    (Mode DIFFICILE : Selon les rumeurs, son dé \"fétiche\" n'est rien d'autre qu'un dé truqué.");
        print("                   Et sans vraiment savoir pourquoi, il commence avec plus d'argent.En bref un adversaire à fuir...)\n");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            ennemyName = "Billy";
            actualTour = 1;
            isHardMode = false;
            startTheGame();
        } else if (choice == 2) {
            ennemyName = "Borris";
            actualTour = 1;
            isHardMode = true;
            startTheGame();
        } else {
            chooseDifficulty();
        }
    }

    public void startTheGame() {
        print("\nVous commencez avec 1000$. Pour gagner la partie, vous devez prendre tout les sous de votre adversaire");
        print("A chaque tour, vous choississez combien vous voulez miser et jouer vos lancer");
        print("Ensuite votre adversaire suivra la même mise et jouera à son tour aussi. Celui qui à le score le plus proche de 21 gagne le pot !");
        while (!ennemyWon && !playerWon) {
            playATour(actualTour);
        }
    }

    private void playATour(int actualTour) {
        boolean hardMode = this.isHardMode;
        boolean enemyTurn = false;
        int miseTour = 0; // mise du tour actuelle
        int lancer = 1; // indique le nombre de lancé effectué
        int playerTotal = 0; // score total du joueur
        int ennemyTotal = 0; // score totale du bot

        if (actualTour == 1) {
            if (hardMode) {
                ennemyMoney = 1300; // ++d'argent si l'on joue en mode difficile
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
        if (miseTour > playerMoney) {
            print("Vous n'avez pas assez pour miser cette somme, votre mise est votre réserve restante.");
            miseTour = playerMoney;
        }
        print(ennemyName + " vous a suivi et mise aussi " + miseTour + "$");
        print("A vous de jouer ! \n");

        while (!enemyTurn) {
            int choice = 0;
            print("___________Lancer N°" + lancer + "____Total : " + playerTotal + "____________");
            print("1. Lancer le dé");
            print("2. Passer au tour de l'adversaire");
            choice = sc.nextInt();
            if (choice == 1) {
                int rollDice = rollNormalDice();
                print("Vous avez obtenu la valeur " + rollDice);
                playerTotal += rollDice;
                lancer++;
                if (playerTotal == 21) {
                    playerWonWithBlackJack(miseTour);
                }
                if (playerTotal > 21) {
                    playerOver21(miseTour, playerTotal);
                }

            } else {
                enemyTurn = true;
                lancer = 1;
                break;
            }
        }
        print("Vous vous êtes arrété à " + playerTotal + " points.");
        print("C'est au tour de " + ennemyName + " de jouer.");
        while (enemyTurn) {
            if (!isHardMode) {
                print("___________________Mode NORMALE_____________________");
            } else {
                print("___________________Mode DIFFICILE___________________");
            }
            print("___________Lancer N°" + lancer + "____Total : " + ennemyTotal + "____________");
            int choice = 0;
            print("1. Voir la valeur du dé adverse");
            choice = sc.nextInt();
            if (choice != 0) {
                int rollDice;
                if (!isHardMode) {
                    rollDice = rollNormalDice();
                } else {
                    rollDice = rollHardcoreDice(ennemyTotal);
                }
                print(ennemyName + " a obtenu la valeur " + rollDice);
                ennemyTotal += rollDice;
                lancer++;
                if (ennemyTotal > 21) {
                    ennemyOver21(miseTour, ennemyTotal);
                }
                if (ennemyTotal == 21) {
                    ennemyWonWithBlackJack(miseTour);
                }
                if (ennemyTotal >= playerTotal) {
                    ennemyOverPlayer(miseTour, ennemyTotal);
                }
            }

        }
    }

    public void playerWonWithBlackJack(int miseTour) {
        print("BLACK JACK !! Vous avez gagné ce tours !");
        print("Vous repartez avec les " + miseTour + " de " + ennemyName + ".");
        playerMoney += miseTour;
        ennemyMoney -= miseTour;
        print("1. Continuer la partie et lancer un nouveau tour");
        print("2. Abandonner la partie et revenir au menu");
        Scanner sc = new Scanner(System.in);
        int tmpAnswer = sc.nextInt();
        if (tmpAnswer == 1) {
            playATour(actualTour + 1);
        } else if (tmpAnswer == 2) {
            showExo4();
        } else {
            playerWonWithBlackJack(miseTour);
        }
    }

    public void playerOver21(int miseTour, int playerTotal) {
        print("Votre score totale est de " + playerTotal + ". Vous avez perdu !");
        print(ennemyName + "a gagné le tour et repars avec vos " + miseTour + ".");
        ennemyMoney += miseTour;
        playerMoney -= miseTour;
        playATour(actualTour + 1);
    }

    public int rollNormalDice() {
        int number = (int) (Math.random() * 5 + 1);
        return number;
    }

    private int rollHardcoreDice(int ennemyTotal) {
        int number = 0;
        if (ennemyTotal >= 15) {
            number = (int) (Math.random() * 2 + 2); // Entre 0 et 3 à chaque coup si >= 15
        } else {
            number = (int) (Math.random() * 5 + 4); // Entre 4 et 9 (oui...) à chaque coup si < 15
        }
        return number;
    }

    public void ennemyOverPlayer(int miseTour, int ennemyTotal) {
        print(ennemyName + "a obtenue " + ennemyTotal + ". Soit plus que vous et votre score minable !");
        print("Vous avez perdu le tour, vous perdez votre mise de " + miseTour + ".");
        ennemyMoney += miseTour;
        playerMoney -= miseTour;
        playATour(actualTour + 1);
    }

    private void ennemyWonWithBlackJack(int miseTour) {
        print("BLACK JACK ADVERSE !! Vous avez perdu ce tours !");
        print("Vous perdez votre mise de " + miseTour + " gagné par " + ennemyName + ".");
        playerMoney -= miseTour;
        ennemyMoney += miseTour;
        print("1. Continuer la partie et lancer un nouveau tour");
        print("2. Abandonner la partie et revenir au menu");
        Scanner sc = new Scanner(System.in);
        int tmpAnswer = sc.nextInt();
        if (tmpAnswer == 1) {
            playATour(actualTour + 1);
        } else if (tmpAnswer == 2) {
            showExo4();
        } else {
            playerWonWithBlackJack(miseTour);
        }
    }

    public void ennemyOver21(int miseTour, int ennemyTotal) {
        print(ennemyName + " a fait " + ennemyTotal + ". Vous avez gagné !");
        print("Vous repartez avec vos " + miseTour + ".");
        ennemyMoney -= miseTour;
        playerMoney += miseTour;
        playATour(actualTour + 1);
    }

    public void print(String text) {
        System.out.println(text);
    }
}