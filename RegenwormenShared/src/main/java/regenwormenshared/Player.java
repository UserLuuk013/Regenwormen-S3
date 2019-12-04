package regenwormenshared;

import java.util.ArrayList;

public class Player {
    private String username;
    private String password;
    private int numberOfRegenwormen = 0;
    private ArrayList<Tile> stack = new ArrayList<>();

    public Player() {

    }

    public boolean Login(String username, String password) {
        if (username == "Luuk" && password == "Regenwormen123!"){
            return true;
        }
        return false;
    }

    public boolean Register(String username, String password) {
        return true;
    }
}
