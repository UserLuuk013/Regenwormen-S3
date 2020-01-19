package regenwormenBigIdea.Models;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.models.Dice;
import regenwormenshared.models.DiceThrow;

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
        List<Dice> actual = diceThrow.generateDiceThrow(5);
        // Assert
        Assert.assertEquals(expected, actual.size());
    }
}
