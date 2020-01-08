package regenwormenBigIdea.Models;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.Models.Dice;

public class DiceTest {

    @Test
    public void testDiceNotNull(){
        // Arrange
        Dice dice = new Dice(1, "image.jpg", false);
        // Act

        // Assert
        Assert.assertNotNull(dice);
    }

    @Test
    public void testDiceCreateDiceDTONotNull(){
        // Arrange
        Dice dice = new Dice(1, "image.jpg", false);
        // Act
        DiceDTO actual = dice.CreateDTO();
        // Assert
        Assert.assertNotNull(actual);
    }

    @Test
    public void testDiceGetValue(){
        // Arrange
        int expected = 1;
        Dice dice = new Dice(expected, "image.jpg",false);
        // Act
        int actual = dice.getValue();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDiceGetImage(){
        // Arrange
        String expected = "image.jpg";
        Dice dice = new Dice(1, expected, false);
        // Act
        String actual = dice.getImage();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDiceGetRegenworm(){
        // Arrange
        Dice dice = new Dice(1, "image.jpg",false);
        // Act
        boolean actual = dice.isRegenworm();
        // Assert
        Assert.assertFalse(actual);
    }
}
