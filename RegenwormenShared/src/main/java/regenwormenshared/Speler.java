package regenwormenshared;

import java.util.ArrayList;

public class Speler {
    private String username;
    private String password;
    private int score;
    private int aantalRegenwormen;
    private ArrayList<Dobbelsteen> stapel;

    public Speler(String username, String password, int score, int aantalRegenwormen, ArrayList<Dobbelsteen> stapel){
        this.username = username;
        this.password = password;
        this.score = score;
        this.aantalRegenwormen = aantalRegenwormen;
        this.stapel = stapel;
    }

    public Speler Inloggen(String username, String password){
        return null;
    }

    public boolean Registreren(String username, String password){
        return false;
    }

    public void Dobbelen(ArrayList<Dobbelsteen> dobbelstenen){

    }

    public void Afleggen(ArrayList<Dobbelsteen> dobbelstenen, ArrayList<Dobbelsteen> afgelegdeDobbelstenen, Dobbelsteen dobbelsteen){

    }

    public void Beëindigen(){

    }

    public void Nemen(ArrayList<Tegel> rij, ArrayList<Tegel> stapel, Tegel tegel){

    }

    public void Inleveren(ArrayList<Tegel> rij, ArrayList<Tegel> stapel, Tegel tegel){

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAantalRegenwormen() {
        return aantalRegenwormen;
    }

    public void setAantalRegenwormen(int aantalRegenwormen) {
        this.aantalRegenwormen = aantalRegenwormen;
    }

    public ArrayList<Dobbelsteen> getStapel() {
        return stapel;
    }

    public void setStapel(ArrayList<Dobbelsteen> stapel) {
        this.stapel = stapel;
    }
}
