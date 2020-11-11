package jeuTamagotchi;

import java.util.Scanner;
import outils.Clavier;

public class MainClass {
	public static void main(String[] args) {
		int iChoicePlayer;
		int typeAnimal = 0;

		String name = null;

		char replay = 0;

		// lauch the game with message
		welcome();

		Scanner sc = new Scanner(System.in);

		do {

			// init Tama

			Tamagotchi myTama = null;

			typeAnimal = choiceAnimal(sc);

			// init object function of player's choice
			if (typeAnimal == 1) {
				myTama = new Limace();
			} else if (typeAnimal == 2) {
				myTama = new Libellule();
			} else {
				myTama = new Licorne();
			}

			// print main informations
			myTama.show();

			do {

				// player can chooses one action from a list
				iChoicePlayer = choiceAction(sc);

				// launch the action function of the choice's player
				checkActionPlayer(iChoicePlayer, myTama, sc);

				// check the action's counters and alert player
				if (iChoicePlayer != 10) {
					myTama.checkEatCounter();

				} // eatcounter = die, if not: launch others check
				if (iChoicePlayer != 10 && myTama.getEatCounter() > 0) {
					myTama.checkSleepCounter();
					myTama.checkToilettesCounter();
					myTama.checkWashCounter();
					myTama.checkgoOutCounter();

					// birthday alert user each 5 days
					myTama.birthdayTama();

					informHealth(myTama);

				}

				// end of life :
			} while (myTama.getHealth() > 0 && myTama.getAge() < myTama.getLifeEsperancy());

			strDie(myTama, name);

			// ask the user if we want to play again
			replay = askReplay(replay, sc);
			sc.nextLine();

		}

		while (replay == 'o');

		goodBye();

		sc.close();
	}

	// --------------------------------Tamagotchi's_characteristics_initialization------------------------------------------------------------

	/**
	 * the player choice the kind of animal he wants
	 * 
	 * @param sc
	 * @param myTama
	 */
	public static int choiceAnimal(Scanner sc) {
		int typeAnimal;
		do {
			System.out.println("choisis ton animal : \r1 = limace \t 2= libellule \t 3 = licorne ");

			typeAnimal = sc.nextInt();

			switch (typeAnimal) {
			case 1:
				System.out.println("ok pour la limace même si c'est un peu gluant\r");
				break;
			case 2:
				System.out.println("Tu as choisis la libellule, vole vole petit insecte\r");
				break;
			case 3:
				System.out.println("La licorne, quelle bonne idée!\r");
				break;
			}

		} while (typeAnimal < 1 || typeAnimal > 3);

		return typeAnimal;

	}

	// --------------------------------Players'_interaction_&_action----------------------------------------------------------------------------------------
	/**
	 * Print the different action's possibilities for the player and return the
	 * result
	 * 
	 * @param sc
	 * @return choicePlayer
	 */
	public static int choiceAction(Scanner sc) {
		int iChoicePlayer = 0;
		do {
			System.out.println("Quelles sont les actions que tu veux effectuer?");
			System.out.println(
					"1 = manger \t2 = dormir \t3 = aller aux toilettes \t4 = se teindre les cheveux \t5 = se reproduire \t6 = exprimer son humeur");
			System.out.println(
					"7 = voir des amis \t8 = fumer \t9 = faire du sport \t10 = mourir \t11 = enlever/mettre son masque \t12 = se laver \t13 = voir mes stats ");

			iChoicePlayer = sc.nextInt();
		}

		while (iChoicePlayer < 1 || iChoicePlayer > 13);

		return (iChoicePlayer);

	}

