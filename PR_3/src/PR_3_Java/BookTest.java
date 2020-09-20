package PR_3_Java;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("What");
        book.setAuthor("Who");
        book.setYearOfWriting(2020);
        System.out.println(book.toString());
    }
}
