package restserver.repositories;

import regenwormenshared.models.Player;
import restserver.interfaces.IPlayerContext;

public class PlayerRepository {

    private IPlayerContext context;

    public PlayerRepository(IPlayerContext context){
        this.context = context;
    }

    public Player login(String username, String password){
        return context.login(username, password);
    }

    public boolean register(String username, String password){
        return context.register(username, password);
    }
}
