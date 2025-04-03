package chain_of_responsibility.feedback;

public abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(FeedbackMessage feedback) {
        if (nextHandler != null) {
            nextHandler.handle(feedback);
        } else {
            System.out.println("No handler available for this feedback.");
        }
    }
}
