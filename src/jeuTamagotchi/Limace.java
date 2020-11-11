package jeuTamagotchi;

public class Limace extends Tamagotchi {

	/**
	 * Tama constructor
	 */
	public Limace() {
		super();
		setTypeAnimal(1);
		lifeEspectancy = 22;
		size = 30;
		maxSize = 40;
		hairColor = tabHairColor[2];
	}
	
	/**
	 * baby constructor
	 * @param color
	 */
	public Limace(int color) {
		super(color);
		String name = nameTama();
		setName(name);
		setTypeAnimal(1);
		lifeEspectancy = 22;
		size = 20;
		maxSize = 40;
		hairColor = tabHairColor[2];
	}
	

	public void eat1() {
		System.out.println("c'était bon ce grain de mais");
		super.eat1();
	}

	public void grow() {
		if (getSize() < maxSize) {
			this.setSize(this.getSize() + 1);
		}
	}

	public void defineBaby() {
		Tamagotchi TamaBaby = new Limace(getColor());
		showBaby(TamaBaby);
		babyPresentation(TamaBaby);

	}
}
