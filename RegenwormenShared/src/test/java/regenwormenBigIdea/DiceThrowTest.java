package regenwormenBigIdea;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.DiceThrow;

import java.util.List;

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
        List<Dice> actual = diceThrow.GenerateDiceThrow(5);
        // Assert
        Assert.assertEquals(expected, actual.size());
    }
}
