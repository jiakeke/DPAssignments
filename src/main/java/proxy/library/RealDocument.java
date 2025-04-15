package proxy.library;

import java.util.Date;

public class RealDocument implements Document{
    private int id;
    private Date creationDate;
    private String content;

    public RealDocument(int id, Date creationDate, String content) {
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
    public String getContent(User user) {
        return content;
    }
}
