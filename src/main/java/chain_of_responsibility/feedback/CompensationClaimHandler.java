package chain_of_responsibility.feedback;

public class CompensationClaimHandler extends Handler {
    @Override
    public void handle(FeedbackMessage feedback) {
        if (feedback.getType() == FeedbackType.COMPENSATION_CLAIM) {
            System.out.println("Handling compensation claim: " + feedback.getContent());
            // Process the compensation claim
        } else {
            super.handle(feedback);
        }
    }
}
