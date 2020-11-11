package jeuTamagotchi;

public class Licorne extends Tamagotchi {

	
	/**
	 * Tama constructor
	 */
	public Licorne() {
		super();
		setTypeAnimal(3);
		lifeEspectancy = 32;
		size = 150;
		maxSize = 200;
		hairColor = tabHairColor[1];
	}
	
	
	/**
	 * baby constructor
	 * @param color
	 */
	public Licorne(int color) {
		super(color);
		String name= nameTama();
		setName(name);
		setTypeAnimal(3);
		lifeEspectancy = 32;
		size = 80;
		maxSize = 200;
		hairColor = tabHairColor[1];
	}

	public void eat1() {
		System.out.println("Ce foin m'a un peu piqué les gencives");
		super.eat1();
	}

	public void grow() {
		if (getSize() < maxSize) {
			this.setSize(this.getSize() + 3);
		}
	}
	
	public void defineBaby() {
		Tamagotchi TamaBaby = new Licorne(getColor());
		showBaby(TamaBaby);
		babyPresentation(TamaBaby);

	}
}