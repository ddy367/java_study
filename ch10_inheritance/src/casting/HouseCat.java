package casting;

public class HouseCat extends Cat{
		//같은 vocal()메소드를 오버라이딩(같은 메소드에 다른 내용을 작성)
		@Override
		public void vocal() {
			System.out.println("미야우~");
		}
		// 집고양이의 메소드 
		public void call() {
			System.out.println("집사를 부릅니다~");
		}
}
