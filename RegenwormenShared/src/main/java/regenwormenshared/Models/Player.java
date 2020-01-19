package regenwormenshared.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private String username;
    private String password;

    private List<Tile> stack = new ArrayList<>();
    private boolean hasTurn;

    public Player() {

    }

    public Player(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Player(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tile> getStack() {
        return stack;
    }

    public void setStack(List<Tile> stack) {
        this.stack = stack;
    }

    public boolean isHasTurn() {
        return hasTurn;
    }

    public void setHasTurn(boolean hasTurn) {
        this.hasTurn = hasTurn;
    }
}
