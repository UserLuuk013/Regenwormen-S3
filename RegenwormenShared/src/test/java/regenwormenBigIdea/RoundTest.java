package regenwormenBigIdea;

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
        RollDiceResult actualResult = round.RollDice(expected);
        int actual = actualResult.getThrownDices().size();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRoundSetAside(){
        // Arrange
        List<Dice> takenDices = new ArrayList<>();
        takenDices.add(new Dice(1, false));
        SetAsideResult setAsideResult = new SetAsideResult(takenDices, new Dice(5, false));
        // Act
        RollDiceResult rollDiceResult = round.RollDice(7);
        SetAsideResult actualResult = round.SetAside(rollDiceResult, setAsideResult);
        int actual = actualResult.getTakenDices().size();
        // Assert
        if (actual == 7){
            testRoundSetAside();
        }
        Assert.assertNotEquals(7, actual);
    }

    @Test
    public void testRoundCheckIfDiceMayBePutAsideReturnsTrue(){
        // Arrange
        List<Dice> takenDices = new ArrayList<>();
        takenDices.add(new Dice(1, false));
        // Act
        boolean actual = round.CheckIfDiceMayBePutAside(takenDices, new Dice(2, false));
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testRoundCheckIfDiceMayBePutAsideReturnsFalse(){
        // Arrange
        List<Dice> takenDices = new ArrayList<>();
        Dice chosenDice = new Dice(1, false);
        takenDices.add(chosenDice);
        // Act
        boolean actual = round.CheckIfDiceMayBePutAside(takenDices, chosenDice);
        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void testRoundEndRound(){
        // Arrange

        // Act
        boolean actual = round.EndRound();
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testRoundTakeTileReturnsNewSizeStack(){
//        // Arrange
//        List<Dice> thrownDices = new ArrayList<>();
//
//        thrownDices.add(new Dice(4, false));
//        thrownDices.add(new Dice(4, false));
//        thrownDices.add(new Dice(5, true));
//        thrownDices.add(new Dice(4, false));
//        thrownDices.add(new Dice(5, false));
//
//        Tile chosenTile = new Tile(21, true);
//
//        List<Tile> chosenStackOrRow = new ArrayList<>();
//        chosenStackOrRow.add(chosenTile);
//
//        List<Tile> stack = new ArrayList<>();
//        // Act
//        boolean actual = round.TakeTile(thrownDices, chosenTile, chosenStackOrRow, stack);
//        // Assert
//        Assert.assertTrue(actual);

        // Arrange
        List<Dice> thrownDices = new ArrayList<>();

        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(5, true));
        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(5, false));

        Tile chosenTile = new Tile(21, true);

        List<Tile> chosenStackOrRow = new ArrayList<>();
        chosenStackOrRow.add(chosenTile);

        List<Tile> stack = new ArrayList<>();

        RollDiceResult rollDiceResult = new RollDiceResult(thrownDices);
        TakeTileResult takeTileResult = new TakeTileResult(chosenTile, chosenStackOrRow, stack);
        // Act
        TakeTileResult actualResult = round.TakeTile(rollDiceResult, takeTileResult);
        // Assert
        Assert.assertEquals(actualResult.getStack().size(), 1);
    }

    @Test
    public void testRoundTakeTileReturnsSameSizeStack(){
//        // Arrange
//        List<Dice> thrownDices = new ArrayList<>();
//
//        thrownDices.add(new Dice(4, false));
//        thrownDices.add(new Dice(5, false));
//        thrownDices.add(new Dice(4, false));
//        thrownDices.add(new Dice(5, false));
//        thrownDices.add(new Dice(5, false));
//
//        Tile chosenTile = new Tile(21, true);
//
//        List<Tile> chosenStackOrRow = new ArrayList<>();
//        chosenStackOrRow.add(chosenTile);
//
//        List<Tile> stack = new ArrayList<>();
//        // Act
//        boolean actual = round.TakeTile(thrownDices, chosenTile, chosenStackOrRow, stack);
//        // Assert
//        Assert.assertFalse(actual);

        // Arrange
        List<Dice> thrownDices = new ArrayList<>();

        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(5, true));
        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(5, false));

        Tile chosenTile = new Tile(24, true);

        List<Tile> chosenStackOrRow = new ArrayList<>();
        chosenStackOrRow.add(chosenTile);

        List<Tile> stack = new ArrayList<>();

        RollDiceResult rollDiceResult = new RollDiceResult(thrownDices);
        TakeTileResult takeTileResult = new TakeTileResult(chosenTile, chosenStackOrRow, stack);
        // Act
        TakeTileResult actualResult = round.TakeTile(rollDiceResult, takeTileResult);
        // Assert
        Assert.assertEquals(actualResult.getStack().size(), 0);
    }

//    @Test
//    public void testRoundTakeTileReturnsFalseOnValue(){
//        // Arrange
//        List<Dice> thrownDices = new ArrayList<>();
//
//        thrownDices.add(new Dice(4, false));
//        thrownDices.add(new Dice(4, false));
//        thrownDices.add(new Dice(5, true));
//        thrownDices.add(new Dice(4, false));
//        thrownDices.add(new Dice(5, false));
//
//        Tile chosenTile = new Tile(28, true);
//
//        List<Tile> chosenStackOrRow = new ArrayList<>();
//        chosenStackOrRow.add(chosenTile);
//
//        List<Tile> stack = new ArrayList<>();
//        // Act
//        boolean actual = round.TakeTile(thrownDices, chosenTile, chosenStackOrRow, stack);
//        // Assert
//        Assert.assertFalse(actual);
//    }

    @Test
    public void testRoundReturnTile(){
        // Arrange
        List<Tile> row = new ArrayList<>();
        List<Tile> stack = new ArrayList<>();
        stack.add(new Tile(28, true));
        ReturnTileResult returnTileResult = new ReturnTileResult(row, stack);
        // Act
        ReturnTileResult actualResult = round.ReturnTile(returnTileResult);
        // Assert
        Assert.assertEquals(1, actualResult.getRow().size());
    }
}
