package restserver.Repositories;

import regenwormenshared.Models.Player;
import restserver.Interfaces.IPlayerContext;

public class PlayerRepository {

    private IPlayerContext context;

    public PlayerRepository(IPlayerContext context){
        this.context = context;
    }

    public Player Login(String username, String password){
        return context.Login(username, password);
    }

    public boolean Register(String username, String password){
        return context.Register(username, password);
    }
}
