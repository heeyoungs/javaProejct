package person;

import book.Book;
import book.BookInfo;
import java.util.Scanner;

public class Customer extends BookInfo {
    private Scanner scanner = new Scanner(System.in);
    private boolean run = true;
    public void runTrue(){
        run = true;
    }
    public void run(){
        System.out.println("[손님]");
        while(run) {
            System.out.println("----------------------------------------------");
            System.out.println("어떤 기능을 이용하실 건가요.");
            System.out.println("1.책 추가 요청하기");
            System.out.println("2.책 빌려가기");
            System.out.println("3.책 목록 확인하기");
            System.out.println("0.손님 모드 종료하기");
            System.out.print("입력 : ");
            try {
                input = scanner.nextInt();
            }catch (Exception e) {
                System.out.println("숫자를 입력안했어요~ 처음 화면으로 돌아갑니다.");
                return;
            }
            switch (input) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    checkBook();;
                    break;
                case 0:
                    run= false;
                    break;
                default:
                    System.out.println("잘못된 입력값입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
    private void addBook() {
        System.out.println("책 추가를 요청합니다.");
        System.out.print("책 이름을 입력해주세요 : ");
        bookName = scanner.next();
        for(int i = 0; i< BookInfo.bookNum; i++){
            if(bookName.equals(BookInfo.bookList.get(i).getBookName())){
                System.out.println("이미 있는 책입니다.");
                return;
            }
        }
        for(int i = 0; i< BookInfo.bookRequest; i++){
            if(bookName.equals(BookInfo.bookPlus.get(i).getBookName())){
                System.out.println("이미 요청받은 책입니다.");
                return;
            }
        }
        BookInfo.bookPlus.add(new Book(bookName,1));
        BookInfo.bookRequest++;
        System.out.println("책을 추가 요청했습니다.");
    } // 책 추가 요청
    private void borrowBook(){
        System.out.println("책 빌리기를 요청합니다.");
        System.out.print("책 이름을 입력해주세요 : ");
        bookName = scanner.next();
        for(int i = 0; i< BookInfo.bookList.size(); i++){
            if(bookName.equals(BookInfo.bookList.get(i).getBookName())){
                System.out.println("저희 도서관에 있는 책입니다. 빌려가세요~");
                System.out.println("책을 빌려갑니다.");
                if(BookInfo.bookList.get(i).getBookCount() > 1){ // 책이 한 권 이상 있을 경우
                    BookInfo.bookList.get(i).minusBookCount();
                    return;
                }else{
                    BookInfo.bookList.remove(BookInfo.bookList.get(i));
                }
                BookInfo.bookNum--;
                return;
            }
        }
        System.out.println("저희 도서관에 없는 책입니다.");
    } // 책 빌리기
}