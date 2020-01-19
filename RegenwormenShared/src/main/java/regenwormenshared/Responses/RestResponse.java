package regenwormenshared.responses;

import regenwormenshared.dto.PlayerDTO;

public class RestResponse {
    private boolean success;
    private PlayerDTO player;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }
}
