package regenwormenshared.Models;

import regenwormenshared.DTO.PlayerDTO;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private String username;
    private String password;
    private int numberOfRegenwormen = 0;
    private List<Tile> stack = new ArrayList<>();

    public Player() {

    }

    public Player(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Player Login(String username, String password) {
//        return username.equals("Luuk") && password.equals("Regenwormen123!");
        return new Player();
    }

    public boolean Register(String username, String password) {
        return true;
    }

    public PlayerDTO CreateDTO() { return new PlayerDTO(username, password); }

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

    public int getNumberOfRegenwormen() {
        return numberOfRegenwormen;
    }

    public void setNumberOfRegenwormen(int numberOfRegenwormen) {
        this.numberOfRegenwormen = numberOfRegenwormen;
    }

    public List<Tile> getStack() {
        return stack;
    }

    public void setStack(List<Tile> stack) {
        this.stack = stack;
    }
}
