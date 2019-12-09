package regenwormenBigIdea.DTO;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.DTO.DiceDTO;

public class DiceDTOTest {

    @Test
    public void testDiceDTONotNull(){
        // Arrange
        DiceDTO diceDTO = new DiceDTO(1, "ïmage.jpg", false);
        // Act

        // Assert
        Assert.assertNotNull(diceDTO);
    }

    @Test
    public void testDiceDTOGetValue(){
        // Arrange
        int expected = 1;
        DiceDTO diceDTO = new DiceDTO(expected, "image.jpg", false);
        // Act
        int actual = diceDTO.getValue();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDiceDTOGetImage(){
        // Arrange
        String expected = "image.jpg";
        DiceDTO diceDTO = new DiceDTO(1, expected, false);
        // Act
        String actual = diceDTO.getImage();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDiceDTOGetRegenworm(){
        // Arrange
        DiceDTO diceDTO = new DiceDTO(1, "image.jpg", false);
        // Act
        boolean actual = diceDTO.getRegenworm();
        // Assert
        Assert.assertFalse(actual);
    }
}
