package animals;

public class Dog extends Animal {

	public Dog(String name) {
		super(name);
	}

	@Override
	public void makeSound() {
		System.out.println("Woef woef!");
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
