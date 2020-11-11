package jeuTamagotchi;

import java.util.Arrays;
import java.util.Scanner;

import outils.Clavier;

abstract class Tamagotchi {

	public String name;
	public int typeAnimal;
	public int color;
	public String hairColor;

	protected int lifeEspectancy;
	protected double size;
	protected double maxSize;

	private String mood;
	private int age;
	private int health = 5;
	private int eatCounter = 5;
	private int sleepCounter = 6;
	private int toilettesCounter = 8;
	private int washCounter = 8;
	private int goOutCounter = 8;
	private boolean mask = true;

	String[] tabHairColor = { "Violet", "Bleu", "Rouge" };

	String strLossHealth1 = " perd un point de vie.\r";
	String strLossHealth2 = " perd deux points de vie.\r";
	String strWinHealth1 = " gagne un point de vie. \r";
	String strWinHealth2 = " gagne deux points de vie. \r";

	/**
	 * Tama constructor
	 */

	public Tamagotchi() {
		this.name = nameTama();
		choiceColor();
	}

	/**
	 * baby constructor
	 * 
	 * @param color
	 */
	public Tamagotchi(int color) {
		setColor(color);
	}

	
	/*----------------------------INIT_TAMAGOTHI'S_CHARACTERISTIQUES--------------------*/
	
	/**
	 * player choose a name for his Tama
	 * 
	 * @param name
	 * @param sc
	 * @param strquestionNom
	 */
	public static String nameTama() {
		String name;
		System.out.println("Comment s'appelle ton nouvel animal?");
		name = Clavier.lireString();

		return name;
	}

	/**
	 * Print a short summary of Tamagotchi's characteristics and rules of the game
	 * 
	 * @param myTama
	 * @param name
	 */
	public void show() {
		System.out.println(
				"\rTon tamagotchi s'appelle " + this.name + " et c'est une " + stringAnimal(getTypeAnimal()) + ".");
		System.out.println(this.name + " mesure " + getSize() + "cm, sa couleur est " + stringColor(getColor()));
		System.out.println("La " + stringAnimal(getTypeAnimal()) + " a une esperance de vie de " + getLifeEsperancy()
				+ " jours. \r");
		System.out.println(name
				+ " vient de naitre, il a 5 points de vie. \rEn pleine forme, il peut avoir jusqu'à 10 points de vie.");
		System.out.println("S'il descend à 0 point de vie " + name
				+ " meurt. Fais lui gagner des points de vie en effectuant des actions. Attention, certaines sont nocives pour la santé!\r");
	}

	/**
	 * the player choice the color of his animal
	 * 
	 * @param sc
	 * @param myTama
	 */

	public void choiceColor() {
		int color;
		do {
			System.out.println("choisis la couleur de ton animal : \r1 = rouge \t 2= violet \t 3 = jaune ");
			color = Clavier.lireInt();
		} while (color < 1 || color > 3);
		this.setColor(color);
		System.out.println("Tu as choisi " + (stringColor(color)));
	}

	/**
	 * Convert animal int to string
	 * 
	 * @param typeAnimal
	 * @return animalConvert
	 */

	public String stringAnimal(int typeAnimal) {
		String animalConvert = null;
		switch (typeAnimal) {
		case 1:
			animalConvert = "limace";
			break;
		case 2:
			animalConvert = "libellule";
			break;
		case 3:
			animalConvert = "licorne";
			break;
		}
		return animalConvert;
	}

	/**
	 * Convert color int to string
	 * 
	 * @param color
	 * @return animalColorConvert
	 */
	public String stringColor(int color) {
		String animalColorConvert = null;
		switch (color) {
		case 1:
			animalColorConvert = "rouge sang";
			break;
		case 2:
			animalColorConvert = "violet prune";
			break;
		case 3:
			animalColorConvert = "jaune poussin";
			break;
		}
		return animalColorConvert;
	}

