package animals;

public class WildCat extends Cat {

	public WildCat(String name) {
		super(name);
	}

	@Override
	public void makeSound() {
		System.out.println("Grrrrrrr...");
	}
}
