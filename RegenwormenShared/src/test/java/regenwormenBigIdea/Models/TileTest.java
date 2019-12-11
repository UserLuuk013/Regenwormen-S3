package regenwormenBigIdea.Models;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Models.Tile;

public class TileTest {

    @Test
    public void testTileNotNull(){
        // Arrange
        Tile tile = new Tile(21, "image.jpg", 1);
        // Act

        // Assert
        Assert.assertNotNull(tile);
    }

    @Test
    public void testTileCreateDTONotNull(){
        // Arrange
        Tile tile = new Tile(21, "image.jpg", 1);
        // Act
        TileDTO actual = tile.CreateDTO();
        // Assert
        Assert.assertNotNull(actual);
    }

    @Test
    public void testTileGetValue(){
        // Arrange
        int expected = 21;
        Tile tile = new Tile(expected, "image.jpg", 1);
        // Act
        int actual = tile.getValue();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTileGetImage(){
        // Arrange
        String expected = "image.jpg";
        Tile tile = new Tile(21, expected, 1);
        // Act
        String actual = tile.getImage();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTileGetAmountOfRegenwormen(){
        // Arrange
        int expected = 1;
        Tile tile = new Tile(21, "image.jpg", expected);
        // Act
        int actual = tile.getAmountOfRegenwormen();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
