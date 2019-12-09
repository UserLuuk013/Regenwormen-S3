package regenwormenBigIdea.Results;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Models.Dice;
import regenwormenshared.Results.SetAsideResult;

import java.util.ArrayList;
import java.util.List;

public class SetAsideResultTest {

    @Test
    public void testSetAsideResultNotNull(){
        // Arrange
        List<Dice> takenDices = new ArrayList<>();
        SetAsideResult setAsideResult = new SetAsideResult(takenDices, new Dice(2, "image.jpg", false));
        // Act

        // Assert
        Assert.assertNotNull(setAsideResult);
    }

    @Test
    public void testSetAsideResultGetTakenDices(){
        // Arrange
        List<Dice> takenDices = new ArrayList<>();
        SetAsideResult setAsideResult = new SetAsideResult(takenDices, new Dice(2, "image.jpg", false));
        // Act
        List<Dice> actual = setAsideResult.getTakenDices();
        // Assert
        Assert.assertEquals(takenDices, actual);
    }

    @Test
    public void testSetAsideResultGetChosenDice(){
        // Arrange
        List<Dice> takenDices = new ArrayList<>();
        Dice chosenDice = new Dice(2, "image.jpg", false);
        SetAsideResult setAsideResult = new SetAsideResult(takenDices, chosenDice);
        // Act
        Dice actual = setAsideResult.getChosenDice();
        // Assert
        Assert.assertEquals(chosenDice, actual);
    }
}
