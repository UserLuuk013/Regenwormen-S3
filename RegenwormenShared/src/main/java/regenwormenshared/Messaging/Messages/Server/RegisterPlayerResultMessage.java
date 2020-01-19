package regenwormenshared.messaging.messages.server;

public class RegisterPlayerResultMessage {

    private boolean result;

    public boolean isResult() {
        return result;
    }

    public RegisterPlayerResultMessage(boolean result) {
        this.result = result;
    }
}
