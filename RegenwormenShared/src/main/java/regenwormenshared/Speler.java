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
        if (CheckIfMagDobbelen(aantal)){
            Worp worp = new Worp();
            return worp.GenereerWorp(aantal);
        }
        // return null solve.
        return null;
    }

    public boolean CheckIfMagDobbelen(int aantal){
        if (aantal > 0){
            return true;
        }
        return false;
    }

    public ArrayList<Dobbelsteen> Afleggen(ArrayList<Dobbelsteen> geworpenDobbelstenen, ArrayList<Dobbelsteen> afgelegdeDobbelstenen, Dobbelsteen gekozenDobbelsteen) {
        ArrayList<Dobbelsteen> gekozenDobbelstenen = new ArrayList<>();
        if (CheckIfDobbelsteenMagAfleggen(afgelegdeDobbelstenen, gekozenDobbelsteen)){
            for (Dobbelsteen geworpenDobbelsteen : geworpenDobbelstenen){
                if (geworpenDobbelsteen.getWaarde() == gekozenDobbelsteen.getWaarde() && geworpenDobbelsteen.getRegenworm() == gekozenDobbelsteen.getRegenworm()){
                    gekozenDobbelstenen.add(geworpenDobbelsteen);
                }
            }
            afgelegdeDobbelstenen.addAll(gekozenDobbelstenen);
            geworpenDobbelstenen.removeAll(gekozenDobbelstenen);
        }
        return geworpenDobbelstenen;
        // Returning multiple items -> Class?
    }

    public boolean CheckIfDobbelsteenMagAfleggen(ArrayList<Dobbelsteen> afgelegdeDobbelstenen, Dobbelsteen gekozenDobbelsteen){
        if (!afgelegdeDobbelstenen.contains(gekozenDobbelsteen)){
            return true;
        }
        return false;
    }

    public boolean Beëindigen() {
        return true;
    }

    public boolean Nemen(ArrayList<Dobbelsteen> geworpenDobbelstenen, Tegel gekozenTegel) {
        int waarde = 0;
        for (Dobbelsteen dobbelsteen : geworpenDobbelstenen){
            waarde += dobbelsteen.getWaarde();
        }
        for (Dobbelsteen dobbelsteen : geworpenDobbelstenen){
            if (waarde >= gekozenTegel.getWaarde() && dobbelsteen.getRegenworm()){
                return true;
            }
        }
        return false;
        // Returning multiple items -> Class?
    }

    public ArrayList<Tegel> Inleveren(ArrayList<Tegel> rij, ArrayList<Tegel> stapel) {
        Tegel tegel = stapel.get(0);
        if ((rij.size() - 1) != tegel.getWaarde()){
            tegel.setZichtbaar(false);
        }
        stapel.remove(tegel);
        rij.add(tegel);
        return rij;
        // Returning multiple items -> Class?
    }
}
