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

    public ArrayList<Dobbelsteen> Afleggen(ArrayList<Dobbelsteen> geworpenDobbelstenen, ArrayList<Dobbelsteen> afgelegdeDobbelstenen, Dobbelsteen gekozenDobbelsteen) {
        ArrayList<Dobbelsteen> toRemove = new ArrayList<>();
        for (Dobbelsteen afgelegdeDobbelsteen : afgelegdeDobbelstenen){
            if (afgelegdeDobbelsteen.getWaarde() != gekozenDobbelsteen.getWaarde() || afgelegdeDobbelsteen.getRegenworm() != gekozenDobbelsteen.getRegenworm()){
                for (Dobbelsteen geworpenDobbelsteen : geworpenDobbelstenen){
                    if (geworpenDobbelsteen.getWaarde() == gekozenDobbelsteen.getWaarde() && geworpenDobbelsteen.getRegenworm() == gekozenDobbelsteen.getRegenworm()){
                        toRemove.add(geworpenDobbelsteen);
                    }
                }
                geworpenDobbelstenen.removeAll(toRemove);
            }
        }
        return geworpenDobbelstenen;
    }

    public boolean CheckIfDobbelsteenMagAfleggen(ArrayList<Dobbelsteen> afgelegdeDobbelstenen, int waarde){
        for (Dobbelsteen dobbelsteen : afgelegdeDobbelstenen){
            if (dobbelsteen.getWaarde() == waarde){
                return false;
            }
        }
        return true;
    }

    public boolean Beëindigen() {
        return true;
    }

    public boolean CheckIfTegelIsNeembaar(int worpresultaat, int aantalregenwormen) {
        if (aantalregenwormen > 0){
            if (worpresultaat > 21){
                return true;
            }
        }
        return false;
    }

    public boolean Inleveren() {
        return true;
    }
}
