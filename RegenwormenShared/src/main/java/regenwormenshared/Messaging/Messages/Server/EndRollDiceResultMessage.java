package regenwormenshared.Messaging.Messages.Server;

public class EndRollDiceResultMessage {

    private boolean result;

    public boolean isResult() {
        return result;
    }

    public EndRollDiceResultMessage(boolean result) {
        this.result = result;
    }
}
