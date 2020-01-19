package regenwormenBigIdea.Models;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.models.Tile;

public class TileTest {

    @Test
    public void testTileNotNull(){
        // Arrange
        Tile tile = new Tile(21, 1);
        // Act

        // Assert
        Assert.assertNotNull(tile);
    }

    @Test
    public void testTileGetValue(){
        // Arrange
        int expected = 21;
        Tile tile = new Tile(expected, 1);
        // Act
        int actual = tile.getValue();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTileGetAmountOfRegenwormen(){
        // Arrange
        int expected = 1;
        Tile tile = new Tile(21, expected);
        // Act
        int actual = tile.getAmountOfRegenwormen();
        // Assert
        Assert.assertEquals(expected, actual);
    }
}
