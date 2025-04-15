package proxy.library;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Document> documents;
    private int documentCount;

    public Library() {
        documents = new HashMap<>();
        documentCount = 0;
    }

    public Document addDocument(String content) {
        int id = documentCount + 1; // Simple ID generation
        Document document = new RealDocument(id, new Date(), content);
        documents.put(id, document);
        documentCount++;
        return document;
    }

    public Document addProtectedDocument(String content) {
        int id = documentCount + 1; // Simple ID generation
        Document document = new DocumentProxy(id, new Date(), content);
        documents.put(id, document);
        documentCount++;
        return document;
    }
}
