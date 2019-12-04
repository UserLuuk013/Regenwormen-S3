package regenwormenshared.Results;

import regenwormenshared.Models.Tile;

import java.util.List;

public class TakeTileResult implements GameResult {
    private Tile chosenTile;
    private List<Tile> chosenStackOrRow;
    private List<Tile> stack;

    public TakeTileResult(Tile chosenTile, List<Tile> chosenStackOrRow, List<Tile> stack){
        this.chosenTile = chosenTile;
        this.chosenStackOrRow = chosenStackOrRow;
        this.stack = stack;
    }

    public Tile getChosenTile() {
        return chosenTile;
    }

    public void setChosenTile(Tile chosenTile) {
        this.chosenTile = chosenTile;
    }

    public List<Tile> getChosenStackOrRow() {
        return chosenStackOrRow;
    }

    public void setChosenStackOrRow(List<Tile> chosenStackOrRow) {
        this.chosenStackOrRow = chosenStackOrRow;
    }

    public List<Tile> getStack() {
        return stack;
    }

    public void setStack(List<Tile> stack) {
        this.stack = stack;
    }
}
