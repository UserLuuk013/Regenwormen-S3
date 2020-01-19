package regenwormenshared.messaging.messages.server;

import regenwormenshared.results.TakeTileResult;

public class TakeTileResultMessage {

    private TakeTileResult takeTileResult;

    public TakeTileResult getTakeTileResult() {
        return takeTileResult;
    }

    public TakeTileResultMessage(TakeTileResult takeTileResult) {
        this.takeTileResult = takeTileResult;
    }
}
