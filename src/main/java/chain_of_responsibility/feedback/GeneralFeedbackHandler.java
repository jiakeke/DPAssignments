package chain_of_responsibility.feedback;

public class GeneralFeedbackHandler extends Handler {
    @Override
    public void handle(FeedbackMessage feedback) {
        if (feedback.getType() == FeedbackType.GENERAL_FEEDBACK) {
            System.out.println("Handling general feedback: " + feedback.getContent());
            // Process the general feedback
        } else {
            super.handle(feedback);
        }
    }
}
