package proxy.library;

import java.nio.file.AccessDeniedException;
import java.util.Date;

public class DocumentProxy implements Document {
    private RealDocument realDocument;
    private int id;
    private Date creationDate;
    private String content;

    public DocumentProxy(int id, Date creationDate,  String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (realDocument == null) {
            realDocument = new RealDocument(id, creationDate, content);
        }
        AccessControlService acs = AccessControlService.getInstance();
        if (!acs.isAllowed(this, user)) {
            throw new AccessDeniedException("Access Denied");
        }
        return realDocument.getContent(user);
    }
}
