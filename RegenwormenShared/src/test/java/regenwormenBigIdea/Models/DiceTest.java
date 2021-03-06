package regenwormenBigIdea.Models;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.models.Dice;

public class DiceTest {

    @Test
    public void testDiceNotNull(){
        // Arrange
        Dice dice = new Dice(1, false);
        // Act

        // Assert
        Assert.assertNotNull(dice);
    }

    @Test
    public void testDiceGetValue(){
        // Arrange
        int expected = 1;
        Dice dice = new Dice(expected,false);
        // Act
        int actual = dice.getValue();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDiceGetRegenworm(){
        // Arrange
        Dice dice = new Dice(1, false);
        // Act
        boolean actual = dice.isRegenworm();
        // Assert
        Assert.assertFalse(actual);
    }
}
