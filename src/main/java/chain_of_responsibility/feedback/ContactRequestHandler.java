package chain_of_responsibility.feedback;

public class ContactRequestHandler extends Handler {
    @Override
    public void handle(FeedbackMessage feedback) {
        if (feedback.getType() == FeedbackType.CONTACT_REQUEST) {
            System.out.println("Handling contact request: " + feedback.getContent());
            // Process the contact request
        } else {
            super.handle(feedback);
        }
    }
}
