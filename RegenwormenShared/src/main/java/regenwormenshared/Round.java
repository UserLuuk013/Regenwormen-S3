package regenwormenshared;

import java.util.ArrayList;

public class Round {
    private ArrayList<Tile> row;
    private ArrayList<Player> players;
    private boolean singlePlayer;
    private String turn;
    private ArrayList<Dice> dices;
    private ArrayList<Dice> takenDices;

    public Round(ArrayList<Tile> row, ArrayList<Player> players, boolean singlePlayer, String turn,
                 ArrayList<Dice> dices, ArrayList<Dice> takenDices){
        this.row = row;
        this.players = players;
        this.singlePlayer = singlePlayer;
        this.turn = turn;
        this.dices = dices;
        this.takenDices = takenDices;
    }

    public Round(){

    }

    public ArrayList<Dice> RollDice(int numberOfDices) {
        DiceThrow diceThrow = new DiceThrow();
        return diceThrow.GenerateDiceThrow(numberOfDices);
    }

    public ArrayList<Dice> SetAside(ArrayList<Dice> thrownDices, ArrayList<Dice> takenDices, Dice chosenDice) {
        ArrayList<Dice> chosenDices = new ArrayList<>();
        if (CheckIfDiceMayBePutAside(takenDices, chosenDice)){
            for (Dice thrownDice : thrownDices){
                if (thrownDice.getValue() == chosenDice.getValue() && thrownDice.getRegenworm() == chosenDice.getRegenworm()){
                    chosenDices.add(thrownDice);
                }
            }
            takenDices.addAll(chosenDices);
            thrownDices.removeAll(chosenDices);
        }
        return thrownDices;
        // Returning multiple items -> Class?
    }

    public boolean CheckIfDiceMayBePutAside(ArrayList<Dice> takenDices, Dice chosenDice){
        if (!takenDices.contains(chosenDice)){
            return true;
        }
        return false;
    }

    public boolean EndRound() {
        return true;
    }

    public boolean TakeTile(ArrayList<Dice> thrownDices, Tile chosenTile) {
        int value = 0;
        for (Dice dice : thrownDices){
            value += dice.getValue();
        }
        for (Dice dice : thrownDices){
            if (value >= chosenTile.getValue() && dice.getRegenworm()){
                return true;
            }
        }
        return false;
        // Returning multiple items -> Class?
    }

    public ArrayList<Tile> ReturnTile(ArrayList<Tile> row, ArrayList<Tile> stack) {
        Tile tile = stack.get(0);
        if ((row.size() - 1) != tile.getValue()){
            tile.setVisible(false);
        }
        stack.remove(tile);
        row.add(tile);
        return row;
        // Returning multiple items -> Class?
    }
}
