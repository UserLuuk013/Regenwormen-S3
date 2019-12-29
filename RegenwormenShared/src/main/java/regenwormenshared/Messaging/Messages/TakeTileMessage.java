package regenwormenshared.Messaging.Messages;

import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

public class TakeTileMessage {

    private SetAsideResult setAsideResult;

    private TakeTileResult takeTileResult;

    public SetAsideResult getSetAsideResult() {
        return setAsideResult;
    }

    public TakeTileResult getTakeTileResult() {
        return takeTileResult;
    }

    public TakeTileMessage(SetAsideResult setAsideResult, TakeTileResult takeTileResult) {
        this.setAsideResult = setAsideResult;
        this.takeTileResult = takeTileResult;
    }
}
