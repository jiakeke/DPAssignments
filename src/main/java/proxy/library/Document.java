package proxy.library;

import java.nio.file.AccessDeniedException;
import java.util.Date;

public interface Document {
    int getId();
    Date getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}
