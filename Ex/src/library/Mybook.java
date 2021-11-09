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

   //
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

   /**
    * 쇼핑몰 시작할 때 콘솔에 기본으로 찍히는 초기 알림
    */
   public void initAlarm() {

      System.out.println(title + "에 방문하신것을 환영합니다.");
      System.out.println("본 사이트는 회원 여부를 확인해야만 이용이 가능합니다.");
      System.out.println("회원(y) / 비회원(n)");

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
         System.out.println("회원 여부를 확인하지 않으면 이용이 불가합니다.");
         System.out.println("다시 시작하여 주십시오");
         break;
      }
   }

   /**
    * 기존 방문여부 y를 눌렀을 때, 기존에 존재하던 계정 고르는 메서드
    */
   public void nonMemberLogin() {

      System.out.println("방문을 환영합니다!(비회원 입장)");
      System.out.println("(일부 서비스 사용이 제한됩니다.)");

      selectCategoryNon();
   }

   /**
    * 회원가입
    */
   public void memberLogin() {

      System.out.println("회원번호를 입력하여 주십시오");
      System.out.printf("회원번호: ");

      newUser = scan.next();
      
      MemberList memberList = new MemberList();
      memberList.setMemberList(memberList);

      System.out.println(memberList.getMemberList() + "님 방문을 환영합니다.(회원 입장)");

      selectCategory();
   }

   /**
    * 카테고리 목록 출력하기
    */
   public void selectCategory() {
      System.out.println();
      System.out.println("┏━━━          이용 가능 서비스              ━━┓");
      System.out.println("┃ 1.도서 대출     2.도서 찾기    3.나의 대여 현황    ┃");
      System.out.println("┗━━━                                   ━━┛");
      System.out.printf("          어떤 서비스를 이용하시겠습니까?");
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
         System.out.println("도서명을 입력하여 주십시오.");
         bookName = scan.next();

         BookName bookName = new BookName();
         bookName.setBookName(bookName);

         System.out.println("검색중이니 잠시만 기다려주십시오.");
         System.out.println();

         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         selectBooks1(search);

         break;
      case 3:
         System.out.println("대여 현황을 조회합니다.");
         System.out.println();

         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         selectProduct(rental);

         break;
      default:

         System.out.println("지원하지 않는 서비스입니다.");
         System.exit(0);
         break;
      }

   }

   private void selectRental(String bookRent) {
      System.out.println("도서의 일련번호를 입력하여주세요.");
      bookName = scan.next();

      BookName bookName = new BookName();
      bookName.setBookName(bookName);

      System.out.println("회원번호를 입력하여 주세요.");
      System.out.printf("회원번호: ");

      newUser = scan.next();
      
      if(newUser == memberList) {
      System.out.println("대출되었습니다.");
   }   else {
      System.out.println("회원 아이디를 바로 입력하십시오.");
      }
   }


   private void selectBooks1(Product[] search) {
      ArrayList<String> randomList = new ArrayList<String>();
      randomList.add("책이 존재하지 않습니다.");
      randomList.add("서고에 있습니다. 사서에게 문의하기 바랍니다.");
      randomList.add("청구기호 : 911.05-99");
      randomList.add("청구기호 : 810.903-82-4");
      randomList.add("청구기호 : 911.0359-67");

      Collections.shuffle(randomList);

      System.out.println(randomList.get(0));
   }

   private void selectProduct(Product[] rental) {
      ArrayList<String> randomList = new ArrayList<String>();
      randomList.add("1권 대여중입니다.");
      randomList.add("2권 대여중입니다.");
      randomList.add("3권 대여중입니다. 더 이상 대여 할 수 없습니다.");
      randomList.add("대여중인 책이 없습니다.");

      Collections.shuffle(randomList);

      System.out.println(randomList.get(0));
   }

   public void selectCategoryNon() {
      System.out.println();
      System.out.println("┏━━━          이용 가능 서비스              ━━┓");
      System.out.println("┃ 1.도서 대출     2.도서 찾기    3.나의 대여 현황    ┃");
      System.out.println("┗━━━                                   ━━┛");
      System.out.printf("          어떤 서비스를 이용하시겠습니까?");
      System.out.println();

      int serviceNo = scan.nextInt();

      printProductListNon(serviceNo);
   }

   public void printProductListNon(int categoryNo) {
      switch (categoryNo) {
      case 1:
         System.out.println("제한된 서비스입니다.");
         break;

      case 2:
         System.out.println("도서명을 입력하여 주십시오.");
         bookName = scan.next();

         BookName bookName = new BookName();
         bookName.setBookName(bookName);

         System.out.println("검색중이니 잠시만 기다려주십시오.");
         System.out.println();

         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         selectBooks1(search);

         break;
      case 3:
         System.out.println("제한된 서비스입니다.");
         break;
      default:

         System.out.println("지원하지 않는 서비스입니다.");
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