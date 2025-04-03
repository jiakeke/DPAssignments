package chain_of_responsibility.feedback;

enum FeedbackType {
    COMPENSATION_CLAIM, CONTACT_REQUEST, DEVELOPMENT_SUGGESTION, GENERAL_FEEDBACK
}

public class FeedbackMessage {
    private FeedbackType type;
    private String content;
    private String senderEmail;

    public FeedbackMessage(FeedbackType type, String content, String senderEmail) {
        this.type = type;
        this.content = content;
        this.senderEmail = senderEmail;
    }

    public String getContent() {
        return content;
    }

    public FeedbackType getType() {
        return type;
    }

    public String getSenderEmail() {
        return senderEmail;
    }


}
