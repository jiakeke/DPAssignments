package chain_of_responsibility.feedback;

public class DevelopmentSuggestionHandler extends Handler {
    @Override
    public void handle(FeedbackMessage feedback) {
        if (feedback.getType() == FeedbackType.DEVELOPMENT_SUGGESTION) {
            System.out.println("Handling development suggestion: " + feedback.getContent());
            // Process the development suggestion
        } else {
            super.handle(feedback);
        }
    }

}
