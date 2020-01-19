package regenwormenshared.messaging.messages.server;

import regenwormenshared.results.ReturnTileResult;

public class ReturnTileResultMessage {

    private ReturnTileResult returnTileResult;

    public ReturnTileResult getReturnTileResult() {
        return returnTileResult;
    }

    public ReturnTileResultMessage(ReturnTileResult returnTileResult) {
        this.returnTileResult = returnTileResult;
    }
}
