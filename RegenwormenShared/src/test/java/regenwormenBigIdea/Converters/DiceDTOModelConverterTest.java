package regenwormenBigIdea.Converters;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Converters.DiceDTOModelConverter;
import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.Models.Dice;

public class DiceDTOModelConverterTest {

    @Test
    public void testDiceDTOModelConverterNotNull(){
        // Arrange
        DiceDTOModelConverter cvt = new DiceDTOModelConverter();
        // Act

        // Assert
        Assert.assertNotNull(cvt);
    }

    @Test
    public void testModelFromDTO(){
        // Arrange
        DiceDTOModelConverter cvt = new DiceDTOModelConverter();
        DiceDTO dto = new DiceDTO(1, "image.jpg", false);
        Dice expected = new Dice(1, "image.jpg", false);
        // Act
        Dice actual = cvt.ModelFromDTO(dto);
        // Assert
        Assert.assertEquals(expected.getValue(), actual.getValue());
        Assert.assertEquals(expected.getImage(), actual.getImage());
        Assert.assertEquals(expected.isRegenworm(), actual.isRegenworm());
    }

    @Test
    public void testModelToDTO(){
        // Arrange
        DiceDTOModelConverter cvt = new DiceDTOModelConverter();
        Dice d = new Dice(1, "image.jpg", false);
        DiceDTO expected = new DiceDTO(1, "image.jpg", false);
        // Act
        DiceDTO actual = cvt.ModelToDTO(d);
        // Assert
        Assert.assertEquals(expected.getValue(), actual.getValue()); // Value
        Assert.assertEquals(expected.getImage(), actual.getImage()); // Image
        Assert.assertEquals(expected.getRegenworm(), actual.getRegenworm()); // Regenworm
    }
}