	/*-----------------------------------------------BABY_TAMA----------------------------------*/
	/**
	 * Print a short summary of Baby's characteristics
	 * 
	 * @param TamaBaby
	 * @param name
	 */
	public void showBaby(Tamagotchi TamaBaby) {

		System.out.println("_________\r\n" + "\\-._.--./ \r\n" + " `-._.-' \r\n" + "    I    \r\n" + "    I    \r\n"
				+ "    I    \r\n" + "   -^- ");

		System.out.println("\rFélicitation, tu viens d'avoir un bébé Tamagotchi et c'est evidemment une "
				+ TamaBaby.stringAnimal(TamaBaby.getTypeAnimal()) + " " + TamaBaby.stringColor(TamaBaby.getColor())
				+ ".");
	}

	/**
	 * when user choice "reproduce action", creation of a new baby Tama
	 */

	abstract public void defineBaby();

	/**
	 * print message to introduce baby Tama and relaunch the game
	 * 
	 * @param TamaBaby
	 */

	public void babyPresentation(Tamagotchi TamaBaby) {
		System.out.println("Bienvenue dans le monde " + TamaBaby.getName()
				+ " on s'occupera de toi ultérieurement.\rRetournons à nos moutons avec " + getName() + "\r");
	}
	
	
	// ----------------------------------------------------------ACTIONS---------------------------------------------------------------------------------------

	

	/**
	 * Eat action if tama needs to eat => increase size + max counter eat. If not,
	 * decrease health. + update others counters
	 */
	public void eat1() {
		if (getEatCounter() < 10) {

			setHealth(getHealth() + 1);
			grow();
			setEatCounter(10);
			setSleepCounter(getSleepCounter() - 1);

			System.out.println("miam, ca fait du bien. " + name + strWinHealth1);

		} else {

			setHealth(getHealth() - 1);
			setSleepCounter(getSleepCounter() - 2);

			System.out.println("pfffff j'en peux plus j'ai trop mangé. " + name + strLossHealth1);

		}
		setToilettesCounter(getToilettesCounter() - 2);
		setWashCounter(getWashCounter() - 1);
		setGoOutCounter(getGoOutCounter() - 1);

	}

	/**
	 * Sleep action Add life + update others counters
	 */
	public void sleep2() {
		setHealth(getHealth() + 1);
		setSleepCounter(10);
		setEatCounter(getEatCounter() - 1);
		setToilettesCounter(getToilettesCounter() - 2);
		setWashCounter(getWashCounter() - 1);
		setGoOutCounter(getGoOutCounter() - 1);

		System.out.println("zzzzzzz....\r" + name + strWinHealth1);

	}

	/**
	 * Toilets action Add life + update others counters
	 */
	public void pee3() {
		setHealth(getHealth() + 1);
		setWashCounter(getWashCounter() - 3);
		setToilettesCounter(10);
		setEatCounter(getEatCounter() - 1);
		setSleepCounter(getSleepCounter() - 1);
		setGoOutCounter(getGoOutCounter() - 1);

		System.out.println("aaaaaaahhhhhhhhhhh\r" + name + strWinHealth1);

	}

	/**
	 * Color hair action Add life + update others counters
	 */

	public void colorHair4() {
		System.out.println("Voici les couleurs disponibles : " + Arrays.toString(tabHairColor));
		System.out.println("J'avais les cheveux " + this.hairColor);

		if (this.hairColor == tabHairColor[0]) {
			this.hairColor = tabHairColor[1];
		} else if (hairColor == tabHairColor[1]) {
			this.hairColor = tabHairColor[2];
		} else {
			this.hairColor = tabHairColor[0];
		}

		setGoOutCounter(getGoOutCounter() - 2);
		setWashCounter(getWashCounter() - 2);
		setHealth(getHealth() + 1);
		setEatCounter(getEatCounter() - 1);
		setSleepCounter(getSleepCounter() - 1);
		setToilettesCounter(getToilettesCounter() - 2);

		System.out.println("Quelle classe, j'ai maintenant les cheveux " + this.hairColor);
		System.out.println(name + strWinHealth1);
	}

	/**
	 * Reproduce action : informe the player he has to make goOut action. Add life +
	 * update others counters
	 */
	public void reproduce5() {
		setHealth(getHealth() + 1);
		setEatCounter(getEatCounter() - 1);
		setSleepCounter(getSleepCounter() - 1);
		setToilettesCounter(getToilettesCounter() - 2);
		setWashCounter(getWashCounter() - 2);
		setGoOutCounter(getGoOutCounter() - 2);
	}

