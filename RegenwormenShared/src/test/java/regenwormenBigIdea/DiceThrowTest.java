package regenwormenBigIdea;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Dice;
import regenwormenshared.DiceThrow;

import java.util.ArrayList;

public class DiceThrowTest {

    @Test
    public void testDiceThrowNotNull(){
        // Arrange
        DiceThrow diceThrow = new DiceThrow();
        // Act

        // Assert
        Assert.assertNotNull(diceThrow);
    }

    @Test
    public void testGenerateDiceThrow(){
        // Arrange
        DiceThrow diceThrow = new DiceThrow();
        int expected = 5;
        // Act
        ArrayList<Dice> actual = diceThrow.GenerateDiceThrow(5);
        // Assert
        Assert.assertEquals(expected, actual.size());
    }
}
