package restserver.interfaces;

import regenwormenshared.models.Player;

public interface IPlayerContext {
    Player login(String username, String password);
    boolean register(String username, String password);
}
