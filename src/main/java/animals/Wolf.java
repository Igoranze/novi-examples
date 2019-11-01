package animals;

public class Wolf extends Animal {

	public Wolf(String name) {
		super(name);
	}

	@Override
	public void makeSound() {
		System.out.println("Houwwwlllll");
	}

	@Override
	public boolean isEating() {
		return false;
	}

	@Override
	public boolean isSleaping() {
		return false;
	}

}

