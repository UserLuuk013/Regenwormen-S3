package regenwormenBigIdea.Results;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Models.Tile;
import regenwormenshared.Results.TakeTileResult;

import java.util.ArrayList;
import java.util.List;

public class TakeTileResultTest {

    @Test
    public void testTakeTileResultNotNull(){
        // Arrange
        Tile chosenTile = new Tile(21, "image.jpg", 1);
        List<Tile> chosenStackOrRow = new ArrayList<>();
        List<Tile> stack = new ArrayList<>();
        TakeTileResult takeTileResult = new TakeTileResult(chosenTile, chosenStackOrRow, stack);
        // Act

        // Assert
        Assert.assertNotNull(takeTileResult);
    }

    @Test
    public void testTakeTileResultGetChosenTile(){
        // Arrange
        Tile chosenTile = new Tile(21, "image.jpg", 1);
        List<Tile> chosenStackOrRow = new ArrayList<>();
        List<Tile> stack = new ArrayList<>();
        TakeTileResult takeTileResult = new TakeTileResult(chosenTile, chosenStackOrRow, stack);
        // Act
        Tile actual = takeTileResult.getChosenTile();
        // Assert
        Assert.assertEquals(chosenTile, actual);
    }

    @Test
    public void testTakeTileResultGetChosenStackOrRow(){
        // Arrange
        Tile chosenTile = new Tile(21, "image.jpg", 1);
        List<Tile> chosenStackOrRow = new ArrayList<>();
        List<Tile> stack = new ArrayList<>();
        TakeTileResult takeTileResult = new TakeTileResult(chosenTile, chosenStackOrRow, stack);
        // Act
        List<Tile> actual = takeTileResult.getChosenStackOrRow();
        // Assert
        Assert.assertEquals(chosenStackOrRow, actual);
    }

    @Test
    public void testTakeTileResultGetStack(){
        // Arrange
        Tile chosenTile = new Tile(21, "image.jpg", 1);
        List<Tile> chosenStackOrRow = new ArrayList<>();
        List<Tile> stack = new ArrayList<>();
        TakeTileResult takeTileResult = new TakeTileResult(chosenTile, chosenStackOrRow, stack);
        // Act
        List<Tile> actual = takeTileResult.getStack();
        // Assert
        Assert.assertEquals(stack, actual);
    }
}
