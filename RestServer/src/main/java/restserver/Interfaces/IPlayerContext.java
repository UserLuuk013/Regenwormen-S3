package restserver.Interfaces;

import regenwormenshared.Models.Player;

public interface IPlayerContext {
    Player Login(String username, String password);
    boolean Register(String username, String password);
}
