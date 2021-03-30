package book;

import java.util.ArrayList;
import java.util.List;

public class BookInfo {
    protected static int bookNum = 3;
    protected static int bookRequest = 0;
    protected String bookName;
    protected int input;
    public static List<Book> bookList = new ArrayList<>(1000);
    public static List<Book> bookPlus = new ArrayList<>(1000);
    protected void checkBook(){
        System.out.println("책 목록을 확인합니다.");
        for(int i=0;i<bookNum;i++) {
            System.out.println( bookList.get(i).getBookName() + " " + bookList.get(i).getBookCount() + "권" );
        }
    }
}
