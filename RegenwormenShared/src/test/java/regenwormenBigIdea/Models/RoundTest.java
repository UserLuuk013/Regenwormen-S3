package regenwormenBigIdea.Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Round;
import regenwormenshared.Models.Tile;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

import java.util.ArrayList;
import java.util.List;

public class RoundTest {

    private Round round;

    @Before
    public void before(){
        round = new Round();
    }

    @Test
    public void testRoundRollDice(){
        // Arrange
        int expected = 8;
        // Act
        RollDiceResult actualResult = round.rollDice(expected);
        int actual = actualResult.getThrownDices().size();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRoundSetAside(){
        // Arrange
        int expected = 7;
        List<Dice> takenDices = new ArrayList<>();
        takenDices.add(new Dice(1, "image.jpg",false));
        SetAsideResult setAsideResult = new SetAsideResult(takenDices, new Dice(5, "image.jpg",false));
        // Act
        RollDiceResult rollDiceResult = round.rollDice(expected);
        SetAsideResult actualResult = round.setAside(rollDiceResult, setAsideResult);
        int actual = actualResult.getTakenDices().size();
        // Assert
        if (actual == expected){
            testRoundSetAside();
        }
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void testRoundCheckIfDiceMayBePutAsideReturnsTrue(){
        // Arrange
        List<Dice> takenDices = new ArrayList<>();
        takenDices.add(new Dice(1, "image.jpg",false));
        // Act
        boolean actual = round.checkIfDiceMayBePutAside(takenDices, new Dice(2, "image.jpg",false));
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testRoundCheckIfDiceMayBePutAsideReturnsFalse(){
        // Arrange
        List<Dice> takenDices = new ArrayList<>();
        Dice chosenDice = new Dice(1, "image.jpg",false);
        takenDices.add(chosenDice);
        // Act
        boolean actual = round.checkIfDiceMayBePutAside(takenDices, chosenDice);
        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void testRoundEndRound(){
        // Arrange

        // Act
        boolean actual = round.endRound();
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testRoundTakeTileEnoughValue(){
        // Arrange
        int expectedStackSize = 1;
        int expectedStackOrRowSize = 0;
        List<Dice> takenDices = new ArrayList<>();

        takenDices.add(new Dice(4, "image.jpg",false));
        takenDices.add(new Dice(4, "image.jpg",false));
        takenDices.add(new Dice(5, "image.jpg",true));
        takenDices.add(new Dice(4, "image.jpg",false));
        takenDices.add(new Dice(5, "image.jpg",false));

        Tile chosenTile = new Tile(21, "image.jpg", 1);

        List<Tile> chosenStackOrRow = new ArrayList<>();
        chosenStackOrRow.add(chosenTile);

        List<Tile> stack = new ArrayList<>();

        SetAsideResult setAsideResult = new SetAsideResult(takenDices, new Dice(4, "image.jpg", false));
        TakeTileResult takeTileResult = new TakeTileResult(chosenTile, chosenStackOrRow, stack);
        // Act
        TakeTileResult actualResult = round.takeTile(setAsideResult, takeTileResult);
        // Assert
        Assert.assertEquals(expectedStackSize, actualResult.getStack().size());
        Assert.assertEquals(expectedStackOrRowSize, actualResult.getChosenStackOrRow().size());
    }

    @Test
    public void testRoundTakeTileNotEnoughValue(){
        // Arrange
        int expectedStackSize = 0;
        int expectedStackOrRowSize = 1;
        List<Dice> takenDices = new ArrayList<>();

        takenDices.add(new Dice(4, "image.jpg",false));
        takenDices.add(new Dice(4, "image.jpg",false));
        takenDices.add(new Dice(5, "image.jpg",true));
        takenDices.add(new Dice(4, "image.jpg",false));
        takenDices.add(new Dice(5, "image.jpg",false));

        Tile chosenTile = new Tile(24, "image.jpg", 1);

        List<Tile> chosenStackOrRow = new ArrayList<>();
        chosenStackOrRow.add(chosenTile);

        List<Tile> stack = new ArrayList<>();

        SetAsideResult setAsideResult = new SetAsideResult(takenDices, new Dice(4, "image.jpg", false));
        TakeTileResult takeTileResult = new TakeTileResult(chosenTile, chosenStackOrRow, stack);
        // Act
        TakeTileResult actualResult = round.takeTile(setAsideResult, takeTileResult);
        // Assert
        Assert.assertEquals(expectedStackSize, actualResult.getStack().size());
        Assert.assertEquals(expectedStackOrRowSize, actualResult.getChosenStackOrRow().size());
    }

    @Test
    public void testRoundReturnTileHighestValue(){
        // Arrange
        List<Tile> row = new ArrayList<>();
        List<Tile> stack = new ArrayList<>();
        row.add(new Tile(27, "image.jpg", 2));
        stack.add(new Tile(28, "image,jpg", 1));
        ReturnTileResult returnTileResult = new ReturnTileResult(row, stack);
        // Act
        ReturnTileResult actualResult = round.returnTile(returnTileResult);
        // Assert
        Assert.assertTrue(actualResult.getRow().get(1).isVisible());
    }

    @Test
    public void testRoundReturnTileLowerValueThanHighestValueRow(){
        // Arrange
        List<Tile> row = new ArrayList<>();
        List<Tile> stack = new ArrayList<>();
        row.add(new Tile(27, "image.jpg", 2));
        stack.add(new Tile(26, "image.jpg", 2));
        ReturnTileResult returnTileResult = new ReturnTileResult(row, stack);
        // Act
        ReturnTileResult actualResult = round.returnTile(returnTileResult);
        // Assert
        Assert.assertFalse(actualResult.getRow().get(1).isVisible());
    }
}
