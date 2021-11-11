package library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mybook {

	private static final Product[] rental = null;
	private static final String bookRent = null;

	// ������ �̸�
	String title;

	// ȸ����ȣ �Է�
	String newUser;

	// ���� ���� �Է�
	String bookName;

	ArrayList<Product> book = new ArrayList<Product>();

	// ������ ���� ��ȣ
	int productNo;

	// �Է��� �ߺ��� ����
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

	// ���� ȭ��
	public void initAlarm() {

		System.out.println(title + "�� �湮�ϽŰ��� ȯ���մϴ�.");
		System.out.println("�� ����Ʈ�� ȸ�� ���θ� Ȯ���ؾ߸� �̿��� �����մϴ�.");
		System.out.println("\tȸ��(y) / ��ȸ��(n)");

		String isLogin = scan.next();

		// ��ҹ��� ��� �Է� ����
		// y,n(Y,N) �̿��� �Է½� ȸ�� Ȯ�� ���� �ݺ� ���
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
			System.out.println("��ȸ�� ���θ� Ȯ������ ������ �̿��� �Ұ����մϴ�.��");
			System.out.println("\t�ٽ� Ȯ���Ͽ� �ֽʽÿ�");
			System.out.println("");
			
			initAlarm();
			break;
		}
	}

	// ��ȸ��(n,N) ������ ����
	// �ٷ� ���� �̿����� �Ѿ
	public void nonMemberLogin() {

		System.out.println("\t�湮�� ȯ���մϴ�!(��ȸ�� ����)");
		System.out.println("\t(�Ϻ� ���� ����� ���ѵ˴ϴ�.)");

		selectCategoryNon();
	}

	// ȸ��(y,Y) ������ ����
	// ȸ����ȣ �Է� �� ���� �̿����� �Ѿ
	public void memberLogin() {

		System.out.println("ȸ����ȣ�� �Է��Ͽ� �ֽʽÿ�");
		System.out.printf("ȸ����ȣ: ");

		newUser = scan.next();

		MemberList memberList = new MemberList();
		memberList.setMemberList(memberList);

		System.out.println("�湮�� ȯ���մϴ�.(ȸ�� ����)");

		selectCategory();
	}

	// ȸ�� �湮�� ���� ��� ���
	public void selectCategory() {
		System.out.println();
		System.out.println("��������          �̿� ���� ����              ������");
		System.out.println("�� 1.���� ����     2.���� ã��    3.���� �뿩 ��Ȳ  ��");
		System.out.println("��������      � ���񽺸� �̿��Ͻðڽ��ϱ�?        ������");

		int serviceNo = scan.nextInt();

		printProductList(serviceNo);
	}

	// ȸ���� ���� �˸�
	// �������� �ʴ� ���� ���ý� ���� ������� �ǵ��ư�
	public void printProductList(int categoryNo) {
		switch (categoryNo) {
		case 1:
			selectRental(bookRent);
			break;

		case 2:
			System.out.println("\t�������� �Է��Ͽ� �ֽʽÿ�.");
			bookName = scan.next();

			BookName bookName = new BookName();
			bookName.setBookName(bookName);

			System.out.println("\t\t�˻���...");
			System.out.println();
			
			// �˻������� �˸��� ���� 1�ʰ� ���
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectBooks1(search);
			break;

		case 3:
			System.out.println(" �뿩 ��Ȳ�� ��ȸ�մϴ�. ��ø� ��ٷ��ֽʽÿ�.");
			System.out.println();
			
			// ��ȸ������ �˸��� ���� 1�ʰ� ���
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectProduct(rental);
			break;

		default:
			System.out.println("  ���������� �ʴ� �����Դϴ�. �ٽ� �����Ͽ� �ֽʽÿ�.��");
			selectCategoryNon();
			break;
		}
	}

	// ���� 1.���� ���� ���ý� ���� ȭ�� ���
	// ȸ���ȣ �Է��� ����
	private void selectRental(String bookRent) {
		System.out.println("���� ������ �Է��Ͻʽÿ�.");
		bookName = scan.next();

		BookName bookName = new BookName();
		bookName.setBookName(bookName);

		System.out.println("ȸ����ȣ�� �Է��Ͻʽÿ�.");
		System.out.printf("ȸ����ȣ: ");

		newUser = scan.next();

		if (newUser == memberList) {
			System.out.println("����Ǿ����ϴ�.");
		} else {
			System.out.println("ȸ�� ���̵� Ȥ�� ���� ������ �ٸ��� �Է��Ͻʽÿ�.");
		}
	}

	// ���� 2.���� ã�� ���ý� �������� ȭ�� ���
	private void selectBooks1(Product[] search) {
		ArrayList<String> randomList = new ArrayList<String>();
		randomList.add("\tå�� �������� �ʽ��ϴ�.");
		randomList.add("\t���� �ֽ��ϴ�. �缭���� �����ϱ� �ٶ��ϴ�.");
		randomList.add("\tû����ȣ : 911.05-99");
		randomList.add("\tû����ȣ : 810.903-82-4");
		randomList.add("\tû����ȣ : 911.0359-67");

		Collections.shuffle(randomList);

		System.out.println(randomList.get(0));
		
		// �ǵ��ư��� ����â ���
		System.out.println();
		System.out.println("�������� * ���� ������� ���ư���(s)               ������");
		System.out.println("��    * ȸ�� ����â���� ���ư���(m)                 ��");
		System.out.println("�������� * ���� �������� �ӹ���(�ƹ� ��ư�� �����ֽʽÿ�.) ������");
	
		String isReturn = scan.next();

		// ��ҹ��� ��� �Է� ����
		// s,S ���ý� ���� ������� �ǵ��ư�
		// m,M ��å�� ȸ�� Ȯ��â���� �ǵ��ư�
		// �̿��� ���� �Է½� ���� �������� �ӹ���
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
			System.out.println("\t���� �������� �ӹ����ϴ�.");
			break;
		}
	}

	// ���� 3.���� ���� ��Ȳ ���ý� �������� ȭ�� ���
	private void selectProduct(Product[] rental) {
		ArrayList<String> randomList = new ArrayList<String>();
		randomList.add(" >> 1�� �뿩���Դϴ�.(�����뿩 ���� �Ǽ�: 2��)");
		randomList.add(" >> 2�� �뿩���Դϴ�.(�����뿩 ���� �Ǽ�: 1��)");
		randomList.add(" >> 3�� �뿩���Դϴ�.(�ش� �̻� �뿩 �� �� �����ϴ�.��)");
		randomList.add(" >> �뿩���� å�� �����ϴ�.(�����뿩 ���� �Ǽ�: 3��)");

		Collections.shuffle(randomList);

		System.out.println(randomList.get(0));
		
		// �ǵ��ư��� ����â ���
		System.out.println();
		System.out.println("�������� * ���� ������� ���ư���(s)               ������");
		System.out.println("��    * ȸ�� ����â���� ���ư���(m)                 ��");
		System.out.println("�������� * ���� �������� �ӹ���(�ƹ� ��ư�� �����ֽʽÿ�.) ������");
	
		String isReturn = scan.next();

		// ��ҹ��� ��� �Է� ����
		// s,S ���ý� ���� ������� �ǵ��ư�
		// m,M ��å�� ȸ�� Ȯ��â���� �ǵ��ư�
		// �̿��� ���� �Է½� ���� �������� �ӹ���
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
			System.out.println("\t���� �������� �ӹ����ϴ�.");
			break;
		}
	}

	// ��ȸ�� �湮�� ���� ��� ���
	public void selectCategoryNon() {
		System.out.println();
		System.out.println("��������          �̿� ���� ����              ������");
		System.out.println("�� 1.���� ����     2.���� ã��    3.���� �뿩 ��Ȳ  ��");
		System.out.println("��������      � ���񽺸� �̿��Ͻðڽ��ϱ�?        ������");

		int serviceNo = scan.nextInt();

		printProductListNon(serviceNo);
	}

	// ��ȸ���� ���ѵ� ���񽺸� �˸�
	// ��밡�� ���񽺴� ȸ���� �����ϰ� ���
	// ���ѵ� ���� ���ý� ���� ������� �ǵ��ư�
	// �������� �ʴ� ���� ���ý� ���� ������� �ǵ��ư�
	public void printProductListNon(int categoryNo) {
		switch (categoryNo) {
		case 1:
			System.out.println("\t  �غ�ȸ�� ���� �����Դϴ�.��");
			System.out.println();
			System.out.println("\t>> ����� ���� ����â���� ���ư��ϴ�.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectCategoryNon();
			break;

		case 2:
			System.out.println("\t�������� �Է��Ͽ� �ֽʽÿ�.");
			bookName = scan.next();

			BookName bookName = new BookName();
			bookName.setBookName(bookName);

			System.out.println("\t\t�˻���...");

			// �˻������� �˸��� ���� 1�ʰ� ���
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectBooks2(search);
			break;
			
		case 3:
			System.out.println("\t  �غ�ȸ�� ���� �����Դϴ�.��");
			System.out.println();
			System.out.println("\t>> ����� ���� ����â���� ���ư��ϴ�.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			selectCategoryNon();
			break;
			
		default:
			System.out.println("  ���������� �ʴ� �����Դϴ�. �ٽ� �����Ͽ� �ֽʽÿ�.��");
			selectCategoryNon();
			break;
		}
		
	}

	// ���� 2.���� ã�� ���ý� �������� ȭ�� ���
		private void selectBooks2(Product[] search) {
			ArrayList<String> randomList = new ArrayList<String>();
			randomList.add("\tå�� �������� �ʽ��ϴ�.");
			randomList.add("\t���� �ֽ��ϴ�. �缭���� �����ϱ� �ٶ��ϴ�.");
			randomList.add("\tû����ȣ : 911.05-99");
			randomList.add("\tû����ȣ : 810.903-82-4");
			randomList.add("\tû����ȣ : 911.0359-67");

			Collections.shuffle(randomList);

			System.out.println(randomList.get(0));
			
			// �ǵ��ư��� ����â ���
			System.out.println();
			System.out.println("�������� * ���� ������� ���ư���(s)               ������");
			System.out.println("��    * ȸ�� ����â���� ���ư���(m)                 ��");
			System.out.println("�������� * ���� �������� �ӹ���(�ƹ� ��ư�� �����ֽʽÿ�.) ������");
		
			String isReturn = scan.next();

			// ��ҹ��� ��� �Է� ����
			// s,S ���ý� ���� ������� �ǵ��ư�
			// m,M ��å�� ȸ�� Ȯ��â���� �ǵ��ư�
			// �̿��� ���� �Է½� ���� �������� �ӹ���
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
				System.out.println("\t���� �������� �ӹ����ϴ�.");
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