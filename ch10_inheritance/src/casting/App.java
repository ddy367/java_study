package casting;

public class App {

	public static void main(String[] args) {

		Cat cat1 = new HouseCat(); // 집고양이 객테
		cat1.vocal();
		cat1.hunt();
		
		//cat1.call();
		//Cat 타입이기 때문에 고양이 메소드만 사용가능(오버라이딩 됨)
		
		HouseCat cat2 = (HouseCat)cat1;
		cat2.call(); // 위에서 선언된 집고양이 객체의 Call 메소드 실행
	}

}
