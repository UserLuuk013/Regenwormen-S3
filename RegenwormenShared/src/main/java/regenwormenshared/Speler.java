package regenwormenshared;

import java.util.ArrayList;

public class Speler {
    private String gebruikersnaam;
    private String wachtwoord;

    public Speler() {

    }

    public boolean Inloggen(String gebruikersnaam, String wachtwoord) {
        if (gebruikersnaam == "Luuk" && wachtwoord == "Regenwormen123!"){
            return true;
        }
        return false;
    }

    public boolean Registreren(String gebruikersnaam, String wachtwoord) {
        return true;
    }

    public ArrayList<Dobbelsteen> Dobbelen(int aantal) {
        Worp worp = new Worp();
        ArrayList<Dobbelsteen> geworpenDobbelstenen = worp.GenereerWorp(aantal);
        return geworpenDobbelstenen;
    }

    public ArrayList<Dobbelsteen> Afleggen(ArrayList<Dobbelsteen> dobbelstenen, int waarde) {
        for (Dobbelsteen dobbelsteen : dobbelstenen){
            if (dobbelsteen.getWaarde() == waarde){
                dobbelstenen.remove(dobbelsteen);
            }
        }
        return dobbelstenen;
    }

    public boolean Beëindigen() {
        return true;
    }
}
