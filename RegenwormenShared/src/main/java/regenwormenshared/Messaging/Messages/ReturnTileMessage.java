package regenwormenshared.Messaging.Messages;

import regenwormenshared.Results.ReturnTileResult;

public class ReturnTileMessage {

    private ReturnTileResult returnTileResult;

    public ReturnTileResult getReturnTileResult() {
        return returnTileResult;
    }

    public ReturnTileMessage(ReturnTileResult returnTileResult) {
        this.returnTileResult = returnTileResult;
    }
}