	/**
	 * Express mood action : different possibilities, depends of health
	 */
	public void expressMood6() {
		setHealth(getHealth() + 1);
		setEatCounter(getEatCounter() - 1);
		setSleepCounter(getSleepCounter() - 1);
		setToilettesCounter(getToilettesCounter() - 1);
		setWashCounter(getWashCounter() - 1);
		setGoOutCounter(getGoOutCounter() - 1);

		if (health > 7) {
			System.out.println("je sauuuute de joie - Booom - Booom\r");
		} else if (health > 5) {
			System.out.println("ca va,ca va\r");
		} else {
			System.out.println("C'est la C-A-T-A !!!!!!! mouhiiiiiiiinnnnnnn\r");
		}
		System.out.println(name + strWinHealth1);
	}

	/**
	 * Action go out : allows the player to do reproduce action. Add life and update
	 * others counters.
	 * 
	 * @param sc
	 */
	public void goOut7() {
		setGoOutCounter(10);
		setHealth(getHealth() + 1);
		setEatCounter(getEatCounter() - 1);
		setSleepCounter(getSleepCounter() - 1);
		setToilettesCounter(getToilettesCounter() - 1);
		setWashCounter(getWashCounter() - 1);

		System.out.println(
				"ca fait plaisir de les voir, j'ai bien rigolé, j'ai bien bu, j'ai .... hips... bien mangé...\r");

		System.out.println(name + strWinHealth1);
	}

	/**
	 * Smooke action : decrease life and increase eatounter + update others counter
	 */
	public void smooke8() {
		setHealth(getHealth() - 2);
		setEatCounter(getEatCounter() + 1);
		setToilettesCounter(getToilettesCounter() - 2);
		setWashCounter(getWashCounter() - 1);
		setSleepCounter(getSleepCounter() - 1);
		setGoOutCounter(getGoOutCounter() - 1);

		System.out.println("aaaaaah une bonne clope! touuus touss. \r" + name + strLossHealth2);
	}

	/**
	 * play sports action : add life + update others counters
	 */
	public void playSports9() {
		setHealth(getHealth() + 2);
		setWashCounter(getWashCounter() - 3);
		setEatCounter(getEatCounter() - 2);
		setSleepCounter(getSleepCounter() - 2);
		setGoOutCounter(getGoOutCounter() - 1);
		setToilettesCounter(getToilettesCounter() - 1);

		System.out.println("un - deux - un -deux ... C'est bon pour mon tour de taille.\r" + name + strWinHealth2);
	}

	/**
	 * the player can make die action if he wants to stop the game prematurely.
	 * Update health to 0.
	 */
	public void die10() {

		if (typeAnimal == 1) {
			System.out
					.println("srouuuutch - ta " + stringAnimal(this.typeAnimal) + " s'est jetée sous une chaussure!\r");
		} else if (typeAnimal == 2) {
			System.out.println("ooooh noooon un chasseur de papillons bourré a attrapé ta "
					+ stringAnimal(this.typeAnimal) + " !\r");
		} else {
			System.out.println("et PAF la " + stringAnimal(this.typeAnimal) + ".\r");
		}
		System.out.println("adieu monde cruel, " + this.name + " a préféré abréger son existance.\r");
		this.health = 0;
	}

	/**
	 * take off or put on the mask. Depends if the Tama already wear it or not.
	 * 
	 * @return mask
	 */
	public boolean takeOfMask11() {
		setEatCounter(getEatCounter() - 1);
		setSleepCounter(getSleepCounter() - 1);
		setToilettesCounter(getToilettesCounter() - 1);
		setWashCounter(getWashCounter() - 1);

		if (mask == true) {
			System.out.println("enfin, plus personne, j'enlève mon masque, je ne vais pas trop sortir!\r");
			setGoOutCounter(getGoOutCounter() + 2);
			mask = false;
		} else {
			System.out.println("Je vais mettre mon masque, c'est pratique avec ce temps, ca tient chaud au nez.\r");
			setGoOutCounter(getGoOutCounter() - 2);
			mask = true;
		}
		return mask;
	}

