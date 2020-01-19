package regenwormenshared.messaging.messages.Server;

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
