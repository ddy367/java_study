package library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mybook {

	private static final Product[] rental = null;
	private static final String bookRent = null;

	// 도서관 이름
	String title;

	// 회원번호 입력
	String newUser;

	// 도서 제목 입력
	String bookName;

	ArrayList<Product> book = new ArrayList<Product>();

	// 선택한 도서 번호
	int productNo;

	// 입력의 중복을 막음
	Scanner scan = new Scanner(System.in);

	private MemberList memberlsit;
	private Product[] search;
	private String memberList;

	public void setMemberList() {
		setMemberlsit(new MemberList());
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// 시작 화면
	public void initAlarm() {

		System.out.println(title + "에 방문하신것을 환영합니다.");
		System.out.println("본 사이트는 회원 여부를 확인해야만 이용이 가능합니다.");
		System.out.println("\t회원(y) / 비회원(n)");

		String isLogin = scan.next();

		// 대소문자 모두 입력 가능
		// y,n(Y,N) 이외의 입력시 회원 확인 여부 반복 출력
		switch (isLogin) {
		case "y":
		case "Y":
			memberLogin();
			break;
		case "n":
		case "N":
			nonMemberLogin();
			break;
		default:
			System.out.println();
			System.out.println("※회원 여부를 확인하지 않으면 이용이 불가능합니다.※");
			System.out.println("\t다시 확인하여 주십시오");
			System.out.println("");
			
			initAlarm();
			break;
		}
	}

	// 비회원(n,N) 입장을 선택
	// 바로 서비스 이용으로 넘어감
	public void nonMemberLogin() {

		System.out.println("\t방문을 환영합니다!(비회원 입장)");
		System.out.println("\t(일부 서비스 사용이 제한됩니다.)");

		selectCategoryNon();
	}

	// 회원(y,Y) 입장을 선택
	// 회원번호 입력 후 서비스 이용으로 넘어감
	public void memberLogin() {

		System.out.println("회원번호를 입력하여 주십시오");
		System.out.printf("회원번호: ");

		newUser = scan.next();

		MemberList memberList = new MemberList();
		memberList.setMemberList(memberList);

		System.out.println("방문을 환영합니다.(회원 입장)");

		selectCategory();
	}

	// 회원 방문시 서비스 목록 출력
	public void selectCategory() {
		System.out.println();
		System.out.println("┏━━━          이용 가능 서비스              ━━┓");
		System.out.println("┃ 1.도서 대출     2.도서 찾기    3.나의 대여 현황  ┃");
		System.out.println("┗━━━      어떤 서비스를 이용하시겠습니까?        ━━┛");

		int serviceNo = scan.nextInt();

		printProductList(serviceNo);
	}

	// 회원의 서비스 알림
	// 지원하지 않는 서비스 선택시 서비스 목록으로 되돌아감
	public void printProductList(int categoryNo) {
		switch (categoryNo) {
		case 1:
			selectRental(bookRent);
			break;

		case 2:
			System.out.println("\t도서명을 입력하여 주십시오.");
			bookName = scan.next();

			BookName bookName = new BookName();
			bookName.setBookName(bookName);

			System.out.println("\t\t검색중...");
			System.out.println();
			
			// 검색중임을 알리기 위해 1초간 대기
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectBooks1(search);
			break;

		case 3:
			System.out.println(" 대여 현황을 조회합니다. 잠시만 기다려주십시오.");
			System.out.println();
			
			// 조회중임을 알리기 위해 1초간 대기
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectProduct(rental);
			break;

		default:
			System.out.println("  ※지원하지 않는 서비스입니다. 다시 선택하여 주십시오.※");
			selectCategoryNon();
			break;
		}
	}

	// 서비스 1.도서 대출 선택시 대출 화면 출력
	// 회언번호 입력을 요함
	private void selectRental(String bookRent) {
		System.out.println("도서 제목을 입력하십시오.");
		bookName = scan.next();

		BookName bookName = new BookName();
		bookName.setBookName(bookName);

		System.out.println("회원번호를 입력하십시오.");
		System.out.printf("회원번호: ");

		newUser = scan.next();

		if (newUser == memberList) {
			System.out.println("대출되었습니다.");
		} else {
			System.out.println("회원 아이디 혹은 도서 제목을 바르게 입력하십시오.");
		}
	}

	// 서비스 2.도서 찾기 선택시 랜덤으로 화면 출력
	private void selectBooks1(Product[] search) {
		ArrayList<String> randomList = new ArrayList<String>();
		randomList.add("\t책이 존재하지 않습니다.");
		randomList.add("\t서고에 있습니다. 사서에게 문의하기 바랍니다.");
		randomList.add("\t청구기호 : 911.05-99");
		randomList.add("\t청구기호 : 810.903-82-4");
		randomList.add("\t청구기호 : 911.0359-67");

		Collections.shuffle(randomList);

		System.out.println(randomList.get(0));
		
		// 되돌아가는 선택창 출력
		System.out.println();
		System.out.println("┏━━━ * 서비스 목록으로 돌아가기(s)               ━━┓");
		System.out.println("┃    * 회훤 학인창으로 돌아가기(m)                 ┃");
		System.out.println("┗━━━ * 현재 페이지에 머물기(아무 버튼을 눌러주십시오.) ━━┛");
	
		String isReturn = scan.next();

		// 대소문자 모두 입력 가능
		// s,S 선택시 서비스 목록으로 되돌아감
		// m,M 선책시 회원 확인창으로 되돌아감
		// 이외의 문자 입력시 현재 페이지에 머무름
		switch (isReturn) {
		case "s":
		case "S":
			selectCategory();
			break;
		case "m":
		case "M":
			initAlarm();
			break;
		default:
			System.out.println("\t현재 페이지에 머무릅니다.");
			break;
		}
	}

	// 서비스 3.나의 대출 현황 선택시 랜덤으로 화면 출력
	private void selectProduct(Product[] rental) {
		ArrayList<String> randomList = new ArrayList<String>();
		randomList.add(" >> 1권 대여중입니다.(남은대여 가능 권수: 2권)");
		randomList.add(" >> 2권 대여중입니다.(남은대여 가능 권수: 1권)");
		randomList.add(" >> 3권 대여중입니다.(※더 이상 대여 할 수 없습니다.※)");
		randomList.add(" >> 대여중인 책이 없습니다.(남은대여 가능 권수: 3권)");

		Collections.shuffle(randomList);

		System.out.println(randomList.get(0));
		
		// 되돌아가는 선택창 출력
		System.out.println();
		System.out.println("┏━━━ * 서비스 목록으로 돌아가기(s)               ━━┓");
		System.out.println("┃    * 회훤 학인창으로 돌아가기(m)                 ┃");
		System.out.println("┗━━━ * 현재 페이지에 머물기(아무 버튼을 눌러주십시오.) ━━┛");
	
		String isReturn = scan.next();

		// 대소문자 모두 입력 가능
		// s,S 선택시 서비스 목록으로 되돌아감
		// m,M 선책시 회원 확인창으로 되돌아감
		// 이외의 문자 입력시 현재 페이지에 머무름
		switch (isReturn) {
		case "s":
		case "S":
			selectCategory();
			break;
		case "m":
		case "M":
			initAlarm();
			break;
		default:
			System.out.println("\t현재 페이지에 머무릅니다.");
			break;
		}
	}

	// 비회원 방문시 서비스 목록 출력
	public void selectCategoryNon() {
		System.out.println();
		System.out.println("┏━━━          이용 가능 서비스              ━━┓");
		System.out.println("┃ 1.도서 대출     2.도서 찾기    3.나의 대여 현황  ┃");
		System.out.println("┗━━━      어떤 서비스를 이용하시겠습니까?        ━━┛");

		int serviceNo = scan.nextInt();

		printProductListNon(serviceNo);
	}

	// 비회원의 제한된 서비스를 알림
	// 사용가능 서비스는 회원과 동일하게 출력
	// 제한된 서비스 선택시 서비스 목록으로 되돌아감
	// 지원하지 않는 서비스 선택시 서비스 목록으로 되돌아감
	public void printProductListNon(int categoryNo) {
		switch (categoryNo) {
		case 1:
			System.out.println("\t  ※비회원 제한 서비스입니다.※");
			System.out.println();
			System.out.println("\t>> 잠시후 서비스 선택창으로 돌아갑니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectCategoryNon();
			break;

		case 2:
			System.out.println("\t도서명을 입력하여 주십시오.");
			bookName = scan.next();

			BookName bookName = new BookName();
			bookName.setBookName(bookName);

			System.out.println("\t\t검색중...");

			// 검색중임을 알리기 위해 1초간 대기
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectBooks2(search);
			break;
			
		case 3:
			System.out.println("\t  ※비회원 제한 서비스입니다.※");
			System.out.println();
			System.out.println("\t>> 잠시후 서비스 선택창으로 돌아갑니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectCategoryNon();
			break;
			
		default:
			System.out.println("  ※지원하지 않는 서비스입니다. 다시 선택하여 주십시오.※");
			selectCategoryNon();
			break;
		}
		
	}

	// 서비스 2.도서 찾기 선택시 랜덤으로 화면 출력
		private void selectBooks2(Product[] search) {
			ArrayList<String> randomList = new ArrayList<String>();
			randomList.add("\t책이 존재하지 않습니다.");
			randomList.add("\t서고에 있습니다. 사서에게 문의하기 바랍니다.");
			randomList.add("\t청구기호 : 911.05-99");
			randomList.add("\t청구기호 : 810.903-82-4");
			randomList.add("\t청구기호 : 911.0359-67");

			Collections.shuffle(randomList);

			System.out.println(randomList.get(0));
			
			// 되돌아가는 선택창 출력
			System.out.println();
			System.out.println("┏━━━ * 서비스 목록으로 돌아가기(s)               ━━┓");
			System.out.println("┃    * 회훤 학인창으로 돌아가기(m)                 ┃");
			System.out.println("┗━━━ * 현재 페이지에 머물기(아무 버튼을 눌러주십시오.) ━━┛");
		
			String isReturn = scan.next();

			// 대소문자 모두 입력 가능
			// s,S 선택시 서비스 목록으로 되돌아감
			// m,M 선책시 회원 확인창으로 되돌아감
			// 이외의 문자 입력시 현재 페이지에 머무름
			switch (isReturn) {
			case "s":
			case "S":
				selectCategoryNon();
				break;
			case "m":
			case "M":
				initAlarm();
				break;
			default:
				System.out.println("\t현재 페이지에 머무릅니다.");
				break;
			}
		}
	
	public MemberList getMemberlsit() {
		return memberlsit;
	}

	public void setMemberlsit(MemberList memberlsit) {
		this.memberlsit = memberlsit;
	}

}