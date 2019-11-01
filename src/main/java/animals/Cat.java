package animals;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
	}

	public void drinkMelk() {
		System.out.println("Drinkt melk");

	}
	
	@Override
	public void makeSound() {
		System.out.println("Miauw");
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