	/**
	 * convert the action choice player to "string" => to print the result
	 * 
	 * @param iChoicePlayer
	 * @return strActionPlayer
	 */
	public static String strAction(int iChoicePlayer) {
		String strActionPlayer = null;
		switch (iChoicePlayer) {
		case 1:
			strActionPlayer = "manger";
			break;
		case 2:
			strActionPlayer = "dormir";
			break;
		case 3:
			strActionPlayer = "aller aux toilettes";
			break;
		case 4:
			strActionPlayer = "colorer ses cheveux";
			break;
		case 5:
			strActionPlayer = "se reproduire";
			break;
		case 6:
			strActionPlayer = "exprimer son humeur";
			break;
		case 7:
			strActionPlayer = "sortir avec des amis";
			break;
		case 8:
			strActionPlayer = "fumer";
			break;
		case 9:
			strActionPlayer = "faire du sport";
			break;
		case 10:
			strActionPlayer = "mourir";
			break;
		case 11:
			strActionPlayer = "enlever / mettre son masque";
			break;
		case 12:
			strActionPlayer = "se laver";
			break;
		case 13:
			strActionPlayer = "voir mes stats";
			break;

		}
		return strActionPlayer;
	}

	/**
	 * launch the action function's of the choicePlayer + add age
	 * 
	 * @param iChoicePlayer
	 * @param myTama
	 * @param sc
	 */
	public static void checkActionPlayer(int iChoicePlayer, Tamagotchi myTama, Scanner sc) {
		if (iChoicePlayer == 1) {
			myTama.eat1();
		} else if (iChoicePlayer == 2) {
			myTama.sleep2();
		} else if (iChoicePlayer == 3) {
			myTama.pee3();
		} else if (iChoicePlayer == 4) {
			myTama.colorHair4();
		} else if (iChoicePlayer == 5) {
			myTama.reproduce5();
			myTama.defineBaby();
		} else if (iChoicePlayer == 6) {
			myTama.expressMood6();
		} else if (iChoicePlayer == 7) {
			myTama.goOut7();
		} else if (iChoicePlayer == 8) {
			myTama.smooke8();
		} else if (iChoicePlayer == 9) {
			myTama.playSports9();
		} else if (iChoicePlayer == 10) {
			myTama.die10();
		} else if (iChoicePlayer == 11) {
			myTama.takeOfMask11();
		} else if (iChoicePlayer == 12) {
			myTama.wash12();
		} else if (iChoicePlayer == 13) {
			myTama.showStatistics13();
		}
		myTama.setAge(myTama.getAge() + 1);
	}

	/**
	 * Ask to the player if he wants play another part.
	 * 
	 * @param replay
	 * @param sc
	 * @return
	 */
	public static char askReplay(char replay, Scanner sc) {
		do {
			System.out.println("Souhaites tu retenter ta chance? o/n");

			replay = sc.next().charAt(0);

		} while (replay != 'o' && replay != 'n');
		return replay;
	}

	// --------------------------------Print_message_for_user_experience----------------------------------------------------------------------------------------
	/**
	 * Welcome message
	 */
	public static void welcome() {
		System.out.println("Bienvenue sur le jeu du Tamagotchi \r");
	}

	/**
	 * Print to user why his Tama is died : too old or player looses the game
	 * 
	 * @param myTama
	 * @param name
	 */
	public static void strDie(Tamagotchi myTama, String name) {
		if (myTama.getHealth() <= 0) {
			System.out.println(myTama.getName() + " a rendu l'âme, tu t'es très mal occupé de lui");
		} else {
			System.out.println(myTama.getName()
					+ " a vécu une belle vie grâce a toi. Il a désormais atteint son age maximum et vient de rendre l'âme.");
		}
	}

	/**
	 * print message at the end of the game
	 */
	public static void goodBye() {
		System.out.println("THE END -------- Merci d'avoir joué et à bientôt");
	}

	/**
	 * Warn the player after health update
	 * 
	 * @param myTama
	 */
	public static void informHealth(Tamagotchi myTama) {
		System.out.println(myTama.getName() + " a " + myTama.getHealth() + " point(s) de vie.\r");
	}
}
