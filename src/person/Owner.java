package person;

import book.Book;
import book.BookInfo;
import book.BookSort;
import java.util.Collections;
import java.lang.System;
import java.util.Scanner;

public class Owner extends BookInfo {
    private Scanner scanner = new Scanner(System.in);
    private int passwordCount = 0;
    private final static String password = "1234";
    private String inputPassword;
    private boolean run = true;
    public void runTrue(){
        run = true;
    }
    public void run(){
        System.out.print("비밀번호를 입력해주세요, 3회 틀리면 종료됩니다. : ");
        for(int i=1;i<=3;i++) {
            inputPassword = scanner.next();
            if (inputPassword.equals(password)){
                System.out.println("[관리자]");
                while(run) {
                    System.out.println("----------------------------------------------");
                    System.out.println("어떤 기능을 이용하실 건가요.");
                    System.out.println("1.책 추가하기");
                    System.out.println("2.추가 요청 받은 책 확인 및 추가하기");
                    System.out.println("3.책 제거하기");
                    System.out.println("4.도서관의 책 목록 확인하기");
                    System.out.println("5.책 정리하기");
                    System.out.println("0.관리자 모드 종료하기");
                    System.out.print("입력 : ");
                    try {
                        input = scanner.nextInt();
                    }catch (Exception e){
                        System.out.println("숫자를 입력안했어요~ 처음 화면으로 돌아갑니다.");
                        return;
                    }
                    switch (input){
                        case 1:
                            addBook();
                            break;
                        case 2:
                            addBook2();;
                            break;
                        case 3:
                            removeBook();
                            break;
                        case 4:
                            checkBook();
                            break;
                        case 5:
                            Collections.sort(BookInfo.bookList,new BookSort());
                            System.out.println("책을 가나다 순으로 정리합니다.");
                            break;
                        case 0:
                            run = false;
                            break;
                        default:
                            System.out.println("잘못된 입력값입니다. 다시 입력해주세요.");
                            break;
                    }
                }
                break;
            }
            else{
                if (passwordCount==2){
                    System.out.println("비밀번호를 3회 틀려서 프로그램이 종료됩니다.");
                    System.exit(1);
                }
                System.out.print("비밀번호를 " + i + "번 만큼 틀렸습니다. 다시 입력해 주세요 : ");
                passwordCount++;
            }
        }
    }
    private void addBook(){
        System.out.println("책을 추가하려고 합니다.");
        System.out.print("책 이름을 입력해주세요 : ");
        bookName = scanner.next();
        System.out.print("몇 권 추가하실 건가요 : ");
        int Count = scanner.nextInt();
        for(int i = 0; i< BookInfo.bookNum; i++){
            if(bookName.equals(BookInfo.bookList.get(i).getBookName())){
                BookInfo.bookList.get(i).plusBookCount(Count);
                System.out.println("책이 " + Count + "권 추가되었습니다.");
                return;
            }
        }
        BookInfo.bookList.add(new Book(bookName,Count));
        BookInfo.bookNum++;
        System.out.println("책이 " + Count + "권 추가되었습니다.");
    } // 직접 추가
    private void addBook2(){
        System.out.println("추가 요청받은 책을 확인합니다.");
        if(BookInfo.bookPlus.size()==0){
            System.out.println("요청받은 책이 없습니다.");
            return;
        }
        for(int i = 0; i< BookInfo.bookRequest; i++){
            System.out.println("책 이름 : " + BookInfo.bookPlus.get(i).getBookName());
        }
        System.out.print("책을 추가하려면 yes, 아니면 아무거나 입력해주세요 : ");
        String yesOrNo = scanner.next();
        if(yesOrNo.equals("yes")){
            System.out.println("요청 받은 책들을 추가합니다.");
            for (int i = 0; i < BookInfo.bookRequest; i++) {
                for(int j = 0; j< BookInfo.bookNum; j++) {
                    if(BookInfo.bookPlus.get(i).getBookName().equals(BookInfo.bookList.get(j).getBookName())){
                        BookInfo.bookList.get(j).plusBookCount(1);
                        BookInfo.bookPlus.remove(BookInfo.bookPlus.get(i));
                        BookInfo.bookRequest--;
                        continue;
                    }
                }
                BookInfo.bookList.add(BookInfo.bookPlus.get(i));
            }
            BookInfo.bookNum+= BookInfo.bookRequest;
            BookInfo.bookPlus.clear();
            BookInfo.bookRequest=0;
        }
        else{
            System.out.println("요청 받은 책들을 추가하지 않습니다.");
        }
    } // 요청받은 책 추가
    private void removeBook(){
        System.out.println("책을 제거하려고 합니다.");
        System.out.print("책 이름을 입력해주세요 : ");
        bookName = scanner.next();
        for(int i = 0; i< BookInfo.bookNum; i++){
            if(bookName.equals(BookInfo.bookList.get(i).getBookName())){
                System.out.println("책을 버립니다.");
                BookInfo.bookList.remove(BookInfo.bookList.get(i));
                BookInfo.bookNum--;
                return;
            }
        }
        System.out.println("없는 책입니다.");
    } // 책 제거
}
