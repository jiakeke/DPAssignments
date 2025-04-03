package chain_of_responsibility.feedback;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create handlers
        Handler primaryHandler;
        Handler compensationClaimHandler = new CompensationClaimHandler();
        Handler contactRequestHandler = new ContactRequestHandler();
        Handler developmentSuggestionHandler = new DevelopmentSuggestionHandler();
        Handler generalFeedbackHandler = new GeneralFeedbackHandler();
        primaryHandler = compensationClaimHandler;

        compensationClaimHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(developmentSuggestionHandler);
        developmentSuggestionHandler.setNextHandler(generalFeedbackHandler);

        // Create feedback messages
        List<FeedbackMessage> messages = Arrays.asList(
            new FeedbackMessage(FeedbackType.COMPENSATION_CLAIM, "Request for compensation", "mike@mike.com"),
            new FeedbackMessage(FeedbackType.CONTACT_REQUEST, "Need to contact support", "jacky@jacky.com"),
            new FeedbackMessage(FeedbackType.DEVELOPMENT_SUGGESTION, "Suggestion for new feature", "rose@rose.com"),
            new FeedbackMessage(FeedbackType.GENERAL_FEEDBACK, "General feedback about the app", "joe@joe.com")
        );

        for (FeedbackMessage message : messages) {
            System.out.println("Processing message from: " + message.getSenderEmail());
            primaryHandler.handle(message);
            System.out.println();
        }

    }


}