	/**
	 * Wash action : add life and update others counters
	 */
	public void wash12() {
		setWashCounter(10);
		setHealth(getHealth() + 1);
		setEatCounter(getEatCounter() - 1);
		setSleepCounter(getSleepCounter() - 1);
		setToilettesCounter(getToilettesCounter() - 1);
		setGoOutCounter(getGoOutCounter() - 1);

		System.out.println("y'a rien de mieux qu'une bonne douche.\r" + name + strWinHealth1);
	}

	/**
	 * If the players wants to see his statistics.
	 */
	public void showStatistics13() {
		System.out.println("\rSanté  = " + getHealth());
		System.out.println("Faim = " + getEatCounter());
		System.out.println("Fatigue = " + getSleepCounter());
		System.out.println("Vessie = " + getToilettesCounter());
		System.out.println("Hygiène = " + getWashCounter());
		System.out.println("Sociabilisation = " + getGoOutCounter());
		System.out.println("Age = " + getAge());
		System.out.println("Taille = " + getSize() + "\r");
	}

	/**
	 * Tama grew up when he eats. The maximum size depends of animal's type.
	 */

	abstract public void grow();

	// ------------------------------------------------METHODS_TO_UPDATE_COUNTER-----------------------------------------------------
	/**
	 * for hungry - if hungry = 0 => die. Alert user if tama needs to eat and update
	 * others counters.
	 */
	public void checkEatCounter() {
		if (getEatCounter() > 3 && getEatCounter() < 6) {
			System.out.println(name + " a faim, n'oublie pas de le nourrir.\r");
		} else if (getEatCounter() > 0 && getEatCounter() <= 3) {
			System.out.println(
					name + " a très très faim, il va bientot faire une crise de manque, n'oublie pas de le nourrir.\r"
							+ name + strLossHealth2 + "\r");
			setHealth(getHealth() - 2);
		} else if (getEatCounter() <= 0) {
			System.out.println("gruuuuuuuuuuuu haaa ha h...");
			System.out.println(name + " n'a pas mangé depuis trop longtemps.\r");
			setHealth(getHealth() - 10);
		}
	}

	/**
	 * for tiredness -alert user if tama needs to sleep and update others counters
	 */
	public void checkSleepCounter() {
		if (getSleepCounter() > 3 && getSleepCounter() < 6) {
			System.out.println(this.name + " commence à être fatigué, il faudrait peut être faire un petit somme.\r");
		} else if (getSleepCounter() > 0 && getSleepCounter() <= 3) {
			System.out.println(this.name + " tombe de sommeil, il faut DORMIR!\r");
		} else if (getSleepCounter() <= 0) {
			System.out.println("B-O-O-M! " + this.name + " était trop fatigué, il est tombé de sommeil.\r" + name
					+ strLossHealth2 + "\r");
			setSleepCounter(10);
			setHealth(getHealth() - 2);
		}
	}

	/**
	 * for toilets -alert user if tama want to pee and update others counters
	 */
	public void checkToilettesCounter() {
		if (getToilettesCounter() > 3 && getToilettesCounter() < 6) {
			System.out.println("Il ne faudra pas oublier d'ammener " + this.name + " aux toilettes.\r");
		} else if (getToilettesCounter() > 0 && getToilettesCounter() <= 3) {
			System.out.println("Enviiiiiiiie d'aller aux toiiiiiiiiiiillettes!!!!!\r");
		}

		else if (getToilettesCounter() <= 0) {
			System.out.println("Rooooo la honte, " + this.name
					+ " avait trop envie d'aller aux toilettes, il s'est fait dessus et maintenant il pue.\r" + name
					+ strLossHealth1);
			setToilettesCounter(10);
			setHealth(getHealth() - 1);
		}
	}

	/**
	 * for hygiene -alert user if tama needs to wash and update health counter
	 */
	public void checkWashCounter() {
		if (getWashCounter() > 3 && getWashCounter() < 6) {
			System.out.println("Y'a une drole d'odeur par ici, non?\r");
		} else if (getWashCounter() > 0 && getWashCounter() <= 3) {
			System.out.println("Ca commence à sentir fort... Ne pas oublier la douche!\r");
		} else if (getWashCounter() <= 0) {
			System.out.println(
					this.name + "  pue grave, il ne vaut mieux pas qu'il sorte et l'envoyer d'urgence se laver.\r"
							+ name + strLossHealth1);
			setHealth(getHealth() - 1);
		}
	}

