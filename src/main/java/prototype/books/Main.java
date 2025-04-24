package prototype.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a book
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("Brave New World", "Aldous Huxley");
        Book book3 = new Book("Fahrenheit 451", "Ray Bradbury");
        Book book4 = new Book("The Catcher in the Rye", "J.D. Salinger");

        // Create a recommendation for young adults
        Recommendation recommendation = new Recommendation("Young Adults");
        recommendation.addBook(book1);
        recommendation.addBook(book2);
        recommendation.addBook(book3);
        recommendation.addBook(book4);

        List<Recommendation> recommendations = new ArrayList<>();
        recommendations.add(recommendation);


        // get user input from console
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // show a menu to list existing recommendations, add new recommendations, clone and modify them
            System.out.println("==========================");
            System.out.println("Books Recommendation System: ");
            System.out.println("1. List existing recommendations");
            System.out.println("2. Clone and modify a recommendation");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // List existing recommendations with a number
                    System.out.println("Existing recommendations: ");
                    for (int i = 0; i < recommendations.size(); i++) {
                        System.out.println(i+1 + ": " + recommendations.get(i));
                    }
                    break;
                case 2:
                    System.out.println("Enter the number of recommendation to clone: ");
                    int index = scanner.nextInt() - 1; // Adjust for zero-based index
                    scanner.nextLine(); // Consume the newline character
                    if (index < recommendations.size()) {
                        Recommendation clonedRecommendation = (Recommendation) recommendations.get(index).clone();
                        System.out.println("Cloned recommendation: " + clonedRecommendation);
                        System.out.println("Enter new target audience for cloned recommendation: ");
                        String newTargetAudience = scanner.nextLine();
                        if (!newTargetAudience.isEmpty()) {
                            clonedRecommendation.setTargetAudience(newTargetAudience);
                        }
                        recommendations.add(clonedRecommendation);

                        while (true) {
                            System.out.println("There are " + clonedRecommendation.getBooks().size()+ " books in this recommendation:");
                            // List the books in the cloned recommendation with a number
                            for (int i = 0; i < clonedRecommendation.getBooks().size(); i++) {
                                System.out.println(i+1 + ": " + clonedRecommendation.getBooks().get(i));
                            }
                            System.out.println("Do you want to add or remove a book? (add/remove/exit)");
                            String action = scanner.nextLine();
                            if (action.equals("add")) {
                                System.out.println("Enter book title: ");
                                String title = scanner.nextLine();
                                System.out.println("Enter book author: ");
                                String author = scanner.nextLine();
                                Book newBook = new Book(title, author);
                                clonedRecommendation.addBook(newBook);
                                System.out.println("Added book: " + newBook);
                            } else if (action.equals("remove")) {
                                System.out.println("Enter the number of book to remove from cloned recommendation: ");
                                int bookIndex = scanner.nextInt() - 1; // Adjust for zero-based index
                                if (bookIndex < clonedRecommendation.getBooks().size()) {
                                    Book bookToRemove = clonedRecommendation.getBooks().get(bookIndex);
                                    clonedRecommendation.removeBook(bookToRemove);
                                    System.out.println("Removed book: " + bookToRemove);
                                } else {
                                    System.out.println("Invalid index");
                                }
                            } else if (action.equals("exit")) {
                                break;
                            } else {
                                System.out.println("Invalid action");
                            }
                        }

                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
