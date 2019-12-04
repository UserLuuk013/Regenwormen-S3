package regenwormenBigIdea;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import regenwormenshared.Dice;
import regenwormenshared.Round;
import regenwormenshared.Tile;

import java.util.ArrayList;

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
        ArrayList<Dice> actualList = round.RollDice(8);
        int actual = actualList.size();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRoundSetAside(){
        // Arrange
        ArrayList<Dice> takenDices = new ArrayList<>();
        takenDices.add(new Dice(1, false));
        // Act
        ArrayList<Dice> thrownDices = round.RollDice(7);
        ArrayList<Dice> actualList = round.SetAside(thrownDices, takenDices, new Dice(5, false));
        int actual = actualList.size();
        // Assert
        if (actual == 7){
            testRoundSetAside();
        }
        Assert.assertNotEquals(7, actual);
    }

    @Test
    public void testRoundCheckIfDiceMayBePutAsideReturnsTrue(){
        // Arrange
        ArrayList<Dice> takenDices = new ArrayList<>();
        takenDices.add(new Dice(1, false));
        // Act
        boolean actual = round.CheckIfDiceMayBePutAside(takenDices, new Dice(2, false));
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testRoundCheckIfDiceMayBePutAsideReturnsFalse(){
        // Arrange
        ArrayList<Dice> takenDices = new ArrayList<>();
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
    public void testRoundTakeTileReturnsTrue(){
        // Arrange
        ArrayList<Dice> thrownDices = new ArrayList<>();

        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(5, true));
        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(5, false));

        Tile chosenTile = new Tile(21, true);
        // Act
        boolean actual = round.TakeTile(thrownDices, chosenTile);
        // Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testRoundTakeTileReturnsFalse(){
        // Arrange
        ArrayList<Dice> thrownDices = new ArrayList<>();

        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(5, false));
        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(5, false));
        thrownDices.add(new Dice(5, false));

        Tile chosenTile = new Tile(21, true);
        // Act
        boolean actual = round.TakeTile(thrownDices, chosenTile);
        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void testRoundTakeTileReturnsFalseOnValue(){
        // Arrange
        ArrayList<Dice> thrownDices = new ArrayList<>();

        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(5, true));
        thrownDices.add(new Dice(4, false));
        thrownDices.add(new Dice(5, false));

        Tile chosenTile = new Tile(28, true);
        // Act
        boolean actual = round.TakeTile(thrownDices, chosenTile);
        // Assert
        Assert.assertFalse(actual);
    }

    @Test
    public void testRoundReturnTile(){
        // Arrange
        ArrayList<Tile> row = new ArrayList<>();
        ArrayList<Tile> stack = new ArrayList<>();
        stack.add(new Tile(28, true));
        // Act
        ArrayList<Tile> actual = round.ReturnTile(row, stack);
        // Assert
        Assert.assertEquals(1, actual.size());
    }
}
