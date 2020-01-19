package regenwormenshared.messaging.messages.Server;

public class RegisterPlayerResultMessage {

    private boolean result;

    public boolean isResult() {
        return result;
    }

    public RegisterPlayerResultMessage(boolean result) {
        this.result = result;
    }
}