	/**
	 * for sociability - alert user if tama needs to go for a drink and update
	 * health counter
	 */
	public void checkgoOutCounter() {
		if (getGoOutCounter() > 3 && getGoOutCounter() < 6) {
			System.out.println(name + " irait bien boire une bierre.\r");
		} else if (getGoOutCounter() > 0 && getGoOutCounter() <= 3) {
			System.out.println("Il va falloir que " + name + " sortes, sinon c'est un coup à devenir fou.\r");
		}

		else if (getGoOutCounter() <= 0) {
			System.out.println("Le confinemment c'est horrible, " + name + " se sens beaucoup trop seul.\r" + name
					+ strLossHealth2);
			setHealth(getHealth() - 2);
		}
	}

	/**
	 * Print age for the players each 5 days
	 * 
	 * @param myTama
	 */
	public void birthdayTama() {
		int timeSpan;
		String strBirthdayBegin = " fête son anniversaire, il lui reste encore ";
		String strBirthdayEnd = " jours à vivre";
		timeSpan = getLifeEsperancy() - getAge();

		if (getAge() % 5 == 0) {
			System.out.println(name + strBirthdayBegin + timeSpan + strBirthdayEnd);
		}
	}

//	----------------------------------------------------GETTERS_AND_SETTERS-----------------------------------------
	/**
	 * @return color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @param color
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * @return typeAnimal
	 */
	public int getTypeAnimal() {
		return typeAnimal;
	}

	/**
	 * type animal define size et lifeEsperancy
	 * 
	 * @param typeAnimal
	 */

	public void setTypeAnimal(int typeAnimal) {
		this.typeAnimal = typeAnimal;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return mask
	 */
	public boolean getMask() {
		return mask;
	}

	/**
	 * @param mask
	 */
	public void setMask(boolean mask) {
		this.mask = mask;
	}

	/**
	 * @return health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * max of health allowed = 10
	 * 
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
		if (getHealth() >= 10) {
			this.health = 10;
		}
		if (getHealth() < 0) {
			this.health = 0;
		}
	}

	/**
	 * @return size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @param size
	 */
	public void setSize(double size) {
		this.size = size;
	}

	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return mood
	 */
	public String getMood() {
		return mood;
	}

	/**
	 * @param mood
	 */
	public void setMood(String mood) {
		this.mood = mood;
	}

	/**
	 * @return lifeEsperancy
	 */
	public int getLifeEsperancy() {
		return lifeEspectancy;
	}

	/**
	 * @param lifeEsperancy
	 */
	public void setLifeEsperancy(int lifeEsperancy) {
		this.lifeEspectancy = lifeEsperancy;
	}

	/**
	 * @return eatCounter
	 */
	int getEatCounter() {
		return eatCounter;
	}

	/**
	 * @param eatCounter
	 */
	public void setEatCounter(int eatCounter) {
		this.eatCounter = eatCounter;
		if (this.getEatCounter() > 10) {
			this.eatCounter = 10;
		}
	}

	/**
	 * @return sleepCounter
	 */
	public int getSleepCounter() {
		return sleepCounter;
	}

	/**
	 * @param sleepCounter
	 */
	public void setSleepCounter(int sleepCounter) {
		this.sleepCounter = sleepCounter;
	}

	/**
	 * @return toilettesCounter
	 */
	public int getToilettesCounter() {
		return toilettesCounter;
	}

	/**
	 * @param toilettesCounter
	 */
	public void setToilettesCounter(int toilettesCounter) {
		this.toilettesCounter = toilettesCounter;
	}

	/**
	 * @return washCounter
	 */
	public int getWashCounter() {
		return washCounter;
	}

	/**
	 * @param washCounter
	 */
	public void setWashCounter(int washCounter) {
		this.washCounter = washCounter;
		if (this.getWashCounter() < 0) {
			this.washCounter = 0;
		}
	}

	/**
	 * @return goOutCounter
	 */
	public int getGoOutCounter() {
		return goOutCounter;
	}

	/**
	 * @param goOutCounter
	 */
	public void setGoOutCounter(int goOutCounter) {
		this.goOutCounter = goOutCounter;
		if (this.getGoOutCounter() < 0) {
			this.goOutCounter = 0;
		}
	}

}