package inheritance;

public class App {

	public static void main(String[] args) {
		//새는 동물을 상속받음.
		Animal animal1 = new Animal();
		animal1.eat();
		
		Bird bird1 = new Bird();
		bird1.eat();
		bird1.fly();
	}

}
