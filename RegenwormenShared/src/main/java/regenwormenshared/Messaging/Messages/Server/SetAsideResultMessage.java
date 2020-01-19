package regenwormenshared.messaging.messages.server;

import regenwormenshared.results.SetAsideResult;

public class SetAsideResultMessage {

    private SetAsideResult setAsideResult;

    public SetAsideResult getSetAsideResult() {
        return setAsideResult;
    }

    public SetAsideResultMessage(SetAsideResult setAsideResult) {
        this.setAsideResult = setAsideResult;
    }
}
