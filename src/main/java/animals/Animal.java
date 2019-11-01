package animals;

public abstract class Animal implements Eat, Sleep {

	private String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void makeSound();
}