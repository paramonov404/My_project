package PR_3_Java;

public class Book {
    private String author;
    private String name;
    private int yearOfWriting;

    public String toString(){
        return "Book " + getName() + " was writing by "
                + getAuthor() + " in " + getYearOfWriting() + " year.";

    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfWriting(int yearOfWriting) {
        this.yearOfWriting = yearOfWriting;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getYearOfWriting() {
        return yearOfWriting;
    }
}
