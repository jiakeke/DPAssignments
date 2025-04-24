package prototype.books;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Prototype{
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }
    @Override
    public Prototype clone() {
        Recommendation clonedRecommendation = new Recommendation(targetAudience);
        for (Book book : books) {
            clonedRecommendation.addBook(book);
        }
        return clonedRecommendation;
    }

    @Override
    public String toString() {
        String booksList = "";
        for (Book book : books) {
            booksList += book.toString() + ", ";
        }
        return "Recommendation for " + targetAudience + ", Books(" + books.size() + "): " + booksList;
    }
}
