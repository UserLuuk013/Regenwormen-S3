package regenwormenshared.Messaging.Messages.Server;

import regenwormenshared.Results.TakeTileResult;

public class TakeTileResultMessage {

    private TakeTileResult takeTileResult;

    public TakeTileResult getTakeTileResult() {
        return takeTileResult;
    }

    public TakeTileResultMessage(TakeTileResult takeTileResult) {
        this.takeTileResult = takeTileResult;
    }
}
