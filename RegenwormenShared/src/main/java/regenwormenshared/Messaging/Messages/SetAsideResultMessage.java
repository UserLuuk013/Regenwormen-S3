package regenwormenshared.Messaging.Messages;

import regenwormenshared.Results.SetAsideResult;

public class SetAsideResultMessage {

    private SetAsideResult setAsideResult;

    public SetAsideResult getSetAsideResult() {
        return setAsideResult;
    }

    public SetAsideResultMessage(SetAsideResult setAsideResult) {
        this.setAsideResult = setAsideResult;
    }
}
