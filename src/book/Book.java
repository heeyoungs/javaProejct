package book;

public class Book {
    private String bookName;
    private int bookCount;
    public Book(String bookName,int bookCount){
        this.bookName = bookName;
        this.bookCount = bookCount;
    }
    public void minusBookCount() {this.bookCount--;}
    public void plusBookCount(int num){this.bookCount += num;}
    public int getBookCount() {return bookCount;}
    public String getBookName(){
        return bookName;
    }
}
