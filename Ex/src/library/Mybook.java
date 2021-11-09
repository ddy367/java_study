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

   //
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

   /**
    * ���θ� ������ �� �ֿܼ� �⺻���� ������ �ʱ� �˸�
    */
   public void initAlarm() {

      System.out.println(title + "�� �湮�ϽŰ��� ȯ���մϴ�.");
      System.out.println("�� ����Ʈ�� ȸ�� ���θ� Ȯ���ؾ߸� �̿��� �����մϴ�.");
      System.out.println("ȸ��(y) / ��ȸ��(n)");

      String isLogin = scan.next();

      switch (isLogin) {
      case "y":

         memberLogin();
         break;
      case "n":

         nonMemberLogin();
         break;
      default:

         System.out.println();
         System.out.println("ȸ�� ���θ� Ȯ������ ������ �̿��� �Ұ��մϴ�.");
         System.out.println("�ٽ� �����Ͽ� �ֽʽÿ�");
         break;
      }
   }

   /**
    * ���� �湮���� y�� ������ ��, ������ �����ϴ� ���� ���� �޼���
    */
   public void nonMemberLogin() {

      System.out.println("�湮�� ȯ���մϴ�!(��ȸ�� ����)");
      System.out.println("(�Ϻ� ���� ����� ���ѵ˴ϴ�.)");

      selectCategoryNon();
   }

   /**
    * ȸ������
    */
   public void memberLogin() {

      System.out.println("ȸ����ȣ�� �Է��Ͽ� �ֽʽÿ�");
      System.out.printf("ȸ����ȣ: ");

      newUser = scan.next();
      
      MemberList memberList = new MemberList();
      memberList.setMemberList(memberList);

      System.out.println(memberList.getMemberList() + "�� �湮�� ȯ���մϴ�.(ȸ�� ����)");

      selectCategory();
   }

   /**
    * ī�װ� ��� ����ϱ�
    */
   public void selectCategory() {
      System.out.println();
      System.out.println("��������          �̿� ���� ����              ������");
      System.out.println("�� 1.���� ����     2.���� ã��    3.���� �뿩 ��Ȳ    ��");
      System.out.println("��������                                   ������");
      System.out.printf("          � ���񽺸� �̿��Ͻðڽ��ϱ�?");
      System.out.println();

      int serviceNo = scan.nextInt();

      printProductList(serviceNo);
   }

   public void printProductList(int categoryNo) {
      switch (categoryNo) {
      case 1:
         selectRental(bookRent);
         break;
      case 2:
         System.out.println("�������� �Է��Ͽ� �ֽʽÿ�.");
         bookName = scan.next();

         BookName bookName = new BookName();
         bookName.setBookName(bookName);

         System.out.println("�˻����̴� ��ø� ��ٷ��ֽʽÿ�.");
         System.out.println();

         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         selectBooks1(search);

         break;
      case 3:
         System.out.println("�뿩 ��Ȳ�� ��ȸ�մϴ�.");
         System.out.println();

         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         selectProduct(rental);

         break;
      default:

         System.out.println("�������� �ʴ� �����Դϴ�.");
         System.exit(0);
         break;
      }

   }

   private void selectRental(String bookRent) {
      System.out.println("������ �Ϸù�ȣ�� �Է��Ͽ��ּ���.");
      bookName = scan.next();

      BookName bookName = new BookName();
      bookName.setBookName(bookName);

      System.out.println("ȸ����ȣ�� �Է��Ͽ� �ּ���.");
      System.out.printf("ȸ����ȣ: ");

      newUser = scan.next();
      
      if(newUser == memberList) {
      System.out.println("����Ǿ����ϴ�.");
   }   else {
      System.out.println("ȸ�� ���̵� �ٷ� �Է��Ͻʽÿ�.");
      }
   }


   private void selectBooks1(Product[] search) {
      ArrayList<String> randomList = new ArrayList<String>();
      randomList.add("å�� �������� �ʽ��ϴ�.");
      randomList.add("���� �ֽ��ϴ�. �缭���� �����ϱ� �ٶ��ϴ�.");
      randomList.add("û����ȣ : 911.05-99");
      randomList.add("û����ȣ : 810.903-82-4");
      randomList.add("û����ȣ : 911.0359-67");

      Collections.shuffle(randomList);

      System.out.println(randomList.get(0));
   }

   private void selectProduct(Product[] rental) {
      ArrayList<String> randomList = new ArrayList<String>();
      randomList.add("1�� �뿩���Դϴ�.");
      randomList.add("2�� �뿩���Դϴ�.");
      randomList.add("3�� �뿩���Դϴ�. �� �̻� �뿩 �� �� �����ϴ�.");
      randomList.add("�뿩���� å�� �����ϴ�.");

      Collections.shuffle(randomList);

      System.out.println(randomList.get(0));
   }

   public void selectCategoryNon() {
      System.out.println();
      System.out.println("��������          �̿� ���� ����              ������");
      System.out.println("�� 1.���� ����     2.���� ã��    3.���� �뿩 ��Ȳ    ��");
      System.out.println("��������                                   ������");
      System.out.printf("          � ���񽺸� �̿��Ͻðڽ��ϱ�?");
      System.out.println();

      int serviceNo = scan.nextInt();

      printProductListNon(serviceNo);
   }

   public void printProductListNon(int categoryNo) {
      switch (categoryNo) {
      case 1:
         System.out.println("���ѵ� �����Դϴ�.");
         break;

      case 2:
         System.out.println("�������� �Է��Ͽ� �ֽʽÿ�.");
         bookName = scan.next();

         BookName bookName = new BookName();
         bookName.setBookName(bookName);

         System.out.println("�˻����̴� ��ø� ��ٷ��ֽʽÿ�.");
         System.out.println();

         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         selectBooks1(search);

         break;
      case 3:
         System.out.println("���ѵ� �����Դϴ�.");
         break;
      default:

         System.out.println("�������� �ʴ� �����Դϴ�.");
         System.exit(0);
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