package regenwormenshared;

import java.util.ArrayList;

public class Spelronde {
    private ArrayList<Tegel> rij;
    private ArrayList<Speler> spelers;
    private boolean singlePlayer;
    private String aanzet;
    private ArrayList<Dobbelsteen> dobbelstenen;
    private ArrayList<Dobbelsteen> afgelegdeDobbelstenen;

    public Spelronde(ArrayList<Tegel> rij, ArrayList<Speler> spelers, boolean singlePlayer, String aanzet, ArrayList<Dobbelsteen> dobbelstenen, ArrayList<Dobbelsteen> afgelegdeDobbelstenen){
        this.rij = rij;
        this.spelers = spelers;
        this.singlePlayer = singlePlayer;
        this.aanzet = aanzet;
        this.dobbelstenen = dobbelstenen;
        this.afgelegdeDobbelstenen = afgelegdeDobbelstenen;
    }

    public ArrayList<Tegel> getRij() {
        return rij;
    }

    public void setRij(ArrayList<Tegel> rij) {
        this.rij = rij;
    }

    public ArrayList<Speler> getSpelers() {
        return spelers;
    }

    public void setSpelers(ArrayList<Speler> spelers) {
        this.spelers = spelers;
    }

    public boolean isSinglePlayer() {
        return singlePlayer;
    }

    public void setSinglePlayer(boolean singlePlayer) {
        this.singlePlayer = singlePlayer;
    }

    public String getAanzet() {
        return aanzet;
    }

    public void setAanzet(String aanzet) {
        this.aanzet = aanzet;
    }

    public ArrayList<Dobbelsteen> getDobbelstenen() {
        return dobbelstenen;
    }

    public void setDobbelstenen(ArrayList<Dobbelsteen> dobbelstenen) {
        this.dobbelstenen = dobbelstenen;
    }

    public ArrayList<Dobbelsteen> getAfgelegdeDobbelstenen() {
        return afgelegdeDobbelstenen;
    }

    public void setAfgelegdeDobbelstenen(ArrayList<Dobbelsteen> afgelegdeDobbelstenen) {
        this.afgelegdeDobbelstenen = afgelegdeDobbelstenen;
    }
}
