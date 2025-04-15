package proxy.library;

import java.nio.file.AccessDeniedException;

public class Main {
    public static void main(String[] args) throws AccessDeniedException {
        // Create a user
        User user1 = new User("John Doe");
        User user2 = new User("Jane Smith");

        // Create a document proxy
        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();
        Document document1 = library.addDocument("This is a public document.");
        Document document2 = library.addProtectedDocument("This is a protected document.");
        Document document3 = library.addProtectedDocument("This is another protected document.");

        acs.grantAccess(document2, user1);
        acs.grantAccess(document3, user2);


        // Access the document through the proxy
        System.out.println("Document ID: " + document1.getId());
        System.out.println("Creation Date: " + document1.getCreationDate());
        System.out.println("Content: " + document1.getContent(user1));


        System.out.println("Document ID: " + document2.getId());
        System.out.println("Creation Date: " + document2.getCreationDate());
        System.out.println("Content: " + document2.getContent(user1));

        System.out.println("Document ID: " + document3.getId());
        System.out.println("Creation Date: " + document3.getCreationDate());
        try {
            System.out.println("Content: " + document3.getContent(user1));
        } catch (AccessDeniedException e) {
            System.out.println("Document "+document3.getId() +" Access Denied for user1");
        }
        try {
            System.out.println("Content: " + document3.getContent(user2));
        } catch (AccessDeniedException e) {
            System.out.println("Access Denied for user2");
        }
    }
}
