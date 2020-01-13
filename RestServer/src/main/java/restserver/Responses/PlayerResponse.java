package restserver.Responses;

import regenwormenshared.DTO.PlayerDTO;

import java.util.Collections;
import java.util.List;

public class PlayerResponse {
    private boolean success;
    private PlayerDTO player;
    private List<PlayerDTO> players;

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public PlayerDTO getPlayer() { return player; }

    public void setPlayer(PlayerDTO player) { this.player = player; }

    public List<PlayerDTO> getPlayers()
    {
        List<PlayerDTO> unmodifiablePlayerList = Collections.unmodifiableList(players);
        return unmodifiablePlayerList;
    }

}
