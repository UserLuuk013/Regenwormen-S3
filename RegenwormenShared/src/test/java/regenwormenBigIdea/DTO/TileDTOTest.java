package regenwormenBigIdea.DTO;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.DTO.TileDTO;

public class TileDTOTest {

    @Test
    public void testTileDTONotNull(){
        // Arrange
        TileDTO tileDTO = new TileDTO(21, "image.jpg", 1);
        // Act

        // Assert
        Assert.assertNotNull(tileDTO);
    }

    @Test
    public void testTileDTOGetValue(){
        // Arrange
        int expected = 21;
        TileDTO tileDTO = new TileDTO(expected, "image.jpg", 1);
        // Act
        int actual = tileDTO.getValue();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTileDTOGetImage(){
        // Arrange
        String expected = "image.jpg";
        TileDTO tileDTO = new TileDTO(21, expected, 1);
        // Act
        String actual = tileDTO.getImage();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTileDTOGetAmountOfRegenwormen(){
        // Arrange
        int expected = 1;
        TileDTO tileDTO = new TileDTO(21, "image.jpg", expected);
        // Act
        int actual = tileDTO.getAmountOfRegenwormen();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
