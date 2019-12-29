package regenwormenshared.Messaging.Messages;

import regenwormenshared.Results.ReturnTileResult;

public class ReturnTileResultMessage {

    private ReturnTileResult returnTileResult;

    public ReturnTileResult getReturnTileResult() {
        return returnTileResult;
    }

    public ReturnTileResultMessage(ReturnTileResult returnTileResult) {
        this.returnTileResult = returnTileResult;
    }
}
