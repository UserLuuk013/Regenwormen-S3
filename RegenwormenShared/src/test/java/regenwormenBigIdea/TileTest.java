package regenwormenBigIdea;

import org.junit.Assert;
import org.junit.Test;
import regenwormenshared.Models.Tile;

public class TileTest {

    @Test
    public void testTileNotNull(){
        // Arrange
        Tile tile = new Tile(21, true);
        // Act

        // Assert
        Assert.assertNotNull(tile);
    }

    @Test
    public void testTileGetValue(){
        // Arrange
        int expected = 21;
        Tile tile = new Tile(expected, true);
        // Act
        int actual = tile.getValue();
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTileGetVisible(){
        // Arrange
        Tile tile = new Tile(21, true);
        // Act
        boolean actual = tile.getVisible();
        // Assert
        Assert.assertTrue(actual);
    }
}
