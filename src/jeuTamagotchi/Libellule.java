package jeuTamagotchi;

public class Libellule extends Tamagotchi {

	/**
	 * Tama constructor
	 */
	public Libellule() {
		super();
		setTypeAnimal(2);
		lifeEspectancy = 12;
		size = 3;
		maxSize = 10;
		hairColor = tabHairColor[0];
	}

	/**
	 * baby constructor
	 * 
	 * @param color
	 */
	public Libellule(int color) {
		super(color);
		String name = nameTama();
		setName(name);
		setTypeAnimal(2);
		lifeEspectancy = 12;
		size = 1;
		maxSize = 10;
		hairColor = tabHairColor[0];
	}

	public void eat1() {
		System.out.println("bien croquante cette mouche");
		super.eat1();

	}

	public void grow() {
		if (getSize() < maxSize) {
			this.setSize(this.getSize() + 0.5);
		}
	}

	public void defineBaby() {
		Tamagotchi TamaBaby = new Libellule(getColor());
		showBaby(TamaBaby);
		babyPresentation(TamaBaby);

	}

}