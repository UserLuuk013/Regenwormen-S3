package regenwormenshared.Results;

import regenwormenshared.Models.Tile;

import java.util.List;

public class ReturnTileResult implements GameResult{
    private List<Tile> row;
    private List<Tile> stack;

    public ReturnTileResult(List<Tile> row, List<Tile> stack){
        this.row = row;
        this.stack = stack;
    }

    public List<Tile> getRow() {
        return row;
    }

    public void setRow(List<Tile> row) {
        this.row = row;
    }

    public List<Tile> getStack() {
        return stack;
    }

    public void setStack(List<Tile> stack) {
        this.stack = stack;
    }
}
