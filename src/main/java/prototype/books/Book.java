package prototype.books;

public class Book implements Prototype {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public Prototype clone() {
        return new Book(title, author);
    }

    @Override
    public String toString() {
        return title + "(" + author +  ")";
    }
}
