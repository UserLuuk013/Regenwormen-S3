package regenwormenshared.messaging.messages.Server;

public class GameEndedResultMessage {

    private int scorePlayer1;
    private int scorePlayer2;
    private boolean draw;

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public boolean isDraw() {
        return draw;
    }

    public GameEndedResultMessage(int scorePlayer1, int scorePlayer2, boolean draw) {
        this.scorePlayer1 = scorePlayer1;
        this.scorePlayer2 = scorePlayer2;
        this.draw = draw;
    }
}
