package regenwormenBigIdea.Results;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.models.Dice;
import regenwormenshared.results.RollDiceResult;

import java.util.ArrayList;
import java.util.List;

public class RollDiceResultTest {

    @Test
    public void testRollDiceResultNotNull(){
        // Arrange
        List<Dice> thrownDices = new ArrayList<>();
        RollDiceResult rollDiceResult = new RollDiceResult(thrownDices);
        // Act

        // Assert
        Assert.assertNotNull(rollDiceResult);
    }

    @Test
    public void testRollDiceResultGetThrownDices(){
        // Arrange
        List<Dice> thrownDices = new ArrayList<>();
        RollDiceResult rollDiceResult = new RollDiceResult(thrownDices);
        // Act
        List<Dice> actual = rollDiceResult.getThrownDices();
        // Assert
        Assert.assertEquals(rollDiceResult.getThrownDices(), actual);
    }
}
